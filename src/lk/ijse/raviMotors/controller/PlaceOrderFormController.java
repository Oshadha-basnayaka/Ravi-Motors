package lk.ijse.raviMotors.controller;


import com.jfoenix.controls.JFXComboBox;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.raviMotors.bo.BOFactory;
import lk.ijse.raviMotors.bo.custom.PlaceOrderBO;
import lk.ijse.raviMotors.bo.custom.impl.PlaceOrderBOimpl;
import lk.ijse.raviMotors.model.PlaceOrderModel;
import lk.ijse.raviMotors.to.Customer;
import lk.ijse.raviMotors.to.Employee;
import lk.ijse.raviMotors.to.Part;
import lk.ijse.raviMotors.to.PlaceOrder;
import lk.ijse.raviMotors.view.tm.PlaceOderTM;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlaceOrderFormController implements Initializable {

    public AnchorPane pane;
    public Label lblOrderId;
    public Label lblOrderDate;
    public JFXComboBox cmbCustomerId;
    public Label lblCustomerName;
    public JFXComboBox cmbPartCode;
    public Label lblDescription;
    public Label lblUnitPrice;
    public Label lblQtyOnHand;
    public TextField txtQty;
    public TableView tblOrderCart;
    public TableColumn colPartName;
    public TableColumn colDescription;
    public TableColumn colQty;
    public TableColumn colUnitPrice;
    public TableColumn colTotal;
    public TextField txtWorkingCharge;
    public TextField TxtOderId;
    public TextField TxtCustomerName;
    public TextField txtDescription;
    public TextField txtUnitPrice;
    public TextField txtQtyOnhand;

    public static ObservableList<PlaceOderTM> placeOderlist= FXCollections.observableArrayList();
    public JFXComboBox cmbEmpName;
    public JFXComboBox cmbEmpId;
    public TextField TxtEmployeeName;

   PlaceOrderBO placeOrderBO = new PlaceOrderBOimpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadstId();
        getStName();
        getPName();
        loadpartDetail();
        loadEmpId();
        getEmpName();
        colPartName.setCellValueFactory(new PropertyValueFactory<>("partName"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        setDateAndTime();


    }
    public void cmbItemOnAction(ActionEvent actionEvent) {
    }

    public void OnActionBtnAddCart(ActionEvent actionEvent) {

        int qty  = Integer.parseInt(txtQty.getText());
        int workingcharge = Integer.parseInt(txtWorkingCharge.getText());
        String description = txtDescription.getText();
        String partName = (String) cmbPartCode.getValue();
        int unitPrice= Integer.parseInt(txtUnitPrice.getText());
        int total=(unitPrice*qty)+workingcharge;

        PlaceOderTM placeOderTM=new PlaceOderTM(partName,description,qty,workingcharge,unitPrice,total);

        placeOderlist.add(placeOderTM);
        tblOrderCart.setItems(placeOderlist);
/*
        try {
            ObservableList list=PlaceOrderModel.loadTable(total);
           // tblOrderCart.setItems(list);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
*/


    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       String empId= String.valueOf(cmbEmpId.getValue());
       String cusId= String.valueOf(cmbCustomerId.getValue());
       String orderId=TxtOderId.getText();
        String date= lblOrderDate.getText();
        int qty= Integer.parseInt(txtQty.getText());
        String partName= cmbPartCode.getValue().toString();

       int subTotal=0;

        for (PlaceOderTM pm:placeOderlist
             ) {
            subTotal= pm.getTotal()+subTotal;
        }
        PlaceOrder placeOrder=new PlaceOrder(cusId,orderId,subTotal,date,empId,qty);


          //  String partName= cmbPartCode.getSelectionModel().getSelectedItem().toString();
           // Part part=PlaceOrderModel.getPartDetail(partName);
            boolean isPlaceOrder=placeOrderBO.placeorder(placeOrder,partName,qty);

            if (isPlaceOrder){
                cmbCustomerId.getSelectionModel().clearSelection();
                cmbEmpId.getSelectionModel().clearSelection();
                cmbPartCode.getSelectionModel().clearSelection();
                tblOrderCart.getItems().clear();

                txtDescription.clear();
                txtQty.clear();
                txtQtyOnhand.clear();
                txtWorkingCharge.clear();
                txtUnitPrice.clear();

                TxtCustomerName.clear();
                TxtEmployeeName.clear();
                TxtOderId.clear();
            }



    }
    public void loadstId(){
        try {
            ObservableList allstIds= PlaceOrderModel.loadstid();
            cmbCustomerId.setItems(allstIds);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void loadEmpId(){
        try {
            ObservableList allempIds= PlaceOrderModel.loadEmptid();
            cmbEmpId.setItems(allempIds);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

  public void getStName(){
        cmbCustomerId.setOnAction(event -> {
           String CId= cmbCustomerId.getSelectionModel().getSelectedItem().toString();
            System.out.println(CId);
            try {
                Customer customer=PlaceOrderModel.getCustomerName(CId);
                System.out.println(customer.getName());
                TxtCustomerName.setText(customer.getName());
            } catch (SQLException e) {
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }

        });
  }


    public void getPName() {

        try {
            ObservableList pNameList=PlaceOrderModel.loadPname();
            cmbPartCode.setItems(pNameList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadpartDetail(){
        cmbPartCode.setOnAction(event -> {
            String partName= cmbPartCode.getSelectionModel().getSelectedItem().toString();
            System.out.println(partName);
            try {
                Part part=PlaceOrderModel.getPartDetail(partName);
                txtDescription.setText(part.getDescription());
                txtUnitPrice.setText(String.valueOf(part.getUnitprice()));
                txtQtyOnhand.setText(String.valueOf(part.getQty()));


            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        });
    }


    public void getEmpName() {

        cmbEmpId.setOnAction(event -> {
            String empId= cmbEmpId.getSelectionModel().getSelectedItem().toString();
            System.out.println(empId);
            try {
                Employee employee=PlaceOrderModel.getEmpName(empId);
                TxtEmployeeName.setText(employee.getName());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        });

    }


    private void setDateAndTime() {
        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e->{
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd   HH:mm:ss");
            lblOrderDate.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void loadTable(){
           }


    public void oIdKeyPress(KeyEvent keyEvent) {

        Pattern pattern =Pattern.compile("(o0)([0-9]{1})([0-9]{0,})");
        Matcher matcher = pattern.matcher(TxtOderId.getText());

        boolean isMatch =matcher.matches();


        if (!isMatch) {
            TxtOderId.setStyle("-fx-text-box-border: #d63031; -fx-focus-color: #d63031;");

            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            TxtOderId.setStyle("-fx-text-box-border: #00b894; -fx-focus-color:#00b894;");
        }

    }
}

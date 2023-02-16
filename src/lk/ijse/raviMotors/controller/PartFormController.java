package lk.ijse.raviMotors.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import lk.ijse.raviMotors.bo.BOFactory;
import lk.ijse.raviMotors.bo.custom.PartBO;
import lk.ijse.raviMotors.bo.custom.SupplierBO;
import lk.ijse.raviMotors.dao.DAOFactory;
import lk.ijse.raviMotors.db.DBConnection;
import lk.ijse.raviMotors.dto.CustomerDTO;
import lk.ijse.raviMotors.dto.PartDTO;
import lk.ijse.raviMotors.dto.SupplierDTO;
import lk.ijse.raviMotors.model.*;
import lk.ijse.raviMotors.to.Customer;
import lk.ijse.raviMotors.to.Employee;
import lk.ijse.raviMotors.to.Part;
import lk.ijse.raviMotors.to.Supplier;
import org.controlsfx.control.Notifications;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartFormController {
    public TableView tblPart;
    public TableColumn colName;
    public TableColumn colAddress;
    public TextField txtId1;
    public TextField txtPartName;
    public TextField txtDescription;
    public TextField txtUnitPrice;
    public TextField txtQty;
    public TableColumn colId;
    public TableColumn colDescription;
    public TableColumn colPrice;
    public TableColumn colQty;
    public TextField txtId;
    public TextField txtName;
    public TableColumn colUnitPrice;
    public JFXComboBox cmbSupplierId;
    public TextField txtSupName;
    public TableColumn colsupId;

    PartBO partBO = (PartBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PART);
    SupplierBO supplierBO = (SupplierBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUPPLIER);


    public void initialize(){

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitprice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colsupId.setCellValueFactory(new PropertyValueFactory<>("SupplierId"));

        LoadAllPart();
        LoadComboSupplier();
        getSupplierName();

    }

    public void OnActionBtnSave(ActionEvent actionEvent) {

        String id = txtId.getText();
        String name = txtName.getText();
        String description = txtDescription.getText();
        int unitprice =Integer.parseInt(txtUnitPrice.getText());
        int qty = Integer.parseInt(txtQty.getText());
       String supId= cmbSupplierId.getSelectionModel().getSelectedItem().toString();

        Part part = new Part(id, name, description, unitprice, supId,qty);
        try {
            boolean isAdded = partBO.addPart(new PartDTO(id,name,description,unitprice,qty,supId));

            if(isAdded) {

                Notifications.create()
                        .title("Ravi motors")
                        //.graphic(new ImageView(image))
                        .text("Part Add !")
                        .darkStyle()
                        .hideAfter(Duration.seconds(5))
                        .show();

                LoadAllPart();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void OnActionBtnPartSearch(ActionEvent actionEvent) {
    }

    public void OnActionBtnupdate(ActionEvent actionEvent) {

        String id = txtId.getText();
        String name = txtName.getText();
        String description = txtDescription.getText();
        int unitprice =Integer.parseInt(txtUnitPrice.getText());
        int qty = Integer.parseInt(txtQty.getText());
        String supId= cmbSupplierId.getSelectionModel().getSelectedItem().toString();


        Part part = new Part(id, name, description, unitprice,supId, qty);
        try {
            boolean isUpdated = partBO.updatePart(new PartDTO(id,name,description,unitprice,qty,supId));

            if(isUpdated) {

                Notifications.create()
                        .title("Ravi motors")
                        //.graphic(new ImageView(image))
                        .text("Part Update !")
                        .darkStyle()
                        .hideAfter(Duration.seconds(5))
                        .show();

                LoadAllPart();


            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }

    }

    public void OnActionBtndelete(ActionEvent actionEvent) {

        String id = txtId.getText();
        try {
            boolean isDelete = partBO.deletePart(id);

            if(isDelete) {

                Notifications.create()
                        .title("Ravi motors")
                        //.graphic(new ImageView(image))
                        .text("Part Update !")
                        .darkStyle()
                        .hideAfter(Duration.seconds(5))
                        .show();

                LoadAllPart();

            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void OnActionBtnclear(ActionEvent actionEvent) {
    }

    public void OnActionBtnSearch(ActionEvent actionEvent) {


        String id = txtId.getText();
        try {
            PartDTO part = partBO.searchPart(id);
//            txtQty.setText(String.valueOf(part.getQty()));
//            txtDescription.setText(part.getDescription());
//            txtUnitPrice.setText(String.valueOf(part.getUnitprice()));
//            txtQty.setText(String.valueOf(part.getQty()));
//            txtPartName.setText(part.getName());
//            cmbSupplierId.setValue(part.getSupplierId());
            if(part != null) {

                Notifications.create()
                        .title("Ravi motors")
                        //.graphic(new ImageView(image))
                        .text("Part Search !")
                        .darkStyle()
                        .hideAfter(Duration.seconds(5))
                        .show();

                LoadAllPart();


                fillData(part);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);        }
    }


    public void LoadAllPart(){

        ObservableList data = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM part");
            ResultSet allPart=statement.executeQuery();


            while (allPart.next()){
                data.add(new Part(allPart.getString(1), allPart.getString(2), allPart.getString(3), allPart.getInt( 4),allPart.getString(3),allPart.getInt( 5)));
            }


        } catch (SQLException e) {
            System.out.println("sql error");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("class not found error");
            throw new RuntimeException(e);
        }
        tblPart.setItems(data);

    }

    public void LoadComboSupplier(){

        try {
            ArrayList<String> allSupIds = supplierBO.loadSupId();
            System.out.println(allSupIds);
            ObservableList<String> observableList=FXCollections.observableList(allSupIds);
            cmbSupplierId.setItems(observableList);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public void getSupplierName() {

        cmbSupplierId.setOnAction(event -> {
            String supId= cmbSupplierId.getSelectionModel().getSelectedItem().toString();
            System.out.println(supId);
            try {
                String name= partBO.loadSupName(supId);
                txtSupName.setText(name);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        });

    }








    private void fillData(PartDTO part) {
        txtId.setText(part.getId());
        txtName.setText(part.getName());
        txtDescription.setText(part.getDescription());
        txtUnitPrice.setText(String.valueOf(part.getUnitprice()));
        txtQty.setText(String.valueOf(part.getQty()));
    }

    public void pIdKeyPress(KeyEvent keyEvent) {

        Pattern pattern =Pattern.compile("(p0)([0-9]{1})([0-9]{0,})");
        Matcher matcher = pattern.matcher(txtId.getText());

        boolean isMatch =matcher.matches();


        if (!isMatch) {
            txtId.setStyle("-fx-text-box-border: #d63031; -fx-focus-color: #d63031;");

            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtId.setStyle("-fx-text-box-border: #00b894; -fx-focus-color:#00b894;");
        }

    }
}

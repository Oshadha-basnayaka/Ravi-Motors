package lk.ijse.raviMotors.controller;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import lk.ijse.raviMotors.bo.BOFactory;
import lk.ijse.raviMotors.bo.custom.CustomerBO;
import lk.ijse.raviMotors.bo.custom.EmployeeBO;
import lk.ijse.raviMotors.bo.custom.OrderDetailBO;
import lk.ijse.raviMotors.dto.CustomerDTO;
import lk.ijse.raviMotors.model.OrderDetailModel;
import lk.ijse.raviMotors.model.PlaceOrderModel;
import lk.ijse.raviMotors.to.Customer;
import lk.ijse.raviMotors.to.OrderDetail;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OrderDetailController implements Initializable {
    public TableView tblPart;
    public TableColumn colId;
    public TableColumn colDate;
    public TableColumn colCusId;
    public TableColumn colEmpId;
    public TableColumn colSubTotal;
    public TextField txtId;
    public TextField txtName;



    OrderDetailBO orderDetailBO = (OrderDetailBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ORDERDETAILS);
    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        LoadOderDetail();
        colId.setCellValueFactory(new PropertyValueFactory<>("o_id"));
        colCusId.setCellValueFactory(new PropertyValueFactory<>("c_id"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("o_date"));
        colSubTotal.setCellValueFactory(new PropertyValueFactory<>("sub_total"));
        colEmpId.setCellValueFactory(new PropertyValueFactory<>("e_id"));

    }

    public void OnActionBtnupdate(ActionEvent actionEvent) {
    }

    public void OnActionBtndelete(ActionEvent actionEvent) {
    }

    public void LoadOderDetail(){
        String cusId=txtId.getText();
        try {
            ObservableList allOrderDetail= OrderDetailModel.allOrderDetail(cusId);
            tblPart.setItems(allOrderDetail);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }


    }

    public void OnActionBtnSearch(ActionEvent actionEvent) {

        String id = txtId.getText();
        try {
            CustomerDTO customer = customerBO.searchCustomer(id);
            txtName.setText(customer.getName());
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
     /*   if(orderDetail != null) {
            Notifications.create()
                    .title("Ravi motors")
                    //.graphic(new ImageView(image))
                    .text("Order Search!")
                    .darkStyle()
                    .hideAfter(Duration.seconds(5))
                    .show();

            fillData(orderDetail);
        }*/
        LoadOderDetail();

    }

    private void fillData(OrderDetail orderDetail) {
        txtId.setText(orderDetail.getO_id());
        txtName.setText(orderDetail.getE_id());

    }

    public void OnActionBtnCustomerId(ActionEvent actionEvent) {
    }

    //String SupplierId=Tx.getText();

}

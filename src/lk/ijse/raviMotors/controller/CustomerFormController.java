package lk.ijse.raviMotors.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.raviMotors.bo.BOFactory;
import lk.ijse.raviMotors.bo.custom.CustomerBO;
import lk.ijse.raviMotors.db.DBConnection;
import lk.ijse.raviMotors.dto.CustomerDTO;
import lk.ijse.raviMotors.model.CustomerModel;
import lk.ijse.raviMotors.to.Customer;
import lk.ijse.raviMotors.util.CrudUtil;
import lk.ijse.raviMotors.util.Navigation;
import lk.ijse.raviMotors.util.Routes;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerFormController {
    public AnchorPane pane;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;

    public TableView tblCustomer;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colDob;
    public TableColumn colNic;
    public TextField txtNic;
    public TextField txtContact;
    public TableColumn colContact;

    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);


    public void initialize(){

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));

        LoadAllCustomer();

    }

    public void OnActionBtnSave(ActionEvent actionEvent) {

        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        int contact =Integer.parseInt(txtContact.getText());

        Customer customer = new Customer(id, name, address, contact);
        try {
            boolean isAdded = customerBO.addCustomer(new CustomerDTO(id,name,address,contact));

            if(isAdded) {

                Notifications.create()
                        .title("Ravi motors")
                        //.graphic(new ImageView(image))
                        .text("Customer Add !")
                        .darkStyle()
                        .hideAfter(Duration.seconds(5))
                        .show();

                LoadAllCustomer();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public void OnActionBtndelete(ActionEvent actionEvent) {

        String id = txtId.getText();
        try {
        boolean isDelete = customerBO.deleteCustomer(id);

        if(isDelete) {
            Notifications.create()
                    .title("Ravi motors")
                    //.graphic(new ImageView(image))
                    .text("Customer Delete !")
                    .darkStyle()
                    .hideAfter(Duration.seconds(5))
                    .show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }
    } catch (SQLException | ClassNotFoundException e) {
        throw new RuntimeException(e);
    }


    }

    public void OnActionBtnupdate(ActionEvent actionEvent) {

        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        int contact =Integer.parseInt(txtContact.getText());

        Customer customer = new Customer(id,name,address,contact);
        try {
            boolean isUpdated = customerBO.addCustomer(new CustomerDTO(id,name,address,contact));

            if(isUpdated) {
                Notifications.create()
                .title("Ravi motors")
                        //.graphic(new ImageView(image))
                        .text("Customer Update !")
                        .darkStyle()
                        .hideAfter(Duration.seconds(5))
                        .show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void OnActionBtnSearch(ActionEvent actionEvent) {

        String id = txtId.getText();
        try {
            CustomerDTO customer = customerBO.searchCustomer(id);
            if(customer != null) {
                Notifications.create()
                        .title("Ravi motors")
                        //.graphic(new ImageView(image))
                        .text("Customer Search!")
                        .darkStyle()
                        .hideAfter(Duration.seconds(5))
                        .show();

                fillData(customer);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void LoadAllCustomer(){

        ObservableList data = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM customer");
            ResultSet allCustomers=statement.executeQuery();


            while (allCustomers.next()){
                data.add(new Customer(allCustomers.getString(1), allCustomers.getString(2), allCustomers.getString(3), allCustomers.getInt( 4)));
            }


        } catch (SQLException e) {
            System.out.println("sql error");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("class not found error");
            throw new RuntimeException(e);
        }
        tblCustomer.setItems(data);

    }

    private void fillData(CustomerDTO customer) {
        txtId.setText(customer.getId());
        txtName.setText(customer.getName());
        txtAddress.setText(customer.getAddress());
        txtContact.setText(String.valueOf(customer.getContact()));
    }


    public void cidKeyPress(KeyEvent keyEvent) {

        Pattern pattern =Pattern.compile("(c0)([0-9]{1})([0-9]{0,})");
        Matcher matcher = pattern.matcher(txtId.getText());

        boolean isMatch =matcher.matches();


        if (!isMatch) {
            txtId.setStyle("-fx-text-box-border: #d63031; -fx-focus-color: #d63031;");

            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtId.setStyle("-fx-text-box-border: #00b894; -fx-focus-color:#00b894;");
        }

    }

    public void contKeyPress(KeyEvent keyEvent) {

        Pattern contactPattern = Pattern.compile("^(07)([0-9]{8})$");
        Matcher matcher = contactPattern.matcher(txtContact.getText());

        boolean isMatch =matcher.matches();

        if (!isMatch) {
            txtContact.setStyle("-fx-text-box-border: #d63031; -fx-focus-color: #d63031;");

            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtContact.setStyle("-fx-text-box-border: #00b894; -fx-focus-color:#00b894;");
        }

    }
}

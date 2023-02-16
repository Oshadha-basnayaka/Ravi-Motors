package lk.ijse.raviMotors.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.raviMotors.bo.BOFactory;
import lk.ijse.raviMotors.bo.custom.SupplierBO;
import lk.ijse.raviMotors.dao.DAOFactory;
import lk.ijse.raviMotors.dao.custom.SupplierDAO;
import lk.ijse.raviMotors.db.DBConnection;
import lk.ijse.raviMotors.dto.CustomerDTO;
import lk.ijse.raviMotors.dto.SupplierDTO;
import lk.ijse.raviMotors.model.CustomerModel;
import lk.ijse.raviMotors.model.EmployeeModel;
import lk.ijse.raviMotors.model.SupplierModel;
import lk.ijse.raviMotors.to.Customer;
import lk.ijse.raviMotors.to.Employee;
import lk.ijse.raviMotors.to.Supplier;
import lk.ijse.raviMotors.util.Navigation;
import lk.ijse.raviMotors.util.Routes;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SupplierFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtDob;
    public TableView tblSupplier;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colDob;
    public TableColumn colNic;
    public TextField txtNic;
    public AnchorPane pane;
    public TextField txtContact;
    public TableColumn colContact;

    SupplierBO supplierBO = (SupplierBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUPPLIER);


    public void initialize(){

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));

        LoadAllSupplier();

    }


    public void OnActionBtnSave(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        int contact = Integer.parseInt(txtContact.getText());

        Supplier supplier = new Supplier(id, name, address, contact);
        try {
            boolean isAdded = supplierBO.addSupplier(new SupplierDTO(id,name,address,contact));

            if(isAdded) {

                Notifications.create()
                        .title("Ravi motors")
                        //.graphic(new ImageView(image))
                        .text("Supplier Add !")
                        .darkStyle()
                        .hideAfter(Duration.seconds(5))
                        .show();

                LoadAllSupplier();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void OnActionBtnclear(ActionEvent actionEvent) {
    }

    public void OnActionBtndelete(ActionEvent actionEvent) {

        String id = txtId.getText();
        try {
            boolean isDelete = supplierBO.deleteSupplier(id);

            if(isDelete) {

                Notifications.create()
                        .title("Ravi motors")
                        //.graphic(new ImageView(image))
                        .text("Supplier Delete !")
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

        Supplier supplier  = new Supplier(id,name,address,contact);
        try {
            boolean isUpdated = supplierBO.updateSupplier(new SupplierDTO(id,name,address,contact));

            if(isUpdated) {

                Notifications.create()
                        .title("Ravi motors")
                        //.graphic(new ImageView(image))
                        .text("Supplier Update !")
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

    public void OnActionBtnBack(ActionEvent actionEvent) throws IOException {

        Navigation.navigate(Routes.DASHBOAD, pane);
    }

    public void OnActionBtnSupplierSearch(ActionEvent actionEvent) {
    }

    public void OnActionBtnSearch(ActionEvent actionEvent) {

        String id = txtId.getText();
        try {
            SupplierDTO supplier = supplierBO.searchSupplier(id);
            if(supplier != null) {

                Notifications.create()
                        .title("Ravi motors")
                        //.graphic(new ImageView(image))
                        .text("Supplier Search !")
                        .darkStyle()
                        .hideAfter(Duration.seconds(5))
                        .show();

                fillData(supplier);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void LoadAllSupplier(){

        ObservableList data = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM supplier");
            ResultSet allSupplier=statement.executeQuery();


            while (allSupplier.next()){
                data.add(new Customer(allSupplier.getString(1), allSupplier.getString(2), allSupplier.getString(3), allSupplier.getInt( 4)));
            }


        } catch (SQLException e) {
            System.out.println("sql error");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("class not found error");
            throw new RuntimeException(e);
        }
        tblSupplier.setItems(data);

    }


    private void fillData(SupplierDTO supplier) {
        txtId.setText(supplier.getId());
        txtName.setText(supplier.getName());
        txtAddress.setText(supplier.getAddress());
        txtContact.setText(String.valueOf(supplier.getContact()));
    }

    public void suIdKeyPress(KeyEvent keyEvent) {

        Pattern pattern =Pattern.compile("(s0)([0-9]{1})([0-9]{0,})");
        Matcher matcher = pattern.matcher(txtId.getText());

        boolean isMatch =matcher.matches();


        if (!isMatch) {
            txtId.setStyle("-fx-text-box-border: #d63031; -fx-focus-color: #d63031;");

            Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        } else {
            txtId.setStyle("-fx-text-box-border: #00b894; -fx-focus-color:#00b894;");
        }

    }

    public void contactKeyPress(KeyEvent keyEvent) {

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

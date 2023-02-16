package lk.ijse.raviMotors.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.raviMotors.bo.BOFactory;
import lk.ijse.raviMotors.bo.custom.*;
import lk.ijse.raviMotors.dao.DAOFactory;
import lk.ijse.raviMotors.dao.custom.SupplierDAO;
import lk.ijse.raviMotors.dto.CustomerDTO;
import lk.ijse.raviMotors.dto.PartDTO;
import lk.ijse.raviMotors.model.DashboardPaneModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PaneDashboadFormController implements Initializable {
    public AnchorPane pane;
    public Label txtCustomerCpont;
    public Label txtEmpoiesCount;
    public Label txtSupplierCount;
    public Label txtPartCount;

    PaneDashboadBO paneDashboadBO = (PaneDashboadBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PANEDASHBOAD);
    PartBO partBO = (PartBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PART);
    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    SupplierBO supplierBO = (SupplierBO)  BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUPPLIER);

    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getCustomerCount();
        getSupplierCount();
        getEmployeeCount();
        getPartCount();
    }

    private void getPartCount() {
        try {
            int partCount= partBO.partCount();
            txtPartCount.setText(String.valueOf(partCount));
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

    }

    private void getEmployeeCount() {
        try {
            int empCount= employeeBO.employeetCount();
            txtEmpoiesCount.setText(String.valueOf(empCount));
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }


    }

    private void getSupplierCount() {
        try {
            int supCount= supplierBO.searchCount();
            txtSupplierCount.setText(String.valueOf(supCount));
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }


    }

    private void getCustomerCount() {
        try {
            int customerCount= customerBO.customerCount();
            txtCustomerCpont.setText(String.valueOf(customerCount));
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

    }
}

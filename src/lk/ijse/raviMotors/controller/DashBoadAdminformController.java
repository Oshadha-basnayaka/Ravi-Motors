package lk.ijse.raviMotors.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.raviMotors.util.Navigation;
import lk.ijse.raviMotors.util.Routes;

import java.io.IOException;

public class DashBoadAdminformController {
    public AnchorPane pane;
    public AnchorPane dashpane;

    public void OnActionBtnCustomer(ActionEvent actionEvent) throws IOException {

        Navigation.navigate(Routes.CUSTOMER, dashpane);

       //setUi("CustomerForm");
    }

    public void OnActionBtnEmployee(ActionEvent actionEvent) throws IOException {

        Navigation.navigate(Routes.EMPLOYEE, dashpane);

        //setUi("EmployeeForm");
    }

    public void OnActionBtnLoginOut(ActionEvent actionEvent) throws IOException {

        Navigation.navigate(Routes.LOGIN, pane);
    }

    public void OnActionBtnSupplier(ActionEvent actionEvent) throws IOException {

        Navigation.navigate(Routes.SUPPLIER, dashpane);
       // setUi("SupplierForm");
    }



    public void OnActionBtnOrder(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PLACEORDER, dashpane);
       //setUi("OrderForm");
    }


    public void OnActionBtnPart(ActionEvent actionEvent) throws IOException {

        Navigation.navigate(Routes.PART, dashpane);
    }

    public void OnActionBtnFinace(ActionEvent actionEvent) throws IOException {
        //setUi("FinaceForm");
        Navigation.navigate(Routes.FINACE, dashpane);
    }

    public void OnActionBtndashboad(ActionEvent actionEvent) throws IOException {

        Navigation.navigate(Routes.PANEDASHBOAD, dashpane);

    }

    public void OnActionBtnOrderDetail(ActionEvent actionEvent) throws IOException {

        Navigation.navigate(Routes.ORDERDETAIL, dashpane);

    }


//    private void setUi(String location) throws IOException {
//        Parent parent = FXMLLoader.load(getClass().getResource("/lk/ijse/raviMotors/view/" +location+".fxml"));
//        dashpane.getChildren().clear();
//        dashpane.getChildren().add(parent);
//    }

}

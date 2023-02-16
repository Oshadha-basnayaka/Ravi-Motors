package lk.ijse.raviMotors.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.raviMotors.util.Navigation;
import lk.ijse.raviMotors.util.Routes;

import java.io.IOException;

public class DashBoadReceptionFormController {
    public AnchorPane pane;
    public AnchorPane dashpane;

    public void OnActionBtnCustomer(ActionEvent actionEvent) throws IOException {

        //setUi("CustomerForm");
        Navigation.navigate(Routes.CUSTOMER, dashpane);
    }

    public void OnActionBtnSupplier(ActionEvent actionEvent) throws IOException {
        //setUi("SupplierForm");
        Navigation.navigate(Routes.SUPPLIER, dashpane);
    }

    public void OnActionBtnOrder(ActionEvent actionEvent) throws IOException {
//        setUi("OrderForm");
        Navigation.navigate(Routes.ORDER, dashpane);
    }

    public void OnActionBtnLoginOut(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN, pane);
    }

    public void OnActionBtnDashboad(ActionEvent actionEvent) throws IOException {

        Navigation.navigate(Routes.PANEDASHBOAD, dashpane);
    }

//    private void setUi(String location) throws IOException {
//        Parent parent = FXMLLoader.load(getClass().getResource("/lk/ijse/raviMotors/view/" +location+".fxml"));
//        dashpane.getChildren().clear();
//        dashpane.getChildren().add(parent);
//    }

}

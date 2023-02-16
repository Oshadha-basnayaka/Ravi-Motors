package lk.ijse.raviMotors.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {

    private static AnchorPane pane;
    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {
            case DASHBOAD:
                window.setTitle("DashBoad Form");
                setUi("DashBoadAdminform.fxml");
                break;
            case CUSTOMER:
                window.setTitle("Customer Form");
                setUi("CustomerForm.fxml");
                break;
            case EMPLOYEE:
                window.setTitle("Employee Form");
                setUi("EmployeeForm.fxml");
                break;
            case LOGIN:
                window.setTitle("login Form");
                setUi("LoginForm.fxml");
                break;
            case SUPPLIER:
                window.setTitle("Supplier Form");
                setUi("SupplierForm.fxml");
                break;
            case DASHBOADRECEPTION:
                window.setTitle("DashBoadReception Form");
                setUi("DashBoadReceptionform.fxml");
                break;
            case ORDER:
                window.setTitle("Order Form");
                setUi("PlaceOrderForm.fxml");
                break;
            case PART:
                window.setTitle("Part Form");
                setUi("PartForm.fxml");
                break;
            case FINACE:
                window.setTitle("Finace Form");
                setUi("FinaceForm.fxml");
                break;
            case MONTHLYREPORT:
                window.setTitle("Monthly Report Form");
                setUi("MonthlyReportForm.fxml");
                break;
            case ANNUALREPORT:
                window.setTitle("Annual Report Form");
                setUi("AnnualReportForm.fxml");
                break;
            case PANEDASHBOAD:
                window.setTitle("Dashboad Form");
                setUi("PaneDashboadForm.fxml");
                break;
            case PLACEORDER:
                window.setTitle("Place Order Form");
                setUi("PlaceOrderForm.fxml");
                break;
            case ORDERDETAIL:
                window.setTitle("Oder Detail Form");
                setUi("OrderDetail.fxml");
                break;
            default:


                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }
    }
    private static void setUi(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                .getResource("/lk/ijse/raviMotors/view/" + location)));
    }


}

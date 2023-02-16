package lk.ijse.raviMotors.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.raviMotors.util.Navigation;
import lk.ijse.raviMotors.util.Routes;

import java.io.IOException;

public class FinaceFormController {
    public AnchorPane pane;
    public AnchorPane finacepane;

    public void OnActionBtnMonthlyReport(ActionEvent actionEvent) throws IOException {

       // setUi("MonthlyReportForm");
        Navigation.navigate(Routes.MONTHLYREPORT, finacepane);
    }

    public void OnActionBtnAnnualReport(ActionEvent actionEvent) throws IOException {
        //setUi("AnnualReportForm");
        Navigation.navigate(Routes.ANNUALREPORT, finacepane);
    }

//    private void setUi(String location) throws IOException {
//        Parent parent = FXMLLoader.load(getClass().getResource("/lk/ijse/raviMotors/view/" +location+".fxml"));
//        finacepane.getChildren().clear();
//        finacepane.getChildren().add(parent);
//    }

}

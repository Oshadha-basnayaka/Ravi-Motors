package lk.ijse.raviMotors.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import lk.ijse.raviMotors.util.Navigation;
import lk.ijse.raviMotors.util.Routes;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField TxtUserName;
    public JFXPasswordField TxtPassword;
    public AnchorPane pane;

    public void OnActionBtnLogin(ActionEvent actionEvent) throws IOException {

        login();

    }

    public void OnActionBtnUsername(ActionEvent actionEvent) {
        TxtPassword.requestFocus();
    }

    public void OnActionBtnPassword(ActionEvent actionEvent) throws IOException {
        login();
    }

    private void login() throws IOException {

        if (TxtUserName.getText().equals("admin") && TxtPassword.getText().equals("1234")) {

            System.out.println("done");

            Navigation.navigate(Routes.DASHBOAD, pane);

        } else if (TxtUserName.getText().equals("reception") && TxtPassword.getText().equals("1234")) {

            System.out.println("done");

            Navigation.navigate(Routes.DASHBOADRECEPTION, pane);

        }else {
            Notification();
        }
    }

    public void Notification(){

        Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        alert.setTitle("Incorrect Password");// line 2
        alert.setHeaderText("invalid username or password!!!");// line 3
        alert.setContentText("Please, check your User Name and Password, and try again!");// line 4
        alert.showAndWait(); // line 5
//        alert.initModality(Modality.APPLICATION_MODAL);

    }



}

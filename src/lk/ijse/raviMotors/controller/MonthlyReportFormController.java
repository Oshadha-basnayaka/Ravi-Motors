package lk.ijse.raviMotors.controller;



import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MonthlyReportFormController {
    public Label LblDateTime;
    public AnchorPane pane;

    public void initialize() throws IOException {
        setDateAndTime();
        //Navigation.navigate(Routes.DASHBOARD,cashierPane);
       // LblDateTime.setText(getDate("yyyy/MM/dd"));


    }

//    public String getDate(String s){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(s);
//        String date = LocalDateTime.now().format(formatter);
//        return date;
//    }

    private void setDateAndTime() {
        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e->{
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd   HH:mm:ss");
            LblDateTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weight_monitor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zakia
 */
public class AfterLoginController implements Initializable {

    @FXML
    private Label result;
    @FXML
    private Button butt;
    double H, W, BMI;
    @FXML
    private TextField hi;
    @FXML
    private TextField wi;
    @FXML
    private Label status;

    @FXML
    private Label caloriegoal;
    @FXML
    private Button ok;
    double calorie;
    @FXML
    private TextField k;
    @FXML
    private TextField d;
    @FXML
    private Label uname;
    @FXML
    private Label lastbmi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //System.out.println("Done");
    }
    double weight = 0.0;
    double height = 0.0;
    double bMI = 0.0;

    @FXML
    private void calculate(ActionEvent event) {

        try {

            weight = Double.valueOf(wi.getText());
            height = Double.valueOf(hi.getText());
            bMI = (weight) / (height * height);

        } catch (Exception e) {

        }

        result.setText("Your Body Mass Index (BMI) is " + String.valueOf(bMI));

        if (bMI == 18.5) {

            status.setText("Normal");
        }
        if (bMI > 18.5 && bMI < 24.9) {

            status.setText("Normal");
        }
        if (bMI == 25) {
            status.setText("OverWieight");

            String st = OpeningController.myUN + " " + String.valueOf(bMI) + "\n";// pass.getText() + " " + age.getText() + " ";
            try {
                //System.out.println(st);
                File file = new File("data2.txt");
                FileWriter fileWriter = new FileWriter(file, true);
                try (BufferedWriter bw = new BufferedWriter(fileWriter)) {
                    bw.write(st);

                }
            } catch (Exception e) {
            }
        }
        if (bMI > 25 && bMI < 29.9) {
            status.setText("OverWieight");

        } else if (bMI > 30) {
            status.setText("Obese");

        } else if (bMI < 18.5) {
            status.setText("Underweight");

        }

    }

    @FXML
    private void handleOkButton(ActionEvent event) {

        double kg = 0.0;
        int day = 0;
        //double bMI = 0.0;

        try {

            kg = Double.valueOf(k.getText());
            day = Integer.valueOf(d.getText());
            calorie = (264.71 * day) / kg;

        } catch (Exception e) {

        }

        caloriegoal.setText("to lose " + String.valueOf(kg) + " kg in " + String.valueOf(day) + " days, your daily calorie goal will be " + String.valueOf(calorie));

    }

}

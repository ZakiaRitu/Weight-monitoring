/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weight_monitor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zakia
 */
public class NewuserController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField pass;
    @FXML
    private TextField age;
    private Object stage;
    private Object primaryStage;
    @FXML
    private Button okbtn;

    //Button okbtn;
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleOKButton(ActionEvent event) {
        String st = username.getText() + " " + pass.getText() + " " + age.getText() + " ";
        try {
            //System.out.println(st);
            File file = new File("data.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            try (BufferedWriter bw = new BufferedWriter(fileWriter)) {
                bw.write("\n");
                bw.write(st);
                
                if (username.getText().trim().isEmpty() || pass.getText().trim().isEmpty() || age.getText().trim().isEmpty()) {
                    Alert fail = new Alert(AlertType.INFORMATION);
                    fail.setHeaderText("failure");
                    fail.setContentText("you havent typed something");
                    fail.showAndWait();
                } else {

                    FXMLLoader fXMLLoader = new FXMLLoader(Weight_Monitor.class.getResource("AfterLogin.fxml"));
                    fXMLLoader.load();
                    Scene scene = new Scene(fXMLLoader.getRoot());
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("Weight Monitoring");
                    stage.setResizable(false);
                    stage.show();
                }
            }

        } catch (IOException e) {
        }

    }

}

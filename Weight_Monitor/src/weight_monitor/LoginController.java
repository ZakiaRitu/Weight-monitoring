/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weight_monitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zakia
 */
public class LoginController implements Initializable {

    @FXML
    private TextField pass_field;
    @FXML
    private Button ok_button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public String getPass() {
        return pass_field.getText();
    }

    @FXML
    private void handleOKButton(ActionEvent event) throws IOException {

        String UN = OpeningController.myUN;
        String pass = getPass();
        System.out.println(UN + " -> " + pass);

        BufferedReader br = null;
        boolean found = false;
        try {
            //System.out.println("here");
            br = new BufferedReader(new FileReader(new File("data.txt")));
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(" ");
                if (arr[0].equals(UN) && arr[1].equals(pass)) {
                    found = true;
                    System.out.println(" found ");

                    break;
                }
            }
            br.close();
        } catch (Exception ex) {
        }

        if (found == false) {
            Alert fail = new Alert(Alert.AlertType.ERROR);
            fail.setHeaderText("Wrong password");
            fail.setContentText("Wrong password");
            fail.showAndWait();
        } else {
            FXMLLoader fXMLLoader1 = new FXMLLoader(Weight_Monitor.class.getResource("Last.fxml"));
            fXMLLoader1.load();
            Scene scene1 = new Scene(fXMLLoader1.getRoot());
     
            Stage stage1 = (Stage) ok_button.getScene().getWindow();
            stage1.setScene(scene1);
            stage1.setTitle("Weight Monitoring");
            stage1.setResizable(false);
            stage1.show();
           
            
        }
    }

}

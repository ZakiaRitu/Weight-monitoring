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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Zakia
 */
public class DeleteUserController implements Initializable {

    @FXML
    private Button no_delete;
    @FXML
    private Button ok_delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void no(ActionEvent event) {
        no_delete.getScene().getWindow().hide();
    }

    @FXML
    private void ok(ActionEvent event) {

//        
//        BufferedReader br = null;
//        try {
//            //System.out.println("here");
//            br = new BufferedReader(new FileReader(new File("data.txt")));
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] arr = line.split(" ");
//                System.out.println(line);
//
//                if (OpeningController.myUN.equals(arr[0])) {
//                    try {
//                        //System.out.println(st);
//                        File file = new File("data.txt");
//                        FileWriter fileWriter = new FileWriter(file, true);
//                        try (BufferedWriter bw = new BufferedWriter(fileWriter)) {
//                            bw.write("\n");
//                            bw.write("OK");
//                        }
//                    } catch (IOException e) {
//                    }
//
//                }
//            }
//            br.close();
//
//        } catch (Exception ex) {
//            System.out.println("Exception ex");
//        }
    }

}

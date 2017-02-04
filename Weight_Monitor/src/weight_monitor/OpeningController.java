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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zakia
 */
public class OpeningController implements Initializable {

    @FXML
    public ChoiceBox<String> choicebox;
    ObservableList<String> userlist = FXCollections.observableArrayList();
    private LoginController loginController;
    String username[] = new String[100], pass[] = new String[100];
    int tot = 0;
    static String myUN;

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //System.out.println("here");
        tot = 0;
        BufferedReader br = null;
        try {
            //System.out.println("here");
            br = new BufferedReader(new FileReader(new File("data.txt")));
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(" ");
                System.out.println(line + " + " + arr[0] + " + " + arr[1]);
                username[tot] = arr[0];
                pass[tot] = arr[1];
                userlist.add(arr[0]);
                System.out.println(userlist.size());
                choicebox.getItems().add(arr[0]);
                tot++;
            }
            br.close();

        } catch (Exception ex) {
            System.out.println("Exception ex");
        }
//        if (userlist != null) {
//            choicebox.getItems().addAll(username[0]);
//        }
    }

    @FXML
    private void handleNewUserButton(ActionEvent event) throws IOException {
        //System.out.println("here");
        FXMLLoader fXMLLoader = new FXMLLoader(Weight_Monitor.class.getResource("Newuser.fxml"));
        fXMLLoader.load();
        Scene scene = new Scene(fXMLLoader.getRoot());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Create a new user");
        stage.setResizable(false);
        stage.show();
        choicebox.getItems().clear();
        BufferedReader br = null;
        try {
            //System.out.println("here");
            br = new BufferedReader(new FileReader(new File("data.txt")));
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(" ");
                choicebox.getItems().add(arr[0]);
            }
            br.close();

        } catch (Exception ex) {
            System.out.println("Exception ex");
        }

    }

    @FXML
    public void handleDeleteUserButton(ActionEvent event) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader(Weight_Monitor.class.getResource("DeleteUser.fxml"));
        fXMLLoader.load();
        Scene scene = new Scene(fXMLLoader.getRoot());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Delete user");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void handleLoginButton(ActionEvent event) throws IOException {

        myUN = choicebox.getValue();
        FXMLLoader fXMLLoader = new FXMLLoader(Weight_Monitor.class.getResource("Login.fxml"));
        fXMLLoader.load();
        loginController = fXMLLoader.getController();
        Scene scene = new Scene(fXMLLoader.getRoot());
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

}

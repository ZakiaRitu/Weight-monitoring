package weight_monitor;

import java.lang.reflect.InvocationTargetException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Weight_Monitor extends Application {
    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception, InvocationTargetException{
        this.primaryStage = stage;
        FXMLLoader fXMLLoader = new FXMLLoader(Weight_Monitor.class.getResource("Main.fxml"));
        fXMLLoader.load();
        Scene scene = new Scene(fXMLLoader.getRoot());
        stage.setScene(scene);
        stage.setTitle("Weight Monitoring");
        stage.setResizable(false);
        stage.show();
    }


}

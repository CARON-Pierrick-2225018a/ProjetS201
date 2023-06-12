package seismeApp.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import seismeApp.Main;

import java.io.IOException;

public class AppMain extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        //AppControl appControl = new AppControl();
        //fxmlLoader.setController(appControl);

        Parent root = FXMLLoader.load(getClass().getResource("Page1View.fxml"));

        primaryStage.setResizable(true);
        primaryStage.setTitle("Sism'App");
        primaryStage.setScene( new Scene(root) );
        primaryStage.show();
    }
}
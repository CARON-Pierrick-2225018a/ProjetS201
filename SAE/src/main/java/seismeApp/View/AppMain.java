package seismeApp.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import seismeApp.Main;

import java.io.IOException;

public class AppMain extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        //AppControl appControl = new AppControl();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/seismeApp/Page1View.fxml"));
        //fxmlLoader.setController(appControl);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("FXML Custom Control");
        stage.show();
    }
}

package fr.amu.iut.SeismeApp.View;

import fr.amu.iut.SeismeApp.Model.ListeDeSeismes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PageView extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        ListeDeSeismes list = new ListeDeSeismes("/amuhome/g22017449/Bureau/SeismApp/src/main/resources/AppControl/SisFrance_seismes_20230609121408.csv");
        list.setSeismes( list.triProximite(list.getSeismes().get(1),true ));

        System.out.println(list.getSeismes());

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("page1.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("FXML Custom Control");
        stage.show();
    }
}
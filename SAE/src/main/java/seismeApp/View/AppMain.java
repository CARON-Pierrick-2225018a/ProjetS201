package seismeApp.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * La classe AppMain est la classe principale de l'application qui étend la classe Application de JavaFX.
 */
public class AppMain extends Application {

    /**
     * La méthode principale qui démarre l'application.
     *
     * @param args Les arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Méthode appelée lors du démarrage de l'application.
     *
     * @param primaryStage La fenêtre principale de l'application.
     * @throws IOException En cas d'erreur lors du chargement du fichier FXML.
     */
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

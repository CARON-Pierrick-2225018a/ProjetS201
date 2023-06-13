package seismeApp.ViewModel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import seismeApp.Model.ListeDeSeismes;

import java.io.File;

/**
 * Le openCSV est un gestionnaire d'événements qui s'occupe de l'ouverture d'un fichier CSV de séismes.
 * Lorsqu'un événement est déclenché, une boîte de dialogue de sélection de fichier s'ouvre, permettant à l'utilisateur de choisir un fichier CSV.
 * Une fois le fichier sélectionné, il est utilisé pour initialiser une liste de séismes.
 */
public class openCSV implements EventHandler<ActionEvent> {

    /**
     * Gère l'événement de l'ouverture d'un fichier CSV.
     * Affiche une boîte de dialogue de sélection de fichier et utilise le fichier sélectionné pour initialiser une liste de séismes.
     * @param event L'événement déclenché.
     */
    @Override
    public void handle(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            ListeDeSeismes seismes = new ListeDeSeismes(file.getAbsolutePath());
            //histoViewModel.updateHistogram();
            //todo changer a l'aide de bindings l'ensemble des graphs et tableur
        }
    }
}

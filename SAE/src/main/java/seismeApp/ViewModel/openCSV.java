package seismeApp.ViewModel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import seismeApp.Model.ListeDeSeismes;

import java.io.File;

public class openCSV implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            ListeDeSeismes seismes = new ListeDeSeismes(file.getAbsolutePath());
            //histoViewModel.updateHistogram();
        }
    }
}

package seismeApp.View;

import javafx.scene.control.TableView;
import seismeApp.Model.ListeDeSeismes;
import seismeApp.ViewModel.TableRepresentationViewModel;

/**
 * La classe TableRepresentationView est responsable de l'affichage de la représentation tabulaire des séismes dans une vue.
 */
public class TableRepresentationView {
    private ListeDeSeismes listeDeSeismes = new ListeDeSeismes();
    private TableRepresentationViewModel viewModel = new TableRepresentationViewModel(new TableView());
    private TableView tab;

    /**
     * Constructeur de la classe TableRepresentationView.
     * Initialise la table de visualisation des séismes en utilisant le modèle de vue correspondant.
     */
    public TableRepresentationView(){
        this.tab = viewModel.getTableView();
    }

    /**
     * Retourne la table de visualisation des séismes.
     * @return La table de visualisation des séismes.
     */
    public TableView getTableView() {
        return tab;
    }
}

package seismeApp.ViewModel;



import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import seismeApp.Model.ListeDeSeismes;
import seismeApp.Model.Seisme;

/**
 * Le HistoListViewModel est responsable de la manipulation des données nécessaires pour la vue de la liste d'historique des séismes.
 * Il gère la liste des séismes affichés dans la vue.
 */
public class HistoListViewModel {
    // private ListeDeSeismes listDeSeismes;
    private ListProperty<Seisme> seismesProperty;

    /**
     * Constructeur de la classe HistoListViewModel.
     * Initialise la liste des séismes affichés dans la vue en fonction du tri par date.
     */
    public HistoListViewModel() {
        // todo lier listeDeSeisme au filtre
        ListeDeSeismes listDeSeismes = new ListeDeSeismes();
        listDeSeismes.setSeismes(listDeSeismes.triDate(true));
        seismesProperty = new SimpleListProperty<>(FXCollections.observableArrayList(listDeSeismes.getSeismes()));
    }

    /**
     * Obtient la propriété de la liste des séismes.
     * @return La propriété de la liste des séismes.
     */
    public ListProperty<Seisme> seismesProperty() {
        return seismesProperty;
    }

    /**
     * Obtient la liste des séismes.
     * @return La liste des séismes.
     */
    public ListProperty<Seisme> getSeismes() {
        return seismesProperty;
    }
}
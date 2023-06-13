package seismeApp.ViewModel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seismeApp.Model.ListeDeSeismes;
import seismeApp.Model.Seisme;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Le GraphListViewModel est responsable de la manipulation des données nécessaires pour la vue graphique de la liste des séismes.
 * Il gère les propriétés de liste des séismes, des régions et de la liste de séismes.
 */
public class GraphListViewModel {
    private ListeDeSeismes listDeSeismes;
    private ListProperty<Seisme> seismesProperty;
    private ArrayList<String> listeDeRegions = new ArrayList<>();
    private ListProperty<String> regionsProperty;

    /**
     * Constructeur de la classe GraphListViewModel.
     * Initialise la liste de séismes à partir de la liste de séismes triée par date.
     * Initialise également la liste de régions et les propriétés de liste des séismes et de régions.
     */
    public GraphListViewModel() {
        this.listDeSeismes = new ListeDeSeismes();
        this.listDeSeismes.setSeismes(listDeSeismes.triDate(true));
        listeDeRegions.addAll(listDeSeismes.getRegions());
        Collections.sort(listeDeRegions);

        seismesProperty = new SimpleListProperty<>(FXCollections.observableArrayList(listDeSeismes.getSeismes()));
        regionsProperty = new SimpleListProperty<>(FXCollections.observableArrayList(listeDeRegions));
    }

    /**
     * Obtient la propriété de liste des séismes.
     * @return La propriété de liste des séismes.
     */
    public ListProperty<Seisme> seismesProperty() {
        return seismesProperty;
    }

    /**
     * Obtient la liste des séismes.
     * @return La liste des séismes.
     */
    public ObservableList<Seisme> getSeismes() {
        return seismesProperty.get();
    }

    /**
     * Obtient la liste des régions.
     * @return La liste des régions.
     */
    public ArrayList<String> getListeDeRegions() {
        return listeDeRegions;
    }

    /**
     * Obtient la propriété de liste des régions.
     * @return La propriété de liste des régions.
     */
    public ObservableList<String> getRegionsProperty() {
        return regionsProperty.get();
    }

    /**
     * Obtient la propriété de liste des régions.
     * @return La propriété de liste des régions.
     */
    public ListProperty<String> regionsPropertyProperty() {
        return regionsProperty;
    }

    /**
     * Obtient la liste de séismes.
     * @return La liste de séismes.
     */
    public ListeDeSeismes getListDeSeismes() {
        return listDeSeismes;
    }
}

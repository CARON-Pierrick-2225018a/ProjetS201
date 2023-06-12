package seismeApp.ViewModel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seismeApp.Model.ListeDeSeismes;
import seismeApp.Model.Seisme;

import java.util.ArrayList;

public class GraphListViewModel {
    private ListeDeSeismes listDeSeismes;
    private ListProperty<Seisme> seismesProperty;
    private ArrayList<String> listeDeRegions = new ArrayList<>();
    private ListProperty<String> regionsProperty;

    public GraphListViewModel() {
        //todo lier listeDeSeisme au filtre
        this.listDeSeismes = new ListeDeSeismes();
        this.listDeSeismes.setSeismes(listDeSeismes.triDate(true));
        listeDeRegions.addAll(listDeSeismes.getRegions());
        seismesProperty = new SimpleListProperty<>(FXCollections.observableArrayList(listDeSeismes.getSeismes()));
        regionsProperty = new SimpleListProperty<>(FXCollections.observableArrayList(listeDeRegions));
    }

    public ListProperty<Seisme> seismesProperty() {
        return seismesProperty;
    }

    public ObservableList<Seisme> getSeismes() {
        return seismesProperty.get();
    }

    public ArrayList<String> getListeDeRegions() {
        return listeDeRegions;
    }

    public ObservableList<String> getRegionsProperty() {
        return regionsProperty.get();
    }

    public ListProperty<String> regionsPropertyProperty() {
        return regionsProperty;
    }
}

package seismeApp.ViewModel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seismeApp.Model.ListeDeSeismes;
import seismeApp.Model.Seisme;

public class HistoListViewModel {
    //private ListeDeSeismes listDeSeismes;
    private ListProperty<Seisme> seismesProperty;

    public HistoListViewModel() {
        //todo lier listeDeSeisme au filtre
        ListeDeSeismes listDeSeismes = new ListeDeSeismes();
        listDeSeismes.setSeismes(listDeSeismes.triDate(true));
        seismesProperty = new SimpleListProperty<>(FXCollections.observableArrayList(listDeSeismes.getSeismes()));
    }

    public ListProperty<Seisme> seismesProperty() {
        return seismesProperty;
    }

    public ListProperty<Seisme> getSeismes() {
        return seismesProperty ;
    }
}



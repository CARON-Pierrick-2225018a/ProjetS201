package seismeApp.ViewModel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seismeApp.Model.ListeDeSeismes;
import seismeApp.Model.Seisme;

public class GraphListViewModel {
    private ListeDeSeismes listDeSeismes;
    private ListProperty<Seisme> seismesProperty;

    public GraphListViewModel() {
        //todo lier listeDeSeisme au filtre
        this.listDeSeismes = new ListeDeSeismes();
        this.listDeSeismes.setSeismes(listDeSeismes.triDate(true));
        seismesProperty = new SimpleListProperty<>(FXCollections.observableArrayList(listDeSeismes.getSeismes()));
    }

    public ListProperty<Seisme> seismesProperty() {
        return seismesProperty;
    }

    public ObservableList<Seisme> getSeismes() {
        return seismesProperty.get();
    }
}

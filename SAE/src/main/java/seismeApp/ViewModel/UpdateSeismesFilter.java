package seismeApp.ViewModel;

import javafx.beans.property.SimpleObjectProperty;
import seismeApp.Model.ListeDeSeismes;

public class UpdateSeismesFilter{
    private SimpleObjectProperty<ListeDeSeismes> seismesProperty ;

    public UpdateSeismesFilter() {
        this.seismesProperty = new SimpleObjectProperty<>();

    }

    public ListeDeSeismes getSeismesProperty() {
        return seismesProperty.get();
    }

    public SimpleObjectProperty<ListeDeSeismes> seismesPropertyProperty() {
        return seismesProperty;
    }

    public void setSeismesProperty(ListeDeSeismes seismesProperty) {
        this.seismesProperty.set(seismesProperty);
    }
}

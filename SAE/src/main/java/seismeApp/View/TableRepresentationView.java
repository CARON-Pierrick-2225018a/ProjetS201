package seismeApp.View;

import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import seismeApp.Model.ListeDeSeismes;
import seismeApp.Model.Seisme;
import seismeApp.ViewModel.TableRepresentationViewModel;

public class TableRepresentationView {
    private ListeDeSeismes listeDeSeismes = new ListeDeSeismes();
    private TableRepresentationViewModel viewModel = new TableRepresentationViewModel(new TableView());
    private TableView tab;
    public TableRepresentationView(){
        this.tab = viewModel.getTableView();
    }

    public TableView getTableView() {
        return tab;
    }
}

package seismeApp.ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import seismeApp.Model.ListeDeSeismes;
import seismeApp.Model.Seisme;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TableRepresentationViewModel {
    private ListeDeSeismes listeDeSeismes = new ListeDeSeismes();
    private ObservableList<TableColumn> listColumns = FXCollections.observableArrayList();



    private TableView tab;
    public TableRepresentationViewModel(TableView tab){
        this.tab = tab;

        // todo implémenté ici les filtres

        TableColumn<Seisme,Integer> id = new TableColumn<Seisme,Integer>("identifiant");
        id.setCellValueFactory(new PropertyValueFactory<>("identifiant"));
        listColumns.add(id);
        TableColumn<Seisme,Integer> intensite = new TableColumn<Seisme,Integer>("intensite");
        intensite.setCellValueFactory(new PropertyValueFactory<>("intensite"));
        listColumns.add(intensite);
        TableColumn<Seisme,Double> latitude = new TableColumn<Seisme,Double>("latitude");
        latitude.setCellValueFactory(new PropertyValueFactory<>("latitude"));
        listColumns.add(latitude);
        TableColumn<Seisme,Double> longitude = new TableColumn<Seisme,Double>("longitude");
        longitude.setCellValueFactory(new PropertyValueFactory<>("longitude"));
        listColumns.add(longitude);
        TableColumn<Seisme,String> qualiteIntensite = new TableColumn<Seisme,String>("qualiteIntensite");
        qualiteIntensite.setCellValueFactory(new PropertyValueFactory<>("qualiteIntensite"));
        listColumns.add(qualiteIntensite);
        TableColumn<Seisme,String> date = new TableColumn<Seisme, String>("date");
        date.setCellValueFactory(data -> new SimpleStringProperty(new SimpleDateFormat("dd/MM/yyyy").format(data.getValue().getDate())));
        listColumns.add(date);


        TableColumn<Seisme, Time> heure = new TableColumn<Seisme, Time>("heure");
        heure.setCellValueFactory(new PropertyValueFactory<>("heure"));
        listColumns.add(heure);
        TableColumn<Seisme,String> zone = new TableColumn<Seisme,String>("zone");
        zone.setCellValueFactory(new PropertyValueFactory<>("zone"));
        listColumns.add(zone);
        TableColumn<Seisme,String> region = new TableColumn<Seisme,String>("region");
        region.setCellValueFactory(new PropertyValueFactory<>("region"));
        listColumns.add(region);
        TableColumn<Seisme,String> choc = new TableColumn<Seisme,String>("choc");
        choc.setCellValueFactory(new PropertyValueFactory<>("choc"));
        listColumns.add(choc);



        tab.getColumns().addAll(listColumns);
        for (Seisme s : listeDeSeismes.getSeismes()){
            tab.getItems().add(s);
        }
    }
    public TableView getTableView() {
        return tab;
    }
}

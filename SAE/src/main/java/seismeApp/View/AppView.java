package seismeApp.View;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import seismeApp.ViewModel.GraphListViewModel;
import seismeApp.ViewModel.openCSV;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * La classe AppView est responsable de la gestion de l'interface utilisateur de l'application.
 */
public class AppView implements Initializable {

    @FXML
    public DatePicker dateP1;
    @FXML
    public DatePicker dateP2;
    @FXML
    public Button btnOpenCSV;
    @FXML
    public Button btnDashboard;
    @FXML
    public Button btnTableview;
    @FXML
    public Label messageFichier;
    @FXML
    public Label iMax;
    @FXML
    public Label iMin;
    @FXML
    public Label iMoy;
    @FXML
    public TextField searchBar;

    @FXML
    public VBox cartoMap;
    @FXML
    public Label textCarte;
    @FXML
    public AnchorPane zoneMap;
    @FXML
    public AnchorPane zoneHeatMap;

    @FXML
    public VBox zoneGraph;
    @FXML
    public LineChart<String, Number> lineChart;
    @FXML
    public CategoryAxis lineChartxAxis;
    @FXML
    public NumberAxis lineChartyAxis;

    @FXML
    public BarChart barChart;
    @FXML
    public CategoryAxis barxAxis;
    @FXML
    public NumberAxis baryAxis;
    @FXML
    public VBox zoneHisto;

    @FXML
    public ComboBox filtre3;
    @FXML
    public ComboBox filtre2;
    @FXML
    public ComboBox filtre1;
    @FXML
    public ComboBox filtre0;

    @FXML
    public VBox zoneSecteur;
    @FXML
    public PieChart pieChart;
    @FXML
    public ListView listViewAttributs;
    @FXML
    public VBox appVBox;
    @FXML
    public HBox appHboxHaut;
    @FXML
    public HBox appHboxBas;

    /**
     * Méthode de filtrage 1.
     */
    @FXML
    public void filtrer1() {
        System.out.println("b");
    }

    /**
     * Méthode de filtrage 2.
     */
    @FXML
    public void filtrer2() {
        if (filtre2.getValue() != null) {
            graphView.lineChart.getData().clear();
            GraphListViewModel ListModel = new GraphListViewModel();

            ArrayList<XYChart.Series<String, Number>> data = graphView.getViewModel().updatedListProperty(ListModel.getListDeSeismes().rechercheRegion(filtre2.getValue().toString()));
            //System.out.println(data.get(1).getData());
            graphView.lineChart.getData().addAll(data);
        }
    }

    @FXML
    public Button changeView;

    @FXML
    public HBox boxGraphesMilieu;



    private MapSeismeView mapSeismeView;
    private HeatMapSeismeView heatMapSeismeView;
    private GraphView graphView;
    private HistoView histoView;
    private SecteurView secteurView;
    private IndicStatsView indicStatsView;

    /**
     * Méthode d'initialisation appelée lors du chargement de la vue.
     *
     * @param location  L'emplacement utilisé pour résoudre les chemins relatifs des fichiers d'objet racine ou de feuille.
     * @param resources Les ressources utilisées pour localiser l'objet racine ou la feuille.
     */
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        btnOpenCSV.setOnAction(new openCSV());
        mapSeismeView = new MapSeismeView(zoneMap, listViewAttributs);
        mapSeismeView.getView();
        heatMapSeismeView = new HeatMapSeismeView(zoneHeatMap);
        heatMapSeismeView.getView();
        graphView = new GraphView(zoneGraph, lineChart);
        histoView = new HistoView(zoneHisto, barChart);
        secteurView = new SecteurView(zoneSecteur, pieChart);
        indicStatsView = new IndicStatsView(iMax, iMin, iMoy);
        filtre0.itemsProperty().bindBidirectional(graphView.listRegionProperty());
        filtre1.itemsProperty().bindBidirectional(graphView.listRegionProperty());
        filtre2.itemsProperty().bindBidirectional(graphView.listRegionProperty());
        filtre3.itemsProperty().bindBidirectional(graphView.listRegionProperty());
        btnDashboard.setOnAction(event -> {
            appVBox.getChildren().clear();
            appVBox.getChildren().addAll(appHboxHaut, appHboxBas);

        });
        btnTableview.setOnAction(event -> {
            appVBox.getChildren().clear();
            TableRepresentationView tab = new TableRepresentationView();
            tab.getTableView().prefHeightProperty().bind(appVBox.heightProperty());
            appVBox.getChildren().add(tab.getTableView());

        });
    }
}

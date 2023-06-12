package  seismeApp.View;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import seismeApp.ViewModel.GraphListViewModel;
import seismeApp.ViewModel.UpdateSeismesFilter;
import seismeApp.ViewModel.openCSV;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
    public LineChart<String,Number> lineChart;
    @FXML
    public CategoryAxis lineChartxAxis ;
    @FXML
    public NumberAxis lineChartyAxis ;



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
    public void filtrer1(){
        System.out.println("b");
    };
    @FXML
    public void filtrer2(){
        if (filtre2.getValue() != null) {
            graphView.lineChart.getData().clear();
            GraphListViewModel ListModel = new GraphListViewModel();

            ArrayList<XYChart.Series<String, Number>> data = graphView.getViewModel().updatedListProperty(ListModel.getListDeSeismes().rechercheRegion(filtre2.getValue().toString()));
            //System.out.println(data.get(1).getData());
            graphView.lineChart.getData().addAll(data);
        }
    };

    private MapSeismeView mapSeismeView;
    private HeatMapSeismeView heatMapSeismeView;
    private GraphView graphView;
    private HistoView histoView;
    private SecteurView secteurView;
    private IndicStatsView indicStatsView;

    @FXML
    public void initialize(URL location,ResourceBundle resources){
        btnOpenCSV.setOnAction(new openCSV());
        mapSeismeView = new MapSeismeView(zoneMap,listViewAttributs);
        mapSeismeView.getView();
        heatMapSeismeView= new HeatMapSeismeView(zoneHeatMap);
        heatMapSeismeView.getView();
        graphView = new GraphView(zoneGraph,lineChart);
        histoView = new HistoView(zoneHisto,barChart );
        secteurView = new SecteurView( zoneSecteur,pieChart);
        indicStatsView = new IndicStatsView(iMax,iMin,iMoy);
        filtre0.itemsProperty().bindBidirectional(graphView.listRegionProperty());
        filtre1.itemsProperty().bindBidirectional(graphView.listRegionProperty());
        filtre2.itemsProperty().bindBidirectional(graphView.listRegionProperty());
        filtre3.itemsProperty().bindBidirectional(graphView.listRegionProperty());


    }

}
package  seismeApp.View;


import javafx.beans.property.ListProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import seismeApp.ViewModel.GraphListViewModel;

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
    public ComboBox filtre2;
    @FXML
    public ComboBox filtre1;


    private MapSeismeView mapSeismeView;
    private HeatMapSeismeView heatMapSeismeView;
    private GraphView graphView;
    private HistoView histoView;
    private GraphListViewModel ListModel = new GraphListViewModel();

    @FXML
    public void initialize(URL location,ResourceBundle resources){
        mapSeismeView = new MapSeismeView(zoneMap);
        mapSeismeView.getView();
        heatMapSeismeView= new HeatMapSeismeView(zoneHeatMap);
        heatMapSeismeView.getView();
        graphView = new GraphView(zoneGraph,lineChart,lineChartxAxis,lineChartyAxis);
        histoView = new HistoView(zoneHisto,barChart,barxAxis,baryAxis);

        filtre2.itemsProperty().bindBidirectional(ListModel.regionsPropertyProperty());
        filtre1.itemsProperty().bindBidirectional(ListModel.regionsPropertyProperty());
    }

}

package seismeApp.View;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import java.net.URL;
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


    private MapSeismeView mapSeismeView;
    private HeatMapSeismeView heatMapSeismeView;
    private GraphView graphView;
    private HistoView histoView;

    @FXML
    public void initialize(URL location,ResourceBundle resources){
        mapSeismeView = new MapSeismeView(zoneMap);
        mapSeismeView.getView();
        heatMapSeismeView= new HeatMapSeismeView(zoneHeatMap);
        heatMapSeismeView.getView();
        graphView = new GraphView(zoneGraph,lineChart,lineChartxAxis,lineChartyAxis);
        histoView = new HistoView(zoneHisto,barChart,barxAxis,baryAxis);
    }

}
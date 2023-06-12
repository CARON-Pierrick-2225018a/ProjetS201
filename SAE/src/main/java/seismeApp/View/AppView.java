package  seismeApp.View;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
    @FXML
    public void filtrer1(){
        System.out.println("b");
    };
    @FXML
    public void filtrer2(){
        if (filtre2.getValue() != null) {
            graphView.lineChart.getData().clear();
            ArrayList<XYChart.Series<String, Number>> data = graphView.getViewModel().updatedListProperty(ListModel.getListDeSeismes().rechercheRegion(filtre2.getValue().toString()));
            System.out.println(data.get(1).getData());
            graphView.lineChart.getData().addAll(data);
        }
    };

    @FXML
    public Button changeView;

    @FXML
    public HBox boxGraphesMilieu;

    @FXML
    public void changerVue() {
        if (changeView.getText().toString().compareTo("Passer en tableau") == 0) {
            changeView.setText("Passer en graphique");
            boxGraphesMilieu.setSpacing(137);

        }
        else {
            changeView.setText("Passer en tableau");
            boxGraphesMilieu.setSpacing(145);
        }
    }

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

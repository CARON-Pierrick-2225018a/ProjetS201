package seismeApp.View;

import javafx.beans.property.ListProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import seismeApp.ViewModel.GraphListViewModel;
import seismeApp.ViewModel.GraphViewModel;

public class GraphView {
    private GraphViewModel viewModel;
    private VBox zoneGraph;
    public LineChart<String, Number> lineChart;
    private ObservableList<XYChart.Series<String, Number>> observableListSeries;

    public GraphView(VBox zone, LineChart<String, Number> lineChart) {
        zoneGraph = zone;
        this.lineChart = lineChart;
        viewModel = new GraphViewModel();
        //viewModel.getListSeries
        lineChart.getData().addAll(viewModel.getListSeries());
    }

    public GraphViewModel getViewModel() {
        return viewModel;
    }
    public ListProperty<String> listRegionProperty(){
        return viewModel.listRegionProperty();
    }
}
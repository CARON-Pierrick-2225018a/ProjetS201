package seismeApp.View;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.VBox;
import seismeApp.ViewModel.GraphListViewModel;
import seismeApp.ViewModel.GraphViewModel;

public class GraphView {
    private GraphViewModel viewModel;
    private VBox zoneGraph;
    private LineChart<String, Number> lineChart;

    public GraphView(VBox zone, LineChart<String, Number> lineChart, CategoryAxis lineChartxAxis, NumberAxis lineChartyAxis) {
        zoneGraph = zone;
        this.lineChart = lineChart;
        viewModel = new GraphViewModel();
        //viewModel.getListSeries
        lineChart.getData().addAll(viewModel.getListSeries());
    }
}

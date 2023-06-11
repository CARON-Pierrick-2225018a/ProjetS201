package seismeApp.View;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.VBox;
import seismeApp.ViewModel.GraphViewModel;
import seismeApp.ViewModel.HistoViewModel;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;

public class HistoView {
    private VBox zoneHisto;
    private BarChart<String, Number> histoChart;
    private CategoryAxis histoChartxAxis;
    private NumberAxis histoChartyAxis;
    private HistoViewModel viewModel;

    public HistoView(VBox zone, BarChart<String, Number> histoChart, CategoryAxis lineChartxAxis, NumberAxis lineChartyAxis) {
        zoneHisto = zone;
        this.histoChart = histoChart;
        viewModel = new HistoViewModel();

        histoChart.getData().add(viewModel.getSeries());
        histoChart.setBarGap(0);
        histoChart.setCategoryGap(0);
        histoChart.setAnimated(false);

        setBarColors();
    }

    private void setBarColors() {
        String[] barColors = {
                "BLUE", "LAVENDER", "LIME", "YELLOW", "ORANGE", "RED", "MAGENTA", "PURPLE"
        };

        XYChart.Series<String, Number> series = histoChart.getData().get(0);
        int colorIndex = 0;
        for (XYChart.Data<String, Number> data : series.getData()) {
            String barColor = barColors[colorIndex % barColors.length];
            data.getNode().setStyle("-fx-bar-fill: " + barColor + ";");
            colorIndex++;
        }
    }
}
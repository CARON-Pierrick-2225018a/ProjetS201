package seismeApp.View;

import javafx.scene.chart.BarChart;
import javafx.scene.layout.VBox;
import seismeApp.ViewModel.HistoViewModel;
import javafx.scene.chart.XYChart;

/**
 * La classe HistoView est responsable de l'affichage d'un histogramme dans une vue.
 */
public class HistoView {
    private VBox zoneHisto;
    private BarChart<String, Number> histoChart;
    private HistoViewModel viewModel;

    /**
     * Constructeur de la classe HistoView.
     * @param zone L'objet VBox où l'histogramme sera affiché.
     * @param histoChart L'objet BarChart représentant l'histogramme.
     */
    public HistoView(VBox zone, BarChart<String, Number> histoChart) {
        zoneHisto = zone;
        this.histoChart = histoChart;
        viewModel = new HistoViewModel();

        histoChart.getData().add(viewModel.getSeries());
        histoChart.setCategoryGap(0);
        histoChart.setAnimated(false);
        histoChart.setStyle("-fx-legend-visible: false");
        setBarColors();
    }

    /**
     * Définit les couleurs des barres de l'histogramme.
     */
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

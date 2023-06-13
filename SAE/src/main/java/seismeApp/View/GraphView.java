package seismeApp.View;

import javafx.beans.property.ListProperty;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.VBox;
import seismeApp.ViewModel.GraphViewModel;

/**
 * La classe GraphView est responsable de l'affichage d'un graphique de ligne dans une zone spécifique.
 */
public class GraphView {
    private GraphViewModel viewModel;
    private VBox zoneGraph;
    public LineChart<String, Number> lineChart;

    /**
     * Constructeur de la classe GraphView.
     *
     * @param zone       La zone dans laquelle afficher le graphique.
     * @param lineChart  Le graphique de ligne à afficher.
     */
    public GraphView(VBox zone, LineChart<String, Number> lineChart) {
        zoneGraph = zone;
        this.lineChart = lineChart;
        viewModel = new GraphViewModel();
        lineChart.getData().addAll(viewModel.getListSeries());
    }

    /**
     * Retourne le modèle de vue associé à la classe GraphView.
     *
     * @return Le modèle de vue associé à la classe GraphView.
     */
    public GraphViewModel getViewModel() {
        return viewModel;
    }

    /**
     * Retourne la propriété de liste des régions du modèle de vue.
     *
     * @return La propriété de liste des régions du modèle de vue.
     */
    public ListProperty<String> listRegionProperty() {
        return viewModel.listRegionProperty();
    }
}

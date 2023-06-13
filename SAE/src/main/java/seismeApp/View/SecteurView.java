package seismeApp.View;

import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import seismeApp.ViewModel.SecteurViewModel;

/**
 * La classe SecteurView est responsable de l'affichage du diagramme circulaire des secteurs dans une vue.
 */
public class SecteurView {
    private final SecteurViewModel viewModel;

    /**
     * Constructeur de la classe SecteurView.
     * @param zoneSecteur Le VBox qui contient le diagramme circulaire.
     * @param pieChart Le diagramme circulaire.
     */
    public SecteurView(VBox zoneSecteur, PieChart pieChart) {
        viewModel = new SecteurViewModel();
        pieChart.setTitle("% du type de choc");
        pieChart.getData().addAll(viewModel.getPieChartData());
    }
}

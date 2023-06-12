package seismeApp.View;

import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import seismeApp.ViewModel.SecteurViewModel;

public class SecteurView {
    private final SecteurViewModel viewModel;

    public SecteurView(VBox zoneSecteur, PieChart pieChart) {
        viewModel = new SecteurViewModel();
        pieChart.setTitle("% du type de choc");
        pieChart.getData().addAll(viewModel.getPieChartData());
    }
}

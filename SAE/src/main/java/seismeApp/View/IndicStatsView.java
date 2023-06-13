package seismeApp.View;

import javafx.scene.control.Label;
import seismeApp.ViewModel.IndicStatsViewModel;

/**
 * La classe IndicStatsView est responsable de l'affichage des indicateurs statistiques dans une vue.
 */
public class IndicStatsView {
    private final Label iMin;
    private final Label iMoy;
    private final Label iMax;
    private IndicStatsViewModel viewModel;

    /**
     * Constructeur de la classe IndicStatsView.
     * @param iMax Le Label affichant l'intensité maximale.
     * @param iMin Le Label affichant l'intensité minimale.
     * @param iMoy Le Label affichant l'intensité moyenne.
     */
    public IndicStatsView(Label iMax, Label iMin, Label iMoy) {
        viewModel = new IndicStatsViewModel();
        this.iMin = iMin;
        this.iMoy = iMoy;
        this.iMax = iMax;
        this.iMin.setText("Intensité Minimale : " + viewModel.getMin());
        this.iMoy.setText("Intensité Moyenne : " + viewModel.getMoy());
        this.iMax.setText("Intensité Maximale : " + viewModel.getMax());
    }
}

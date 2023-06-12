package seismeApp.View;

import javafx.scene.control.Label;
import seismeApp.ViewModel.IndicStatsViewModel;

public class IndicStatsView {
    private final Label iMin;
    private final Label iMoy;
    private final Label iMax;
    private IndicStatsViewModel viewModel;
    public IndicStatsView(Label iMax, Label iMin, Label iMoy) {
        viewModel = new IndicStatsViewModel();
        this.iMin = iMin;
        this.iMoy = iMoy;
        this.iMax = iMax;
        this.iMin.setText("Intensité Minimale : "+ viewModel.getMin());
        this.iMoy.setText("Intensité Moyenne : "+ viewModel.getMoy());
        this.iMax.setText("Intensité Maximalee : "+ viewModel.getMax());

    }
}

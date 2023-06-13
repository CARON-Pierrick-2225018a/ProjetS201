package seismeApp.ViewModel;

import javafx.scene.chart.XYChart;
import seismeApp.Model.Seisme;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Le HistoViewModel est responsable de la manipulation des données nécessaires pour la vue de l'histogramme des séismes.
 * Il génère les données de l'histogramme à partir de la liste des séismes.
 */
public class HistoViewModel {
    private HistoListViewModel listModel;
    private XYChart.Series<String, Number> series = new XYChart.Series<>();

    /**
     * Constructeur de la classe HistoViewModel.
     * Initialise les données de l'histogramme à partir de la liste des séismes.
     */
    public HistoViewModel() {
        listModel = new HistoListViewModel();

        Map<Integer, Integer> intervalCounts = new HashMap<>();
        for (Seisme s : listModel.getSeismes()) {
            double intensite = s.getIntensite();
            int interval = (int) Math.floor(intensite);
            intervalCounts.put(interval, intervalCounts.getOrDefault(interval, 0) + 1);
        }
        Map<Integer, Integer> sortedMap = new TreeMap<>(intervalCounts);

        for (int i = 1; i < 9; i++) { // on enleve les <2 en mettant i a 1,
            String intervalLabel;
            if (i == 1) { // on enleve les <2 en mettant i a 1,
                intervalLabel = "<2";
            } else if (i == 8) {
                intervalLabel = ">9";
            } else {
                intervalLabel = i + "-" + (i + 1);
            }
            series.getData().add(new XYChart.Data<>(intervalLabel, sortedMap.getOrDefault(i, 0)));
        }
    }

    /**
     * Obtient la série de données de l'histogramme.
     * @return La série de données de l'histogramme.
     */
    public XYChart.Series<String, Number> getSeries() {
        return series;
    }
}

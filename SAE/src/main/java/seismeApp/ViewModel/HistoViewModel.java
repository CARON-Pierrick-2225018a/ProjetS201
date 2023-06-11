package seismeApp.ViewModel;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import seismeApp.Model.Seisme;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
public class HistoViewModel {
    private HistoListViewModel listModel;
    private XYChart.Series<String, Number> series = new XYChart.Series<>();

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

    public XYChart.Series<String, Number> getSeries() {
        return series;
    }
}
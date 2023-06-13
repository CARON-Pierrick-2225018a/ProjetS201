package seismeApp.ViewModel;

import javafx.beans.property.ListProperty;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import seismeApp.Model.Seisme;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Le GraphViewModel est responsable de la manipulation des données nécessaires pour la vue graphique.
 * Il gère les séries de données utilisées pour afficher les graphiques.
 */
public class GraphViewModel {
    private GraphListViewModel listModel = new GraphListViewModel();
    private ArrayList<XYChart.Series<String, Number>> listSeries = new ArrayList<>();
    private ObservableList<Seisme> listSeismes = listModel.getSeismes();

    /**
     * Constructeur de la classe GraphViewModel.
     * Initialise les séries de données utilisées pour les graphiques.
     */
    public GraphViewModel() {
        // Création des séries avec les noms des intervalles
        for (int i = 1; i <= 9; i++) {
            XYChart.Series<String, Number> s = new XYChart.Series<>();
            if (i == 0) {
                s.setName("intensité : <2");
            } else {
                s.setName("intensité : " + i + "-" + (i + 1));
            }
            listSeries.add(s);
        }

        // Comptage des séismes par année et par intervalle
        Map<Integer, Map<Integer, Integer>> yearIntervalCounts = new HashMap<>();
        for (Seisme s : listSeismes) {
            double intensite = s.getIntensite();
            int interval = (int) Math.floor(intensite);
            int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(s.getDate()));
            Map<Integer, Integer> intervalCounts = yearIntervalCounts.getOrDefault(year, new HashMap<>());
            intervalCounts.put(interval, intervalCounts.getOrDefault(interval, 0) + 1);
            yearIntervalCounts.put(year, intervalCounts);
        }

        // Trie des données par année
        Map<Integer, Map<Integer, Integer>> sortedMap = new TreeMap<>(yearIntervalCounts);

        // Sélection des données à afficher
        Integer size = 100;
        if (sortedMap.size() > size) {
            int entriesToSkip = sortedMap.size() - size;
            sortedMap = new TreeMap<>(sortedMap).subMap(sortedMap.entrySet().stream().skip(entriesToSkip).findFirst().get().getKey(),
                    ((TreeMap<Integer, Map<Integer, Integer>>) sortedMap).lastKey() + 1);
        }

        // Ajout des données aux séries
        for (int i = 0; i < 9; i++) {
            XYChart.Series<String, Number> series = listSeries.get(i);
            String intervalLabel;
            if (i == 0) {
                intervalLabel = "<2";
            } else {
                intervalLabel = i + "-" + (i + 1);
            }

            for (Map.Entry<Integer, Map<Integer, Integer>> entry : sortedMap.entrySet()) {
                int year = entry.getKey();
                int count = entry.getValue().getOrDefault(i, 0);
                series.getData().add(new XYChart.Data<>(String.valueOf(year), count));
            }
        }
    }

    /**
     * Obtient la liste des séries de données utilisées pour les graphiques.
     * @return La liste des séries de données.
     */
    public ArrayList<XYChart.Series<String, Number>> getListSeries() {
        return listSeries;
    }

    /**
     * Met à jour la liste des séries de données en fonction d'une nouvelle liste de séismes.
     * @param liste La nouvelle liste de séismes.
     * @return La liste des séries de données mise à jour.
     */
    public ArrayList<XYChart.Series<String, Number>> updatedListProperty(ArrayList<Seisme> liste) {
        GraphListViewModel ListModelTemp = new GraphListViewModel();
        ListModelTemp.getListDeSeismes().setSeismes(liste);
        ArrayList<XYChart.Series<String, Number>> listSeriesTemp = new ArrayList<>();
        ObservableList<Seisme> listSeismesTemp = ListModelTemp.getSeismes();

        // Création des séries avec les noms des intervalles
        for (int i = 1; i <= 9; i++) {
            XYChart.Series<String, Number> s = new XYChart.Series<>();
            if (i == 0) {
                s.setName("intensité : <2");
            } else {
                s.setName("intensité : " + i + "-" + (i + 1));
            }
            listSeriesTemp.add(s);
        }

        // Comptage des séismes par année et par intervalle
        Map<Integer, Map<Integer, Integer>> yearIntervalCounts = new HashMap<>();
        for (Seisme s : listSeismesTemp) {
            double intensite = s.getIntensite();
            int interval = (int) Math.floor(intensite);
            int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(s.getDate()));
            Map<Integer, Integer> intervalCounts = yearIntervalCounts.getOrDefault(year, new HashMap<>());
            intervalCounts.put(interval, intervalCounts.getOrDefault(interval, 0) + 1);
            yearIntervalCounts.put(year, intervalCounts);
        }

        // Trie des données par année
        Map<Integer, Map<Integer, Integer>> sortedMap = new TreeMap<>(yearIntervalCounts);

        // Sélection des données à afficher
        Integer size = 100;
        if (sortedMap.size() > size) {
            int entriesToSkip = sortedMap.size() - size;
            sortedMap = new TreeMap<>(sortedMap).subMap(sortedMap.entrySet().stream().skip(entriesToSkip).findFirst().get().getKey(),
                    ((TreeMap<Integer, Map<Integer, Integer>>) sortedMap).lastKey() + 1);
        }

        // Ajout des données aux séries
        for (int i = 0; i < 9; i++) {
            XYChart.Series<String, Number> series = listSeriesTemp.get(i);
            String intervalLabel;
            if (i == 0) {
                intervalLabel = "<2";
            } else {
                intervalLabel = i + "-" + (i + 1);
            }

            for (Map.Entry<Integer, Map<Integer, Integer>> entry : sortedMap.entrySet()) {
                int year = entry.getKey();
                int count = entry.getValue().getOrDefault(i, 0);
                series.getData().add(new XYChart.Data<>(String.valueOf(year), count));
            }
        }
        return listSeriesTemp;
    }

    /**
     * Obtient la propriété de liste des régions.
     * @return La propriété de liste des régions.
     */
    public ListProperty<String> listRegionProperty() {
        return listModel.regionsPropertyProperty();
    }
}

package seismeApp.ViewModel;

import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import seismeApp.Model.Seisme;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GraphViewModel {
    private GraphListViewModel ListModel = new GraphListViewModel();
    private ArrayList<XYChart.Series<String, Number>> listSeries = new ArrayList<>();
    private ObservableList<Seisme> listSeismes= ListModel.getSeismes();
    public GraphViewModel() {
        //lineChart.setAnimated(false);

        // Création des séries avec les noms des intervalles
        for (int i = 0; i <= 9; i++) { // si on veut les affiché il faut changer i
            XYChart.Series<String, Number> s = new XYChart.Series<>();
            if (i == 0) { // on affiche pas les non renseignés
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


        Map<Integer,Map<Integer,Integer> > sortedMap = new TreeMap<>(yearIntervalCounts);
        // on pourra se servir de ce genre de chose pour trier sur une durée voulu
        //trier du debut jusqu'a un indice max
        /*
        if (sortedMap.size() > 10) {
            sortedMap = new TreeMap<>(sortedMap).subMap(((TreeMap<Integer, Map<Integer, Integer>>) sortedMap).firstKey(),
                    sortedMap.entrySet().stream().skip(10).findFirst().get().getKey());
        }
        */
        if (sortedMap.size() > 15) {
            int entriesToSkip = sortedMap.size() - 15;
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
                //System.out.println(entry);
                series.getData().add(new XYChart.Data<>(String.valueOf(year), count));
            }

        }
    }
    public  ArrayList<XYChart.Series<String, Number>> getListSeries(){
        return listSeries;
    }
}

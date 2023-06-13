package seismeApp.ViewModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import seismeApp.Model.ListeDeSeismes;
import seismeApp.Model.Seisme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Le SecteurViewModel est responsable de la création des données pour le graphique en secteurs.
 * Il collecte les données des types de chocs à partir de la liste de séismes et calcule les pourcentages correspondants.
 * Les données sont ensuite stockées dans une liste observable utilisée par le graphique en secteurs.
 */
public class SecteurViewModel {
    private ObservableList<PieChart.Data> pieChartData ;

    /**
     * Initialise le SecteurViewModel et collecte les données des types de chocs à partir de la liste de séismes.
     * Les pourcentages correspondants sont calculés et les données sont stockées dans une liste observable pour le graphique en secteurs.
     */
    public SecteurViewModel(){
        pieChartData = FXCollections.observableArrayList();
        // TODO les filtres s'appliquent ici

        ListeDeSeismes listeDeSeismes = new ListeDeSeismes();

        // Comptage des types de chocs
        Map<String, Integer> chocCounts = new HashMap<>();
        int totalCount = 0; // Variable pour stocker le nombre total d'occurrences de tous les types de chocs

        for (Seisme seisme : listeDeSeismes.getSeismes()) {
            String choc = seisme.getChoc();
            if (choc != null && !choc.isEmpty()) { // Vérification de la non-nullité et de la non-viduité
                chocCounts.put(choc, chocCounts.getOrDefault(choc, 0) + 1);
                totalCount++;
            }
        }

        // Ajout des données à la liste pieChartData avec les pourcentages
        for (Map.Entry<String, Integer> entry : chocCounts.entrySet()) {
            String choc = entry.getKey();
            int count = entry.getValue();

            double percentage = (count / (double) totalCount) * 100; // Calcul du pourcentage

            pieChartData.add(new PieChart.Data(choc + " (" + String.format("%.1f", percentage) + "%)", count));

        }
    }

    /**
     * Retourne la liste observable des données du graphique en secteurs.
     * @return La liste observable des données du graphique en secteurs.
     */
    public ObservableList<PieChart.Data> getPieChartData() {
        return pieChartData;
    }

}

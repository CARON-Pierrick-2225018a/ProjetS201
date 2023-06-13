package seismeApp.ViewModel;

import seismeApp.Model.ListeDeSeismes;

import java.util.ArrayList;

/**
 * Le IndicStatsViewModel est responsable de la manipulation des données nécessaires pour les indicateurs statistiques des séismes.
 * Il calcule les statistiques d'intensité à partir de la liste des séismes.
 */
public class IndicStatsViewModel {
    private ListeDeSeismes seismes;
    private ArrayList<Double> indicsStats;

    /**
     * Constructeur de la classe IndicStatsViewModel.
     * Initialise les statistiques d'intensité à partir de la liste des séismes.
     */
    public IndicStatsViewModel() {
        seismes = new ListeDeSeismes();
        indicsStats = new ArrayList<>();

        indicsStats.add(seismes.getIntensiteAvg(seismes));
        indicsStats.add(seismes.getIntensiteMax());
        indicsStats.add(seismes.getIntensiteMin());
    }

    /**
     * Obtient la valeur maximale d'intensité des séismes.
     * @return La valeur maximale d'intensité des séismes.
     */
    public String getMax() {
        return String.valueOf(indicsStats.get(1));
    }

    /**
     * Obtient la valeur minimale d'intensité des séismes.
     * @return La valeur minimale d'intensité des séismes.
     */
    public String getMin() {
        return String.valueOf(indicsStats.get(2));
    }

    /**
     * Obtient la valeur moyenne d'intensité des séismes.
     * @return La valeur moyenne d'intensité des séismes.
     */
    public String getMoy() {
        return String.valueOf(indicsStats.get(0));
    }
}

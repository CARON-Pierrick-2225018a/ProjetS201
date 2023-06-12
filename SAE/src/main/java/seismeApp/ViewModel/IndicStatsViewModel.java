package seismeApp.ViewModel;

import javafx.beans.property.ListProperty;
import seismeApp.Model.ListeDeSeismes;
import seismeApp.Model.Seisme;

import java.util.ArrayList;

public class IndicStatsViewModel {
    private ListeDeSeismes seismes;
    private ArrayList<Double> indicsStats;
    public IndicStatsViewModel(){
        seismes = new ListeDeSeismes() ;
        indicsStats = new ArrayList<>();

        indicsStats.add(seismes.getIntensiteAvg(seismes));
        indicsStats.add(seismes.getIntensiteMax());
        indicsStats.add(seismes.getIntensiteMin());

    }
    public String getMax(){
        return String.valueOf(indicsStats.get(1));
    }
    public String getMin(){
        return String.valueOf(indicsStats.get(2));

    }
    public String getMoy(){
        return String.valueOf(indicsStats.get(0));

    }
}

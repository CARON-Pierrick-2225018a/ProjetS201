package seismeApp.ViewModel;

import com.gluonhq.maps.MapPoint;
import javafx.scene.paint.Color;
import seismeApp.Model.ListeDeSeismes;
import seismeApp.Model.Seisme;

import java.util.ArrayList;

/**
 * Le HeatMapCircleMarkerLayerViewModel est responsable de la manipulation des données nécessaires pour la vue de la carte thermique.
 * Il gère les points sur la carte, les couleurs associées et les intensités des séismes.
 */
public class HeatMapCircleMarkerLayerViewModel {
    private ArrayList<MapPoint> listMapPoint;
    private ArrayList<Color> listColor;
    private ArrayList<Double> listIntensite;
    private ListeDeSeismes seismes;

    /**
     * Constructeur de la classe HeatMapCircleMarkerLayerViewModel.
     * Initialise les listes de points sur la carte, de couleurs associées et d'intensités des séismes.
     */
    public HeatMapCircleMarkerLayerViewModel() {
        seismes = new ListeDeSeismes();
        listMapPoint = new ArrayList<>();
        listColor = new ArrayList<>();
        listIntensite = new ArrayList<>();

        // TODO ici on va devoir enlever de la liste seismes les éléments pas dans la combo box lieux

        seismes.setSeismes(seismes.triIntensite(true));
        // System.out.println(seismes.getSeismes()); debug pour voir si csv bien chargé
        for (Seisme s : seismes.getSeismes()) {
            listMapPoint.add(new MapPoint(s.getLatitude(), s.getLongitude()));
            if (s.getIntensite() < 2) {
                listColor.add(Color.BLUE); // cas inconnu
            } else if (s.getIntensite() >= 2 && s.getIntensite() < 3) {
                listColor.add(Color.LAVENDER);
            } else if (s.getIntensite() >= 3 && s.getIntensite() < 4) {
                listColor.add(Color.AQUA);
            } else if (s.getIntensite() >= 4 && s.getIntensite() < 5) {
                listColor.add(Color.LIME);
            } else if (s.getIntensite() >= 5 && s.getIntensite() < 6) {
                listColor.add(Color.YELLOW);
            } else if (s.getIntensite() >= 6 && s.getIntensite() < 7) {
                listColor.add(Color.ORANGE);
            } else if (s.getIntensite() >= 7 && s.getIntensite() < 8) {
                listColor.add(Color.RED);
            } else if (s.getIntensite() >= 8 && s.getIntensite() < 9) {
                listColor.add(Color.MAGENTA);
            } else if (s.getIntensite() >= 9) {
                listColor.add(Color.PURPLE);
            }

            listIntensite.add(50 - s.getIntensite() * 5.5);
        }
    }

    /**
     * Obtient la liste des points sur la carte.
     * @return La liste des points sur la carte.
     */
    public ArrayList<MapPoint> getListMapPoint() {
        return listMapPoint;
    }

    /**
     * Définit la liste des points sur la carte.
     * @param listMapPoint La nouvelle liste des points sur la carte.
     */
    public void setListMapPoint(ArrayList<MapPoint> listMapPoint) {
        this.listMapPoint = listMapPoint;
    }

    /**
     * Obtient la liste des couleurs associées aux points sur la carte.
     * @return La liste des couleurs associées aux points sur la carte.
     */
    public ArrayList<Color> getListColor() {
        return listColor;
    }

    /**
     * Définit la liste des couleurs associées aux points sur la carte.
     * @param listColor La nouvelle liste des couleurs associées aux points sur la carte.
     */
    public void setListColor(ArrayList<Color> listColor) {
        this.listColor = listColor;
    }

    /**
     * Obtient la liste des intensités des séismes.
     * @return La liste des intensités des séismes.
     */
    public ArrayList<Double> getListIntensite() {
        return listIntensite;
    }

    /**
     * Définit la liste des intensités des séismes.
     * @param listIntensite La nouvelle liste des intensités des séismes.
     */
    public void setListIntensite(ArrayList<Double> listIntensite) {
        this.listIntensite = listIntensite;
    }

    /**
     * Obtient la liste des séismes.
     * @return La liste des séismes.
     */
    public ListeDeSeismes getSeismes() {
        return seismes;
    }

    /**
     * Définit la liste des séismes.
     * @param seismes La nouvelle liste des séismes.
     */
    public void setSeismes(ListeDeSeismes seismes) {
        this.seismes = seismes;
    }
}

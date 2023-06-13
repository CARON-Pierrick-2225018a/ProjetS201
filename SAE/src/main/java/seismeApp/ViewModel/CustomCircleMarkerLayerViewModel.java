package seismeApp.ViewModel;

import com.gluonhq.maps.MapPoint;
import javafx.scene.paint.Color;
import seismeApp.Model.ListeDeSeismes;
import seismeApp.Model.Seisme;
import java.util.ArrayList;

/**
 * Le CustomCircleMarkerLayerViewModel est responsable de la manipulation des données nécessaires pour le calque de marqueurs de cercle personnalisé.
 * Il stocke les informations sur les points de carte, les couleurs des cercles, les intensités et les identifiants des séismes.
 */
public class CustomCircleMarkerLayerViewModel {
    private ArrayList<MapPoint> listMapPoint;
    private ArrayList<Color> listColor;
    private ArrayList<Double> listIntensite;
    private ArrayList<Integer> listIndentifiant;
    private ListeDeSeismes seismes;

    /**
     * Obtient la liste des identifiants des séismes.
     * @return La liste des identifiants des séismes.
     */
    public ArrayList<Integer> getListIndentifiant() {
        return listIndentifiant;
    }

    /**
     * Définit la liste des identifiants des séismes.
     * @param listIndentifiant La liste des identifiants des séismes.
     */
    public void setListIndentifiant(ArrayList<Integer> listIndentifiant) {
        this.listIndentifiant = listIndentifiant;
    }

    /**
     * Obtient la liste des points de carte.
     * @return La liste des points de carte.
     */
    public ArrayList<MapPoint> getListMapPoint() {
        return listMapPoint;
    }

    /**
     * Définit la liste des points de carte.
     * @param listMapPoint La liste des points de carte.
     */
    public void setListMapPoint(ArrayList<MapPoint> listMapPoint) {
        this.listMapPoint = listMapPoint;
    }

    /**
     * Obtient la liste des couleurs des cercles.
     * @return La liste des couleurs des cercles.
     */
    public ArrayList<Color> getListColor() {
        return listColor;
    }

    /**
     * Définit la liste des couleurs des cercles.
     * @param listColor La liste des couleurs des cercles.
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
     * @param listIntensite La liste des intensités des séismes.
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
     * @param seismes La liste des séismes.
     */
    public void setSeismes(ListeDeSeismes seismes) {
        this.seismes = seismes;
    }

    /**
     * Constructeur de la classe CustomCircleMarkerLayerViewModel.
     * Initialise les listes des points de carte, des couleurs des cercles, des intensités et des identifiants des séismes.
     * Initialise également la liste de séismes.
     */
    public CustomCircleMarkerLayerViewModel() {
        seismes = new ListeDeSeismes();
        listMapPoint = new ArrayList<>();
        listColor = new ArrayList<>();
        listIntensite = new ArrayList<>();
        listIndentifiant = new ArrayList<>();

        seismes.setSeismes(seismes.triIntensite(true));

        for (Seisme s : seismes.getSeismes()) {
            listIntensite.add(s.getIntensite() + 10);
            listIndentifiant.add(s.getIdentifiant());
            listMapPoint.add(new MapPoint(s.getLatitude(), s.getLongitude()));
            if (s.getIntensite() < 2) {
                listColor.add(Color.BLUE);
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
        }
    }
}

package seismeApp.ViewModel;

import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import seismeApp.Model.Seisme;

import java.text.SimpleDateFormat;

/**
 * Le gestionnaire d'événements CircleClickHandler est responsable de la manipulation des clics sur un cercle sur la carte.
 * Il effectue des actions spécifiques lorsqu'un cercle est cliqué, tels que le déplacement de la carte vers le séisme correspondant et l'affichage de ses détails dans une liste.
 */
public class CircleClickHandler implements EventHandler<MouseEvent> {
    private Seisme s;
    private MapView mapView;
    private MapPoint mapPoint;
    private ListView list;

    /**
     * Constructeur de la classe CircleClickHandler.
     * Initialise les séismes, la carte, le point de carte et la liste associés au gestionnaire d'événements.
     * @param s Le séisme associé au cercle.
     * @param mapView La carte utilisée pour afficher les séismes.
     * @param mapPoint Le point de carte correspondant au séisme.
     * @param list La liste utilisée pour afficher les détails du séisme.
     */
    public CircleClickHandler(Seisme s, MapView mapView, MapPoint mapPoint, ListView list) {
        this.s = s;
        this.mapView = mapView;
        this.mapPoint = mapPoint;
        this.list = list;
    }

    /**
     * Gère l'événement de clic sur le cercle.
     * Lorsqu'un cercle est cliqué, la carte se déplace vers le séisme correspondant et les détails du séisme sont affichés dans la liste.
     * @param event L'événement de clic de la souris.
     */
    @Override
    public void handle(MouseEvent event) {
        if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
            mapView.flyTo(0, mapPoint, 0.3);
            list.getItems().clear();
            String date = new SimpleDateFormat("yyyy").format(s.getDate());

            list.getItems().add("Identifiant : " + s.getIdentifiant());
            list.getItems().add("Intensite : " + s.getIntensite());
            list.getItems().add("Qualité du Renseignement: " + s.getQualiteIntensite());
            list.getItems().add("Date : " + date);
            list.getItems().add("Heure : " + s.getHeure());
            list.getItems().add("Zone : " + s.getZone());
            list.getItems().add("Region : " + s.getRegion());
            list.getItems().add("Choc : " + s.getChoc());
            list.getItems().add("Longitude : " + s.getLongitude());
            list.getItems().add("Latitude : " + s.getLatitude());

            //list.getItems().add(s);
            //System.out.println(s);
        }
    }
}

package seismeApp.ViewModel;

import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import seismeApp.Model.Seisme;

import java.text.SimpleDateFormat;

public class CircleClickHandler implements EventHandler<MouseEvent> {
    private Seisme s;
    private MapView mapView ;
    private MapPoint mapPoint ;
    private ListView list;
    public CircleClickHandler(Seisme s, MapView mapView, MapPoint mapPoint,ListView list) {
        this.s = s;
        this.mapView = mapView;
        this.mapPoint = mapPoint;
        this.list = list;
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED )){
            mapView.flyTo(0,mapPoint,0.3);
            list.getItems().clear();
            String date = new SimpleDateFormat("yyyy").format(s.getDate());

            list.getItems().add("Identifiant : "+s.getIdentifiant());
            list.getItems().add("Intensite : "+s.getIntensite());
            list.getItems().add("Qualité du Renseignement: "+s.getQualiteIntensite());
            list.getItems().add("Date : "+date);
            list.getItems().add("Heure : "+s.getHeure());
            list.getItems().add("Zone : "+s.getZone());
            list.getItems().add("Region : "+s.getRegion());
            list.getItems().add("Choc : "+s.getChoc());
            list.getItems().add("Longitude : "+s.getLongitude());
            list.getItems().add("Latitude : "+s.getLatitude());

            //list.getItems().add(s);
            System.out.println(s); // todo remplacer par l'affichage dans la search box
        };
    }
}

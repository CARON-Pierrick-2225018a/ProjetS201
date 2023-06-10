package seismeApp.ViewModel;

import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import seismeApp.Model.Seisme;

import java.util.Map;

public class CircleClickHandler implements EventHandler<MouseEvent> {
    private int id ;
    private Seisme s;
    private MapView mapView ;
    private MapPoint mapPoint ;


    public CircleClickHandler(Seisme s, MapView mapView, MapPoint mapPoint) {
        this.id = s.getIdentifiant();
        this.s = s;
        this.mapView = mapView;
        this.mapPoint = mapPoint;
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED )){
            mapView.flyTo(0,mapPoint,0.3);

            System.out.println(s);
        };
    }
}

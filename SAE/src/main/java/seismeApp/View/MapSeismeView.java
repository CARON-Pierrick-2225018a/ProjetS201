package seismeApp.View;

import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * La classe MapSeismeView est responsable de l'affichage de la carte des séismes dans une vue.
 */
public class MapSeismeView {

    private MapView mapView;
    private AnchorPane zone;
    private Button btnPlus = new Button("+");
    private Button btnMoins= new Button("-");
    private VBox vbox = new VBox(btnPlus,btnMoins);

    /**
     * Constructeur de la classe MapSeismeView.
     * @param zoneCarte L'AnchorPane qui contient la carte.
     * @param listView La ListView associée à la carte.
     */
    public MapSeismeView(AnchorPane zoneCarte, ListView listView){
        System.setProperty("javafx.platform", "desktop");
        System.setProperty("http.agent", "Gluon Mobile/1.0.3");

        zone = zoneCarte;
        mapView = new MapView();
        MapLayer circleView = new CustomCircleMarkerLayerView(mapView,listView);
        MapPoint mapPoint = new MapPoint(46.227638, 2.213749);

        mapView.addLayer(circleView);
        mapView.setZoom(5.5);

        mapView.setPrefSize(730,570);
        mapView.setMinSize(730,570);
        mapView.setMaxSize(730,570);
        mapView.flyTo(0, mapPoint, 0.1);
        btnPlus.setOnAction(event -> {mapView.setZoom(mapView.getZoom()+1);
            ((CustomCircleMarkerLayerView) circleView).layoutLayer();});
        btnMoins.setOnAction(event -> {mapView.setZoom(mapView.getZoom()-1);
            ((CustomCircleMarkerLayerView) circleView).layoutLayer();});
        btnPlus.setPrefSize(30,30);
        btnMoins.setPrefSize(30,30);

        mapView.addEventFilter(ScrollEvent.ANY, new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                event.consume();
            }
        });

        mapView.setCenter(mapPoint);
    }

    /**
     * Méthode pour obtenir la vue de la carte.
     */
    public void getView(){

        zone.getChildren().add(mapView);
        zone.getChildren().add(vbox);

    }
}

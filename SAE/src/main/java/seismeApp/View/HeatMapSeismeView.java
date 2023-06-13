package seismeApp.View;

import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * La classe HeatMapSeismeView est responsable de l'affichage de la carte thermique des séismes dans une vue.
 */
public class HeatMapSeismeView {
    private AnchorPane zone;
    private MapView mapView;
    private Button btnPlus = new Button("+");
    private Button btnMoins = new Button("-");
    private VBox vbox = new VBox(btnPlus, btnMoins);

    /**
     * Constructeur de la classe HeatMapSeismeView.
     * @param zone L'AnchorPane où la carte et les boutons seront affichés.
     */
    public HeatMapSeismeView(AnchorPane zone) {
        this.zone = zone;
        System.setProperty("javafx.platform", "desktop");
        System.setProperty("http.agent", "Gluon Mobile/1.0.3");
        mapView = new MapView();
        MapPoint mapPoint = new MapPoint(46.227638, 2.213749);
        MapLayer circleView = new HeatMapCircleMarkerLayerView();
        mapView.addLayer(circleView);

        mapView.setZoom(5.5);
        mapView.flyTo(0, mapPoint, 0.1);

        mapView.setPrefSize(730, 570);
        mapView.setMinSize(730, 570);
        mapView.setMaxSize(730, 570);
        btnPlus.setOnAction(event -> {
            mapView.setZoom(mapView.getZoom() + 1);
            ((HeatMapCircleMarkerLayerView) circleView).layoutLayer();
        });
        btnMoins.setOnAction(event -> {
            mapView.setZoom(mapView.getZoom() - 1);
            ((HeatMapCircleMarkerLayerView) circleView).layoutLayer();
        });
        btnPlus.setPrefSize(30, 30);
        btnMoins.setPrefSize(30, 30);
        mapView.addEventFilter(ScrollEvent.ANY, new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                event.consume();
            }
        });
        mapView.setCenter(mapPoint);
    }

    /**
     * Affiche la vue contenant la carte et les boutons.
     */
    public void getView() {
        zone.getChildren().add(mapView);
        zone.getChildren().add(vbox);
    }
}

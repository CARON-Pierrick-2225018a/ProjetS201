package seismeApp.View;

import eu.hansolo.fx.heatmap.HeatMap;
import javafx.scene.layout.AnchorPane;
import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;


import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;

public class HeatMapSeismeView {
    private MapLayer circleView;
    private AnchorPane zone;
    private MapView mapView;

    public HeatMapSeismeView(AnchorPane zone){
        this.zone = zone;
        System.setProperty("javafx.platform", "desktop");
        System.setProperty("http.agent", "Gluon Mobile/1.0.3");
        mapView = new MapView();


        MapLayer circleView = new HeatMapCircleMarkerLayerView();

        //heatmap = circleView.getHeatMap();


        mapView.addLayer(circleView);

        MapPoint mapPoint = new MapPoint(46.227638, 2.213749);
        mapView.setZoom(5.5);
        mapView.setPrefSize(750,570);
        mapView.setMinSize(550,450);
        mapView.setMaxSize(750,570);
        mapView.flyTo(0, mapPoint, 0.1);
        mapView.addEventFilter(ScrollEvent.ANY, new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                event.consume();
            }
        });
        mapView.setCenter(mapPoint);

    }

    public void getView(){
        zone.getChildren().add(mapView);
        //zone.getChildren().add(circleView);
    }
}

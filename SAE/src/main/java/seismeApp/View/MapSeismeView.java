package seismeApp.View;

import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;


import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import seismeApp.ViewModel.MapSeismeViewModel;

public class MapSeismeView {

    private MapView mapView;
    private AnchorPane zone;
    private MapSeismeViewModel mapViewModel;
    private CustomCircleMarkerLayerView circleView;
    public MapSeismeView(AnchorPane zoneCarte ){

        zone = zoneCarte;
        System.setProperty("javafx.platform", "desktop");
        System.setProperty("http.agent", "Gluon Mobile/1.0.3");
        mapView = new MapView();
        mapViewModel = new MapSeismeViewModel();


        MapLayer circleView = new CustomCircleMarkerLayerView();
        mapView.addLayer(circleView);

        MapPoint mapPoint = new MapPoint(46.227638, 2.213749);
        mapView.setZoom(5.1);
        mapView.setPrefSize(550,450);
        mapView.setMinSize(550,450);
        mapView.setMaxSize(550,450);
        mapView.flyTo(0, mapPoint, 0.1);

        mapView.addEventFilter(ScrollEvent.ANY, new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                event.consume();
            }
        });


        //  MapPoint mapPoint = new MapPoint(46.227638, 2.213749); ajout point
        mapView.setCenter(mapPoint);
    }

    public void getView(){
        zone.getChildren().add(mapView);
    }
}

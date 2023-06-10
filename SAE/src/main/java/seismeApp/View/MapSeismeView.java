package seismeApp.View;

import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;


import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import seismeApp.ViewModel.MapSeismeViewModel;

public class MapSeismeView {

    private MapView mapView;
    private AnchorPane zone;
    private CustomCircleMarkerLayerView circleView;
    private Button btnPlus = new Button("+");
    private Button btnMoins= new Button("-");
    private VBox vbox = new VBox(btnPlus,btnMoins);

    public MapSeismeView(AnchorPane zoneCarte ){

        zone = zoneCarte;
        System.setProperty("javafx.platform", "desktop");
        System.setProperty("http.agent", "Gluon Mobile/1.0.3");
        mapView = new MapView();


        MapLayer circleView = new CustomCircleMarkerLayerView();
        mapView.addLayer(circleView);

        MapPoint mapPoint = new MapPoint(46.227638, 2.213749);
        mapView.setZoom(5.5);
        mapView.setPrefSize(750,570);
        mapView.setMinSize(550,450);
        mapView.setMaxSize(750,570);
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


        //  MapPoint mapPoint = new MapPoint(46.227638, 2.213749); ajout point
        mapView.setCenter(mapPoint);
    }

    public void getView(){

        zone.getChildren().add(mapView);
        zone.getChildren().add(vbox);

    }
}

package seismeApp.View;

import com.gluonhq.maps.MapView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MapSeismeView {

    private VBox cartoMap;
    private Label text;
    private Pane paneBoxForMap;
    private MapView mapView;
    public MapSeismeView(VBox fromFxmlCartoMap, Label textCarte,Pane map){
        cartoMap = fromFxmlCartoMap;
        text = textCarte;
        paneBoxForMap = map;
        System.setProperty("javafx.platform", "desktop");
        System.setProperty("http.agent", "Gluon Mobile/1.0.3");
        mapView = new MapView();



        //  MapPoint mapPoint = new MapPoint(46.227638, 2.213749); ajout point
        paneBoxForMap.getChildren().add(mapView);
    }


}

package seismeApp.View;

import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import seismeApp.ViewModel.CircleClickHandler;
import seismeApp.ViewModel.CustomCircleMarkerLayerViewModel;

import java.util.ArrayList;

public class CustomCircleMarkerLayerView extends MapLayer {


    private ObservableList<Circle> listCircle= FXCollections.observableArrayList();



    private ArrayList<MapPoint> listMapPoint;
    private ArrayList<Double> listIntensite;
    private ArrayList<Color> listColor;

    private CustomCircleMarkerLayerViewModel viewModel;

    public CustomCircleMarkerLayerView(MapView mapView) {
        viewModel = new CustomCircleMarkerLayerViewModel();
        //MapPoint mapPoint,double intensite,Color color
        listMapPoint = viewModel.getListMapPoint();
        listColor = viewModel.getListColor();
        listIntensite = viewModel.getListIntensite();
        for (int i = 0 ; i<listMapPoint.size(); i++){
            CircleClickHandler circleClickHandler = new CircleClickHandler(((viewModel.getSeismes()).getSeismes()).get(i),
                                                                            mapView,listMapPoint.get(i));

            listCircle.add(new Circle(listIntensite.get(i)*0.3,listColor.get(i)));
            listCircle.get(i).setOnMouseClicked(circleClickHandler);
        }

        this.getChildren().addAll(listCircle);

    }
    @Override
    protected void layoutLayer() {
        /* Conversion du MapPoint vers Point2D */
        for (int i = 0 ; i<listMapPoint.size(); i++){
            Point2D point2d = this.getMapPoint(listMapPoint.get(i).getLatitude(),
                                               listMapPoint.get(i).getLongitude());

            /* Déplace le cercle selon les coordonnées du point */
            listCircle.get(i).setTranslateX(point2d.getX());
            listCircle.get(i).setTranslateY(point2d.getY());

        }

    }


}

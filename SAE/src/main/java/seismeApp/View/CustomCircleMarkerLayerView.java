package seismeApp.View;

import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import seismeApp.ViewModel.CircleClickHandler;
import seismeApp.ViewModel.CustomCircleMarkerLayerViewModel;
import java.util.ArrayList;

/**
 * La classe CustomCircleMarkerLayerView est responsable de l'affichage des marqueurs de cercle personnalisés sur une carte.
 */
public class CustomCircleMarkerLayerView extends MapLayer {
    private ObservableList<Circle> listCircle = FXCollections.observableArrayList();
    private ArrayList<MapPoint> listMapPoint;
    private ArrayList<Double> listIntensite;
    private ArrayList<Color> listColor;
    private CustomCircleMarkerLayerViewModel viewModel;

    /**
     * Constructeur de la classe CustomCircleMarkerLayerView.
     *
     * @param mapView La vue de la carte sur laquelle afficher les marqueurs.
     * @param list    La liste de contrôle à mettre à jour lors du clic sur un cercle.
     */
    public CustomCircleMarkerLayerView(MapView mapView, ListView list) {
        viewModel = new CustomCircleMarkerLayerViewModel();
        listMapPoint = viewModel.getListMapPoint();
        listColor = viewModel.getListColor();
        listIntensite = viewModel.getListIntensite();

        for (int i = 0; i < listMapPoint.size(); i++) {
            CircleClickHandler circleClickHandler = new CircleClickHandler(
                    viewModel.getSeismes().getSeismes().get(i),
                    mapView, listMapPoint.get(i), list);

            listCircle.add(new Circle(listIntensite.get(i) * 0.3, listColor.get(i)));
            listCircle.get(i).setOnMouseClicked(circleClickHandler);
        }

        this.getChildren().addAll(listCircle);
    }

    @Override
    protected void layoutLayer() {
        for (int i = 0; i < listMapPoint.size(); i++) {
            Point2D point2d = this.getMapPoint(listMapPoint.get(i).getLatitude(),
                    listMapPoint.get(i).getLongitude());

            listCircle.get(i).setTranslateX(point2d.getX());
            listCircle.get(i).setTranslateY(point2d.getY());
        }
    }
}

package seismeApp.View;

import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import seismeApp.ViewModel.HeatMapCircleMarkerLayerViewModel;
import java.util.ArrayList;

/**
 * La classe HeatMapCircleMarkerLayerView est responsable de l'affichage des marqueurs de cercle d'une carte thermique dans une couche de carte.
 */
public class HeatMapCircleMarkerLayerView extends MapLayer {
    private ObservableList<Circle> listCircle = FXCollections.observableArrayList();
    private ArrayList<MapPoint> listMapPoint;
    private ArrayList<Double> listIntensite;
    private ArrayList<Color> listColor;
    private HeatMapCircleMarkerLayerViewModel viewModel;

    /**
     * Constructeur de la classe HeatMapCircleMarkerLayerView.
     */
    public HeatMapCircleMarkerLayerView() {
        viewModel = new HeatMapCircleMarkerLayerViewModel();
        listMapPoint = viewModel.getListMapPoint();
        listColor = viewModel.getListColor();
        listIntensite = viewModel.getListIntensite();
        for (int i = 0; i < listMapPoint.size(); i++) {
            double intensity = listIntensite.get(i);
            Color color = listColor.get(i);
            double radius = intensity * 0.5;

            Color opaqueColor = color.deriveColor(1, 1, 1, 1); // Couleur opaque
            Color transparentColor = color.deriveColor(1, 1, 1, 0); // Couleur transparente

            // Créer le dégradé radial
            RadialGradient gradient = new RadialGradient(0, 0, 0.5, 0.5, radius,
                    false, CycleMethod.NO_CYCLE, new Stop(0, opaqueColor), new Stop(1, transparentColor));

            Circle circle = new Circle(radius, gradient);
            circle.setOpacity(0.5);
            circle.setStroke(transparentColor); // Définit le contour plus transparent
            listCircle.add(circle);
        }
        this.getChildren().addAll(listCircle);
    }

    @Override
    protected void layoutLayer() {
        /* Conversion du MapPoint vers Point2D */
        for (int i = 0; i < listMapPoint.size(); i++) {
            Point2D point2d = this.getMapPoint(listMapPoint.get(i).getLatitude(), listMapPoint.get(i).getLongitude());

            /* Déplace le cercle selon les coordonnées du point */
            listCircle.get(i).setTranslateX(point2d.getX());
            listCircle.get(i).setTranslateY(point2d.getY());
        }
    }
}

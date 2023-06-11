package seismeApp.View;

import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import eu.hansolo.fx.heatmap.HeatMap;
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



public class HeatMapCircleMarkerLayerView extends MapLayer {


    private ObservableList<Circle> listCircle= FXCollections.observableArrayList();
    private ArrayList<MapPoint> listMapPoint;
    private ArrayList<Double> listIntensite;
    private ArrayList<Color> listColor;
    private HeatMap heatMap = new HeatMap(700,500);
    private HeatMapCircleMarkerLayerViewModel viewModel;

    public HeatMap getHeatMap() {
        return heatMap;
    }
/*
    public void setHeatMap(HeatMap heatMap) {
        this.heatMap = heatMap;
    }
*/


    public HeatMapCircleMarkerLayerView() {
        viewModel = new HeatMapCircleMarkerLayerViewModel();
        //MapPoint mapPoint,double intensite,Color color
        listMapPoint = viewModel.getListMapPoint();
        listColor = viewModel.getListColor();
        listIntensite = viewModel.getListIntensite();
        //ArrayList<Point> a = new ArrayList<>();
        for (int i = 0 ; i<(listMapPoint.size()); i++){

            //a.add(new Point(50+(listMapPoint.get(i).getLongitude()+6) * (500/14),50+(listMapPoint.get(i).getLatitude()-43 )*(300/6)));
            //Circle circle = new Circle(listIntensite.get(i) * 0.5, listColor.get(i));
            //circle.setEffect(new Bloom());
            //circle.setBlendMode(BlendMode.SOFT_LIGHT);
            double intensity = listIntensite.get(i);
            Color color = listColor.get(i);
            double radius = intensity * 0.5;

            Color opaqueColor = color.deriveColor(1, 1, 1, 1); // Couleur opaque
            Color transparentColor = color.deriveColor(1, 1, 1, 0); // Couleur transparente

            // Créer le dégradé radial

            RadialGradient gradient = new RadialGradient(0,0,0.5,0.5,radius,
                    false, CycleMethod.NO_CYCLE,new Stop(0, opaqueColor),new Stop(1,
                    transparentColor));

            Circle circle = new Circle(radius, gradient);
            circle.setOpacity(0.5);
            circle.setStroke(transparentColor); // Définit le contour plus transparent
            //circle.setEffect(new Bloom());
            //circle.setBlendMode(BlendMode.EXCLUSION);


            listCircle.add(circle);
        }
        //heatMap.setSpotRadius(20);
        //heatMap.addSpots(a);
        //heatMap.rotateProperty().set(30);
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

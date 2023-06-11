package seismeApp.ViewModel;

import com.gluonhq.maps.MapPoint;
import javafx.scene.paint.Color;
import seismeApp.Model.ListeDeSeismes;
import seismeApp.Model.Seisme;
import java.util.ArrayList;

public class CustomCircleMarkerLayerViewModel {
    private ArrayList<MapPoint> listMapPoint;
    private ArrayList<Color> listColor;
    private ArrayList<Double> listIntensite;
    private ArrayList<Integer> listIndentifiant;
    private ListeDeSeismes seismes;

    public ArrayList<Integer> getListIndentifiant() {
        return listIndentifiant;
    }
    public void setListIndentifiant(ArrayList<Integer> listIndentifiant) {
        this.listIndentifiant = listIndentifiant;
    }
    public ArrayList<MapPoint> getListMapPoint() {
        return listMapPoint;
    }
    public void setListMapPoint(ArrayList<MapPoint> listMapPoint) {
        this.listMapPoint = listMapPoint;
    }
    public ArrayList<Color> getListColor() {
        return listColor;
    }
    public void setListColor(ArrayList<Color> listColor) {
        this.listColor = listColor;
    }
    public ArrayList<Double> getListIntensite() {
        return listIntensite;
    }
    public void setListIntensite(ArrayList<Double> listIntensite) {
        this.listIntensite = listIntensite;
    }
    public ListeDeSeismes getSeismes() {return seismes;}
    public void setSeismes(ListeDeSeismes seismes) {this.seismes = seismes;}

    public CustomCircleMarkerLayerViewModel(){
        seismes = new ListeDeSeismes();
        listMapPoint = new ArrayList<>();
        listColor = new ArrayList<>();
        listIntensite = new ArrayList<>();
        listIndentifiant = new ArrayList<>();

        // TODO ici on va devoir enlever de la liste seismes les elements pas dans la combo box lieux

        seismes.setSeismes( seismes.triIntensite(true));
        //System.out.println(seismes.getSeismes()); debug pour voir si csv bien chargé

        for (Seisme s: seismes.getSeismes()){
            listIntensite.add(s.getIntensite()+10);
            listIndentifiant.add(s.getIdentifiant());
            listMapPoint.add(new MapPoint(s.getLatitude(),s.getLongitude()));
            if (s.getIntensite()<2)                             {listColor.add(Color.BLUE);} // cas inconnu
            else if (s.getIntensite()>=2 && s.getIntensite()<3) {listColor.add(Color.LAVENDER);}
            else if (s.getIntensite()>=3 && s.getIntensite()<4) {listColor.add(Color.AQUA);}
            else if (s.getIntensite()>=4 && s.getIntensite()<5) {listColor.add(Color.LIME);}
            else if (s.getIntensite()>=5 && s.getIntensite()<6) {listColor.add(Color.YELLOW);}
            else if (s.getIntensite()>=6 && s.getIntensite()<7) {listColor.add(Color.ORANGE);}
            else if (s.getIntensite()>=7 && s.getIntensite()<8) {listColor.add(Color.RED);}
            else if (s.getIntensite()>=8 && s.getIntensite()<9) {listColor.add(Color.MAGENTA);}
            else if (s.getIntensite()>=9 ) listColor.add(Color.PURPLE);
        }
    }
}

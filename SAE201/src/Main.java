package SAE201.src;

import SAE201.src.Model.ListeDeSeismes;
import SAE201.src.Model.Seisme;

import java.sql.Time;
import java.time.Duration;
import java.util.Date;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Seisme s1 = new Seisme(2,10,11,new Date(2010, 03, 01),"Incertaine", 340004,new Time(0),  "Camargue", "Provence", "Precurseur");
        Seisme s2 = new Seisme(1, 47.2015, 78.6452,new Date(2015, 03, 02), "Information isolée", 4131,new Time(23, 55, 0),  "Luberon occidental", "Vaucluse", "A");

        ListeDeSeismes list = new ListeDeSeismes();
        list.addSeisme(s1);
        list.addSeisme(s2);

        System.out.println(list.triRegion(false));
    }
}
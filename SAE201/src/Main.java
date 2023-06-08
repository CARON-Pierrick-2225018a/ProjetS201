package SAE201.src;

import SAE201.src.Model.ListeDeSeismes;
import SAE201.src.Model.Seisme;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Seisme s1 = new Seisme(2,10,11,new Date(2010, 03, 01),"Incertaine", 340004, "23H55", "Camargue", "Provence", "Precurseur");
        Seisme s2 = new Seisme(1, 47.2015, 78.6452,new Date(2015, 03, 02), "Information isolée", 4131, "", "Luberon occidental", "Vaucluse", "a");

        ListeDeSeismes list = new ListeDeSeismes();
    }
}
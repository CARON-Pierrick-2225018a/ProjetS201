package SAE201.src;

import SAE201.src.Model.ListeDeSeismes;
import SAE201.src.Model.Seisme;

import java.sql.Time;
import java.util.Date;

public class Main {
    public static void main(String[] args) {


        // Implémenté :
        // -tous les tris
        // -tous les getAttributMax
        // -tous les getAttributMin
        // -toutes les rechercheAttribut
        // -tous les getAttributAvg


        // Affichage de la liste
        //System.out.println(list.getSeismes());

        ListeDeSeismes list = new ListeDeSeismes("/home/flouksac/Téléchargements/SisFranceBDD2.csv");
        //list.setSeismes( list.triProximite(list.getSeismes().get(1),true ));
        //list.setSeismes( list.triQualiteIntensite(true ));

        System.out.println(list.getSeismes());
    }
}
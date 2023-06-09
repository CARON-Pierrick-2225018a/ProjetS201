package seismeApp;

import seismeApp.Model.ListeDeSeismes;

import java.nio.file.Path;

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
        ListeDeSeismes list = new ListeDeSeismes( Main.class.getClassLoader().getResource("SisFranceBDD2.csv").getPath());
        list.setSeismes( list.triProximite(list.getSeismes().get(1),true ));

        System.out.println(list.getSeismes());
    }
}
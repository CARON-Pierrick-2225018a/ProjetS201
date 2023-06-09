package fr.amu.iut.SeismeApp;

import fr.amu.iut.SeismeApp.Model.ListeDeSeismes;
import fr.amu.iut.SeismeApp.Model.Seisme;
import javafx.fxml.FXMLLoader;

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

        ListeDeSeismes list = new ListeDeSeismes("/amuhome/g22017449/Bureau/SeismApp/src/main/resources/AppControl/SisFrance_seismes_20230609121408.csv");
        list.setSeismes( list.triProximite(list.getSeismes().get(1),true ));

        System.out.println(list.getSeismes());
    }
}
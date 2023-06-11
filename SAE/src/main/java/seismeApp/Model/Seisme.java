package seismeApp.Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Time;

// La classe séisme représentera chaque séisme du csv importé
public class Seisme {
    private int identifiant;
    private Date date;
    private Time heure;
    private String zone;    // Attribut "nom" dans le csv
    private String region;
    private String choc;
    private double xRGF93L93;
    private double yRGF93L93;
    private double latitude;
    private double longitude;
    private double intensite;
    private String qualiteIntensite;

    // Constructeur de la classe
    public Seisme(int identifiant, Date date, Time heure, String zone, String region,
                  String choc, double xRGF93L93, double yRGF93L93, double latitude,
                  double longitude, double intensite, String qualiteIntensite) {
        this.identifiant = identifiant;
        this.date = date;
        this.heure = heure;
        this.zone = zone;
        this.region = region;
        this.choc = choc;
        this.xRGF93L93 = xRGF93L93;
        this.yRGF93L93 = yRGF93L93;
        this.latitude = latitude;
        this.longitude = longitude;
        this.intensite = intensite;
        this.qualiteIntensite = qualiteIntensite;
    }


    // A part le toString, rien d'intéressant c'est que des getters et des setters

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String strDate = formatter.format(date);
        String strChoc = choc ;
        if (strChoc == null)
            strChoc = "N/A";
        String qualite = qualiteIntensite ;
        if (qualite == null)
            qualite = "N/A";
        return "Seisme[" +
                "id:" + identifiant +
                ", date: " + strDate +
                ", durée: " + heure +
                ", zone: '" + zone + '\'' +
                ", region: '" + region + '\'' +
                ", choc: '" + strChoc + '\'' +
                //", xRGF93: " + xRGF93L93 + // car pas super intéressant a affiché
                //", yRGF93: " + yRGF93L93 +
                ", latitude: " + latitude +
                ", longitude: " + longitude +
                ", intensite: " + intensite +
                ", qualiteIntensite: '" + qualite + '\'' +
                ']'+"\n";
    }

    public double getIntensite() {
        return intensite;
    }
    public void setIntensite(double intensite) {
        this.intensite = intensite;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getQualiteIntensite() {
        return qualiteIntensite;
    }
    public void setQualiteIntensite(String qualiteIntensite) {
        this.qualiteIntensite = qualiteIntensite;
    }
    public int getIdentifiant() {
        return identifiant;
    }
    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }
    public Time getHeure() {
        return heure;
    }
    public void setHeure(Time heure) {
        this.heure = heure;
    }
    public String getZone() {
        return zone;
    }
    public void setZone(String zone) {
        this.zone = zone;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getChoc() {
        return choc;
    }
    public void setChoc(String choc) {
        this.choc = choc;
    }
    public double getxRGF93L93() {
        return xRGF93L93;
    }
    public void setxRGF93L93(double xRGF93L93) {
        this.xRGF93L93 = xRGF93L93;
    }
    public double getyRGF93L93() {
        return yRGF93L93;
    }
    public void setyRGF93L93(double yRGF93L93) {
        this.yRGF93L93 = yRGF93L93;
    }
}
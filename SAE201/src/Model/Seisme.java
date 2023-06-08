package SAE201.src.Model;

import java.util.Date;
import java.sql.Time;

/// La classe séisme représentera chaque séisme du csv importé
public class Seisme {
    private double intensite;
    private double longitude;
    private double latitude;
    private Date date;
    private String qualiteIntensite;
    private int identifiant;
    private Time heure;
    private String zone;    /// Attribut "nom" dans le csv
    private String region;
    private String choc;

    /// Constructeur de la classe
    public Seisme(double intensite, double longitude, double latitude, Date date, String qualiteIntensite, int identifiant, Time heure, String zone, String region, String choc) {
        this.intensite = intensite;
        this.longitude = longitude;
        this.latitude = latitude;
        this.date = date;
        this.qualiteIntensite = qualiteIntensite;
        this.identifiant = identifiant;
        this.heure = heure;
        this.zone = zone;
        this.region = region;
        this.choc = choc;
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

    /// Renvoi un booléen selon si le séisme est avant la date rentrée
    public boolean estAvant(Date date) {
        return this.date.before(date);
    }

    /// Renvoi un booléen selon si le séisme est après la date rentrée
    public boolean estApres(Date date) {
        return this.date.after(date);
    }

    @Override
    public String toString() {
        return "" + zone;
    }
}
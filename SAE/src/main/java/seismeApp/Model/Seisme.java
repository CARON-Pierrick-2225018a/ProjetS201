package seismeApp.Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Time;

/**
 * La classe Seisme représente chaque séisme importé à partir d'un fichier CSV.
 */
public class Seisme {
    private int identifiant;
    private Date date;
    private Time heure;
    private String zone;    // Attribut "nom" dans le CSV
    private String region;
    private String choc;
    private double xRGF93L93;
    private double yRGF93L93;
    private double latitude;
    private double longitude;
    private double intensite;
    private String qualiteIntensite;

    /**
     * Constructeur de la classe Seisme.
     *
     * @param identifiant        L'identifiant du séisme.
     * @param date               La date du séisme.
     * @param heure              L'heure du séisme.
     * @param zone               La zone du séisme.
     * @param region             La région du séisme.
     * @param choc               Le type de choc du séisme.
     * @param xRGF93L93          La coordonnée x RGF93L93 du séisme.
     * @param yRGF93L93          La coordonnée y RGF93L93 du séisme.
     * @param latitude           La latitude du séisme.
     * @param longitude          La longitude du séisme.
     * @param intensite          L'intensité du séisme.
     * @param qualiteIntensite   La qualité de l'intensité du séisme.
     */
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

    /**
     * Renvoie une représentation sous forme de chaîne de caractères de l'objet Seisme.
     *
     * @return Une chaîne de caractères représentant l'objet Seisme.
     */
    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String strDate = formatter.format(date);
        String strChoc = choc;
        if (strChoc == null)
            strChoc = "N/A";
        String qualite = qualiteIntensite;
        if (qualite == null)
            qualite = "N/A";
        return "Seisme[" +
                "id:" + identifiant +
                ", date: " + strDate +
                ", durée: " + heure +
                ", zone: '" + zone + '\'' +
                ", région: '" + region + '\'' +
                ", choc: '" + strChoc + '\'' +
                ", latitude: " + latitude +
                ", longitude: " + longitude +
                ", intensité: " + intensite +
                ", qualiteIntensite: '" + qualite + '\'' +
                ']' + "\n";
    }

    // Getters et Setters

    /**
     * Renvoie l'intensité du séisme.
     *
     * @return L'intensité du séisme.
     */
    public double getIntensite() {
        return intensite;
    }

    /**
     * Définit l'intensité du séisme.
     *
     * @param intensite L'intensité du séisme.
     */
    public void setIntensite(double intensite) {
        this.intensite = intensite;
    }

    /**
     * Renvoie la longitude du séisme.
     *
     * @return La longitude du séisme.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Définit la longitude du séisme.
     *
     * @param longitude La longitude du séisme.
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Renvoie la latitude du séisme.
     *
     * @return La latitude du séisme.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Définit la latitude du séisme.
     *
     * @param latitude La latitude du séisme.
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Renvoie la date du séisme.
     *
     * @return La date du séisme.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Définit la date du séisme.
     *
     * @param date La date du séisme.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Renvoie la qualité de l'intensité du séisme.
     *
     * @return La qualité de l'intensité du séisme.
     */
    public String getQualiteIntensite() {
        return qualiteIntensite;
    }

    /**
     * Définit la qualité de l'intensité du séisme.
     *
     * @param qualiteIntensite La qualité de l'intensité du séisme.
     */
    public void setQualiteIntensite(String qualiteIntensite) {
        this.qualiteIntensite = qualiteIntensite;
    }

    /**
     * Renvoie l'identifiant du séisme.
     *
     * @return L'identifiant du séisme.
     */
    public int getIdentifiant() {
        return identifiant;
    }

    /**
     * Définit l'identifiant du séisme.
     *
     * @param identifiant L'identifiant du séisme.
     */
    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    /**
     * Renvoie l'heure du séisme.
     *
     * @return L'heure du séisme.
     */
    public Time getHeure() {
        return heure;
    }

    /**
     * Définit l'heure du séisme.
     *
     * @param heure L'heure du séisme.
     */
    public void setHeure(Time heure) {
        this.heure = heure;
    }

    /**
     * Renvoie la zone du séisme.
     *
     * @return La zone du séisme.
     */
    public String getZone() {
        return zone;
    }

    /**
     * Définit la zone du séisme.
     *
     * @param zone La zone du séisme.
     */
    public void setZone(String zone) {
        this.zone = zone;
    }

    /**
     * Renvoie la région du séisme.
     *
     * @return La région du séisme.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Définit la région du séisme.
     *
     * @param region La région du séisme.
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Renvoie le type de choc du séisme.
     *
     * @return Le type de choc du séisme.
     */
    public String getChoc() {
        return choc;
    }

    /**
     * Définit le type de choc du séisme.
     *
     * @param choc Le type de choc du séisme.
     */
    public void setChoc(String choc) {
        this.choc = choc;
    }

    /**
     * Renvoie la coordonnée x RGF93L93 du séisme.
     *
     * @return La coordonnée x RGF93L93 du séisme.
     */
    public double getxRGF93L93() {
        return xRGF93L93;
    }

    /**
     * Définit la coordonnée x RGF93L93 du séisme.
     *
     * @param xRGF93L93 La coordonnée x RGF93L93 du séisme.
     */
    public void setxRGF93L93(double xRGF93L93) {
        this.xRGF93L93 = xRGF93L93;
    }

    /**
     * Renvoie la coordonnée y RGF93L93 du séisme.
     *
     * @return La coordonnée y RGF93L93 du séisme.
     */
    public double getyRGF93L93() {
        return yRGF93L93;
    }

    /**
     * Définit la coordonnée y RGF93L93 du séisme.
     *
     * @param yRGF93L93 La coordonnée y RGF93L93 du séisme.
     */
    public void setyRGF93L93(double yRGF93L93) {
        this.yRGF93L93 = yRGF93L93;
    }
}

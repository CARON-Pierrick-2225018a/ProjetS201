package seismeApp.Model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Cette classe représente une liste de séismes.
 */
public class ListeDeSeismes {
    private ArrayList<Seisme> seismes;

    /**
     * Constructeur de la liste à partir d'un fichier CSV.
     *
     * @param pathToCSV Chemin du fichier CSV contenant les séismes.
     */
    public ListeDeSeismes(String pathToCSV) {
        seismes = new ArrayList<>();
        seismes = loadCSV(pathToCSV,"¤");
    }

    /**
     * Constructeur de la liste par défaut.
     * Utilise un fichier CSV par défaut pour charger les séismes.
     */
    public ListeDeSeismes() {
        seismes = new ArrayList<>();
        seismes = loadCSV("src/main/resources/seismeApp/SisFranceBDD2.csv","¤");
    }

    /**
     * Ajoute un séisme à la liste.
     *
     * @param seisme Séisme à ajouter.
     */
    public void addSeisme(Seisme seisme) {
        seismes.add(seisme);
    }

    /**
     * Supprime un séisme de la liste en utilisant son identifiant.
     *
     * @param identifiant Identifiant du séisme à supprimer.
     */
    public void removeSeisme(int identifiant){
        for (Seisme s : seismes){
            if (s.getIdentifiant()==identifiant)
                seismes.remove(s);
            break;
        }
    }
    /**
     * Supprime un séisme de la liste.
     *
     * @param s Séisme à supprimer.
     */
    public void removeSeisme(Seisme s){
        seismes.remove(s);
    }

    /**
     * Retourne la liste des séismes.
     *
     * @return Liste des séismes.
     */
    public ArrayList<Seisme> getSeismes() {
        return seismes;
    }

    /**
     * Remplace la liste des séismes par une nouvelle liste.
     *
     * @param seismes Nouvelle liste de séismes.
     */
    public void setSeismes(ArrayList<Seisme> seismes) {
        this.seismes = seismes;
    }

    /**
     * Charge un fichier CSV et retourne une liste de séismes.
     *
     * @param csvFile      Chemin du fichier CSV contenant les séismes.
     * @param splitterChar Caractère utilisé comme séparateur dans le fichier CSV.
     * @return Liste de séismes chargée à partir du fichier CSV.
     */
    public ArrayList<Seisme> loadCSV(String csvFile,String splitterChar) {
        ArrayList<Seisme> seismeList = new ArrayList<>();
        String line;
        String csvSplitBy = splitterChar;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header line if it exists
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                if (data.length<=12){

                    int identifiant = Integer.valueOf(data[0]);
                    String date = data[1];
                    String heure = data[2];
                    String nom = data[3];
                    String regionEpicentrale = data[4];
                    String choc = null;
                    if (data.length>=6)
                        choc = data[5].isEmpty() ? null : data[5];

                    double xRGF93L93 = 0;
                    double yRGF93L93 = 0;
                    double latitudeWGS84 = 0;
                    double longitudeWGS84 = 0;
                    double intensiteEpicentrale = 0;
                    String qualiteIntensiteEpicentrale = null;
                    Time heureSeisme = null;
                    if (data.length <= 6 ){
                        xRGF93L93 = seismeList.get(seismes.size()).getxRGF93L93();
                        yRGF93L93 = seismeList.get(seismes.size()).getyRGF93L93();
                        latitudeWGS84 = seismeList.get(seismes.size()).getLatitude();
                        longitudeWGS84 = seismeList.get(seismes.size()).getLongitude();
                        intensiteEpicentrale = seismeList.get(seismes.size()).getIntensite();
                        qualiteIntensiteEpicentrale = seismeList.get(seismes.size()).getQualiteIntensite();
                    }

                    else {
                        xRGF93L93 = data[6].isEmpty() ? 0.0 : Double.parseDouble(data[6]);
                        yRGF93L93 = data[7].isEmpty() ? 0.0 :Double.parseDouble(data[7]);
                        latitudeWGS84 = data[8].isEmpty() ? 0.0 :Double.parseDouble(data[8]);
                        longitudeWGS84 = data[9].isEmpty() ? 0.0 :Double.parseDouble(data[9]);
                        intensiteEpicentrale = ((data.length <= 10) || data[10].isEmpty()) ? 0.0 : Double.parseDouble(data[10]);
                        qualiteIntensiteEpicentrale = (data.length <= 11 || data[11].isEmpty()) ? null : data[11];
                    }
                    if (!heure.isEmpty()) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("HH 'h' mm 'min'");
                        dateFormat.setLenient(false);
                        try {
                            Date parsedDate = dateFormat.parse(heure);
                            heureSeisme = new Time(parsedDate.getTime());
                        } catch (ParseException e) {
                            dateFormat = new SimpleDateFormat("HH 'h'");
                            Date parsedDate = dateFormat.parse(heure);
                            heureSeisme = new Time(parsedDate.getTime());
                        }
                    }
                    Date dateSeisme = null;

                    if (!date.isEmpty()) {
                        ArrayList<SimpleDateFormat> knownPattern = new ArrayList<>();
                        knownPattern.add(new SimpleDateFormat("yyyy'/'MM'/'dd'/'"));
                        knownPattern.add(new SimpleDateFormat("yyyy'/'MM'/'"));
                        knownPattern.add(new SimpleDateFormat("yyyy'/'"));


                        for (SimpleDateFormat format : knownPattern) {
                            try {
                                dateSeisme = format.parse(date);
                            } catch (ParseException e) {
                            }
                        }

                    }
                    Seisme seisme = new Seisme(identifiant, dateSeisme, heureSeisme, nom, regionEpicentrale, choc,
                            xRGF93L93, yRGF93L93, latitudeWGS84, longitudeWGS84,
                            intensiteEpicentrale, qualiteIntensiteEpicentrale);
                    seismeList.add(seisme);
                }};
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return seismeList;

    }

    // L'argument des tris reverse  définit si la liste est inversée ou non (croissant/décroissant)

    /**
     * Trie la liste des séismes par intensité dans l'ordre décroissant.
     *
     * @param reverse Indique si la liste doit être inversée (tri croissant).
     * @return Liste des séismes triée par intensité décroissante.
     */
    public ArrayList<Seisme> triIntensite(boolean reverse) {
        Collections.sort(seismes, new Comparator<Seisme>() {
            public int compare(Seisme c1, Seisme c2) {
                if (c1.getIntensite() > c2.getIntensite()) return -1;
                if (c1.getIntensite() < c2.getIntensite()) return 1;
                return 0;
            }});
        // On inverse ou non la liste
        if (reverse) Collections.reverse(seismes);
        return seismes;
    }

    /**
     * Trie la liste des séismes par date, du plus récent au plus ancien.
     * @param reverse true si la liste doit être inversée, false sinon
     * @return la liste des séismes triée par date
     */
    public ArrayList<Seisme> triDate(boolean reverse) {
        Collections.sort(seismes, new Comparator<Seisme>() {
            public int compare(Seisme c1, Seisme c2) {
                if (c1.getDate().after(c2.getDate())) return -1;
                if (c1.getDate().before(c2.getDate())) return 1;
                return 0;
            }});
        // On inverse ou non la liste
        if (reverse) Collections.reverse(seismes);
        return seismes;
    }

    /**
     * Trie la liste des séismes par heure, de la plus élevée à la plus faible.
     * @param reverse true si la liste doit être inversée, false sinon
     * @return la liste des séismes triée par heure
     */
    public ArrayList<Seisme> triHeure(boolean reverse) {
        Collections.sort(seismes, new Comparator<Seisme>() {
            public int compare(Seisme c1, Seisme c2) {
                if (c1.getHeure().after(c2.getHeure())) return -1;
                if (c1.getHeure().before(c2.getHeure())) return 1;
                return 0;
            }});
        // On inverse ou non la liste
        if (reverse) Collections.reverse(seismes);
        return seismes;
    }


    /**
     * Trie la liste des séismes par ordre alphabétique des types de chocs différents.
     * @param reverse true si la liste doit être inversée, false sinon
     * @return la liste des séismes triée par type de choc
     */
    public ArrayList<Seisme> triChoc(boolean reverse) {
        Collections.sort(seismes, new Comparator<Seisme>() {
            public int compare(Seisme c1, Seisme c2) {
                return c1.getChoc().compareTo(c2.getChoc());
            }});
        // On inverse ou non la liste
        if (reverse) Collections.reverse(seismes);
        return seismes;
    }

    /**
     * Trie la liste des séismes par ordre alphabétique des régions.
     * @param reverse true si la liste doit être inversée, false sinon
     * @return la liste des séismes triée par région
     */
    public ArrayList<Seisme> triRegion(boolean reverse) {
        Collections.sort(seismes, new Comparator<Seisme>() {
            public int compare(Seisme c1, Seisme c2) {
                return c1.getRegion().compareTo(c2.getRegion());
            }});
        // On inverse ou non la liste
        if (reverse) Collections.reverse(seismes);
        return seismes;
    }

    /**
     * Trie la liste des séismes par ordre alphabétique des zones.
     * @param reverse true si la liste doit être inversée, false sinon
     * @return la liste des séismes triée par zone
     */
    public ArrayList<Seisme> triZone(boolean reverse) {
        Collections.sort(seismes, new Comparator<Seisme>() {
            public int compare(Seisme c1, Seisme c2) {
                return c1.getZone().compareTo(c2.getZone());
            }});
        // On inverse ou non la liste
        if (reverse) Collections.reverse(seismes);
        return seismes;
    }




    /**
     * Trie la liste des séismes par ordre alphabétique des qualités d'intensité.
     * @param reverse true si la liste doit être inversée, false sinon
     * @return la liste des séismes triée par qualité d'intensité
     */
    public ArrayList<Seisme> triQualiteIntensite(boolean reverse) {
        ArrayList<Seisme> arbitraire = new ArrayList<Seisme>();
        ArrayList<Seisme> assezSure = new ArrayList<Seisme>();
        ArrayList<Seisme> assezSureSponHeueur = new ArrayList<Seisme>();
        ArrayList<Seisme> incertaine = new ArrayList<Seisme>();
        ArrayList<Seisme> informationIsolee = new ArrayList<Seisme>();
        ArrayList<Seisme> sure = new ArrayList<Seisme>();
        ArrayList<Seisme> nullList = new ArrayList<Seisme>();

        triDate(false);

        for (Seisme s : seismes){
            if (s.getQualiteIntensite()==null) {nullList.add(s);}
            else if (s.getQualiteIntensite().equals("ARBITRAIRE")) {arbitraire.add(s);}
            else if (s.getQualiteIntensite().equals("ASSEZ SURE")) {assezSure.add(s);}
            else if (s.getQualiteIntensite().equals("ASSEZ SURE (SPONHEUEUR)")) {assezSureSponHeueur.add(s);}
            else if (s.getQualiteIntensite().equals("INCERTAINE")) {incertaine.add(s);}
            else if (s.getQualiteIntensite().equals("INFORMATION ISOLÉE")) {informationIsolee.add(s);}
            else if (s.getQualiteIntensite().equals("SURE")) {sure.add(s);}
        }
        sure.addAll(assezSure);
        sure.addAll(assezSureSponHeueur);
        sure.addAll(informationIsolee);
        sure.addAll(arbitraire);
        sure.addAll(incertaine);
        sure.addAll(nullList);
        setSeismes(sure); // modification de l'attribut seismes

        if (reverse) Collections.reverse(seismes);
        return seismes;
    }

    /**
     * Trie la liste des séismes par latitude.
     * @param reverse true si la liste doit être inversée, false sinon
     * @return la liste des séismes triée par latitude
     */
    public ArrayList<Seisme> triLatitude(boolean reverse) {
        Collections.sort(seismes, new Comparator<Seisme>() {
            public int compare(Seisme c1, Seisme c2) {
                if (c1.getLatitude() > c2.getLatitude()) return -1;
                if (c1.getLatitude() < c2.getLatitude()) return 1;
                return 0;
            }});
        // On inverse ou non la liste
        if (reverse) Collections.reverse(seismes);
        return seismes;
    }


    /**
     * Trie la liste des séismes par longitude.
     * @param reverse true si la liste doit être inversée, false sinon
     * @return la liste des séismes triée par longitude
     */
    public ArrayList<Seisme> triLongitude(boolean reverse) {
        Collections.sort(seismes, new Comparator<Seisme>() {
            public int compare(Seisme c1, Seisme c2) {
                if (c1.getLongitude() > c2.getLongitude()) return -1;
                if (c1.getLongitude() < c2.getLongitude()) return 1;
                return 0;
            }});
        // On inverse ou non la liste
        if (reverse) Collections.reverse(seismes);
        return seismes;
    }

    /**
     * Trie la liste des séismes par identifiant.
     * @param reverse true si la liste doit être inversée, false sinon
     * @return la liste des séismes triée par identifiant
     */
    public ArrayList<Seisme> triIdentifiant(boolean reverse) {
        Collections.sort(seismes, new Comparator<Seisme>() {
            public int compare(Seisme c1, Seisme c2) {
                if (c1.getIdentifiant() > c2.getIdentifiant()) return -1;
                if (c1.getIdentifiant() < c2.getIdentifiant()) return 1;
                return 0;
            }});
        // On inverse ou non la liste
        if (reverse) Collections.reverse(seismes);
        return seismes;
    }

    /**
     * Trie la liste des séismes par proximité d'un séisme donné.
     * @param s le séisme de référence pour le calcul de proximité
     * @param reverse true si la liste doit être inversée, false sinon
     * @return la liste des séismes triée par proximité
     */
    public ArrayList<Seisme> triProximite(Seisme s,boolean reverse){
        // Création d'une copie de la liste originale pour effectuer le tri
        ArrayList<Seisme> sortedList = new ArrayList<>(seismes);

        Comparator<Seisme> proximityComparator = new Comparator<Seisme>() {
            @Override
            public int compare(Seisme seisme1, Seisme seisme2) {
                // Calcul de la distance entre les séismes et le séisme de référence
                double distance1 = calculerDistance(seisme1, s);
                double distance2 = calculerDistance(seisme2, s);

                // Comparaison en fonction de la distance
                if (distance1 < distance2) { return -1;
                } else if (distance1 > distance2) { return 1;
                } else { return 0; }
            }
        };

        // Tri de la liste en utilisant le Comparator de proximité
        Collections.sort(sortedList, proximityComparator);

        // Inversion de l'ordre si reverse est true
        if (reverse) {
            Collections.reverse(sortedList);
        }

        return sortedList;
    };
    /**
     * Calcul de la distance en kilomètres entre deux séismes.
     * @param seisme1 le premier séisme
     * @param seisme2 le deuxième séisme
     * @return la distance en kilomètres entre les deux séismes
     */
    private double calculerDistance(Seisme seisme1, Seisme seisme2) {
        double lat1 = seisme1.getLatitude();
        double lon1 = seisme1.getLongitude();
        double lat2 = seisme2.getLatitude();
        double lon2 = seisme2.getLongitude();
        final double earthRadius = 6371; // Rayon de la Terre en kilomètres
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;

        return distance;
    }
    // Méthodes pour obtenir les attributs maximum
    /**
     * Retourne l'intensité maximale parmi les séismes de la liste.
     *
     * @return L'intensité maximale.
     */
    public double getIntensiteMax() {
        double max = 0;
        for (Seisme i : seismes) {
            if (i.getIntensite() > max) max = i.getIntensite();
        }
        return max;
    }
    /**
     * Retourne la longitude maximale parmi les séismes de la liste.
     *
     * @return La longitude maximale.
     */
    public double getLongitudeMax() {
        double max = 0;
        for (Seisme i : seismes) {
            if (i.getLongitude() > max) max = i.getLongitude();
        }
        return max;
    }
    /**
     * Retourne la latitude maximale parmi les séismes de la liste.
     *
     * @return La latitude maximale.
     */
    public double getLatitudeMax() {
        double max = 0;
        for (Seisme i : seismes) {
            if (i.getLatitude() > max) max = i.getLatitude();
        }
        return max;
    }
    /**
     * Retourne la date maximale parmi les séismes de la liste.
     *
     * @return La date maximale.
     */
    public Date getDateMax() {
        Date max = new Date(0);
        for (Seisme i : seismes) {
            if (i.getDate().after(max)) max = i.getDate();
        }
        return max;
    }
    /**
     * Retourne l'identifiant maximal parmi les séismes de la liste.
     *
     * @return L'identifiant maximal.
     */
    public double getIdentifiantMax() {
        double max = 0;
        for (Seisme i : seismes) {
            if (i.getIdentifiant() > max) max = i.getIdentifiant();
        }
        return max;
    }
    /**
     * Retourne l'heure maximale parmi les séismes de la liste.
     *
     * @return L'heure maximale.
     */
    public Time getHeureMax() {
        Time max = new Time(0);
        for (Seisme i : seismes) {
            if (i.getHeure().after(max)) max = i.getHeure();
        }
        return max;
    }


    // Méthodes pour obtenir les attributs minimum
    /**
     * Retourne l'intensité minimale parmi les séismes de la liste.
     *
     * @return L'intensité minimale.
     */
    public double getIntensiteMin() {
        double min = 0;
        for (Seisme i : seismes) {
            if (i.getIntensite() < min) min = i.getIntensite();
        }
        return min;
    }
    /**
     * Retourne la longitude minimale parmi les séismes de la liste.
     *
     * @return La longitude minimale.
     */
    public double getLongitudemin() {
        double min = 0;
        for (Seisme i : seismes) {
            if (i.getLongitude() < min) min = i.getLongitude();
        }
        return min;
    }
    /**
     * Retourne la latitude minimale parmi les séismes de la liste.
     *
     * @return La latitude minimale.
     */
    public double getLatitudeMin() {
        double min = 0;
        for (Seisme i : seismes) {
            if (i.getLatitude() < min) min = i.getLatitude();
        }
        return min;
    }
    /**
     * Retourne la date minimale parmi les séismes de la liste.
     *
     * @return La date minimale.
     */
    public Date getDateMin() {
        Date min = getDateMax();
        for (Seisme i : seismes) {
            if (i.getDate().before(min)) min = i.getDate();
        }
        return min;
    }

    /**
     * Retourne l'identifiant minimal parmi les séismes de la liste.
     *
     * @return L'identifiant minimal.
     */
    public double getIdentifiantMin() {
        double min = 0;
        for (Seisme i : seismes) {
            if (i.getIdentifiant() < min) min = i.getIdentifiant();
        }
        return min;
    }
    /**
     * Retourne l'heure minimale parmi les séismes de la liste.
     *
     * @return L'heure minimale.
     */
    public Time getHeureMin() {
        Time min = getHeureMax();
        for (Seisme i : seismes) {
            if (i.getHeure().before(min)) min = i.getHeure();
        }
        return min;
    }


    // Méthodes pour obtenir des moyennes d'attributs
    /**
     * Calcule la moyenne d'intensité des séismes de la liste.
     *
     * @param liste La liste de séismes.
     * @return La moyenne d'intensité.
     */
    public double getIntensiteAvg(ListeDeSeismes liste) {
        long total = 0;
        long valnul= 0;
        for (Seisme i : liste.getSeismes()) {
            if (i.getIntensite()>0)
                total += i.getIntensite();
            else
                valnul++;
        }
        return total / (liste.getSeismes().size()-valnul);
    }
    /**
     * Calcule la moyenne de longitude des séismes de la liste.
     *
     * @param liste La liste de séismes.
     * @return La moyenne de longitude.
     */
    public double getLongitudeAvg(ListeDeSeismes liste) {
        long total = 0;

        for (Seisme i : liste.getSeismes()) {
            total += i.getLongitude();
        }

        return total / liste.getSeismes().size();
    }
    /**
     * Calcule la moyenne de latitude des séismes de la liste.
     *
     * @param liste La liste de séismes.
     * @return La moyenne de latitude.
     */
    public double getLatitudeAvg(ListeDeSeismes liste) {
        long total = 0;

        for (Seisme i : liste.getSeismes()) {
            total += i.getLatitude();
        }

        return total / liste.getSeismes().size();
    }
    /**
     * Calcule la moyenne d'heure des séismes de la liste.
     *
     * @param dates La liste de séismes.
     * @return La moyenne d'heure.
     */
    public Time getHeureAvg(ListeDeSeismes dates) {
        long total = 0;

        for (Seisme date : dates.getSeismes()) {
            total += date.getHeure().getTime();
        }

        return new Time(total / dates.getSeismes().size());
    }

    // Méthodes de rehcreche d'attributs


    /**
     * Recherche les séismes ayant une intensité donnée.
     *
     * @param intensite L'intensité recherchée.
     * @return Une liste des séismes correspondants.
     */
    public ArrayList<Seisme> rechercheIntensite(int intensite) {
        ArrayList<Seisme> tabFinal = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getIntensite() == intensite) {
                tabFinal.add(seisme);
            }
        }
        return tabFinal;
    }
    /**
     * Recherche les séismes ayant une longitude donnée.
     *
     * @param longitude La longitude recherchée.
     * @return Une liste des séismes correspondants.
     */
    public ArrayList<Seisme> rechercheLongitude(int longitude) {
        ArrayList<Seisme> tabFinal = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getLongitude() == longitude) {
                tabFinal.add(seisme);
            }
        }
        return tabFinal;
    }
    /**
     * Recherche les séismes ayant une latitude donnée.
     *
     * @param latitude La latitude recherchée.
     * @return Une liste des séismes correspondants.
     */
    public ArrayList<Seisme> rechercheLatitude(int latitude) {
        ArrayList<Seisme> tabFinal = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getLatitude() == latitude) {
                tabFinal.add(seisme);
            }
        }
        return tabFinal;
    }
    /**
     * Recherche les séismes ayant une date donnée.
     *
     * @param date La date recherchée.
     * @return Une liste des séismes correspondants.
     */
    public ArrayList<Seisme> rechercheDate(Date date) {
        ArrayList<Seisme> tabFinal = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getDate().getTime() == date.getTime()) {
                tabFinal.add(seisme);
            }
        }
        return tabFinal;
    }
    /**
     * Recherche les séismes ayant une qualité d'intensité donnée.
     *
     * @param QI La qualité d'intensité recherchée.
     * @return Une liste des séismes correspondants.
     */
    public ArrayList<Seisme> rechercheQualiteIntensite(String QI) {
        ArrayList<Seisme> tabFinal = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getQualiteIntensite().toString().compareTo(QI.toString()) == 0) {
                tabFinal.add(seisme);
            }
        }
        return tabFinal;
    }
    /**
     * Recherche les séismes ayant un identifiant donné.
     *
     * @param id L'identifiant recherché.
     * @return Une liste des séismes correspondants.
     */
    public ArrayList<Seisme> rechercheIdentifiant(int id) {
        ArrayList<Seisme> tabFinal = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getIdentifiant() == id) {
                tabFinal.add(seisme);
            }
        }
        return tabFinal;
    }
    /**
     * Recherche les séismes ayant une heure donnée.
     *
     * @param heure L'heure recherchée.
     * @return Une liste des séismes correspondants.
     */
    public ArrayList<Seisme> rechercheHeure(Time heure) {
        ArrayList<Seisme> tabFinal = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getHeure().getTime() == heure.getTime()) {
                tabFinal.add(seisme);
            }
        }
        return tabFinal;
    }
    /**
     * Recherche les séismes ayant une zone donnée.
     *
     * @param zone La zone recherchée.
     * @return Une liste des séismes correspondants.
     */
    public ArrayList<Seisme> rechercheZone(String zone) {
        ArrayList<Seisme> tabFinal = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getZone().toString().compareTo(zone.toString()) == 0) {
                tabFinal.add(seisme);
            }
        }
        return tabFinal;
    }
    /**
     * Recherche les séismes ayant une région donnée.
     *
     * @param region La région recherchée.
     * @return Une liste des séismes correspondants.
     */
    public ArrayList<Seisme> rechercheRegion(String region) {
        ArrayList<Seisme> tabFinal = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getRegion().toString().compareTo(region.toString()) == 0) {
                tabFinal.add(seisme);
            }
        }
        return tabFinal;
    }
    /**
     * Recherche les séismes ayant un type de choc donné.
     *
     * @param choc Le type de choc recherché.
     * @return Une liste des séismes correspondants.
     */
    public ArrayList<Seisme> rechercheChoc(String choc) {
        ArrayList<Seisme> tabFinal = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getChoc().toString().compareTo(choc.toString()) == 0) {
                tabFinal.add(seisme);
            }
        }
        return tabFinal;
    }

    /**
     * Recherche les séismes ayant une date antérieure à une date donnée.
     *
     * @param date La date de référence.
     * @return Une liste des séismes correspondants.
     */
    public ArrayList<Seisme> rechercheAvant(Date date) {
        ArrayList<Seisme> tabFinal = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getDate().before(date)) {
                tabFinal.add(seisme);
            }
        }
        return tabFinal;
    }
    /**
     * Recherche les séismes ayant une date postérieure à une date donnée.
     *
     * @param date La date de référence.
     * @return Une liste des séismes correspondants.
     */
    public ArrayList<Seisme> rechercheApres(Date date) {
        ArrayList<Seisme> tabFinal = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getDate().after(date)) {
                tabFinal.add(seisme);
            }
        }
        return tabFinal;
    }
    /**
     * Retourne une liste des régions présentes dans la liste de séismes.
     *
     * @return Une liste des régions présentes.
     */
    public ArrayList<String> getRegions() {
        ArrayList<String> tabFinal = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (!tabFinal.contains(seisme.getRegion())) {
                tabFinal.add(seisme.getRegion());
            }
        }
        return tabFinal;
    }
}
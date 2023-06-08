package SAE201.src.Model;

import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListeDeSeismes {
    private ArrayList<Seisme> seismes;

    // Constructeur de la liste depuis un csv
    public ListeDeSeismes(String pathToCSV) {
        seismes = new ArrayList<>();
        seismes = loadCSV(pathToCSV,";");
    }

    // Ajouter un élément à la liste
    public void addSeisme(Seisme seisme) {
        seismes.add(seisme);
    }

    // on détruit de la liste un seisme par rapport a son identifiant
    public void removeSeisme(int identifiant){
        for (Seisme s : seismes){
            if (s.getIdentifiant()==identifiant)
                seismes.remove(s);
            break;
        }
    }
    // on détruit de la liste un seisme
    public void removeSeisme(Seisme s){
        seismes.remove(s);
    }

    // Getter de la liste
    public ArrayList<Seisme> getSeismes() {
        return seismes;
    }

    // On remplace la liste
    public void setSeismes(ArrayList<Seisme> seismes) {
        this.seismes = seismes;
    }

    // Ici on load le CSV et on l'update
    // Pas entièrement fonctionnel
    public ArrayList<Seisme> loadCSV(String csvFile,String splitterChar) {
        ArrayList<Seisme> seismeList = new ArrayList<>();
        String line;
        String csvSplitBy = splitterChar;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header line if it exists
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

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
                    intensiteEpicentrale = data.length >= 10 ? 0.0 : Double.parseDouble(data[10]);
                    qualiteIntensiteEpicentrale = data.length >= 10 ? null : data[11];
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
                            //intentionally empty
                        }
                    }

                }
                Seisme seisme = new Seisme(identifiant, dateSeisme, heureSeisme, nom, regionEpicentrale, choc,
                        xRGF93L93, yRGF93L93, latitudeWGS84, longitudeWGS84,
                        intensiteEpicentrale, qualiteIntensiteEpicentrale);
                seismeList.add(seisme);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return seismeList;

    }

    // L'argument des tris suivants définit si la liste est inversée ou non (croissant/décroissant)

    // On tri par intensité décroissante
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

    // On trie par date, du plus récent au plus ancien
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

    // On trie par heure, de la plus élevée à la plus faible
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

    // On tri par ordre alphabétique les types de chocs différents
    public ArrayList<Seisme> triChoc(boolean reverse) {
        Collections.sort(seismes, new Comparator<Seisme>() {
            public int compare(Seisme c1, Seisme c2) {
                return c1.getChoc().compareTo(c2.getChoc());
            }});
        // On inverse ou non la liste
        if (reverse) Collections.reverse(seismes);
        return seismes;
    }

    // On tri par ordre alphabétique les régions
    public ArrayList<Seisme> triRegion(boolean reverse) {
        Collections.sort(seismes, new Comparator<Seisme>() {
            public int compare(Seisme c1, Seisme c2) {
                return c1.getRegion().compareTo(c2.getRegion());
            }});
        // On inverse ou non la liste
        if (reverse) Collections.reverse(seismes);
        return seismes;
    }

    // On tri par ordre alphabétique les zones
    public ArrayList<Seisme> triZone(boolean reverse) {
        Collections.sort(seismes, new Comparator<Seisme>() {
            public int compare(Seisme c1, Seisme c2) {
                return c1.getZone().compareTo(c2.getZone());
            }});
        // On inverse ou non la liste
        if (reverse) Collections.reverse(seismes);
        return seismes;
    }



    // TODO : tableau de correspondance a la main selon les valeurs uniques
    
    // On tri par ordre alphabétique les qualités d'intensité
    public ArrayList<Seisme> triQualiteIntensite(boolean reverse) {
        Collections.sort(seismes, new Comparator<Seisme>() {
            public int compare(Seisme c1, Seisme c2) {
                return c1.getQualiteIntensite().compareTo(c2.getQualiteIntensite());
            }});
        // On inverse ou non la liste
        if (reverse) Collections.reverse(seismes);
        return seismes;
    }

    // On trie par latitude
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

    // On trie par longitude
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

    // On trie par identifiant
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

    // on tri par proximité d'un seisme
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
    //pour calculer la distance entre deux points
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
    public double getIntensiteMax() {
        double max = 0;
        for (Seisme i : seismes) {
            if (i.getIntensite() > max) max = i.getIntensite();
        }
        return max;
    }

    public double getLongitudeMax() {
        double max = 0;
        for (Seisme i : seismes) {
            if (i.getLongitude() > max) max = i.getLongitude();
        }
        return max;
    }

    public double getLatitudeMax() {
        double max = 0;
        for (Seisme i : seismes) {
            if (i.getLatitude() > max) max = i.getLatitude();
        }
        return max;
    }

    public Date getDateMax() {
        Date max = new Date(0);
        for (Seisme i : seismes) {
            if (i.getDate().after(max)) max = i.getDate();
        }
        return max;
    }

    public double getIdentifiantMax() {
        double max = 0;
        for (Seisme i : seismes) {
            if (i.getIdentifiant() > max) max = i.getIdentifiant();
        }
        return max;
    }

    public Date getHeureMax() {
        Date max = new Date(0);
        for (Seisme i : seismes) {
            if (i.getHeure().after(max)) max = i.getHeure();
        }
        return max;
    }


    // Méthodes pour obtenir les attributs minimum
    public double getIntensiteMin() {
        double min = -1;
        for (Seisme i : seismes) {
            if (i.getIntensite() < min) min = i.getIntensite();
        }
        return min;
    }

    public double getLongitudemin() {
        double min = 0;
        for (Seisme i : seismes) {
            if (i.getLongitude() < min) min = i.getLongitude();
        }
        return min;
    }

    public double getLatitudeMin() {
        double min = 0;
        for (Seisme i : seismes) {
            if (i.getLatitude() < min) min = i.getLatitude();
        }
        return min;
    }

    public Date getDateMin() {
        Date min = getDateMax();
        for (Seisme i : seismes) {
            if (i.getDate().before(min)) min = i.getDate();
        }
        return min;
    }

    public double getIdentifiantMin() {
        double min = 0;
        for (Seisme i : seismes) {
            if (i.getIdentifiant() < min) min = i.getIdentifiant();
        }
        return min;
    }

    public Date getHeureMin() {
        Date min = getHeureMax();
        for (Seisme i : seismes) {
            if (i.getHeure().before(min)) min = i.getHeure();
        }
        return min;
    }


    // Méthodes pour obtenir des moyennes d'attributs
    public double getIntensiteAvg(ListeDeSeismes liste) {
        long total = 0;

        for (Seisme i : liste.getSeismes()) {
            total += i.getIntensite();
        }

        return total / liste.getSeismes().size();
    }

    public double getLongitudeAvg(ListeDeSeismes liste) {
        long total = 0;

        for (Seisme i : liste.getSeismes()) {
            total += i.getLongitude();
        }

        return total / liste.getSeismes().size();
    }

    public double getLatitudeAvg(ListeDeSeismes liste) {
        long total = 0;

        for (Seisme i : liste.getSeismes()) {
            total += i.getLatitude();
        }

        return total / liste.getSeismes().size();
    }

    public Date getHeureAvg(ListeDeSeismes dates) {
        long total = 0;

        for (Seisme date : dates.getSeismes()) {
            total += date.getHeure().getTime();
        }

        return new Date(total / dates.getSeismes().size());
    }

    // Méthodes de rehcreche d'attributs



    public ArrayList<Seisme> rechercheIntensite(int intensite) {
        ArrayList<Seisme> tab_final = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getIntensite() == intensite) {
                tab_final.add(seisme);
            }
        }
        return tab_final;
    }

    public ArrayList<Seisme> rechercheLongitude(int longitude) {
        ArrayList<Seisme> tab_final = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getLongitude() == longitude) {
                tab_final.add(seisme);
            }
        }
        return tab_final;
    }

    public ArrayList<Seisme> rechercheLatitude(int latitude) {
        ArrayList<Seisme> tab_final = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getLatitude() == latitude) {
                tab_final.add(seisme);
            }
        }
        return tab_final;
    }

    public ArrayList<Seisme> rechercheDate(Date date) {
        ArrayList<Seisme> tab_final = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getDate().getTime() == date.getTime()) {
                tab_final.add(seisme);
            }
        }
        return tab_final;
    }

    public ArrayList<Seisme> rechercheQualiteIntensite(String QI) {
        ArrayList<Seisme> tab_final = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getQualiteIntensite() == QI) {
                tab_final.add(seisme);
            }
        }
        return tab_final;
    }

    public ArrayList<Seisme> rechercheIdentifiant(int id) {
        ArrayList<Seisme> tab_final = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getIdentifiant() == id) {
                tab_final.add(seisme);
            }
        }
        return tab_final;
    }

    public ArrayList<Seisme> rechercheHeure(Date heure) {
        ArrayList<Seisme> tab_final = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getHeure().getTime() == heure.getTime()) {
                tab_final.add(seisme);
            }
        }
        return tab_final;
    }

    public ArrayList<Seisme> rechercheZone(String zone) {
        ArrayList<Seisme> tab_final = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getZone() == zone) {
                tab_final.add(seisme);
            }
        }
        return tab_final;
    }

    public ArrayList<Seisme> rechercheRegion(String region) {
        ArrayList<Seisme> tab_final = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getRegion() == region) {
                tab_final.add(seisme);
            }
        }
        return tab_final;
    }

    public ArrayList<Seisme> rechercheChoc(String choc) {
        ArrayList<Seisme> tab_final = new ArrayList<>();
        for (Seisme seisme : seismes) {
            if (seisme.getChoc() == choc) {
                tab_final.add(seisme);
            }
        }
        return tab_final;
    }
}
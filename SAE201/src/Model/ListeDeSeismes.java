package SAE201.src.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class ListeDeSeismes {
    private ArrayList<Seisme> seismes;

    // Constructeur de la liste
    public ListeDeSeismes() {
        seismes = new ArrayList<>();
    }

    // Ajouter un élément à la liste
    public void addSeisme(Seisme seisme) {
        seismes.add(seisme);
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
    public void loadCSV(String nomFichier) {
        boolean started = false;
        File fichier = new File(nomFichier);
        try {
            Scanner sc = new Scanner(fichier);
            sc.useDelimiter(";");
            while (sc.hasNext())
            {
                if (started) {
                    String a = sc.next();
                    System.out.print(a);
                }
                else {
                    started=true;
                }
            }
            sc.close();
        }
        catch(FileNotFoundException exception) {
            System.out.println("Erreur lors de l'importation du fichier");
            System.out.println(exception);
        }
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
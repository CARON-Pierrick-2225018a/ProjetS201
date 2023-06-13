package seismeApp.Model;

import org.junit.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class ListeDeSeismesTest {

    ListeDeSeismes liste = new ListeDeSeismes();

    private Seisme seisme1 = new Seisme(01,new Date(01, 01, 01),
            new Time(01), "Cote dijonnaise", "Bourgogne", "GROUPE DE SECOUSSES D UN ESSAIM",
            01,01,01,01,01,"Arbitraire");

    private Seisme seisme2 = new Seisme(02,new Date(02, 02, 02),
            new Time(02), "Cote dijonnaise", "Bourgogne", "GROUPE DE SECOUSSES D UN ESSAIM",
            02,02,02,02,02,"Arbitraire");

    private Seisme seisme3 = new Seisme(03,new Date(03, 03, 03),
            new Time(03), "Cote dijonnaise", "Bourgogne", "GROUPE DE SECOUSSES D UN ESSAIM",
            03,03,03,03,03,"Arbitraire");

    @Test
    public void addSeisme() {
        liste.addSeisme(seisme1);
    }

    @Test
    public void removeSeisme() {
        ArrayList<Seisme> temp;
        temp = liste.getSeismes();
        liste.addSeisme(seisme1);
        liste.removeSeisme(seisme1);
        assertEquals(liste.getSeismes(), temp);
    }

    @Test
    public void getSeismes() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme1);
        liste.setSeismes(temp);
        assertEquals(temp, liste.getSeismes());
    }

    @Test
    public void setSeismes() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme1);
        liste.setSeismes(temp);
        assertEquals(temp, liste.getSeismes());
    }

    @Test
    public void triIntensite() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<Seisme> temp2 = new ArrayList<Seisme>();
        temp2.add(seisme3);
        temp2.add(seisme2);
        temp2.add(seisme1);

        liste.triIntensite(false);
        assertEquals(temp2, liste.getSeismes());
    }

    @Test
    public void triDate() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<Seisme> temp2 = new ArrayList<Seisme>();
        temp2.add(seisme3);
        temp2.add(seisme2);
        temp2.add(seisme1);

        liste.triDate(false);
        assertEquals(temp2, liste.getSeismes());
    }

    @Test
    public void triHeure() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<Seisme> temp2 = new ArrayList<Seisme>();
        temp2.add(seisme3);
        temp2.add(seisme2);
        temp2.add(seisme1);

        liste.triHeure(false);
        assertEquals(temp2, liste.getSeismes());
    }

    @Test
    public void triChoc() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<Seisme> temp2 = new ArrayList<Seisme>();
        temp2.add(seisme3);
        temp2.add(seisme2);
        temp2.add(seisme1);

        liste.triChoc(false);
        assertEquals(temp2, liste.getSeismes());
    }

    @Test
    public void triRegion() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<Seisme> temp2 = new ArrayList<Seisme>();
        temp2.add(seisme3);
        temp2.add(seisme2);
        temp2.add(seisme1);

        liste.triRegion(false);
        assertEquals(temp2, liste.getSeismes());
    }

    @Test
    public void triZone() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<Seisme> temp2 = new ArrayList<Seisme>();
        temp2.add(seisme3);
        temp2.add(seisme2);
        temp2.add(seisme1);

        liste.triZone(false);
        assertEquals(temp2, liste.getSeismes());
    }

    @Test
    public void triQualiteIntensite() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<Seisme> temp2 = new ArrayList<Seisme>();
        temp2.add(seisme3);
        temp2.add(seisme2);
        temp2.add(seisme1);

        liste.triQualiteIntensite(false);
        assertEquals(temp2, liste.getSeismes());
    }

    @Test
    public void triLatitude() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<Seisme> temp2 = new ArrayList<Seisme>();
        temp2.add(seisme3);
        temp2.add(seisme2);
        temp2.add(seisme1);

        liste.triLatitude(false);
        assertEquals(temp2, liste.getSeismes());
    }

    @Test
    public void triLongitude() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<Seisme> temp2 = new ArrayList<Seisme>();
        temp2.add(seisme3);
        temp2.add(seisme2);
        temp2.add(seisme1);

        liste.triLongitude(false);
        assertEquals(temp2, liste.getSeismes());
    }

    @Test
    public void triIdentifiant() {ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<Seisme> temp2 = new ArrayList<Seisme>();
        temp2.add(seisme3);
        temp2.add(seisme2);
        temp2.add(seisme1);

        liste.triIdentifiant(false);
        assertEquals(temp2, liste.getSeismes());

    }

    @Test
    public void getIntensiteMax() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(3, liste.getIntensiteMax());
    }

    @Test
    public void getLongitudeMax() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(3, liste.getLongitudeMax());
    }

    @Test
    public void getLatitudeMax() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(3, liste.getLatitudeMax());
    }

    @Test
    public void getDateMax() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(0, liste.getDateMax().compareTo(new Date(3,3,3)));
    }

    @Test
    public void getIdentifiantMax() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(3, liste.getIdentifiantMax());
    }

    @Test
    public void getHeureMax() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(3, liste.getHeureMax());
    }

    @Test
    public void getIntensiteMin() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(3, liste.getIntensiteMin());
    }

    @Test
    public void getLongitudemin() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(3, liste.getLongitudemin());
    }

    @Test
    public void getLatitudeMin() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(3, liste.getLatitudeMin());
    }

    @Test
    public void getDateMin() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(3, liste.getDateMin());
    }

    @Test
    public void getIdentifiantMin() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(3, liste.getIdentifiantMin());
    }

    @Test
    public void getHeureMin() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(3, liste.getHeureMin());
    }

    @Test
    public void getIntensiteAvg() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(2, liste.getIntensiteAvg(liste));
    }

    @Test
    public void getLongitudeAvg() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(2, liste.getLongitudeAvg(liste));
    }

    @Test
    public void getLatitudeAvg() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(3, liste.getLatitudeAvg(liste));
    }

    @Test
    public void getHeureAvg() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(3, liste.getHeureAvg(liste));
    }

    @Test
    public void rechercheIntensite() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<Seisme> temp2 = new ArrayList<>();
        temp2.add(seisme2);

        assertEquals(temp2, liste.rechercheIntensite(2));
    }

    @Test
    public void rechercheLongitude() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<Seisme> temp2 = new ArrayList<>();
        temp2.add(seisme2);

        assertEquals(temp2, liste.rechercheLongitude(2));
    }

    @Test
    public void rechercheLatitude() {ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<Seisme> temp2 = new ArrayList<>();
        temp2.add(seisme2);

        assertEquals(temp2, liste.rechercheLatitude(2));

    }

    @Test
    public void rechercheDate() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<Seisme> temp2 = new ArrayList<>();
        temp2.add(seisme2);

        assertEquals(temp2, liste.rechercheDate(new Date(2,2,2)));
    }

    @Test
    public void rechercheQualiteIntensite() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(temp, liste.rechercheQualiteIntensite("Arbitraire"));
    }

    @Test
    public void rechercheIdentifiant() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<Seisme> temp2 = new ArrayList<>();
        temp2.add(seisme2);

        assertEquals(temp2, liste.rechercheIdentifiant(2));
    }

    @Test
    public void rechercheHeure() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<Seisme> temp2 = new ArrayList<>();
        temp2.add(seisme2);

        assertEquals(temp2, liste.rechercheHeure(new Time(02)));
    }

    @Test
    public void rechercheZone() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(temp, liste.rechercheZone("Cote dijonnaise"));
    }

    @Test
    public void rechercheRegion() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(temp, liste.rechercheRegion("Bourgogne"));
    }

    @Test
    public void rechercheChoc() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        assertEquals(temp, liste.rechercheChoc("GROUPE DE SECOUSSES D UN ESSAIM"));
    }

    @Test
    public void rechercheAvant() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<Seisme> temp2 = new ArrayList<>();
        temp2.add(seisme1);

        assertEquals(temp2, liste.rechercheAvant(new Date(02,02,01)));
    }

    @Test
    public void rechercheApres() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<Seisme> temp2 = new ArrayList<>();
        temp2.add(seisme3);

        assertEquals(temp2, liste.rechercheApres(new Date(02,02,03)));
    }

    @Test
    public void getRegions() {
        ArrayList<Seisme> temp = new ArrayList<Seisme>();
        temp.add(seisme3);
        temp.add(seisme1);
        temp.add(seisme2);
        liste.setSeismes(temp);

        ArrayList<String> temp2 = new ArrayList<>();
        temp2.add("Bourgogne");

        assertEquals(temp2, liste.getRegions());
    }
}
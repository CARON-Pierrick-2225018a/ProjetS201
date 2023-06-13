package seismeApp.Model;

import org.junit.Test;

import java.sql.Time;
import java.util.Date;

import static org.junit.Assert.*;

public class SeismeTest {

    private Seisme seisme = new Seisme(01,new Date(01, 01, 01),
            new Time(0), "Cote dijonnaise", "Bourgogne", "GROUPE DE SECOUSSES D UN ESSAIM",
            69,3,1,2,3,"Arbitraire");
    @Test
    public void getIntensite() {
        assertEquals(3, seisme.getIntensite());
    }

    @Test
    public void setIntensite() {
        seisme.setIntensite(5);
        assertEquals(5, seisme.getIntensite());
    }

    @Test
    public void getLongitude() {
        assertEquals(2, seisme.getLongitude());
    }

    @Test
    public void setLongitude() {
        seisme.setLongitude(6);
        assertEquals(6, seisme.getLongitude());
    }

    @Test
    public void getLatitude() {
        assertEquals(1, seisme.getLatitude());
    }

    @Test
    public void setLatitude() {
        seisme.setLatitude(2);
        assertEquals(2, seisme.getLatitude());
    }

    @Test
    public void getDate() {
        assertEquals(0, seisme.getDate().compareTo(new Date(01,01,01)));
    }

    @Test
    public void setDate() {
        seisme.setDate(new Date(02,02,02));
        assertEquals(0, seisme.getDate().compareTo(new Date(02,02,02)));
    }

    @Test
    public void getQualiteIntensite() {
        assertEquals(0, seisme.getQualiteIntensite().compareTo("Arbitraire"));
    }

    @Test
    public void setQualiteIntensite() {
        seisme.setQualiteIntensite("Incertaine");
        assertEquals(0, seisme.getQualiteIntensite().compareTo("Incertaine"));
    }

    @Test
    public void getIdentifiant() {
        assertEquals(01, seisme.getIdentifiant());
    }

    @Test
    public void setIdentifiant() {
        seisme.setIdentifiant(02);
        assertEquals(02, seisme.getIdentifiant());
    }

    @Test
    public void getHeure() {
        assertEquals(0, seisme.getHeure().compareTo(new Time(0)));
    }

    @Test
    public void setHeure() {
        seisme.setHeure(new Time(5));
        assertEquals(0, seisme.getHeure().compareTo(new Time(5)));
    }

    @Test
    public void getZone() {
        assertEquals(0, seisme.getZone().compareTo("Cote dijonnaise"));
    }

    @Test
    public void setZone() {
        seisme.setZone("Ailleurs");
        assertEquals(0, seisme.getZone().compareTo("Ailleurs"));
    }

    @Test
    public void getRegion() {
        assertEquals(0, seisme.getRegion().compareTo("Bourgogne"));
    }

    @Test
    public void setRegion() {
        seisme.setRegion("Paca");
        assertEquals(0, seisme.getRegion().compareTo("paca"));
    }

    @Test
    public void getChoc() {
        assertEquals(0, seisme.getChoc().compareTo("GROUPE DE SECOUSSES D UN ESSAIM"));
    }

    @Test
    public void setChoc() {
        seisme.setChoc("Essaim");
        assertEquals(0, seisme.getChoc().compareTo("Essaim"));
    }

    @Test
    public void getxRGF93L93() {
        assertEquals(69, seisme.getxRGF93L93());
    }

    @Test
    public void setxRGF93L93() {
        seisme.setxRGF93L93(10);
        assertEquals(10, seisme.getxRGF93L93());
    }

    @Test
    public void getyRGF93L93() {
        assertEquals(3, seisme.getyRGF93L93());
    }

    @Test
    public void setyRGF93L93() {
        seisme.setyRGF93L93(10);
        assertEquals(10, seisme.getyRGF93L93());
    }
}
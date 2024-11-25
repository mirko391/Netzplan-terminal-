import java.util.ArrayList;
import java.util.List;

public class Arbeitspaket {

    // definieren der Objektattribute
    private String name;
    private List<Integer> vorgaenger = new ArrayList<>();
    private List<Integer> nachfolger = new ArrayList<>();
    private double dauer;
    private double saz;
    private double sez;
    private double faz;
    private double fez;
    private double gp;
    private double fp;

    // leerer Konstruktor
    public Arbeitspaket(){}

    // Konstruktor
    public Arbeitspaket(
            String name,
            List<Integer>vorgaenger,
            int dauer

    ) {
        this.name = name;
        this.vorgaenger = vorgaenger;
        this.nachfolger= nachfolger;
        this.dauer = dauer;
        this.saz = saz;
        this.sez = sez;
        this.faz = faz;
        this.fez = fez;
        this.gp = gp;
        this.fp = fp;
    }

    // getter und setter für Objektattribute

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDauer() {
        return dauer;
    }

    public void setDauer(double dauer) {
        this.dauer = dauer;
    }

    public double getSaz() {
        return saz;
    }

    public void setSaz(double saz) {
        this.saz = saz;
    }

    public double getSez() {
        return sez;
    }

    public void setSez(double sez) {
        this.sez = sez;
    }

    public double getFaz() {
        return faz;
    }

    public void setFaz(double faz) {
        this.faz = faz;
    }

    public double getFez() {
        return fez;
    }

    public void setFez(double fez) {
        this.fez = fez;
    }

    public double getGp() {
        return gp;
    }

    public void setGp(double gp) {
        this.gp = gp;
    }

    public double getFp() {
        return fp;
    }

    public void setFp(double fp) {
        this.fp = fp;
    }

    public List<Integer> getVorgaenger() {
        return vorgaenger;
    }

    public void setVorgaenger(List<Integer> vorgaenger) {
        this.vorgaenger = vorgaenger;
    }

    public List<Integer> getNachfolger() {
        return nachfolger;
    }

    public void setNachfolger(List<Integer> nachfolger) {
        this.nachfolger = nachfolger;
    }
}



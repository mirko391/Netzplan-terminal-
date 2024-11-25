import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Start des Netzplan - Programms und Eingabe der Nutzer- Daten
        Netzplan.start();
        // Berechnung des Netzplans
        Netzplan.berechnen();
        // fertige Berechnung wird komplett ausgegeben
        Netzplan.ausgabeNetzplan();
        // einzelnes Arbeitspaket wird ausgegeben
        Netzplan.ausgabeArbeitspaketMitEingabe();
    }
}


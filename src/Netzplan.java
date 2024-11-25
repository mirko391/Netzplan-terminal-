import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Netzplan {
    // Liste von Arbeitspaketen wird initialisiert
   private static List<Arbeitspaket> arbeitspaketListe = new ArrayList<>();

    // leerer Konstruktor
    public Netzplan(){}

    // Konstruktor
    public Netzplan( Arbeitspaket arbeitspaketListe){}

    // get Methode für Arbeitspaketliste
    public static List<Arbeitspaket> getArbeitspaketListe() {
        return arbeitspaketListe;
    }

    // set Methode für Arbeitspaketliste
    public void setArbeitspaketListe(List<Arbeitspaket> arbeitspaketListe) {
        this.arbeitspaketListe = arbeitspaketListe;
    }

    // Methode, um die Eingabe der Dauer zu prüfen und zurückzugeben
    public static double eingabeUndCheckDauer(){
        double dauer = 0;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("Hilfe")) {                       // wenn Eingabe = "Hilfe" wird Methode hilfe angezeigt
                hilfe();
                continue;
            }
            try {                                                                   // try/catch Funktion, um bei ungültiger Eingabe exception zu verhindern
                dauer = Double.parseDouble(input);                                  // Prüfung ob Eingabe in einen double Wert umgewandelt werden kann
                if (dauer > 0) {                                                    // Prüfung ob Eingabe über 0
                    break;
                } else {
                    System.out.println("Bitte tätige eine gültige Eingabe!");
                }
            } catch (Exception e) {
                System.out.println("Bitte tätige eine gültige Eingabe!");
            }
        }
        return dauer;
    }

    // Methode, um die Eingabe der Anzahl der Arbeitspakete zu prüfen und zurückzugeben
    public static int eingabeUndCheckAnzahl(){
        int anzahl = 0;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("Hilfe")) {                     // wenn Eingabe = "Hilfe" wird Methode hilfe angezeigt
                hilfe();
                continue;
            }
            try {                                                                   // try/catch Funktion, um bei ungültiger Eingabe exception zu verhindern
                anzahl = Integer.parseInt(input);                                   // Prüfung ob Eingabe in einen int Wert umgewandelt werden kann
                if (anzahl > 0) {                                                   // Prüfung ob Eingabe über 0
                    break;
                } else {
                    System.out.println("Bitte tätige eine gültige Eingabe!");
                }
            } catch (Exception e) {
                System.out.println("Bitte tätige eine gültige Eingabe!");
            }
        }
        return anzahl;
    }

    // Methode, um die eingegebene Anzahl der Vorgänger zu prüfen und zurückzugeben
    public static int eingabeUndCheckAnzahlVorgänger(int a, int b){                 // Übergabeparameter a und b
        int anzahlVorgänger = 0;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("Hilfe")) {                       // wenn Eingabe = "Hilfe" wird Methode hilfe angezeigt
                hilfe();
                continue;
            }
            try {                                                                   // try/catch Funktion, um bei ungültiger Eingabe exception zu verhindern
                anzahlVorgänger = Integer.parseInt(input);                          // Prüfung ob Eingabe in einen int Wert umgewandelt werden kann
                if (anzahlVorgänger >= a && anzahlVorgänger <= b) {                 // Prüfung ob Eingabe größer gleich a und kleiner gleich b
                    break;
                } else {
                    System.out.println("Bitte tätige eine gültige Eingabe!");
                }
            } catch (Exception e) {
                System.out.println("Bitte tätige eine gültige Eingabe!");
            }
        }
        return anzahlVorgänger;
    }




    // Methode, um die Eingabe des Namens zu prüfen und zurückzugeben
    public static String eingabeUndCheckName(){
        String name ;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("Hilfe")) {                      // wenn Eingabe = "Hilfe" wird Methode hilfe angezeigt
                hilfe();
                continue;
            }
            try {                                                                  // try/catch Funktion, um bei ungültiger Eingabe exception zu verhindern
                name = input ;
                if (input.length() > 0 && input.length() <= 16) {                   // Prüfung ob Eingabe String größer 0 und kleiner gleich 16
                    break;
                } else {
                    System.out.println("Bitte tätige eine gültige Eingabe!");
                }
            } catch (Exception e) {
                System.out.println("Bitte tätige eine gültige Eingabe!");
            }
        }
        return name;
    }

    public static void ausgabeArbeitspaketMitEingabe() {
        while (true) {
            System.out.println("Bitte geben Sie einen Index ein (oder 'hilfe' für Hilfe, 'ende' zum Beenden):");
            Scanner scanner = new Scanner(System.in);
            // Lesen der Eingabe des Benutzers
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("hilfe")) {
                hilfe();                                                                                                  // wenn Eingabe = "Hilfe" wird Methode hilfe angezeigt
                continue;
            }

            if (input.equalsIgnoreCase("ende")) {                                                             // wenn Eingabe = "exit" wird das Programm beendet
                System.out.println("Programm beendet.");
                break;
            }

            try {                                                                                                         // try/catch Funktion, um bei ungültiger Eingabe exception zu verhindern
                int index = Integer.parseInt(input);                                                                   // Prüfung ob Eingabe in einen int Wert umgewandelt werden kann
                if (index < 0 || index >= arbeitspaketListe.size()) {                                                     // Wenn Eingabe kleiner 0 oder größer gleich APListe - Ungültige Eingabe
                    System.out.println("Ungültiges Arbeitspaketindex. Bitte versuchen Sie es erneut.");
                } else {
                    ausgabeArbeitspaket(index);                                                                           // Index wird an ausgabeArbeitspaketMitEingabe übergeben
                }
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl, 'hilfe' oder 'ende' ein.");
            }
        }
    }

    // Methode, um Erklärung zum Ablauf auszugeben
    public static void hilfe(){
        System.out.println("Larry erklärt dir die Funktionsweise vom Netzwerk-Tool:");
        System.out.println();
        System.out.println("Zuerst gibst du die Anzahl der Arbeitspakete an. Hierfür wird eine ganze Zahl erwartet.");
        System.out.println("Dann wirst du durch die Erstellung der einzelnen Arbeitspakete geführt. Bitte gib die Arbeitspakete in chronologischer Reihenfolge an.");
        System.out.println("Für jedes Arbeitspaket werden ein Name, eine Dauer(Kommazahl möglich) und die Abhängigkeiten (INDEX des/der vorherigen Arbeitspakete(s)) benötigt, sprich von 0 beginnend.");
        System.out.println("Anschließend wird der Netzplan berechnet und ausgegeben. Außerdem hast du danach die Möglichkeit einzelne Arbeitspakete aufzurufen.");
        System.out.println("Falls etwas unklar ist kannst du diesen Text bei jeder Eingabeaufforderung durch die Eingabe \"help\" aufrufen");
    }
    // Methode, um das Netzplan - Tool zu starten
    public static void start(){
        System.out.println("Herzlich willkommen zu Larry's Netzplan-Tool!");
        hilfe();
        int anzahlArbeitspakete;
        System.out.println("Bitte gib die Anzahl der benötigten Arbeitspakete ein:");
        anzahlArbeitspakete = eingabeUndCheckAnzahl();                                                                     // Eingabe Anzahl der AP
        arbeitspaketeErstellen(anzahlArbeitspakete);                                                                       // Erstellung APListe mit gewünschter größe
    }

    // Methode, um Name, Dauer und Vorgänger der Arbeitspakete abzufragen
    public static void arbeitspaketeErstellen(int anzahlArbeitspakete) {
        for (int i = 0; i < anzahlArbeitspakete; i++) {

            arbeitspaketListe.add(new Arbeitspaket());

            // Name definieren
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bitte gib den Namen von Arbeitspaket " + (i + 1) + " ein.");
            arbeitspaketListe.get(i).setName(eingabeUndCheckName());

            // Dauer definieren
            System.out.println("Bitte gib die Dauer von Arbeitspaket " + (i + 1) + " ein.");
            arbeitspaketListe.get(i).setDauer(eingabeUndCheckDauer());

            // Vorgänger definieren
            System.out.println("Bitte gib an wie viele Vorgänger - Arbeitspakete das Arbeitspaket " + (i + 1) + " hat. Ein Arbeitspaket kann zwischen 0 und 3 Vorgänger - Arbeitspakete haben.");
            int anzahlVorgänger = eingabeUndCheckAnzahlVorgänger(0, 3);

            if (!(anzahlVorgänger == 0)) {
                for (int j = 0; j < anzahlVorgänger; j++) {
                    System.out.println("Bitte gib den " + (j + 1) + ". Vorgänger ein.");
                    arbeitspaketListe.get(i).getVorgaenger().add(eingabeUndCheckAnzahlVorgänger(0, i - 1));
                }

            }

        }
    }

    // Methode, in der alle für die Berechnung notwendigen Methoden gesammelt sind
    public static void berechnen(){
     berechnenFZ();
     setzeNachfolger(arbeitspaketListe);
     berechnenSZ(arbeitspaketListe);
     berechnenPuffer(arbeitspaketListe); // Huff and puff
    }

    // Methode, die frühesten Anfangszeitpunkt und frühesten Endzeitpunkt berechnet
    public static void berechnenFZ() {

        for (int i = 0; i < arbeitspaketListe.size(); i++) {                                                                // Schleife durch ArbeitspaketListe, um FAZ und FEZ für Arbeitspakete ohne Vorgänger zu setzen
            if (arbeitspaketListe.get(i).getVorgaenger().isEmpty()) {                                                       // prüft ob AP Vorgänger hat
                arbeitspaketListe.get(i).setFaz(0);                                                                         // Setzt FAZ der Anfänge auf 0
                arbeitspaketListe.get(i).setFez(arbeitspaketListe.get(i).getDauer());                                       // FEZ = FAZ + Dauer
            }
        }

        for (int j = 0; j < arbeitspaketListe.size(); j++) {                                                                // Schleife durch ArbeitspaketListe, um FAZ und FEZ für Arbeitspakete mit Vorgängern zu berechnen
            if (!arbeitspaketListe.get(j).getVorgaenger().isEmpty()) {                                                      // prüft ob AP Vorgänger hat
                double vorgaengerMax = 0;                                                                                   // Zwischenspeicher FEZ Vorgänger Max
                for (int l = 0; l < arbeitspaketListe.get(j).getVorgaenger().size(); l++) {                                 // Schleife für Vorgängerliste
                    int vorgaengerIndex = arbeitspaketListe.get(j).getVorgaenger().get(l);
                    vorgaengerMax = Math.max(vorgaengerMax, arbeitspaketListe.get(vorgaengerIndex).getFez());               // Vergleich von FEZ des Vorgängers mit Zwischenspeicher
                }
                arbeitspaketListe.get(j).setFaz(vorgaengerMax);                                                             // größter FEZ des Vorgängers wird als FAZ des aktuellen AP eingespeichert
                arbeitspaketListe.get(j).setFez(vorgaengerMax + arbeitspaketListe.get(j).getDauer());                       // FAZ + Dauer = FEZ
            }
        }
    }

    // Methode, die die Nachfolger der Arbeitspakete identifiziert
    public static void setzeNachfolger(List<Arbeitspaket> arbeitspaketListe) {

        for (int i = 0; i < arbeitspaketListe.size(); i++) {                                                                // Durchlaufen aller Arbeitspakete, um Nachfolger zu setzen
            Arbeitspaket aktuellesPaket = arbeitspaketListe.get(i);

            aktuellesPaket.getNachfolger().clear();                                                                         // Leeren der Nachfolger-Liste des aktuellen Pakets

            for (int vorgaengerIndex : aktuellesPaket.getVorgaenger()) {                                                    // Durchlaufen der Vorgänger-Indizes und Setzen der Nachfolger
                if (vorgaengerIndex >= 0 && vorgaengerIndex < arbeitspaketListe.size()) {
                    Arbeitspaket vorgaengerPaket = arbeitspaketListe.get(vorgaengerIndex);
                    vorgaengerPaket.getNachfolger().add(i);
                } else {
                    System.out.println("Ungültiger Vorgängerindex für Paket " + aktuellesPaket.getName() + ": " + vorgaengerIndex);
                }
            }
        }
    }

   // Methode, um spätesten Anfangszeitpunkt und spätesten Endzeitpunkt zu berechnen
    public static void berechnenSZ(List<Arbeitspaket> arbeitspaketListe) {

        Arbeitspaket letztesPaket = arbeitspaketListe.get(arbeitspaketListe.size() - 1);                                    // Initialisierung für das letzte Arbeitspaket
        letztesPaket.setSez(letztesPaket.getFez());                                                                         // berechnet Sez des letzten APs
        letztesPaket.setSaz(letztesPaket.getSez() - letztesPaket.getDauer());                                               // berechnet Saz des letzten APs

        for (int i = arbeitspaketListe.size() - 2; i >= 0; i--) {                                                           // Berechnen von SEZ und SAZ für alle Arbeitspakete rückwärts
            Arbeitspaket aktuellesPaket = arbeitspaketListe.get(i);
            double minSez = Double.MAX_VALUE;                                                                               // setzt größtmöglichen double Wert

            for (int nachfolgerIndex : aktuellesPaket.getNachfolger()) {                                                    // Finden des kleinsten SAZ der Nachfolger
                Arbeitspaket nachfolgerPaket = arbeitspaketListe.get(nachfolgerIndex);
                minSez = Math.min(minSez, nachfolgerPaket.getSaz());
            }

            if (minSez == Double.MAX_VALUE) {                                                                               // wenn minSez entspricht größtmöglichem double Wert -> minSez entspricht Fez des letzten APs
                minSez = letztesPaket.getFez();
            }
                                                                                                                            // kleinste Sez wird verwendet, um Saz des aktuellen APs zu berechnen
            aktuellesPaket.setSez(minSez);
            aktuellesPaket.setSaz(minSez - aktuellesPaket.getDauer());
        }
    }


    //Methode, um den FP und GP zu berechnen
    public static void berechnenPuffer(List<Arbeitspaket> arbeitspaketListe) {

        Arbeitspaket letztesPaket = arbeitspaketListe.get(arbeitspaketListe.size() - 1);                                   // Initialisierung des letzten Arbeitspakets
        letztesPaket.setGp(0);                                                                                             // GP des letzten AP wird auf 0 gesetzt
        letztesPaket.setFp(0);                                                                                             // FP des letzten AP wird auf 0 gesetzt

        for (int i = arbeitspaketListe.size() - 1; i >= 0; i--) {                                                          // Schleife über die ArbeitspaketListe von hinten
            Arbeitspaket aktuellesPaket = arbeitspaketListe.get(i);

            aktuellesPaket.setGp(aktuellesPaket.getSaz() - aktuellesPaket.getFaz());                                       // Berechnung des gesamten Puffers (GP)

            if (!aktuellesPaket.getNachfolger().isEmpty()) {                                                               // Initialisierung des freien Puffers (FP)
                double minFp = Double.MAX_VALUE;

                for (int nachfolgerIndex : aktuellesPaket.getNachfolger()) {                                               // Berechnung des freien Puffers (FP)
                    Arbeitspaket nachfolgerPaket = arbeitspaketListe.get(nachfolgerIndex);
                    double fpZwischen = nachfolgerPaket.getFaz() - aktuellesPaket.getFez();

                    if (fpZwischen < minFp) {                                                                              // Aktualisieren des minimalen freien Puffers
                        minFp = fpZwischen;
                    }
                }

                aktuellesPaket.setFp(minFp);
            } else {
                aktuellesPaket.setFp(0);                                                                                   // Falls keine Nachfolger, setze den FP auf 0
            }
        }
    }
    public static void ausgabeNetzplan() {
        System.out.println("Netzplan Übersicht:");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("%-15s %-10s %-10s %-10s %-10s %-10s %-10s  %-10s\n", "Name", "Dauer","FAZ", "FEZ", "SAZ", "SEZ", "GP", "FP");
        System.out.println("---------------------------------------------------------------------------------");

        for (Arbeitspaket ap : arbeitspaketListe) {
            System.out.printf(                                                                                             // formatiert und druckt die Eigenschaften eines AP-Objekts in einer Tabelle. Jeder Spezifikator sorgt dafür, dass die entsprechenden Werte ordentlich ausgerichtet und formatiert sind.
                    "%-15s %-10.2f %-10.2f %-10.2f %-10.2f %-10.2f %-10.2f %-10.2f\n",
                    ap.getName(),
                    ap.getDauer(),
                    ap.getFaz(),
                    ap.getFez(),
                    ap.getSaz(),
                    ap.getSez(),
                    ap.getGp(),
                    ap.getFp()
            );
        }
        System.out.println("---------------------------------------------------------------------------------");
    }

    // Methode, um ein einzelnes AP auszugeben
    public static void ausgabeArbeitspaket(int index) {
        if (index < 0 || index >= arbeitspaketListe.size()) {                                                             // Prüfen, ob der Index innerhalb der Grenzen der Liste liegt
            System.out.println("Ungültiger Index.");
            return;
        }

        Arbeitspaket ap = arbeitspaketListe.get(index);                                                                   // Das Arbeitspaket an dem angegebenen Index abrufen

        System.out.println("Arbeitspaket Details:");                                                                      // Arbeitspaketdetails ausgeben
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("%-15s : %s\n", "Name", ap.getName());
        System.out.printf("%-15s : %.2f\n", "Dauer", ap.getDauer());
        System.out.printf("%-15s : %.2f\n", "FAZ", ap.getFaz());
        System.out.printf("%-15s : %.2f\n", "FEZ", ap.getFez());
        System.out.printf("%-15s : %.2f\n", "SAZ", ap.getSaz());
        System.out.printf("%-15s : %.2f\n", "SEZ", ap.getSez());
        System.out.printf("%-15s : %.2f\n", "GP", ap.getGp());
        System.out.printf("%-15s : %.2f\n", "FP", ap.getFp());
        System.out.println("---------------------------------------------------------------------------------");
    }
}



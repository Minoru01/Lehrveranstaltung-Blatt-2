import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by robin on 13.10.2017.
 */
public class Sachbearbeiter {
    private static ArrayList<Sachbearbeiter> alleSachbearbeiter = new ArrayList<Sachbearbeiter>();
    private static HashSet<String> alleIds = new HashSet<String>();
    private String id = "";
    private String name = "";
    private String berechtigung = "";

    /*
     * sollte nicht aufgerufen werden, wird in dieser Klasse vermieden und ist durch private in anderen nicht möglich
     */
    private Sachbearbeiter() {}

    /*
     * erstellt einen Sachberarbeiter mit berechtigung normal
     */
    public Sachbearbeiter(String name) {
        this.id = name;
        this.name = name;
        this.berechtigung = "normal";

        if (alleIds.contains(this.id))
            //throw //.....
            System.out.println("Error Id " + this.id + " already exists.");
        else {
            alleIds.add(this.id);
            alleSachbearbeiter.add(this);
            System.out.println("Added to Set " + id + ".");

        }
    }

    /*
     * erstellt einen sachbearbeiter mit einer gewünschten berechtigung
     */
    public Sachbearbeiter(String name, String berechtigung) {
        this.id = name;
        this.name = name;
        this.berechtigung = berechtigung;

        if (alleIds.contains(this.id))
            //throw //.....
            System.out.println("Error");
        else {
            alleIds.add(this.id);
            alleSachbearbeiter.add(this);
            System.out.println("Added to Set " + id + ".");

        }
    }

    /*
     * Kopier Konstruktor erstellt eine Kopie ohne den Sachbearbeiter in alleSachbearbeiter hinzu zufügen
     */
    public Sachbearbeiter(String name, String berechtigung, boolean a) {
        this.id = name;
        this.name = name;
        this.berechtigung = berechtigung;
    }

    /*
     *  gibt einen Array mit allen Namen/IDs zurück
     */
    public static String[] gibAlleNamen() {
        return alleIds.toArray(new String[alleIds.size()]);
    }

    /*
     * gibt eine Kopie des Sacharbeiters zurück mit hilfe des namens
     */
    public static Sachbearbeiter gibKopie(String name) {
        Sachbearbeiter arbeiter = null;

        // durchläuft HashSet aller Sachbearbeiter und sucht id
        for (Sachbearbeiter s : Sachbearbeiter.alleSachbearbeiter) {
            if (name == s.gibName()) {
                //gibt die Instanz s zurück
                return new Sachbearbeiter(s.gibName(), s.gibBerechtigung(), true);
            }
        }

        // wirft wenn es den nicht Namen gibt eine NullPointerExecption
        if (arbeiter == null) {
            System.out.println("Error gib Sachbearbeiter");
            throw new NullPointerException();
        }

        //Syntaktisch notwendiger return Wert
        return null;
    }

    /*
     * gibt die Instanz eines Sachbearbeiter mithilfe des Namens aus
     */

    public static Sachbearbeiter gib(String name) {

        Sachbearbeiter arbeiter = null;

        // durchläuft HashSet aller Sachbearbeiter und sucht id
        for (Sachbearbeiter s : Sachbearbeiter.alleSachbearbeiter) {
            if (name == s.gibName()) {
                //gibt die Instanz s zurück
                return s;
            }
        }

        // wirft wenn es den nicht Namen gibt eine NullPointerExecption
        if (arbeiter == null) {
            System.out.println("Error gib Sachbearbeiter");
            throw new NullPointerException();
        }

        //Syntaktisch notwendiger return Wert
        return null;
    }

    /*
     * Sacharbeiter gibt seine id zurück
     */
    public String gibId() {
        return this.id;
    }

    /*
     * Sacharbeiter gibt seinen name zurück
     */
    public String gibName() {
        return this.name;
    }

    /*
     * gibt die Berechtigung als String zurück.
     */
    public String gibBerechtigung() { return this.berechtigung;}

    /*
     * ändert die Werte id und berechtigung der der Instanz
     */
    public void schreibe(String id, String name, String berechtigung){
        this.schreibeId(id);
        this.schreibeName(name);
        this.schreibeBerechtigung(berechtigung);
    }

    /*
     * ändert den Wert id der Instanz
     */
    public void schreibeId(String id){
        alleIds.remove(this.id);
        this.id = id;
        alleIds.add(id);
    }

    /*
     * ändert den Wert namen der Instanz
     */
    public void schreibeName(String name) {
        this.name = name;
    }

    /*
     * ändert die Wert berechtigung der Instanz
     */
    public void schreibeBerechtigung(String berechtigung){
        this.berechtigung = berechtigung;
    }

    /*
     * kopiert die attribute der instanz in die ausführende Instanz(this)
     */
    public void kopiereAttribute(Sachbearbeiter instanz){ this.schreibe(instanz.id, instanz.name, instanz.berechtigung); }
    // evtl nicht wie gefordert fragen!!

    /*
     * löscht den Sacharbeiter aus alleSacharbeiter
     */
    public void lösche(){
        Sachbearbeiter.alleSachbearbeiter.remove(Sachbearbeiter.gib(this.id));
        Sachbearbeiter.alleIds.remove(this.id);
    }
}
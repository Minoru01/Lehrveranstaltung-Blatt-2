import java.util.HashSet;
import java.util.regex.Pattern;

/**
 * Created by robin on 13.10.2017.
 */
public class Sachbearbeiter {
    public static HashSet<Sachbearbeiter> alleSachbearbeiter = Sachbearbeiter.createHashSetWithSachbearbeiter();
    private String name;
    private String passwort = "";
    private String berechtigung;

    private static HashSet<Sachbearbeiter> createHashSetWithSachbearbeiter(){
        HashSet<Sachbearbeiter> retHash = new HashSet<>();
        retHash.add(new Sachbearbeiter("Robin","admin",true));
        retHash.add(new Sachbearbeiter("Luis","admin",true));
        retHash.add(new Sachbearbeiter("Lang","normal",true));
        retHash.add(new Sachbearbeiter("Jeff","normal",true));
        retHash.add(new Sachbearbeiter("Jess","normal",true));
        retHash.add(new Sachbearbeiter("Java_Gott","admin",true));
        retHash.add(new Sachbearbeiter("Exception_Master","admin",true));
        retHash.add(new Sachbearbeiter("Java_Buddha","admin",true));
        System.out.println("!");
        return retHash;
    }
    /*
     * sollte nicht aufgerufen werden, wird in dieser Klasse vermieden und ist durch private in anderen nicht möglich
     */
    private Sachbearbeiter() {
    }

    /*
     * erstellt einen sachbearbeiter mit einer gewünschten berechtigung
     */
    public Sachbearbeiter(String name, String berechtigung) {
        if (name.equals(""))
            throw new NullPointerException("Fehler! Bestandteile des Namens sind unzulässig!");

        if (!Pattern.matches("[A-Za-z_äöüß]+$", name))
            throw new NullPointerException("Fehler! Bestandteile des Namens sind unzulässig!");

        this.name = name;
        this.passwort = berechtigung;
        this.berechtigung = berechtigung;

        if(this.berechtigung != "normal" || this.berechtigung != "admin")
            throw new NullPointerException("Es wurde keine Berechtigung gewählt!");

        if (!alleSachbearbeiter.contains(this)) {
            alleSachbearbeiter.add(this);
            System.out.println("Erfolg! " + this.name + " (" + this.berechtigung + ")");
        } else {
            throw new NullPointerException(this.name + " existiert bereits!");
        }
    }

    public Sachbearbeiter(String name, String b_p, boolean x){
        this.name = name;
        this.berechtigung = b_p;
        this.passwort = b_p;
    }

    public Sachbearbeiter(String name, String b, String p) {
        if (name.equals(""))
            throw new NullPointerException("Fehler! Bestandteile des Namens sind unzulässig!");

        if (!Pattern.matches("[A-Za-z_äöüßÄÖÜ]+$", name))
            throw new NullPointerException("Fehler! Bestandteile des Namens sind unzulässig!");

        this.name = name;
        this.berechtigung = b;
        this.passwort = p;

        if (!alleSachbearbeiter.contains(this)) {
            Sachbearbeiter.alleSachbearbeiter.add(new Sachbearbeiter(this));
        } else {
            throw new NullPointerException(this.name + " existiert bereits!");
        }
    }

    /*
     * Kopier Konstruktor erstellt eine Kopie ohne den Sachbearbeiter in alleSachbearbeiter hinzu zufügen
     */
    public Sachbearbeiter(String name, Sachbearbeiter s) {
        this.name = name;
        this.passwort = s.gibPasswort();
        this.berechtigung = s.gibBerechtigung();
    }

    public Sachbearbeiter(Sachbearbeiter s) {
        this.name = s.name;
        this.berechtigung = s.berechtigung;
        this.passwort = s.passwort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sachbearbeiter that = (Sachbearbeiter) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    /*
     *  gibt einen Array mit allen Namen/IDs zurück
     */
    public static String[] gibAlleNamen() {
        String[] retSachbearbeiter = new String[alleSachbearbeiter.size()];
        int i = 0;

        for (Sachbearbeiter s : alleSachbearbeiter) {
            retSachbearbeiter[i] = s.gibName();
            ++i;
        }

        return retSachbearbeiter;
    }

    /*
     * gibt eine Kopie des Sacharbeiters zurück mit hilfe des namens
     */
    public static Sachbearbeiter gibKopie(String name) {

        // durchläuft HashSet aller Sachbearbeiter und sucht id
        for (Sachbearbeiter s : Sachbearbeiter.alleSachbearbeiter) {

            if (s.equals(new Sachbearbeiter(name, s))) {
                // gibt eine Kopie der Instanz s zurück
                return new Sachbearbeiter(s);
            }
        }

        throw new NullPointerException("Error konnte keinen Sachbearbeiter zurückgeben, weil es keinen mit diesem Namen gibt.");
    }

    /*
     * gibt die Instanz eines Sachbearbeiter mithilfe des Namens aus
     */
    public static Sachbearbeiter gib(String name) {

        // durchläuft HashSet aller Sachbearbeiter und sucht id
        for (Sachbearbeiter s : Sachbearbeiter.alleSachbearbeiter) {

            if (s.equals(new Sachbearbeiter(name, s))) {
                return s;
            }
        }

        throw new NullPointerException(/*Error konnte keinen Sachbearbeiter zurückgeben, weil es keinen mit diesem Namen gibt.*/"Falscher Benutzername!");
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
    public String gibBerechtigung() {
        return this.berechtigung;
    }

    /*
     * gibt die Berechtigung als String zurück.
     */
    public String gibPasswort() {
        return this.passwort;
    }

    /*
     * ändert die Werte id und berechtigung der der Instanz
     */
    public void schreibe(String name, String berechtigung, String passwort) {
        //this.schreibeId(id);
        this.schreibeName(name);
        this.schreibeBerechtigung(berechtigung);
        this.schreibePasswort(passwort);
    }

    /*
     * ändert den Wert namen der Instanz
     */
    public void schreibeName(String name) {
        if (name.equals(""))
            throw new NullPointerException("Fehler! Bestandteile des Namens sind unzulässig!");

        if (!Pattern.matches("[A-Za-z_äöüßÄÖÜ]+$", name))
            throw new NullPointerException("Fehler! Bestandteile des Namens sind unzulässig!");

        this.name = name;
    }

    /*
     * ändert die Wert berechtigung der Instanz
     */
    public void schreibeBerechtigung(String berechtigung) {
        this.berechtigung = berechtigung;
    }

    /*
     * ändert den Wert berechtigung der Instanz
     */
    public void schreibePasswort(String passwort) {
        this.passwort = passwort;
    }

    /*
     * kopiert die attribute der instanz in die ausführende Instanz(this)
     */
    public void kopiereAttribute(Sachbearbeiter instanz) {
        this.schreibe(/*instanz.id,*/ instanz.name, instanz.berechtigung, instanz.passwort);
    }
    // evtl nicht wie gefordert fragen!!

    /*
     * löscht den Sacharbeiter aus alleSacharbeiter
     */
    public void lösche() {
        Sachbearbeiter.alleSachbearbeiter.remove(Sachbearbeiter.gib(this.name));
    }

    @Override
    public String toString() {
        return "" + name + " | " + passwort + " | " + berechtigung;
    }

}
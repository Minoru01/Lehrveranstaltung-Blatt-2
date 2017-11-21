/**
 * Created by robin on 14.10.2017.
 */
public class AdminSachbearbeiterLöschenK {
    /*
     * erzeugt eine Instanz mit dem namen und gibt ihm die berechtigung normal
     */
    public Sachbearbeiter erzeugeSachbearbeiter(String name, String berechtigung, String passwort) {
        new Sachbearbeiter(name, berechtigung, passwort);
        return Sachbearbeiter.gibKopie(name);
    }

    /**
     * gibt den Namen aller Sachbearbeiter zurück
     */
    public String[] gibSachberarbeiterNamen() {
        return Sachbearbeiter.gibAlleNamen();
    }

    /*
     * gibt ein Objekt Sachbearbeiter anhand des Namens zurück
     */
    public Sachbearbeiter gibSachbearbeiter(String name) {
        return Sachbearbeiter.gibKopie(name);
    }

    /*
     * schreibt die Attribute einer kopie in das Orginal
     */
    //public void schreibeSachbearbeiter(Sachbearbeiter kopie){ Sachbearbeiter.gib(kopie.gibName()).kopiereAttribute(kopie); }
    //verwendet evlt falsche Methode falls kopiereAttribute nicht wie gewünscht weiche auf schreibe() aus!

    /*
     * löscht anhand des Namens einen Sachbearbeiter
     */
    public void löscheSachbearbeiter(String name) {
        if (!istLetzterAdmin(name))
            Sachbearbeiter.gib(name).lösche();
    }
    /*
     * prüft ob der name dem letzen Admin gehört
     */
    public boolean istLetzterAdmin(String name) {
        int coutAdmin = 0;
        if (!Sachbearbeiter.gib(name).gibBerechtigung().equals("admin"))
            return false;
        else {
            for (String s : Sachbearbeiter.gibAlleNamen()) {
                if (Sachbearbeiter.gib(s).gibBerechtigung().equals("admin")) {
                    ++coutAdmin;
                }
            }
            if (coutAdmin != 1)
                return false;
            throw new NullPointerException("Fehler! Der letzte Admin kann nicht gelöscht werden!");
        }
    }
}

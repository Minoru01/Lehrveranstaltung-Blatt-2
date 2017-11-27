/**
 * Created by robin on 14.10.2017.
 */
public class AdminSachbearbeiterLoeschenK {

    /**
     * gibt den Namen aller Sachbearbeiter zurück
     */
    public String[] gibSachberarbeiterNamen() {
        return Sachbearbeiter.gibAlleNamen();
    }

    /*
     * löscht anhand des Namens einen Sachbearbeiter
     */
    public void loescheSachbearbeiter(String name) {
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
            //return true;
        }
    }
}

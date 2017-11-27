public class SachbearbeiterEditierenK {
    public String[] gibSachberarbeiterNamen(){ return Sachbearbeiter.gibAlleNamen();}

    public void ändereSacharbeiter(String alterName, String neuerName, String neueBerechtigung, String neuesPasswort){
        Sachbearbeiter.gib(alterName).schreibe(neuerName,neueBerechtigung,neuesPasswort);
    }

    public boolean istLetzterAdmin(String name, String neueBerechtigung) {
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
            if (!neueBerechtigung.equals("admin"))
                throw new NullPointerException("Fehler! Der letzte Admin kann nicht an seinen Rechten bearbeitet werden!");
            return true;
        }
    }
}

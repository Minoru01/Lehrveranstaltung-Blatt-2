public class SachbearbeiterEditierenAAS extends SachbearbeiterS {

    private SachbearbeiterAuswählenAAS saAAS = new SachbearbeiterAuswählenAAS();
    private SachbearbeiterEditierenK sek = new SachbearbeiterEditierenK();

    /*
     * gibt den Namen aller Sachbearbeiter aus 
     */
    protected void präsentiereSachbearbeiterNamen() {
        for (String name : sek.gibSachberarbeiterNamen())
            System.out.println(name);
    }

    protected void präsentiereSachbearbeiter(String name) {
        System.out.println(sek.gibSachbearbeiter(name));
    }

    /*
     * ändert einen Sachbearbeiter
     */
    protected void modifiziereSachbearbeiter(String alterName, String neuerName, String neueBerechtigung, String neuesPasswort) {
        sek.ändereSacharbeiter(alterName,neuerName,neueBerechtigung,neuesPasswort);
    }

    protected String selektiereSachbearbeiter() {
        return saAAS.oeffnen();
    }

    /*
    public void oeffnen() {

    }

    public void schließen() {

    }

    public void abbrechen() {

    }

    public void ausgefuehrt() {

    }*/
}

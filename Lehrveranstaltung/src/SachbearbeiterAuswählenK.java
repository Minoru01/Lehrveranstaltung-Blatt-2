/**
 * Created by robin on 27.10.2017.
 */
public class SachbearbeiterAuswählenK {
    public SachbearbeiterAuswählenK() {}

    /*
     * erzeugt eine Instanz mit dem namen und gibt ihm die berechtigung normal
     */
    public Sachbearbeiter erzeugeSachbearbeiter(String name, String berechtigung){
        new Sachbearbeiter(name, berechtigung);
        return Sachbearbeiter.gibKopie(name);
    }

    /**
     * gibt den Namen aller Sachbearbeiter zurück
     */
    public String[] gibSachberarbeiterNamen(){ return Sachbearbeiter.gibAlleNamen();}

    /*
     * gibt ein Objekt Sachbearbeiter anhand des Namens zurück
     */
    public Sachbearbeiter gibSachbearbeiter(String name){ return Sachbearbeiter.gibKopie(name); }

    /*
     * schreibt die Attribute einer kopie in das Orginal
     */
    public void schreibeSachbearbeiter(Sachbearbeiter kopie){ Sachbearbeiter.gib(kopie.gibName()).kopiereAttribute(kopie); }
    //verwendet evlt falsche Methode falls kopiereAttribute nicht wie gewünscht weiche auf schreibe() aus!

    /*
     * löscht anhand des Namens einen Sachbearbeiter
     */
    public void löscheSachbearbeiter(String name){ Sachbearbeiter.gib(name).lösche(); }

    public boolean sacharbeiterExistiert(String name){
        try{
            Sachbearbeiter.gib(name);
        } catch (NullPointerException e){
            return false;
        }
        return true;
    }
}

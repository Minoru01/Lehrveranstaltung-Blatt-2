/**
 * Created by robin on 14.10.2017.
 */
public class NormalSachbearbeiterEditierenK {
    /*
     * erzeugt eine Instanz mit dem namen und gibt ihm die berechtigung normal
     */
    public Sachbearbeiter erzeugeSachbearbeiter(String name){
        new Sachbearbeiter(name);
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
    public void schreibeSachbearbeiter(Sachbearbeiter kopie){ Sachbearbeiter.gib(kopie.gibId()).kopiereAttribute(kopie); }
    //verwendet evlt falsche Methode falls kopiereAttribute nicht wie gewünscht weiche auf schreibe() aus!

    /*
     * löscht anhand des Namens einen Sachbearbeiter
     */
    public void löscheSachbearbeiter(String name){ Sachbearbeiter.gib(name).lösche(); }
}

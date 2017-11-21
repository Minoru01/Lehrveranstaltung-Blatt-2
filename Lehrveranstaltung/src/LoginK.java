/**
 * Created by robin on 14.10.2017.
 */
public class LoginK {

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

    public String loginSachbearbeiter(String name, String berechtigung, String passwort){
        Sachbearbeiter s = new Sachbearbeiter(prüfeName(name));
        prüfePasswort(passwort, s);
        return prüfeBerechtigung(berechtigung, s);
    }

    /*
     * gibt wenn der Sacharbeiter existiert eine Kopie mit den selben Werten zurück
     */
    public Sachbearbeiter prüfeName(String name) {
        return Sachbearbeiter.gib(name);
    }

    /*
     * gibt wenn der Sacharbeiter existiert eine Kopie mit den selben Werten zurück
     */
    public Sachbearbeiter prüfePasswort(String passwort, Sachbearbeiter s){
        if(!s.gibPasswort().equals(passwort)){
            throw new NullPointerException("Falsches Passwort!");
        }
        return s;
    }

    public String prüfeBerechtigung(String berechtigung, Sachbearbeiter s){
        if(s.gibBerechtigung().equals("normal") && berechtigung.equals("normal")){
            return "normal";
        }
        else if(s.gibBerechtigung().equals("admin")){
            if(berechtigung.equals("normal")){
                return "normal";
            }
            else if(berechtigung.equals("admin")){
                return "admin";
            }
        }
        throw new NullPointerException("Sie haben für diese Aktion keine Berechtigung!");
    }
}

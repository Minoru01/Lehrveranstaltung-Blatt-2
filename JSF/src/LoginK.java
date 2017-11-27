import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by robin on 14.10.2017.
 */
@ManagedBean()
@RequestScoped
public class LoginK {

    public void loginSachbearbeiter(String name, String berechtigung, String passwort) {
        Sachbearbeiter s = new Sachbearbeiter(prüfeName(name));
        prüfePasswort(passwort, s);
        prüfeBerechtigung(berechtigung, s);
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
    public void prüfePasswort(String passwort, Sachbearbeiter s) {
        if (!s.gibPasswort().equals(passwort)) {
            throw new NullPointerException("Falsches Passwort!");
        }
    }

    public String prüfeBerechtigung(String berechtigung, Sachbearbeiter s) {
        if (s.gibBerechtigung().equals("normal") && berechtigung.equals("normal")) {
            return "normal";
        } else if (s.gibBerechtigung().equals("admin")) {
            if (berechtigung.equals("normal")) {
                return "normal";
            } else if (berechtigung.equals("admin")) {
                return "admin";
            }
        }
        throw new NullPointerException("Sie haben für diese Aktion keine Berechtigung!");
    }
}

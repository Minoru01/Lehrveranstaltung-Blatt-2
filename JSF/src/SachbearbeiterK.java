import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.HashSet;

public class SachbearbeiterK {
    public static class WrappedSachbarbeiter{
        public WrappedSachbarbeiter(String name) {
            this.sachbearbeiter = Sachbearbeiter.gib(name);
            this.praesentation = sachbearbeiter.gibName();
        }

        private final Sachbearbeiter sachbearbeiter;

        private final String praesentation;
        @Override
        public String toString() {
            return praesentation;
        }

        public String getName() {
            return sachbearbeiter.gibName();
        }
    }

    public String gibBenutzerName(Object o){
        WrappedSachbarbeiter ws = (WrappedSachbarbeiter) o;
        return ws.sachbearbeiter.gibName();
    }

    public String gibPasswort(Object o){
        WrappedSachbarbeiter ws = (WrappedSachbarbeiter) o;
        return ws.sachbearbeiter.gibPasswort();
    }

    public String gibBerechtigung(Object o){
        WrappedSachbarbeiter ws = (WrappedSachbarbeiter) o;
        return ws.sachbearbeiter.gibBerechtigung();
    }

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

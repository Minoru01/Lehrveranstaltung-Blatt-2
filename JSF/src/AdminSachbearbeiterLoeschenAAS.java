import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean
public class AdminSachbearbeiterLoeschenAAS extends SachbearbeiterS{
    AdminSachbearbeiterLoeschenK aslK = new AdminSachbearbeiterLoeschenK();

    @Override
    public void setName(String name) {
        super.setName(name);
        this.passwort = sK.gibPasswort(new SachbearbeiterK.WrappedSachbarbeiter(name));
        this.berechtigung = sK.gibBerechtigung(new SachbearbeiterK.WrappedSachbarbeiter(name));
    }

    public String loeschen(){
        try {
            aslK.loescheSachbearbeiter(name);
            return "AdminAS";
        } catch (NullPointerException e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fehler Löschen! " + e.getMessage(), e.getMessage()));
            return null;
        }
    }

    public String zurueck(){
        return "AdminAS";
    }
}

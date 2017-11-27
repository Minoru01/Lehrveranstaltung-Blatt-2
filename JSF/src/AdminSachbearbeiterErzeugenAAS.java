import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class AdminSachbearbeiterErzeugenAAS extends SachbearbeiterS{
    private AdminSachbearbeiterErzeugenK aseK = new AdminSachbearbeiterErzeugenK();

    public String erzeugen(){
        try {
            aseK.erzeugeSachbearbeiter(this.name,this.berechtigung,this.passwort);
            return "AdminAS";
        } catch (NullPointerException e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fehler Erzeugen! " + e.getMessage(), e.getMessage()));
            return null;
        }
    }

    public String zurueck(){
        return "AdminAS";
    }
}

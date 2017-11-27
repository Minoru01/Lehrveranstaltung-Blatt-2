import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class SachbearbeiterEditierenAS extends SachbearbeiterS{
    private String altername;

    public void setAltername(String altername) {
        this.altername = altername;
        this.name = altername;
        this.passwort = sK.gibPasswort(new SachbearbeiterK.WrappedSachbarbeiter(altername));
        this.berechtigung = sK.gibBerechtigung(new SachbearbeiterK.WrappedSachbarbeiter(altername));
    }

    public String getAltername() {
        return altername;
    }

    public SachbearbeiterEditierenK seK = new SachbearbeiterEditierenK();

    private void modifiziereSachbearbeiter(String alterName, String neuerName, String neueBerechtigung, String neuesPasswort) {
        seK.istLetzterAdmin(alterName, neueBerechtigung);
        seK.ändereSacharbeiter(alterName,neuerName,neueBerechtigung,neuesPasswort);
    }

    public String modifizierenNormal(){
        try{
            modifiziereSachbearbeiter(this.altername,this.name,this.berechtigung,this.passwort);
            return "NormalAS";
        } catch (NullPointerException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fehler Editieren! " + e.getMessage(), e.getMessage()));
            return null;
        }
    }

    public String modifizierenAdmin(){
        try {
            modifiziereSachbearbeiter(this.altername, this.name, this.berechtigung, this.passwort);
            return "AdminAS";
        }catch (NullPointerException e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fehler Editieren! " + e.getMessage(), e.getMessage()));
            return null;
        }
    }

    public String zurueckNormal(){
        return "NormalAS";
    }

    public String zurueckAdmin() {
        return "AdminAS";
    }

}

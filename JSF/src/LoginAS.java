import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean()
@RequestScoped
public class LoginAS extends SachbearbeiterS {

    private static LoginAS ourInstance = new LoginAS();
    private static LoginK lK = new LoginK();

    public static LoginAS getInstance() {
        return ourInstance;
    }

    public LoginAS() {
        ourInstance = this;
        berechtigung = "normal";
    }

    public String login() {
        try {
            lK.loginSachbearbeiter(this.name, this.berechtigung, this.passwort);
            if (getBerechtigung().equals("admin")) {
                AdminK.setOurInstance(this);
                return "AdminAS";
            } else {
                NormalK.setOurInstance(this);
                return "NormalAS";
            }
        } catch (NullPointerException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fehler Login!" + e.getMessage(), e.getMessage()));
            return null;
        }
    }
}

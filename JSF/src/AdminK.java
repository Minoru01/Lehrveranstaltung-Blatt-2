import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean()
@ApplicationScoped

public class AdminK {

    private static AdminK ourInstance;

    public static AdminK getInstance() {
        return ourInstance;
    }

    private String name;
    private String berechtigung;

    public static void setOurInstance(LoginAS ourInstance) {
        AdminK.ourInstance = new AdminK(ourInstance);
    }

    public AdminK(){
        this.berechtigung = ourInstance.getBerechtigung();
        this.name = ourInstance.getName();
        ourInstance = this;
    }

    public AdminK(LoginAS lAS){
        this.name = lAS.getInstance().getName();
        this.berechtigung = lAS.getInstance().getBerechtigung();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBerechtigung() {
        return berechtigung;
    }

    public void setBerechtigung(String berechtigung) {
        this.berechtigung = berechtigung;
    }

    public void editieren(){
    }
}

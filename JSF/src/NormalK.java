import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean()
@ApplicationScoped
public class NormalK {
    private static NormalK ourInstance;

    public static NormalK getInstance() {
        return ourInstance;
    }

    private String name;
    private String berechtigung;

    public static void setOurInstance(LoginAS ourInstance) {
        NormalK.ourInstance = new NormalK(ourInstance);
    }

    public NormalK(){
        this.berechtigung = ourInstance.getBerechtigung();
        this.name = ourInstance.getName();
        ourInstance = this;
    }

    public NormalK(LoginAS lAS){
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


}

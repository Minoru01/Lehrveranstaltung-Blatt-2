import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SachbearbeiterS {
    protected SachbearbeiterK sK = new SachbearbeiterK();
    protected List<String> comboboxItems;

    protected String name;
    protected String berechtigung;
    protected String passwort;

    public void setName(String name) {
        this.name = name;
    }

    public void setBerechtigung(String berechtigung) {
        this.berechtigung = berechtigung;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getName() {
        return name;
    }

    public String getBerechtigung() {
        return berechtigung;
    }

    public String getPasswort() {
        return passwort;
    }

    protected SachbearbeiterS(){
        String[] namen = sK.gibSachberarbeiterNamen();
        HashSet<SachbearbeiterK.WrappedSachbarbeiter> Sachbearbeiter = new HashSet<>();

        for(String name : namen)
            Sachbearbeiter.add(new SachbearbeiterK.WrappedSachbarbeiter(name));

        this.generateComboBoxItems();
    }

    public List<String> getComboboxItems() {
        return comboboxItems;
    }

    public void generateComboBoxItems(){
        String[] namen = sK.gibSachberarbeiterNamen();
        List<String> names = new ArrayList<>();
        for (String name: namen)
            names.add(name);
        comboboxItems = names;
    }
}

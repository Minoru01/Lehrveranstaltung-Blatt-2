/**
 * Created by robin on 28.10.2017.
 */
public class NormalSachbearbeiterEditierenAAS extends SachbearbeiterEditierenAAS {

    private NormalSachbearbeiterEditierenK nseK = new NormalSachbearbeiterEditierenK();

    public void oeffnen() {
        System.out.println("Aktion Editieren wurde ausgewählt: ");
        String name = selektiereSachbearbeiter();
        if (istSachbearbeiterAdmin(name)) {
            throw new NullPointerException("Sie verfügen nicht über die Berechtigung um " + name + " zu ändern!\n");
        } else {
            System.out.println("\nGeben Sie die Änderung für " + name + " ein:");
            String neuerName = readName();
            String neuesPasswort = readPasswort();
            modifiziereSachbearbeiter(name, neuerName, "normal", neuesPasswort);
        }
    }
}

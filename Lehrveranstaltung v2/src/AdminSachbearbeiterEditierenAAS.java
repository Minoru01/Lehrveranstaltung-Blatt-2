/**
 * Created by robin on 28.10.2017.
 */
public class AdminSachbearbeiterEditierenAAS extends SachbearbeiterEditierenAAS{

    private NormalSachbearbeiterEditierenK nseK = new NormalSachbearbeiterEditierenK();

    public void oeffnen() {
        System.out.println("Aktion Editieren wurde ausgewählt: ");
        String name = selektiereSachbearbeiter();
        System.out.println("\nGeben sie die Änderung für " + name + " ein:");
        String neuerName = readName();
        String neuesPasswort = readPasswort();
        String neueBerechtigung = readBerechtigung();
        modifiziereSachbearbeiter(name, neuerName, neueBerechtigung, neuesPasswort);
    }
}

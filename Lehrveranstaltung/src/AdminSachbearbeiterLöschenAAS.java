/**
 * Created by robin on 28.10.2017.
 */
public class AdminSachbearbeiterLöschenAAS {
    private AdminSachbearbeiterLöschenK aslK = new AdminSachbearbeiterLöschenK();
    private SachbearbeiterAuswählenAAS saAAS = new SachbearbeiterAuswählenAAS();

    public void oeffnen() {
        System.out.println("Aktion Löschen wurde ausgewählt: ");
        try {
            String s = saAAS.oeffnen();
            aslK.löscheSachbearbeiter(s);
            System.out.println("Sachbearbeiter " + s + " wurde erfolgreich gelöscht! \n");
        } catch(NullPointerException e){
            System.out.println("\n" + e.getMessage() + "\n");
        }
    }
}

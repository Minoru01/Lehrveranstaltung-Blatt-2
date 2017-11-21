/**
 * Created by robin on 28.10.2017.
 */
public class AdminSachbearbeiterErzeugenAAS extends SachbearbeiterS{

    private AdminSachbearbeiterErzeugenK aseK = new AdminSachbearbeiterErzeugenK();

    public void oeffnen() {
        try {
            System.out.println("Aktion Erzeugen wurde ausgewählt: ");
            System.out.println("Geben sie die Daten des neuen Sacharbeiters ein:");
            String n = readName();
            String p = readPasswort();
            String b = readBerechtigung();
            aseK.erzeugeSachbearbeiter(n, b, p);
            System.out.println("Wurde erfolgreich erstellt!\n");
        } catch (NullPointerException e){
            System.out.println("\n" + e.getMessage() + "\n");
        }
    }

    /*private String readLine(){
        return new Scanner(System.in).nextLine();
    }

    private String readName(){
        System.out.print("Name: ");
        return readLine();
    }

    private String readPasswort(){
        System.out.print("Passwort: ");
        return readLine();
    }

    private String readBerechtigung(){
        System.out.print("Berechtigung:_ ");
        return readLine();
    }
*/
}

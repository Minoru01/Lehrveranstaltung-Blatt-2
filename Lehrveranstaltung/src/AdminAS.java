import java.util.Scanner;

/**
 * Created by robin on 28.10.2017.
 */
public class AdminAS {
    private AdminK aK = new AdminK();
    private AdminSachbearbeiterEditierenAAS aseAAS = new AdminSachbearbeiterEditierenAAS();
    private AdminSachbearbeiterErzeugenAAS asezASS = new AdminSachbearbeiterErzeugenAAS();
    private AdminSachbearbeiterLöschenAAS aslAAS = new AdminSachbearbeiterLöschenAAS();

    public void oeffnen() {
        boolean stay = true;

        while(stay) {
            System.out.println("Optionen:");
            System.out.println("Sachbearbeiter editieren... (e)");
            System.out.println("Sachbearbeiter erzeugen... (ez)");
            System.out.println("Sachbearbeiter löschen... (l)\n");
            System.out.println("Sachbearbeiter abmelden... (a)");
            System.out.println("Programm beenden... (b)\n");
            System.out.print("Eingabe: ");
            String eingabe = readLine();
            System.out.println("");
            switch (eingabe) {
                case "e":
                    try {
                        aseAAS.oeffnen();
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "ez":
                    try {
                        asezASS.oeffnen();
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "l":
                    try {
                        aslAAS.oeffnen();
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "a":
                    throw new NullPointerException("Logout erfolgreich!\n");
                case "b":
                    stay = false;
                    break;
            }
        }
    }

    private String readLine(){
        return new Scanner(System.in).nextLine();
    }
}

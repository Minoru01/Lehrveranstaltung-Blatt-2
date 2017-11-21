import java.util.Scanner;

/**
 * Created by robin on 28.10.2017.
 */
public class NormalAS {
    NormalSachbearbeiterEditierenAAS nseAAS = new NormalSachbearbeiterEditierenAAS();
    NormalK nK = new NormalK();

    public void oeffnen(){

        boolean stay = true;

        while(stay) {
            System.out.println("Optionen:");
            System.out.println("Sachbearbeiter editieren... (e)\n");
            System.out.println("Sachbearbeiter abmelden... (a)");
            System.out.println("Programm beenden... (b)\n");
            System.out.print("Eingabe: ");
            String eingabe = readLine();
            System.out.println("");
            switch (eingabe) {
                case "e":
                    try {
                        nseAAS.oeffnen();
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

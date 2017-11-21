import java.util.Scanner;

/**
 * Created by robin on 13.10.2017.
 */
public class LehrveranstaltungsverwaltungHS {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("LehrveranstaltungsverwaltungHS Debug:");
        new Sachbearbeiter("Jeff", "normal");
        new Sachbearbeiter("Jack", "normal");
        new Sachbearbeiter("John", "admin");
        new Sachbearbeiter("Josh", "normal");
        System.out.println("--------------------------------------------------------------------");

//        NormalSachbearbeiterEditierenAAS nseaas = new NormalSachbearbeiterEditierenAAS();
//        AdminSachbearbeiterEditierenAAS aseaas = new AdminSachbearbeiterEditierenAAS();
//        AdminSachbearbeiterErzeugenAAS asezaas = new AdminSachbearbeiterErzeugenAAS();
//        AdminSachbearbeiterLöschenAAS aslAAS = new AdminSachbearbeiterLöschenAAS();
        LoginAAS lAS = new LoginAAS();
        //NormalAS nAS = new NormalAS();

        lAS.oeffnen();

        for (Sachbearbeiter q : Sachbearbeiter.alleSachbearbeiter)
            System.out.println(q);

        //nAS.oeffnen();
        //lAS.oeffnen();
        //aslAAS.oeffnen();
        //asezaas.oeffnen();
        //nseaas.oeffnen();
        //aseaas.oeffnen();

        //for (String l: Sachbearbeiter.gibAlleNamen())
        //System.out.println(Sachbearbeiter.gibKopie(l));
    }
}

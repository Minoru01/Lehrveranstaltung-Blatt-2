/**
 * Created by robin on 28.10.2017.
 */
public class LoginAAS extends SachbearbeiterS {
    public LoginK Login = new LoginK();
    public NormalAS nAS = new NormalAS();
    public AdminAS aAS = new AdminAS();

    public void oeffnen() {
        try {
            System.out.println("\nLogin");
            String n = readName();
            String p = readPasswort();
            String b = readBerechtigung();
            String log = Login.loginSachbearbeiter(n, b, p);

            if (log.equals("admin")) {
                //System.out.println("Log in A succeded");
                try {
                    aAS.oeffnen();
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                    oeffnen();
                }
            } else {
                //System.out.println("Log in N succeded");
                try {
                    nAS.oeffnen();
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                    oeffnen();
                }
            }
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
            System.out.println("Wollen sie es nochmal versuchen, ja? [j]");
            if (readLine().toLowerCase().equals("j")){
                oeffnen();
            }
        }
    }
}

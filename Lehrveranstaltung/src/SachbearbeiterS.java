import java.util.Scanner;

/**
 * Created by robin on 28.10.2017.
 */
public class SachbearbeiterS {

    /*private HashSet<Character> alphabet = new HashSet<Character>(Arrays.asList(new Character[]{'a','b','c','d','e','f','g','h','i',
                                                                                                'j','k','l','m','n','o','p','q',
                                                                                                'r','s','t','u','w','x','y','z'}));*/

    protected SachbearbeiterK sK = new SachbearbeiterK();

    protected String readLine(){
        return new Scanner(System.in).nextLine();
    }

    protected String readName(){
        System.out.print("Name: ");
        String eingabe = readLine();
        if(eingabe.equals(""))
            throw new NullPointerException("Fehler! Bestandteile des Namens sind unzulässig!");

        for (int i = 0; i < eingabe.length(); ++i)
            if(!((eingabe.toUpperCase().charAt(i) >= 'A' && eingabe.toUpperCase().charAt(i) <= 'Z') || !(eingabe.charAt(i) == '_') || !(eingabe.charAt(i) == 'ß')))
                throw new NullPointerException("Fehler! Bestandteile des Namens sind unzulässig!");
        return eingabe;
    }

    protected String readPasswort(){
        System.out.print("Passwort: ");
        return readLine();
    }

    protected String readBerechtigung(){
        System.out.print("Berechtigung: ");
        String eingabe = readLine();
        System.out.println("");
        if (!eingabe.equals("normal") && !eingabe.equals("admin"))
            throw new NullPointerException("Fehler! Die Berechtigung muss entweder \"normal\" oder \"admin\" lauten!" );
        return eingabe;
    }

    protected boolean istSachbearbeiterAdmin(String name){
        return sK.istAdmin(name);
    }
}

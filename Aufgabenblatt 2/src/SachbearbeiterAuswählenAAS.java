/**
 * Created by robin on 20.10.2017.
 */
public class SachbearbeiterAuswählenAAS extends SachbearbeiterS {

    private SachbearbeiterAuswählenK sk = new SachbearbeiterAuswählenK();

    public String selektiereSachbearbeiter() {
        präsentiereSachbearbeiterNamen();
        System.out.println("Gib den Namen den du auswählen möchtest ein:");
        String n = readName();
        //System.out.println("(" + n + " wurde erfolgreich ausgewählt)");

        if(sk.sacharbeiterExistiert(n)){
            return n;
        }

        throw new NullPointerException(n + " konnte nicht selektiert werden, da er nicht existiert!");
    }

    private void präsentiereSachbearbeiterNamen() {
        for(String name : sk.gibSachberarbeiterNamen())
            System.out.println(name);
    }


    public String oeffnen() {
        return selektiereSachbearbeiter();
    }

    public void schließen() {

    }

    public void abbrechen() {

    }

    public void ausgefuehrt() {

    }
}

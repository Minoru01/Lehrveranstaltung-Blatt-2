public class AdminSachbearbeiterErzeugenK {
    public void erzeugeSachbearbeiter(String name, String berechtigung, String passwort){
        new Sachbearbeiter(name, berechtigung , passwort);
        new Sachbearbeiter(Sachbearbeiter.gib(name));
    }
}

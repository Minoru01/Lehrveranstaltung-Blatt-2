import javax.swing.*;
import java.awt.*;

/**
 * Created by robin on 13.10.2017.
 */
public class LehrveranstaltungsverwaltungHS {
    public static void main(String[] args) {
        System.out.println("Hello World");
        new Sachbearbeiter("Jeff");
        new Sachbearbeiter("Jack");
        new Sachbearbeiter("John");
        new Sachbearbeiter("Jack");
        SachbearbeiterK a = new SachbearbeiterK();
        for (String name : a.gibSachberarbeiterNamen())
            System.out.println("* " + name);
        System.out.println(a.gibSachbearbeiter("Jeff").gibName());
        System.out.println(a.gibSachbearbeiter("Jeff").gibBerechtigung());

        JMenuItem i1 = new JMenuItem("Sachbearbeiter erzeugen");
        JMenuItem i2 = new JMenuItem("Sachbearbeiter editieren");
        JMenuItem i3 = new JMenuItem("Sachbearbeiter löschen");

        JMenu m = new JMenu();
        m.setSize(30,50);
        m.add(i1);
        m.add(i2);
        m.add(i3);

        JMenuBar h = new JMenuBar();
        h.setSize(500,40);
        h.setVisible(true);
        h.add(m);

        JFrame w = new JFrame("Optionen");
        w.setJMenuBar(h);
        w.setVisible(true);
        w.setSize(500,300);

        /*w.setSize(500, 200);
        w.setContentPane(new AdminAS().getPanel());
        w.setVisible(true);
        w.setJMenuBar(h);

        JFrame x = new JFrame("Optionen");
        x.setSize(500, 200);
        x.setContentPane(new NormalAS().getPanel());
        x.setVisible(true);

        JFrame y = new JFrame("Login");
        y.setSize(500, 200);
        y.setContentPane(new LoginAS().getPanel());
        y.setVisible(true);*/


    }
}

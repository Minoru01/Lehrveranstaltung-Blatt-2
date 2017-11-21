import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Created by robin on 13.10.2017.
 */
public class LehrveranstaltungsverwaltungHS {

    private static JFrame frame = createJFrame();
    private static JPanel panel = createJPanel();
    private static JMenuBar menuLeiste = createJMenubar();
    private static JMenuBar symbolLeiste = createJMenubar();
    private static JButton loginBtn = createJButton("Login");
    private static JButton beendenBtn = createJButton("Beenden");
    private static JMenu loginMenu = createJMenu("Login");
    private static JMenuItem loginMenuItem = createJMenuItem("Login");
    private static JMenu beendenMenu = createJMenu("Beenden");
    private static JMenuItem beendenMenuItem = createJMenuItem("Beenden");

    public void oeffnen() {
        symbolLeiste.add(loginBtn);
        symbolLeiste.add(beendenBtn);
        loginMenu.add(loginMenuItem);
        beendenMenu.add(beendenMenuItem);
        frame.setTitle("Verwaltung");
        menuLeiste.add(loginMenu);
        menuLeiste.add(beendenMenu);
        //panel.add(menuLeiste);
        frame.setLayout(new GridBagLayout());
        frame.setJMenuBar(menuLeiste);
        frame.setJMenuBar(symbolLeiste);
        frame.add(panel);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public static JFrame createJFrame() {
        Dimension maxDim = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame retFrame = new JFrame();
        retFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        retFrame.setSize(maxDim);
        retFrame.setResizable(false);
        retFrame.setVisible(true);
        return retFrame;
    }

    public static JPanel createJPanel() {
        Dimension dimPan = new Dimension(500, 500);
        JPanel retPnl = new JPanel();
        retPnl.setPreferredSize(dimPan);
        retPnl.setVisible(true);
        return retPnl;
    }

    public static JMenuBar createJMenubar() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        JMenuBar retJMnBr = new JMenuBar();
        retJMnBr.setSize(1000,40);
        retJMnBr.setLocation(0,0);
        retJMnBr.setVisible(true);
        return retJMnBr;
    }

    public static JButton createJButton(String text) {
        Dimension d = new Dimension(80, 40);
        JButton retBtn = new JButton();
        retBtn.setText(text);
        retBtn.setSize(d);
        retBtn.setVisible(true);
        return retBtn;
    }

    public static JMenu createJMenu(String text){
        JMenu retMenu = new JMenu(text);
        return retMenu;
    }

    public static JMenuItem createJMenuItem(String text){
        JMenuItem retJMenuItem = new JMenuItem(text);
        return retJMenuItem;
    }
}

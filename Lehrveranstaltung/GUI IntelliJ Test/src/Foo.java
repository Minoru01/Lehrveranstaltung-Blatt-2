import javax.swing.*;
import java.awt.*;

/**
 * Created by robin on 11.11.2017.
 */
public class Foo extends JPanel{
    private JPanel Login;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextField passwortTextField;
    private JRadioButton sachbearbeiterRadioButton;
    private JRadioButton administratorRadioButton;
    private JPasswordField passwordField1;
    private JButton button4;
    private JButton button5;
    private JPanel ScreenLog;
    private JPanel huiii;

    public static void main(String[] args) {
        Foo foo = new Foo();
        JFrame no1 = new JFrame();
        no1.setContentPane(foo.Login);
        no1.getContentPane();
        //foo.ScreenLog.setVisible(false);

        no1.setVisible(true);
    }
}

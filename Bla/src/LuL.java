import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by robin on 06.10.2017.
 */
public class LuL {
    public static void main(String[] args){
        System.out.println("Hello FART Rofel");
        JFrame window = new JFrame();
        window.setSize(500, 350);
        window.setTitle("You suck!!! :P");
        window.setVisible(true);
        JLabel miim = new JLabel();
        miim.setText("Is this your age?");
        miim.setSize(160,40);
        miim.setVisible(true);
        JLabel meem = new JLabel();
        meem.setText("0");
        meem.setVisible(true);
        meem.setSize(160,40);
        JButton meme = new JButton();
        meme.setText("Yes or no");
        meme.setSize(160,40);
        meme.setVisible(true);
        meme.setLocation(new Point(100,100));
        miim.setLocation(new Point(100,0));
        meem.setLocation(new Point(100,50));
        meme.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                meem.setText("" + dropAge());
            }
        } );
        window.add(miim);
        window.add(meem);
        window.add(meme);
    }

    public static int dropAge(){
        int minimum = 0;
        int maximum = 127;
        return minimum + (int)(Math.random() * maximum);
    }
}

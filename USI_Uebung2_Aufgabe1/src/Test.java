import javax.swing.*;
import java.awt.*;

/**
 * Created by robin on 07.11.2017.
 */
public class Test {
    public static JFrame frame = createJFrame();
    public static JPanel panel = createPanel();
    public static JSlider jSlider = createJButton();
    public static JScrollBar jScrollBar = createJScrollBar();
    public static BoundedRangeModel uniBRModel = jScrollBar.getModel();

    public static void main(String[] args) {
        System.out.println("Starting...");
        panel.add(jSlider);
        panel.add(jScrollBar);
        frame.getContentPane().add(panel);
        jSlider.setModel(uniBRModel);
        panel.validate();
        panel.repaint();
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

    public static JPanel createPanel() {
        Dimension dimPan = new Dimension(500, 500);
        JPanel retPnl = new JPanel();
        retPnl.setPreferredSize(dimPan);
        return retPnl;
    }

    public static JSlider createJButton() {
        Dimension sldDim = new Dimension(80, 40);
        JSlider retSld = new JSlider();
        retSld.setSize(sldDim);
        retSld.setVisible(true);
        retSld.setLocation(0, 0);
        return retSld;
    }

    public static JScrollBar createJScrollBar() {
        JScrollBar retJScroll = new JScrollBar();
        retJScroll.setSize(500, 40);
        retJScroll.setVisible(true);
        return retJScroll;
    }
}

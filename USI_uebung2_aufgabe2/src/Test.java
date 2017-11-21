import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Created by robin on 07.11.2017.
 */
public class Test {

    public static JFrame frame = createJFrame();
    public static JPanel panel = createPanel();
    public static JSlider slider = createJSlider();
    public static JList list = new JList(new String[]{"John","Jack","Jeff"});
    //public static JSlider slider1 = createJSlider();
    public static BoundedRangeModel uniBRModel = slider.getModel();
    public static ListSelectionModel uniLSModel = list.getSelectionModel();

    public static void main(String[] args) {
        panel.add(slider);
        panel.add(list);
        frame.add(panel);
        frame.setVisible(true);

        //lightweight Notification
        uniBRModel.addChangeListener(
                new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                            BoundedRangeModel m = (BoundedRangeModel) e.getSource();
                            System.out.println("value changed: " + m.getValue());
                    }
                }
        );

        //statefull Notification
        uniLSModel.addListSelectionListener (
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (!e.getValueIsAdjusting()) {
                            System.out.println("Auswahl hat sich geändert: " + e.getLastIndex());
                        }
                    }
                }
        );
    }

    public static JFrame createJFrame() {
        //Dimension maxDim = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame retFrame = new JFrame();
        retFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //retFrame.setSize(maxDim);
        retFrame.setSize(500,500);
        retFrame.setResizable(true);
        retFrame.setVisible(true);
        return retFrame;
    }

    public static JPanel createPanel() {
        Dimension dimPan = new Dimension(500, 500);
        JPanel retPnl = new JPanel();
        retPnl.setPreferredSize(dimPan);
        return retPnl;
    }

    public static JSlider createJSlider() {
        Dimension sldDim = new Dimension(80, 40);
        JSlider retSld = new JSlider();
        retSld.setSize(sldDim);
        retSld.setVisible(true);
        retSld.setLocation(0, 0);
        return retSld;
    }

}

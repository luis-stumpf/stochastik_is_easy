package themen.diskretewarsch.info;

import javax.swing.*;
import java.net.URL;

public class KombinatorikInfo {

    URL imageUrl = ClassLoader.getSystemResource("diskreteWarsch/kombinatorikinfo.PNG");
    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();

    public KombinatorikInfo() {
        ImageIcon icon = new ImageIcon(imageUrl);
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.setTitle("Kombinatorik INFO");
        frame.setSize(780, 900);
        frame.getContentPane().add(infoPanel);
        frame.setVisible(true);
    }
}
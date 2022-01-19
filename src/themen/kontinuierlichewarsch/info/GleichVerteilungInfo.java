package themen.kontinuierlichewarsch.info;

import javax.swing.*;
import java.net.URL;

public class GleichVerteilungInfo {

    URL imageUrl = ClassLoader.getSystemResource("kontinuierlicheWarsch/gleichverteilungInfo.PNG");
    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();

    public GleichVerteilungInfo() {
        ImageIcon icon = new ImageIcon(imageUrl);
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.setTitle("Binominal Verteilung INFO");
        frame.setSize(780, 400);
        frame.getContentPane().add(infoPanel);
        frame.setVisible(true);
    }
}

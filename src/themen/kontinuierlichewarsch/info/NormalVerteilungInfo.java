package themen.kontinuierlichewarsch.info;

import javax.swing.*;
import java.net.URL;

public class NormalVerteilungInfo {

    URL imageUrl = ClassLoader.getSystemResource("kontinuierlicheWarsch/normalverteilunginfo.PNG");
    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();

    public NormalVerteilungInfo() {
        ImageIcon icon = new ImageIcon(imageUrl);
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.setTitle("Binominal Verteilung INFO");
        frame.setSize(700, 700);
        frame.getContentPane().add(infoPanel);
        frame.setVisible(true);
    }
}

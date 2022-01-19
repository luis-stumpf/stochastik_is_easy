package themen.kontinuierlichewarsch.info;

import javax.swing.*;
import java.net.URL;

public class ExponentialVerteilungInfo {

    URL imageUrl = ClassLoader.getSystemResource("kontinuierlicheWarsch/exponentialverteilunginfo.PNG");
    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();

    public ExponentialVerteilungInfo() {
        ImageIcon icon = new ImageIcon(imageUrl);
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.setTitle("Binominal Verteilung INFO");
        frame.setSize(780, 520);
        frame.getContentPane().add(infoPanel);
        frame.setVisible(true);
    }
}

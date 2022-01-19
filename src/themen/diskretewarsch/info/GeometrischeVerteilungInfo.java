package themen.diskretewarsch.info;

import javax.swing.*;
import java.net.URL;

public class GeometrischeVerteilungInfo {

    URL imageUrl = ClassLoader.getSystemResource("diskreteWarsch/GeometrischeVerteilunginfo.png");
    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();

    public GeometrischeVerteilungInfo() {
        ImageIcon icon = new ImageIcon(imageUrl);
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.setTitle("Binominal Verteilung INFO");
        frame.setSize(780, 500);
        frame.getContentPane().add(infoPanel);
        frame.setVisible(true);
    }
}

package themen.diskretewarsch.info;

import javax.swing.*;
import java.net.URL;

public class BinominalVerteilungInfo {

    URL imageUrl = ClassLoader.getSystemResource("diskreteWarsch/binominalverteilunginfo.PNG");
    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();

    public BinominalVerteilungInfo() {
        ImageIcon icon = new ImageIcon(imageUrl);
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.setTitle("Binominal Verteilung INFO");
        frame.setSize(780, 740);
        frame.getContentPane().add(infoPanel);
        frame.setVisible(true);
    }
}

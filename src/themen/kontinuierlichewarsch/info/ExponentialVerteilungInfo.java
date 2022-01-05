package themen.kontinuierlichewarsch.info;

import javax.swing.*;

public class ExponentialVerteilungInfo {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();

    public ExponentialVerteilungInfo() {
        ImageIcon icon = new ImageIcon("src/res/kontinuierlicheWarsch/exponentialverteilunginfo.PNG");
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.setTitle("Binominal Verteilung INFO");
        frame.setSize(780, 520);
        frame.getContentPane().add(infoPanel);
        frame.setVisible(true);
    }
}

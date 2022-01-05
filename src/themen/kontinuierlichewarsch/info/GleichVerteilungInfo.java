package themen.kontinuierlichewarsch.info;

import javax.swing.*;

public class GleichVerteilungInfo {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();

    public GleichVerteilungInfo() {
        ImageIcon icon = new ImageIcon("src/res/kontinuierlicheWarsch/gleichverteilungInfo.PNG");
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.setTitle("Binominal Verteilung INFO");
        frame.setSize(780, 400);
        frame.getContentPane().add(infoPanel);
        frame.setVisible(true);
    }
}

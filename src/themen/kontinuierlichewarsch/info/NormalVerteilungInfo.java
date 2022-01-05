package themen.kontinuierlichewarsch.info;

import javax.swing.*;

public class NormalVerteilungInfo {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();

    public NormalVerteilungInfo() {
        ImageIcon icon = new ImageIcon("src/res/kontinuierlicheWarsch/normalverteilunginfo.PNG");
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.setTitle("Binominal Verteilung INFO");
        frame.setSize(700, 700);
        frame.getContentPane().add(infoPanel);
        frame.setVisible(true);
    }
}

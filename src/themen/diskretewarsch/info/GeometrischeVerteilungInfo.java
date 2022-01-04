package themen.diskretewarsch.info;

import javax.swing.*;

public class GeometrischeVerteilungInfo {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();

    public GeometrischeVerteilungInfo() {
        ImageIcon icon = new ImageIcon("src/res/diskreteWarsch/GeometrischeVerteilunginfo.png");
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.setTitle("Binominal Verteilung INFO");
        frame.setSize(780, 500);
        frame.getContentPane().add(infoPanel);
        frame.setVisible(true);
    }
}

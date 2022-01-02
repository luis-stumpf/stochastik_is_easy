package themen.diskretewarsch.info;

import javax.swing.*;

public class BinominalVerteilungInfo {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();

    public BinominalVerteilungInfo() {
        ImageIcon icon = new ImageIcon("src/res/diskreteWarsch/binominalverteilunginfo.PNG");
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.setTitle("Binominal Verteilung INFO");
        frame.setSize(780, 740);
        frame.getContentPane().add(infoPanel);
        frame.setVisible(true);
    }
}

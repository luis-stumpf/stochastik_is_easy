package themen.diskretewarsch.info;

import javax.swing.*;

public class KombinatorikInfo {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();

    public KombinatorikInfo() {
        ImageIcon icon = new ImageIcon("src/res/diskreteWarsch/kombinatorikinfo.PNG");
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.setTitle("Kombinatorik INFO");
        frame.setSize(780, 900);
        frame.getContentPane().add(infoPanel);
        frame.setVisible(true);
    }
}
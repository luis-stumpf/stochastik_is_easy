package themen.diskretewarsch.info;

import javax.swing.*;

public class PoissonVerteilungInfo {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();

    public PoissonVerteilungInfo(){
        ImageIcon icon = new ImageIcon("src/res/diskreteWarsch/poissonverteilung.PNG");
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.setTitle("Poisson Verteilung INFO");
        frame.setSize(620, 550);
        frame.getContentPane().add(infoPanel);
        frame.setVisible(true);
    }
}

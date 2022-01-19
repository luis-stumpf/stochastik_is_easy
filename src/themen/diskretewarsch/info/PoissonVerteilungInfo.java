package themen.diskretewarsch.info;

import javax.swing.*;
import java.net.URL;

public class PoissonVerteilungInfo {

    URL imageUrl = ClassLoader.getSystemResource("diskreteWarsch/poissonverteilung.PNG");
    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();

    public PoissonVerteilungInfo(){
        ImageIcon icon = new ImageIcon(imageUrl);
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.setTitle("Poisson Verteilung INFO");
        frame.setSize(620, 550);
        frame.getContentPane().add(infoPanel);
        frame.setVisible(true);
    }
}

package themen.diskretewarsch.beispiele;

import javax.swing.*;
import java.awt.*;

public class PoissonVerteilungBsp {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();
    JScrollPane scrollBar = new JScrollPane(infoPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    public PoissonVerteilungBsp(){
        ImageIcon icon = new ImageIcon("src/res/diskreteWarsch/poissionsverteilungBsp.png");
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.add(scrollBar, BorderLayout.EAST);
        frame.setTitle("Poisson Verteilung Beispiel");
        frame.setSize(770, 700);
        frame.setVisible(true);
    }
}

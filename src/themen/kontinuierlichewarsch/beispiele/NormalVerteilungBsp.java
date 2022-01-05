package themen.kontinuierlichewarsch.beispiele;

import javax.swing.*;
import java.awt.*;

public class NormalVerteilungBsp {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();
    JScrollPane scrollBar = new JScrollPane(infoPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    public NormalVerteilungBsp(){
        ImageIcon icon = new ImageIcon("src/res/kontinuierlicheWarsch/normalverteilungBsp.PNG");
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.add(scrollBar, BorderLayout.EAST);
        frame.setTitle("Normal Verteilung Beispiel");
        frame.setSize(770, 700);
        frame.setVisible(true);
    }
}

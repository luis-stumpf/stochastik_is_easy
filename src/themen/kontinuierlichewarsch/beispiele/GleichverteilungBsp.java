package themen.kontinuierlichewarsch.beispiele;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GleichverteilungBsp {

    URL imageUrl = ClassLoader.getSystemResource("kontinuierlicheWarsch/gleichverteilungBsp.PNG");
    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();
    JScrollPane scrollBar = new JScrollPane(infoPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    public GleichverteilungBsp(){
        ImageIcon icon = new ImageIcon(imageUrl);
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.add(scrollBar, BorderLayout.EAST);
        frame.setTitle("Gleichverteilung Beispiel");
        frame.setSize(770, 700);
        frame.setVisible(true);
    }
}

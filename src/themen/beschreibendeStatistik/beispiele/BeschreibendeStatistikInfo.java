package themen.beschreibendeStatistik.beispiele;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class BeschreibendeStatistikInfo {
    URL imageUrl = ClassLoader.getSystemResource("beschstoch.png");
    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();
    JScrollPane scrollBar = new JScrollPane(infoPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    public BeschreibendeStatistikInfo(){
        ImageIcon icon = new ImageIcon(imageUrl);
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.add(scrollBar, BorderLayout.EAST);
        frame.setTitle("Beschreibende Statistik");
        frame.setSize(715, 700);
        frame.setVisible(true);
    }
}

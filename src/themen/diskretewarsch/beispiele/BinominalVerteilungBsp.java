package themen.diskretewarsch.beispiele;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class BinominalVerteilungBsp {

    URL imageUrl = ClassLoader.getSystemResource("diskreteWarsch/BinominalVerteilungBsp.png");
    JFrame frame = new JFrame();
    JLabel label = new JLabel("TEST");
    JPanel infoPanel = new JPanel();
    JScrollPane scrollBar = new JScrollPane(infoPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    public BinominalVerteilungBsp(){
        ImageIcon icon = new ImageIcon(imageUrl);
        JLabel label = new JLabel();
        label.setIcon(icon);
        infoPanel.add(label);
        frame.add(scrollBar, BorderLayout.EAST);
        frame.setTitle("Binominal Verteilung Beispiel");
        frame.setSize(770, 700);
        frame.setVisible(true);
    }
}

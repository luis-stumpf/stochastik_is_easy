package panels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StandartPanel extends JPanel {

    private JButton descStoch;
    private JButton discStoch;
    private JButton kontWarsch;
    private JButton schlStoch;
    private JPanel auswahl;

    public StandartPanel(CardLayout cl, JPanel cp){


        auswahl = new JPanel();
        auswahl.setLayout(new GridLayout(4, 2));

        descStoch = new JButton("Beschreibende Stochastik");
        discStoch = new JButton("Diskrete Warscheinlichkeitstheorie");
        discStoch.addActionListener(event -> toDiscStoch(cl, cp));
        kontWarsch = new JButton("Kontinuierliche Warscheinlichkeitstheorie");
        kontWarsch.addActionListener(e -> toKontWarsch(cl, cp));
        schlStoch = new JButton("Schließende Statistik");
        auswahl.add(descStoch);
        auswahl.add(discStoch);
        auswahl.add(kontWarsch);
        auswahl.add(schlStoch);
        this.add(auswahl);

        Border border = BorderFactory.createTitledBorder("Auswahl");
        this.setBorder(border);
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

    }

    private void toKontWarsch(CardLayout cl, JPanel cp) {
        cl.show(cp, "KONT");
    }

    private void toDiscStoch(CardLayout cl, JPanel cp) {
        cl.show(cp, "DISK");
    }
}

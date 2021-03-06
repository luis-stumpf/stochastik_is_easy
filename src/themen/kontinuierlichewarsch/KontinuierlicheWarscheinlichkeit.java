package themen.kontinuierlichewarsch;

import panels.NavigationPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class KontinuierlicheWarscheinlichkeit extends JPanel {

    JButton gleichVerteilung;
    JButton exponentialVerteilung;
    JButton normalVerteilung;

    public KontinuierlicheWarscheinlichkeit(CardLayout cl, JPanel cp){

        gleichVerteilung = new JButton("GleichVerteilung");
        gleichVerteilung.addActionListener(event -> toGelichverteilug(cl, cp));

        exponentialVerteilung = new JButton("ExponentialVerteilung");
        exponentialVerteilung.addActionListener(e -> toExponentialverteilung(cl, cp));

        normalVerteilung = new JButton("NormalVerteilung");
        normalVerteilung.addActionListener(e -> toNormalVerteilung(cl, cp));

        JLabel label = new JLabel("<= || >= entspricht < | >\n P(X=x) ist immer 0");

        this.add(normalVerteilung);
        this.add(exponentialVerteilung);
        this.add(gleichVerteilung);

        this.add(label);
        Border border = BorderFactory.createTitledBorder("Kontinuierliche Warscheinlickeit");
        this.setBorder(border);
    }

    private void toNormalVerteilung(CardLayout cl, JPanel cp) {
        cl.show(cp, "NORM");
        NavigationPanel.prevPage = "KONT";
        NavigationPanel.currentPage = "NORM";
    }

    private void toExponentialverteilung(CardLayout cl, JPanel cp) {
        cl.show(cp, "EXPO");
        NavigationPanel.prevPage = "KONT";
        NavigationPanel.currentPage = "EXPO";
    }

    private void toGelichverteilug(CardLayout cl, JPanel cp) {
        cl.show(cp, "GLEICH");
        NavigationPanel.prevPage = "KONT";
        NavigationPanel.currentPage = "EXPO";
    }
}

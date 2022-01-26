package themen.diskretewarsch;

import panels.NavigationPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class DiskreteWarscheinlichkeit extends JPanel {

    private JButton geoVerteilung;
    private JButton binomVerteilung;
    private JButton poissonVerteilung;
    private JButton kombinatorik;
    private JButton diskreteZufallsvariable;

    public DiskreteWarscheinlichkeit(CardLayout cl, JPanel cp){

        geoVerteilung = new JButton("geometrische Verteilung");
        geoVerteilung.addActionListener(event -> toGeoVerteilug(cl, cp));

        binomVerteilung = new JButton("binominal Verteilung");
        binomVerteilung.addActionListener(e -> toBinomVerteilung(cl, cp));

        poissonVerteilung = new JButton("possion Verteilung");
        poissonVerteilung.addActionListener(e -> toPossionVerteilung(cl, cp));

        kombinatorik = new JButton("Kombinatorik");
        kombinatorik.addActionListener(e -> toKombinatorik(cl, cp));


        diskreteZufallsvariable = new JButton("Diskrete ZV");
        diskreteZufallsvariable.addActionListener(e -> todiskZV(cl, cp));

        this.add(poissonVerteilung);
        this.add(binomVerteilung);
        this.add(geoVerteilung);
        this.add(kombinatorik);
        this.add(diskreteZufallsvariable);
        CompoundBorder border = new CompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5),
                BorderFactory.createTitledBorder("Diskrete Wahrscheinlichkeit"));

        this.setBorder(border);
    }

    private void todiskZV(CardLayout cl, JPanel cp) {
        cl.show(cp, "DISKZV");
        NavigationPanel.prevPage = "DISK";
        NavigationPanel.currentPage = "DISKZV";
    }

    private void toPossionVerteilung(CardLayout cl, JPanel cp) {
        cl.show(cp, "POIS");
        NavigationPanel.prevPage = "DISK";
        NavigationPanel.currentPage = "POIS";
    }

    private void toBinomVerteilung(CardLayout cl, JPanel cp) {
        cl.show(cp, "BINO");
        NavigationPanel.prevPage = "DISK";
        NavigationPanel.currentPage = "BINO";
    }

    private void toGeoVerteilug(CardLayout cl, JPanel cp) {
        cl.show(cp, "GEO");
        NavigationPanel.prevPage = "DISK";
        NavigationPanel.currentPage = "GEO";
    }

    private void toKombinatorik(CardLayout cl, JPanel cp) {
        cl.show(cp, "KOMB");
        NavigationPanel.prevPage = "DISK";
        NavigationPanel.currentPage = "KOMB";
    }
}

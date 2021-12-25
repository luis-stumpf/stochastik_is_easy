package themen.diskretewarsch;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DiskreteWarscheinlichkeit extends JPanel {

    private JButton geoVerteilung;
    private JButton binomVerteilung;
    private JButton poissonVerteilung;

    public DiskreteWarscheinlichkeit(CardLayout cl, JPanel cp){

        geoVerteilung = new JButton("geometrische Verteilung");
        geoVerteilung.addActionListener(event -> toGeoVerteilug(cl, cp));

        binomVerteilung = new JButton("binominal Verteilung");
        binomVerteilung.addActionListener(e -> toBinomVerteilung(cl, cp));

        poissonVerteilung = new JButton("possion Verteilung");
        poissonVerteilung.addActionListener(e -> toPossionVerteilung(cl, cp));

        this.add(poissonVerteilung);
        this.add(binomVerteilung);
        this.add(geoVerteilung);
        Border border = BorderFactory.createTitledBorder("Diskrete Warscheinlickeit");
        this.setBorder(border);
    }

    private void toPossionVerteilung(CardLayout cl, JPanel cp) {
        cl.show(cp, "POIS");
    }

    private void toBinomVerteilung(CardLayout cl, JPanel cp) {
        cl.show(cp, "BINO");
    }

    private void toGeoVerteilug(CardLayout cl, JPanel cp) {
        cl.show(cp, "GEO");
    }
}

package panels;

import themen.beschreibendeStatistik.BeschreibendeStatistik;
import themen.diskretewarsch.*;
import themen.kontinuierlichewarsch.ExponentialVerteilung;
import themen.kontinuierlichewarsch.KontinuierlicheWarscheinlichkeit;
import themen.kontinuierlichewarsch.Gleichverteilung;
import themen.kontinuierlichewarsch.NormalVerteilung;

import javax.swing.*;
import java.awt.*;
//a
public class Main extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public Main(){
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(new StandartPanel(cardLayout, cardPanel), "MENU");
        cardPanel.add(new BeschreibendeStatistik(), "BESCH");
        cardPanel.add(new DiskreteWarscheinlichkeit(cardLayout, cardPanel), "DISK");
        cardPanel.add(new BinominalVerteilung(), "BINO");
        cardPanel.add(new GeometrischeVerteilung(), "GEO");
        cardPanel.add(new PoissonVerteilung(), "POIS");
        cardPanel.add(new KontinuierlicheWarscheinlichkeit(cardLayout, cardPanel), "KONT");
        cardPanel.add(new Gleichverteilung(), "GLEICH");
        cardPanel.add(new ExponentialVerteilung(), "EXPO");
        cardPanel.add(new NormalVerteilung(), "NORM");
        cardPanel.add(new Kombinatorik(), "KOMB");
        cardPanel.add(new ZufallsvariableDiskret(), "DISKZV");
        JPanel navigationPanel= new NavigationPanel(cardLayout, cardPanel);

        this.add(cardPanel, BorderLayout.CENTER);
        this.add(navigationPanel, BorderLayout.SOUTH);
        this.setTitle("Stochastik Rechner");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Main();
    }
}

package panels;

import org.apache.commons.math3.distribution.NormalDistribution;
import themen.kontinuierlichewarsch.ExponentialVerteilung;
import themen.kontinuierlichewarsch.KontinuierlicheWarscheinlichkeit;
import themen.kontinuierlichewarsch.Gleichverteilung;
import themen.kontinuierlichewarsch.NormalVerteilung;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private JButton descStoch;
    private JButton discStoch;
    private JButton kontWarsch;
    private JButton schlStoch;
    private JPanel auswahl;
    private JTextArea choose;

    private CardLayout cardLayout;
    private JPanel cardPanel;



    public Main(){

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(new StandartPanel(cardLayout, cardPanel), "MENU");
        //cardPanel.add(new)
        cardPanel.add(new KontinuierlicheWarscheinlichkeit(cardLayout, cardPanel), "KONT");
        cardPanel.add(new Gleichverteilung(), "GLEICH");
        cardPanel.add(new ExponentialVerteilung(), "EXPO");
        cardPanel.add(new NormalVerteilung(), "NORM");
        JPanel navigationPanel= new NavigationPanel(cardLayout, cardPanel);



        this.add(cardPanel, BorderLayout.CENTER);
        this.add(navigationPanel, BorderLayout.SOUTH);
        this.setTitle("Stochastik Cheat Engine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }


    public static void main(String[] args) {
        new Main();

        //PoissonDistribution a = new PoissonDistribution(2);

        //System.out.println(a.probability(5));

        NormalDistribution normalDistribution = new NormalDistribution(180.3, 7.17);
        double result = normalDistribution.cumulativeProbability(175);

        System.out.println(result);



    }
}

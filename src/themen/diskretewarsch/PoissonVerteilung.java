package themen.diskretewarsch;

import org.apache.commons.math3.distribution.PoissonDistribution;
import themen.diskretewarsch.beispiele.PoissonVerteilungBsp;
import themen.diskretewarsch.info.PoissonVerteilungInfo;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.util.Locale;

public class PoissonVerteilung extends JPanel {

    private JTextField x;
    private JTextField p;
    private JTextField res;
    private JButton evalExact;
    private JButton evalMax;
    private JButton evalMin;
    private JButton evalEW;
    private JButton evalVar;
    private JButton info;
    private JButton beispiel;

    int ao;
    double bo, result;

    public PoissonVerteilung(){

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5, 1));
        panel1.add(new JLabel("x Treffer"));
        panel1.add(new JLabel("λ"));
        panel1.add(new JLabel("Result"));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(5, 1));
        x = new JTextField("0", 10);
        p = new JTextField("0", 10);
        res = new JTextField("", 10);
        panel2.add(x);
        panel2.add(p);
        panel2.add(res);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(5, 1));
        evalExact = new JButton("exakt x");
        evalExact.addActionListener(e -> evalExact());
        evalMax = new JButton("max x");
        evalMax.addActionListener(e -> evalMax());
        evalMin= new JButton("min x");
        evalMin.addActionListener(e -> evalMin());
        evalEW= new JButton("Erwartungswert");
        evalEW.addActionListener(e -> evalEW());
        evalVar = new JButton("Varianz");
        evalVar.addActionListener(e -> evalVar());

        panel3.add(evalExact);
        panel3.add(evalMax);
        panel3.add(evalMin);
        panel3.add(evalEW);
        panel3.add(evalVar);

        JPanel panel4 = new JPanel();
        panel4.setBorder(new EmptyBorder(20, 20, 20, 20));
        info = new JButton("INFO");
        info.addActionListener(e -> showInfo());
        beispiel = new JButton("Beispiel");
        beispiel.addActionListener(e -> showBsp());

        panel4.add(info);
        panel4.add(beispiel);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        CompoundBorder border = new CompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5),
                BorderFactory.createTitledBorder("poisson Verteilung"));
        this.setBorder(border);

    }

    private void showBsp() {
        new PoissonVerteilungBsp();
    }

    private void showInfo() {
        new PoissonVerteilungInfo();
    }

    private void evalExact() {
        if(tryEval()){
            PoissonDistribution distribution = new PoissonDistribution(bo);
            result = distribution.probability(ao);
            res.setText("" + String.format(Locale.US, "%.6f", result));
        }
    }

    private void evalMax() {
        if(tryEval()){
            PoissonDistribution distribution = new PoissonDistribution(bo);
            result = distribution.cumulativeProbability(ao);
            res.setText("" + String.format(Locale.US, "%.6f", result));
        }
    }

    private void evalMin() {
        if(tryEval()){
            PoissonDistribution distribution = new PoissonDistribution(bo);
            result = 1 - distribution.cumulativeProbability(ao);
            res.setText("" + String.format(Locale.US, "%.6f", result));
        }
    }

    private void evalEW() {
        if(tryEval()){
            PoissonDistribution distribution = new PoissonDistribution(bo);
            result = bo;
            res.setText("" + String.format(Locale.US, "%.6f", result));
        }
    }

    private void evalVar() {
        if(tryEval()){
            PoissonDistribution distribution = new PoissonDistribution(bo);
            result = bo;
            res.setText("" + String.format(Locale.US, "%.6f", result));
        }
    }


    private boolean tryEval(){
        String as = x.getText();
        String bs = p.getText();

        try {
            ao = Integer.parseInt(as);
        } catch(Exception x){
            res.setText("Fehler in x!");
        }
        try {
            bo = Double.parseDouble(bs);
        } catch (Exception x){
            res.setText("Fehler in p!");
            return false;
        }
        return true;
    }
}

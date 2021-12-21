package themen.diskretewarsch;

import org.apache.commons.math3.distribution.BinomialDistribution;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Locale;

public class BinominalVerteilung extends JPanel{

    private JTextField x;
    private JTextField n;
    private JTextField p;
    private JTextField res;
    private JButton evalExact;
    private JButton evalMax;
    private JButton evalMin;
    private JButton evalEW;
    private JButton evalVar;

    int ao, bo;
    double co;
    double result;

    public BinominalVerteilung(){

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5, 1));
        panel1.add(new JLabel("x Treffer"));
        panel1.add(new JLabel("n Versuche"));
        panel1.add(new JLabel("p"));
        panel1.add(new JLabel("Result"));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(5, 1));
        x = new JTextField("0", 10);
        n = new JTextField("0", 10);
        p = new JTextField("0", 10);
        res = new JTextField("", 10);
        panel2.add(x);
        panel2.add(n);
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

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        Border border = BorderFactory.createTitledBorder("binominal Verteilung");
        this.setBorder(border);
    }

    private void evalVar() {
        if(tryEval()){
            BinomialDistribution binomialDistribution = new BinomialDistribution(bo,co);
            result = binomialDistribution.getNumericalVariance();
            res.setText("" + String.format(Locale.US, "%.6f", result));
        }
    }

    private void evalEW() {
        if(tryEval()){
            result = bo*co;
            res.setText("" + String.format(Locale.US, "%.6f", result));
        }
    }

    private void evalMin() {
        if(tryEval()){
            BinomialDistribution binomialDistribution = new BinomialDistribution(bo,co);
            result = 1 - binomialDistribution.cumulativeProbability(ao);
            res.setText("" + String.format(Locale.US, "%.6f", result));
        }

    }

    private void evalMax() {
        if(tryEval()){
            BinomialDistribution binomialDistribution = new BinomialDistribution(bo,co);
            result = binomialDistribution.cumulativeProbability(ao);
            res.setText("" + String.format(Locale.US, "%.6f", result));
        }
    }

    private void evalExact() {
         if(tryEval()){
            BinomialDistribution binomialDistribution = new BinomialDistribution(bo,co);
            result = binomialDistribution.probability(ao);
            res.setText("" + String.format(Locale.US, "%.6f", result));
        }
    }

    private boolean tryEval(){
        String as = x.getText();
        String bs = n.getText();
        String cs = p.getText();

        try {
            ao = Integer.parseInt(as);
        } catch(Exception x){
            res.setText("Fehler in µ!");
        }

        try {
            bo = Integer.parseInt(bs);

        } catch (Exception x){
            res.setText("Fehler in 𝝈!");
        }

        try {
            co = Double.parseDouble(cs);
        } catch (Exception x){
            res.setText("Fehler in x!");
            return false;
        }
        return true;
    }
}

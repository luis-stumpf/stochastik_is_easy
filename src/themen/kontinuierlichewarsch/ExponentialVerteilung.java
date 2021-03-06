package themen.kontinuierlichewarsch;

import org.apache.commons.math3.analysis.function.Exp;
import org.apache.commons.math3.distribution.ExponentialDistribution;
import themen.kontinuierlichewarsch.beispiele.ExponentialVerteilungBsp;
import themen.kontinuierlichewarsch.info.ExponentialVerteilungInfo;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Locale;

public class ExponentialVerteilung extends JPanel {

    private JTextField lamda;
    private JTextField x;
    private JTextField res;
    private JButton evalEW;
    private JButton evalVar;
    private JButton evalMin;
    private JButton evalMax;
    private JButton evalQuant;
    private JButton info;
    private JButton beispiel;

    double ao;
    double bo;
    double result;

    public ExponentialVerteilung(){
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1));
        panel1.add(new JLabel("EW oder 1/𝝀 !"));
        panel1.add(new JLabel("x"));
        panel1.add(new JLabel("Result"));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 1));
        lamda = new JTextField("", 10);
        x = new JTextField("0", 10);
        res = new JTextField("", 10);
        panel2.add(lamda);
        panel2.add(x);
        panel2.add(res);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(2, 1));
        evalEW = new JButton("Erwartungswert");
        evalEW.addActionListener(e -> evalEW());
        evalVar = new JButton("Varianz");
        evalVar.addActionListener(e -> evalVar());
        evalMin = new JButton("Mindestens x");
        evalMin.addActionListener(e -> evalMin());
        evalMax = new JButton("Maximal x");
        evalMax.addActionListener(e -> evalMax());
        evalQuant = new JButton("Quantil");
        evalQuant.addActionListener(e -> evalQuant());

        panel3.add(evalEW);
        panel3.add(evalVar);
        panel3.add(evalMin);
        panel3.add(evalMax);
        panel3.add(evalQuant);

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
        Border border = BorderFactory.createTitledBorder("ExponentialVerteilung");
        this.setBorder(border);

    }

    private void showBsp() {
        new ExponentialVerteilungBsp();
    }

    private void showInfo() {
        new ExponentialVerteilungInfo();
    }

    // überarbeiten
    // inverse für quantil

    private void evalQuant(){
        if(tryEval()){
            ExponentialDistribution exponentialDistribution = new ExponentialDistribution(ao);
            result = exponentialDistribution.inverseCumulativeProbability(bo);
            res.setText("" + String.format(Locale.US, "%.6f",result));
        }
    }

    private void evalMax() {
        if(tryEval()) {
            ExponentialDistribution exponentialDistribution = new ExponentialDistribution(ao);
            result = exponentialDistribution.cumulativeProbability(bo);
            res.setText("" + String.format(Locale.US, "%.6f",result));
        }
    }

    private void evalMin() {
        if(tryEval()) {
            ExponentialDistribution exponentialDistribution = new ExponentialDistribution(ao);
            result = 1 - exponentialDistribution.cumulativeProbability(bo);
            res.setText("" + String.format(Locale.US, "%.6f",result));
        }
    }

    private void evalEW() {
        if(tryEval()){
            result = 1 / ao;
            res.setText("" + String.format(Locale.US, "%.6f",result));
        }

    }

    private void evalVar() {
        result = 1 / Math.pow(ao,2);
        res.setText("" + String.format(Locale.US, "%.6f",result));
    }

    private boolean tryEval(){
        String as = lamda.getText();
        String bs = x.getText();

        try {
            ao = Double.parseDouble(as);
        } catch(Exception x){
            res.setText("Fehler in lamda!");
        }

        try {
            bo = Double.parseDouble(bs);

        } catch (Exception x){
            res.setText("Fehler in x!");
            return false;
        }
        return true;
    }
}

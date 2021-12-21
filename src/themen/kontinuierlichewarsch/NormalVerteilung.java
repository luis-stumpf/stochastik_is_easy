package themen.kontinuierlichewarsch;

import org.apache.commons.math3.distribution.NormalDistribution;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Locale;

public class NormalVerteilung extends JPanel {

    private JTextField µ;
    private JTextField 𝝈;
    private JTextField x;
    private JTextField res;
    private JButton evalEW;
    private JButton evalVar;
    private JButton evalMax;
    private JButton evalNotMore;

    double ao;
    double bo;
    double xo;
    double result;

    public NormalVerteilung(){

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5, 1));
        panel1.add(new JLabel("µ"));
        panel1.add(new JLabel("𝝈"));
        panel1.add(new JLabel("x"));
        panel1.add(new JLabel("Result"));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(5, 1));
        µ = new JTextField("0", 10);
        𝝈 = new JTextField("0", 10);
        x = new JTextField("0", 10);
        res = new JTextField("", 10);
        panel2.add(µ);
        panel2.add(𝝈);
        panel2.add(x);
        panel2.add(res);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(2, 1));
        evalEW = new JButton("Erwartungswert");
        evalEW.addActionListener(e -> evalEW());
        evalVar = new JButton("Varianz");
        evalVar.addActionListener(e -> evalVar());
        evalMax = new JButton("Höchstens");
        evalMax.addActionListener(e -> evalMax());
        evalNotMore = new JButton("Nicht mehr");
        evalNotMore.addActionListener(e -> evalNotMore());

        panel3.add(evalEW);
        panel3.add(evalVar);
        panel3.add(evalMax);
        panel3.add(evalNotMore);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        Border border = BorderFactory.createTitledBorder("Normalverteilung");
        this.setBorder(border);

    }

    private void evalNotMore() {
        if(tryEval()){
            NormalDistribution normalDistribution = new NormalDistribution(ao, bo);
            result = normalDistribution.inverseCumulativeProbability(xo);
            res.setText("" + String.format(Locale.US, "%.6f", result));
        }
    }

    private void evalMax() {
        if(tryEval()) {
            NormalDistribution normalDistribution = new NormalDistribution(ao, bo);
            result = normalDistribution.cumulativeProbability(xo);
            res.setText("" + String.format(Locale.US, "%.6f", result));
        }
    }

    private void evalVar() {
        if(tryEval()) {
            result = Math.pow(bo, 2);
            res.setText("" + String.format(Locale.US, "%.6f", result));
        }
    }

    private void evalEW() {
        if(tryEval()){
            result = ao;
            res.setText("" + String.format(Locale.US, "%.6f",result));
        }
    }

    private boolean tryEval(){
        String as = µ.getText();
        String bs = 𝝈.getText();
        String xs = x.getText();

        try {
            ao = Double.parseDouble(as);
        } catch(Exception x){
            res.setText("Fehler in µ!");
        }

        try {
            bo = Double.parseDouble(bs);

        } catch (Exception x){
            res.setText("Fehler in 𝝈!");
        }

        try {
            xo = Double.parseDouble(xs);
        } catch (Exception x){
            res.setText("Fehler in x!");
            return false;
        }
        return true;
    }
}

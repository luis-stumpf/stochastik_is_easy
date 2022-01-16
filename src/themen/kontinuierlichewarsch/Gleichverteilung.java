package themen.kontinuierlichewarsch;


import themen.kontinuierlichewarsch.beispiele.GleichverteilungBsp;
import themen.kontinuierlichewarsch.info.GleichVerteilungInfo;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Locale;
//TODO implementierung von max und min !!!!!!!

public class Gleichverteilung extends JPanel{

    private JTextField a;
    private JTextField b;
    private JTextField x;
    private JTextField res;
    private JButton evalEW;
    private JButton evalVar;
    private JButton evalMax;
    private JButton evalMin;
    private JButton info;
    private JButton beispiel;

    double ao;
    double bo;
    double xo;
    double result;

    public Gleichverteilung(){

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4, 1));
        panel1.add(new JLabel("a"));
        panel1.add(new JLabel("b"));
        panel1.add(new JLabel("x"));
        panel1.add(new JLabel("Result"));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4, 1));
        a = new JTextField("", 10);
        b = new JTextField("", 10);
        x = new JTextField("", 10);
        res = new JTextField("", 10);
        panel2.add(a);
        panel2.add(b);
        panel2.add(x);
        panel2.add(res);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(4, 1));
        evalEW = new JButton("Erwartungswert");
        evalEW.addActionListener(e -> evalEW());
        evalVar = new JButton("Varianz");
        evalVar.addActionListener(e -> evalVar());
        evalMax = new JButton("höchsten");
        evalMax.addActionListener(e -> evalMax());
        evalMin = new JButton("mindestens");
        evalMin.addActionListener(e -> evalMin());

        panel3.add(evalEW);
        panel3.add(evalVar);
        panel3.add(evalMax);
        panel3.add(evalMin);

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
        Border border = BorderFactory.createTitledBorder("Gleichverteilung");
        this.setBorder(border);
    }

    private void evalMin() {
        if(tryEval()){
            result = (xo - bo) / (ao - bo);
            res.setText("" + String.format(Locale.US, "%.6f",result));
        }
    }

    private void evalMax() {
        if(tryEval()){
            result = 1 - ((xo - bo) / (ao - bo));
            res.setText("" + String.format(Locale.US, "%.6f",result));
        }
    }

    private void showBsp() {
        new GleichverteilungBsp();
    }

    private void showInfo() {
        new GleichVerteilungInfo();
    }

    private boolean tryEval(){
        String as = a.getText();
        String bs = b.getText();
        String xs = x.getText();

        try {
            ao = Double.parseDouble(as);
        } catch(Exception x){
            res.setText("Fehler in a!");
        }

        try {
            bo = Double.parseDouble(bs);

        } catch (Exception x){
            res.setText("Fehler in b");
        }
        try {
            xo = Double.parseDouble(xs);
        } catch (Exception x){
            res.setText("Fehler in x!");
            return false;
        }
        return true;
    }

    private void evalEW() {
        if(tryEval()){
            result = (ao + bo) / 2.0;
            res.setText("" + String.format(Locale.US, "%.6f",result));
        }

    }

    private void evalVar() {
        if(tryEval()){
            result = Math.pow((ao - bo), 2) / 12;
            res.setText("" + String.format(Locale.US, "%.6f",result));
        }
    }
}

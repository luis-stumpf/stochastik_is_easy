package themen.diskretewarsch;

import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import themen.beschreibendeStatistik.PlaceholderTextField;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.Locale;

public class ZufallsvariableDiskret extends JPanel {

    private PlaceholderTextField inputA;
    private PlaceholderTextField inputB;


    private JButton evalExact;
    private JButton evalMax;
    private JButton evalMin;
    private JButton evalEW;
    private JButton evalVar;
    private JButton info;
    private JTextField x, res;


    private int[] ArrayA;
    private double[] ArrayB;
    int ao;
    double result;

    public ZufallsvariableDiskret() {

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4, 2));
        inputA = new PlaceholderTextField("", 30);
        inputA.setPlaceholder("0 0 0 0 0");
        inputB = new PlaceholderTextField("", 30);
        inputB.setPlaceholder("0 0 0 0 0");

        panel1.add(new JLabel("Ereignisse  "));
        panel1.add(inputA);
        panel1.add(new JLabel("Warscheinlichkeiten  "));
        panel1.add(inputB);


        panel1.add(new JLabel("x Treffer"));
        x = new JTextField("0", 10);
        panel1.add(x);
        panel1.add(new JLabel("Result"));
        res = new JTextField("", 10);
        panel1.add(res);

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
        this.add(panel3);

        CompoundBorder border = new CompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5),
                BorderFactory.createTitledBorder("disk ZV"));
        this.setBorder(border);

    }

    private void evalVar() {
        if(tryEval()) {
            EnumeratedIntegerDistribution distribution = new EnumeratedIntegerDistribution(ArrayA, ArrayB);
            result = distribution.getNumericalVariance();
            res.setText("" + String.format(Locale.US, "%.6f", result));
        }
    }

    private void evalEW() {
        if(tryEval()) {
            EnumeratedIntegerDistribution distribution = new EnumeratedIntegerDistribution(ArrayA, ArrayB);
            result = distribution.getNumericalMean();
            res.setText("" + String.format(Locale.US, "%.6f", result));
        }
    }

    private void evalMin() {
        if(tryEval()) {
            EnumeratedIntegerDistribution distribution = new EnumeratedIntegerDistribution(ArrayA, ArrayB);
            result = 1 - distribution.cumulativeProbability(ao);
            res.setText("" + String.format(Locale.US, "%.6f", result));
        }
    }

    private void evalMax() {
        if(tryEval()) {
            EnumeratedIntegerDistribution distribution = new EnumeratedIntegerDistribution(ArrayA, ArrayB);
            result = distribution.cumulativeProbability(ao);
            res.setText("" + String.format(Locale.US, "%.6f", result));
        }
    }

    private void evalExact() {
        if(tryEval()) {
            EnumeratedIntegerDistribution distribution = new EnumeratedIntegerDistribution(ArrayA, ArrayB);
            result = distribution.probability(ao);
            res.setText("" + String.format(Locale.US, "%.6f", result));
        }
    }


    private boolean tryEval(){
        String as = x.getText();
        String inputStrA = inputA.getText();
        String inputStrB = inputB.getText();

        try {
            ao = Integer.parseInt(as);
        } catch(Exception x){
            res.setText("Fehler in x!");
        }
        try {
            if (!inputStrA.isEmpty()) {
                String[] splitA = inputStrA.split(" ");
                ArrayA = new int[splitA.length];
                for (int i = 0; i < splitA.length; i++) {
                    ArrayA[i] = Integer.parseInt(splitA[i]);
                }
            }
        } catch(Exception x) {
            res.setText("Fehler in Array A");
        }
        try {
            if (!inputStrB.isEmpty()) {
                String[] splitB = inputStrB.split(" ");
                ArrayB = new double[splitB.length];
                for (int i = 0; i < splitB.length; i++) {
                    ArrayB[i] = Double.parseDouble(splitB[i]);
                }
            }
        } catch (Exception x){
            res.setText("Fehler in Array B");
            return false;
        }
        return true;
    }
}

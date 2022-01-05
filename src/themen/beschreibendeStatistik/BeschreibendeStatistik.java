package themen.beschreibendeStatistik;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import themen.diskretewarsch.info.BinominalVerteilungInfo;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.*;

public class BeschreibendeStatistik extends JPanel{

    private PlaceholderTextField inputA;
    private PlaceholderTextField inputB;
    private PlaceholderTextField inputQuanA;
    private PlaceholderTextField inputQuanB;

    private JButton evalMean;
    private JButton evalMedian;
    private JButton evalQuantil;
    private JButton evalMostFreq;
    private JButton evalVar;
    private JButton evalStdAbweichung;
    private JButton evalSpannweite;
    private JButton evalInterQuanAbs;
    private JButton info;
    private JButton beispiel;

    private JTextArea ausgabe;

    private JPanel mainPanel2;
    private JPanel mainPanel1;

    private DescriptiveStatistics valuesA;
    private DescriptiveStatistics valuesB;
    private double[] ArrayA;
    private double[] ArrayB;
    private double quantileA;
    private double quantileB;

    public BeschreibendeStatistik() {
        mainPanel1 = new JPanel();
        mainPanel2 = new JPanel();

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4, 2));
        inputA = new PlaceholderTextField("", 10);
        inputA.setPlaceholder("0 0 0 0 0");
        inputB = new PlaceholderTextField("", 10);
        inputB.setPlaceholder("0 0 0 0 0");
        inputQuanA = new PlaceholderTextField("",10);
        inputQuanA.setPlaceholder("(0,1]");
        inputQuanB = new PlaceholderTextField("",10);
        inputQuanB.setPlaceholder("(0,1]");

        panel1.add(new JLabel("Array A  "));
        panel1.add(inputA);
        panel1.add(new JLabel("Array B  "));
        panel1.add(inputB);
        panel1.add(new JLabel("Erstes Quantil  "));
        panel1.add(inputQuanA);
        panel1.add(new JLabel("Zweites Quantil  "));
        panel1.add(inputQuanB);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(4, 2));
        evalMean = new JButton("Mittelwert (A&B)");
        evalMean.addActionListener(e -> evalMean());
        evalMedian = new JButton("Median (A&B)");
        evalMedian.addActionListener(e -> evalMedian());
        evalQuantil = new JButton("quantil (A,q1 & B,q2)");
        evalQuantil.addActionListener(e -> evalQuantil());
        evalMostFreq = new JButton("mostFreq (A&B)");
        evalMostFreq.addActionListener(e -> evalMostFreq());
        evalVar = new JButton("Varianz (A&B)");
        evalVar.addActionListener(e -> evalVar());
        evalStdAbweichung = new JButton("Std-Abweichung (A&B)");
        evalStdAbweichung.addActionListener(eval -> evalStdAbweichung());
        evalSpannweite = new JButton("Spannweite (A&B)");
        evalSpannweite.addActionListener(event -> evalSpannweite());
        evalInterQuanAbs = new JButton("Interquantilabstand (A&B)");
        evalInterQuanAbs.addActionListener(event -> evalInterQuanAbs());

        panel3.add(evalMean);
        panel3.add(evalMedian);
        panel3.add(evalQuantil);
        panel3.add(evalMostFreq);
        panel3.add(evalVar);
        panel3.add(evalStdAbweichung);
        panel3.add(evalSpannweite);
        panel3.add(evalInterQuanAbs);

        JPanel panel4 = new JPanel();
        panel4.setBorder(new EmptyBorder(20, 20, 20, 20));
        info = new JButton("INFO");
        info.addActionListener(e -> showInfo());
        beispiel = new JButton("Beispiel");
        beispiel.addActionListener(e -> showBsp());

        panel4.add(info);
        panel4.add(beispiel);

        ausgabe = new JTextArea();
        ausgabe.setEditable(false);

        mainPanel1.add(panel1);
        mainPanel1.add(panel3);
        mainPanel1.add(panel4);

        mainPanel2.setBorder(new EmptyBorder(20, 20, 20, 20));
        CompoundBorder mainPanel2Border = new CompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5),
                BorderFactory.createTitledBorder("Ausgabe"));
        mainPanel2.setBorder(mainPanel2Border);
        mainPanel2.add(ausgabe);

        this.setLayout(new GridLayout(2,1));
        this.add(mainPanel1);
        this.add(mainPanel2);

        CompoundBorder border = new CompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5),
                BorderFactory.createTitledBorder("Beschreibende Statistik"));
        this.setBorder(border);

    }

    private void evalMean() {
        if(tryEval()){
            double tmpA = 0;
            double tmpB = 0;

            if (ArrayA != null) {
                for (double d:ArrayA) {
                    tmpA+= d;
                }
                tmpA = tmpA/ArrayA.length;
                ausgabe.append("\nMittelwert(A) = " + tmpA);
            }

            if (ArrayB != null) {
                for (double d:ArrayB) {
                    tmpB+= d;
                }
                tmpB = tmpB/ArrayB.length;
                ausgabe.append("\nMittelwert(B) = " + tmpB);
            }
        }
    }

    private void evalMedian() {
        if(tryEval()){
            if (ArrayA != null) {
                double s = valuesA.getPercentile(50);
                ausgabe.append("\nMedian(A) = " + s);
            }

            if (ArrayB != null) {
                double s = valuesB.getPercentile(50);
                ausgabe.append("\nMedian(B) = " + s);
            }
        }
    }
    private void evalQuantil() {
        if(tryEval()){
            if (ArrayA != null) {
                if (quantileA == 0) {
                    ausgabe.setText("Fehler im ersten Quantil!");
                    return;
                }
                double s = valuesA.getPercentile(quantileA * 100);
                ausgabe.append("\nQuantil(A," + quantileA + ") = " + s);
            }
            if (ArrayB != null) {
                if (quantileB == 0) {
                    ausgabe.setText("Fehler im zweiten Quantil!");
                    return;
                }
                double s = valuesB.getPercentile(quantileB * 100);
                ausgabe.append("\nQuantil(B," + quantileB + ") = " + s);
            }

        }
    }
    private void evalMostFreq() {
        if(tryEval()){
            if (ArrayA != null)
                ausgabe.append("\nHäufigste Zahl in A = " + mode(ArrayA));
            if (ArrayB != null)
                ausgabe.append("\nHäufigste Zahl in B = " + mode(ArrayB));
        }
    }

    private static List<Double> mode(final double[] numbers) {
        final List<Double> modes = new ArrayList<>();
        final Map<Double, Double> countMap = new HashMap<>();

        double max = -1;

        for (final double n : numbers) {
            double count = 0;

            if (countMap.containsKey(n)) {
                count = countMap.get(n) + 1;
            } else {
                count = 1;
            }

            countMap.put(n, count);

            if (count > max) {
                max = count;
            }
        }

        for (final Map.Entry<Double, Double> tuple : countMap.entrySet()) {
            if (tuple.getValue() == max) {
                modes.add(tuple.getKey());
            }
        }

        return modes;
    }
    private void evalVar() {
        if(tryEval()){
            if (ArrayA != null)
                ausgabe.append("\nVarianz(A) = " + valuesA.getVariance());
            if (ArrayB != null)
                ausgabe.append("\nVarianz(B) = " + valuesB.getVariance());
        }
    }
    private void evalStdAbweichung() {
        if(tryEval()){
            ausgabe.append("\nStandartabweichung(A) = " + valuesA.getStandardDeviation());
            ausgabe.append("\nStandartabweichung(A) = " + valuesA.getStandardDeviation());
        }
    }
    private void evalSpannweite() {
        if(tryEval()){
            if (ArrayA != null)
                ausgabe.append("\nSpannweite(A) = " + (valuesA.getMax() - valuesA.getMin()));
            if (ArrayB != null)
                ausgabe.append("\nSpannweite(B) = " + (valuesB.getMax() - valuesB.getMin()));
        }
    }
    private void evalInterQuanAbs() {
        if(tryEval()){
            if (ArrayA != null)
                ausgabe.append("\nInterquantilabstand(A) = " + (valuesA.getPercentile(75) - valuesA.getPercentile(25)));
            if (ArrayB != null)
                ausgabe.append("\nInterquantilabstand(B) = " + (valuesB.getPercentile(75) - valuesB.getPercentile(25)));
        }
    }

    private void showBsp() {
    }

    private void showInfo() {
        new BinominalVerteilungInfo();
    }

    private boolean tryEval(){
        String inputStrA = inputA.getText();
        String inputStrB = inputB.getText();
        String inputStrQuanA = inputQuanA.getText();
        String inputStrQuanB = inputQuanB.getText();
        ausgabe.setText("");

        try {
            if (!inputStrA.isEmpty()) {
                String[] splitA = inputStrA.split(" ");
                ArrayA = new double[splitA.length];
                for (int i = 0; i < splitA.length; i++) {
                    ArrayA[i] = Double.parseDouble(splitA[i]);
                }
                valuesA = new DescriptiveStatistics(ArrayA);
                ausgabe.setText("" + Arrays.toString(valuesA.getSortedValues()));
            }
        } catch(Exception x) {
            ausgabe.setText("Fehler in Array A");
        }

        try {
            if (!inputStrB.isEmpty()) {
                String[] splitB = inputStrB.split(" ");
                ArrayB = new double[splitB.length];
                for (int i = 0; i < splitB.length; i++) {
                    ArrayB[i] = Double.parseDouble(splitB[i]);
                }
                valuesB = new DescriptiveStatistics(ArrayB);
                ausgabe.append("\n" + Arrays.toString(valuesB.getSortedValues()));
            }
        } catch (Exception x){
            ausgabe.append("\nFehler in Array B");
        }

        try {
            if (!inputStrQuanA.isEmpty()) {
                quantileA = Double.parseDouble(inputStrQuanA);
                if (quantileA < 0 || quantileA > 1) {
                    quantileA = 0;
                    throw new IndexOutOfBoundsException();
                }
            }
        } catch (Exception x) {
            ausgabe.append("\nFehler in erstem Quantil");
        }

        try {
            if (!inputStrQuanB.isEmpty()) {
                quantileB = Double.parseDouble(inputStrQuanB);
                if (quantileB < 0.0 || quantileB > 1.0) {
                    quantileB = 0;
                    throw new IndexOutOfBoundsException();
                }
            }
        } catch (Exception x) {
            ausgabe.append("\nFehler in zweitem Quantil");
        }
        return true;
    }

}



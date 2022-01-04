package themen.diskretewarsch;

import org.apache.commons.math3.util.CombinatoricsUtils;
import themen.diskretewarsch.info.KombinatorikInfo;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Kombinatorik extends JPanel {

    private final JTextField gesamt;
    private final JTextField type;
    private final JTextField auswahl;
    private final JTextField result;
    private final JCheckBox waea;
    private final JCheckBox idrw;
    private final JCheckBox we;
    private final JButton info;
    private final JButton beispiel;

    public Kombinatorik(){

        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setBorder(new EmptyBorder(new Insets(20,20,20,20)));
        leftPanel.setLayout(new GridLayout(2,2));
        gesamt = new JTextField("0",20); //TODO: Zeigt 96! fakultät nicht an weil zu klein, fix shitty formatierung
        auswahl = new JTextField("0",20);
        leftPanel.add(new JLabel("Gesamtmenge"));
        leftPanel.add(gesamt);
        leftPanel.add(new JLabel("Auswahl"));
        leftPanel.add(auswahl);


        JPanel rightPanel = new JPanel();
        waea = new JCheckBox();
        waea.addItemListener(e-> boxWAEA());
        idrw = new JCheckBox();
        idrw.addItemListener(e-> boxIDRW());
        we = new JCheckBox();
        we.addItemListener(e-> boxWE());

        rightPanel.setBorder(new EmptyBorder(20,20,20,20));
        rightPanel.setLayout(new GridLayout(3,2));
        rightPanel.add(new JLabel("Werden alle Elemente angeordnet?"));
        rightPanel.add(waea);
        rightPanel.add(new JLabel("Ist die Reihenfolge wichtig?"));
        rightPanel.add(idrw);
        rightPanel.add(new JLabel("Sind Wiederholungen erlaubt?"));
        rightPanel.add(we);

        masterPanel.add(leftPanel, BorderLayout.WEST);
        masterPanel.add(rightPanel, BorderLayout.NORTH);

        JPanel leftResult = new JPanel();
        leftResult.setBorder(new EmptyBorder(20,20,20,20));
        leftResult.setLayout(new GridLayout(2,1));
        result = new JTextField("0");
        type = new JTextField();
        type.setEditable(false);
        result.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        type.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        result.setEditable(false);
        leftResult.add(result);

        leftResult.add(type);

        masterPanel.add(leftResult, BorderLayout.SOUTH);


        JPanel controlPanel = new JPanel();
        controlPanel.setBorder(new EmptyBorder(20,20,20,20));
        controlPanel.setLayout(new GridLayout(1,2));
        JButton equals = new JButton("=");
        equals.addActionListener(e->eval());
        JButton reset = new JButton("Reset");
        reset.addActionListener(e->resetSettings());
        controlPanel.add(equals);
        controlPanel.add(reset);

        JPanel infobspPanel = new JPanel();
        info = new JButton("INFO");
        info.addActionListener(e -> showInfo());
        beispiel = new JButton("Beispiel");
        beispiel.addActionListener(e -> showBsp());
        infobspPanel.add(info);
        infobspPanel.add(beispiel);

        masterPanel.add(infobspPanel, BorderLayout.AFTER_LAST_LINE);

        masterPanel.add(controlPanel, BorderLayout.EAST);


        this.add(masterPanel);
        CompoundBorder border = new CompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5),
                BorderFactory.createTitledBorder("Kombinatorik"));

        this.setBorder(border);

    }

    private void showBsp() {
    }

    private void showInfo() {
        new KombinatorikInfo();
    }

    private void boxWAEA() {
        if (waea.isSelected()){
            idrw.setVisible(false);
            idrw.setSelected(false);
            we.setVisible(false);
            we.setSelected(false);
            auswahl.setEditable(false);

        } else {
            idrw.setVisible(true);
            we.setVisible(true);
            we.setSelected(false);
            idrw.setSelected(false);
            auswahl.setEditable(true);
        }
    }

    private void boxIDRW() {
    }

    private void boxWE() {
    }

    private void resetSettings() {
        gesamt.setText("0");
        auswahl.setText("0");
        result.setText("0");
        type.setText("");
        idrw.setVisible(true);
        we.setVisible(true);
        we.setSelected(false);
        idrw.setSelected(false);
        waea.setSelected(false);
        auswahl.setEditable(true);
    }

    private void eval() {
        String gesamtText = gesamt.getText();
        String auswahlText = auswahl.getText();
        int n = Integer.parseInt(gesamtText);
        int k = Integer.parseInt(auswahlText);

        if (waea.isSelected() && !idrw.isSelected() && !we.isSelected()){
            result.setText(""+factorialHavingLargeResult(n));
            type.setText("Permutation, zb CDs im Regal");
        }

        if (!waea.isSelected() && idrw.isSelected() && !we.isSelected()){
            BigInteger zaehler = factorialHavingLargeResult(n);
            int nk = n-k;
            BigInteger nenner = factorialHavingLargeResult(nk);
            result.setText(""+ zaehler.divide(nenner));
            type.setText("Variation ohne Wiederholung, zb Podestplätze");
        }

        if (!waea.isSelected() && idrw.isSelected() && we.isSelected()){
            result.setText(""+Math.pow(n,k));
            type.setText("Variation mit Wiederholung, zb Passwoerter");
        }

        if (!waea.isSelected() && !idrw.isSelected() && we.isSelected()){
            result.setText(""+CombinatoricsUtils.binomialCoefficient(n+k-1,k));
            type.setText("Kombination mit Wiederholung, zb Gummibärchenorakel");
        }

        if (!waea.isSelected() && !idrw.isSelected() && !we.isSelected()){
            result.setText(""+CombinatoricsUtils.binomialCoefficient(n,k));
            type.setText("Kombination ohne Wiederholung, zb Lotto");
        }



    }

    public BigInteger factorialHavingLargeResult(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }


}

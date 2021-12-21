package themen;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Locale;

public class Gleichverteilung extends JPanel{

    private JTextField a;
    private JTextField b;
    private JTextField res;
    private JButton evalEW;
    private JButton evalVar;

    double ao;
    double bo;
    double result;


    public Gleichverteilung(){

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1));
        panel1.add(new JLabel("a"));
        panel1.add(new JLabel("b"));
        panel1.add(new JLabel("Result"));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 1));
        a = new JTextField("", 10);
        b = new JTextField("", 10);
        res = new JTextField("", 10);
        panel2.add(a);
        panel2.add(b);
        panel2.add(res);



        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(2, 1));
        evalEW = new JButton("Erwartungswert");
        evalEW.addActionListener(e -> evalEW());
        evalVar = new JButton("Varianz");
        evalVar.addActionListener(e -> evalVar());

        panel3.add(evalEW);
        panel3.add(evalVar);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        Border border = BorderFactory.createTitledBorder("Gleichverteilung");
        this.setBorder(border);



    }



    private boolean tryEval(){
        String as = a.getText();
        String bs = b.getText();

        try {
            ao = Double.parseDouble(as);
        } catch(Exception x){
            res.setText("Fehler in a!");
        }

        try {
            bo = Double.parseDouble(bs);

        } catch (Exception x){
            res.setText("Fehler in b!");
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
            result = Math.pow((ao + bo), 2) / 12;
            res.setText("" + String.format(Locale.US, "%.6f",result));
        }
    }
}

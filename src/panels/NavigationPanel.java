package panels;

import javax.swing.*;
import java.awt.*;

public class NavigationPanel extends JPanel {

    JButton menu;
    JButton prev;
    JButton next;


    public NavigationPanel(CardLayout cl, JPanel cp){

        menu = new JButton("MENU");
        menu.addActionListener(event -> backToMenu(cl, cp));
        prev = new JButton("<");
        prev.addActionListener(e -> goPrev(cl, cp));
        next = new JButton(">");
        next.addActionListener(e -> goNext(cl, cp));

        //this.add(prev);
        this.add(menu);
        //this.add(next);
        /*
        TODO: need to implement a global prev and next variable storing last page!
         */
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

    }

    private void goPrev(CardLayout cl, JPanel cp) {
        cl.previous(cp);
    }

    private void goNext(CardLayout cl, JPanel cp) {
        cl.next(cp);
    }

    private void backToMenu(CardLayout cl, JPanel cp) {
        cl.show(cp, "MENU");
    }
}

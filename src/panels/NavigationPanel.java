package panels;

import javax.swing.*;
import java.awt.*;

public class NavigationPanel extends JPanel {

    JButton menu;
    JButton prev;
    JButton next;
    public static String prevPage;
    public static String currentPage= "MENU";
    public static String nextPage;


    public NavigationPanel(CardLayout cl, JPanel cp){

        menu = new JButton("MENU");
        menu.addActionListener(event -> backToMenu(cl, cp));
        prev = new JButton("<");
        prev.addActionListener(e -> goPrev(cl, cp));
        next = new JButton(">");

        this.add(prev);
        this.add(menu);
        //this.add(next);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

    }

    private void goPrev(CardLayout cl, JPanel cp) {
        nextPage = currentPage;
        cl.show(cp, prevPage);

    }

    private void backToMenu(CardLayout cl, JPanel cp) {
        nextPage = currentPage;
        cl.show(cp, "MENU");
    }
}

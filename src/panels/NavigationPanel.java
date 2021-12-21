package panels;

import javax.swing.*;
import java.awt.*;

public class NavigationPanel extends JPanel {

    JButton menu;


    public NavigationPanel(CardLayout cl, JPanel cp){

        menu = new JButton("MENU");
        menu.addActionListener(event -> backToMenu(cl, cp));
        this.add(menu);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

    }

    private void backToMenu(CardLayout cl, JPanel cp) {
        cl.show(cp, "MENU");
    }
}

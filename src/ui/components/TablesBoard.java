package ui.components;

import javax.swing.*;
import java.awt.*;

public class TablesBoard extends JPanel {
    public TablesBoard() {

        this.setPreferredSize(new Dimension(600, 600));
        GridLayout layout = new GridLayout(4,4);
        this.setLayout(layout);

        for (int i = 0; i < 6; i++) {
            String btnName = "" + i;
            JButton button = new JButton("");
            button.setBackground(Color.GRAY);
            button.setEnabled(false);
            this.add(button);
            JButton button2 = new JButton(btnName);
            button2.setBackground(Color.GREEN);
            this.add(button2);
        }
    }
}

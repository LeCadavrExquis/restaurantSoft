package ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TablesBoard extends JPanel {
    public TablesBoard() {

        this.setPreferredSize(new Dimension(400, 400));
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
            button2.setActionCommand("TABLE_SELECTED");
            this.add(button2);
        }
    }

    public void setActionListener(ActionListener listener) {
        Component[] components = this.getComponents();

        for (int i = 0; i < components.length; i++) {
            ((JButton)components[i]).addActionListener(listener);
        }
    }
}

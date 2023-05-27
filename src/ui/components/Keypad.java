package ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Keypad extends JPanel {
    public Keypad() {
        GridLayout layout = new GridLayout(4,3);

        this.setLayout(layout);

        this.add(new JButton("1")); // 0
        this.add(new JButton("2")); // 1
        this.add(new JButton("3")); // 2
        this.add(new JButton("4")); // ...
        this.add(new JButton("5"));
        this.add(new JButton("6"));
        this.add(new JButton("7"));
        this.add(new JButton("8"));
        this.add(new JButton("9"));
        this.add(new JButton("#"));
        this.add(new JButton("0")); // 10
        this.add(new JButton("*")); // 11
    }

    public void setActionListener(ActionListener l) {
        int buttonsCount = 12;
        for (int i = 0; i < buttonsCount; i++) {
            JButton b = (JButton) this.getComponent(i);
            b.addActionListener(l);
            b.setActionCommand("KEYPAD");
        }
    }
}

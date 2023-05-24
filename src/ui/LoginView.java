package ui;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JPanel {
    public LoginView() {
        GridLayout layout = new GridLayout(4,3);

        this.setLayout(layout);

        this.add(new JButton("1"));
        this.add(new JButton("2"));
        this.add(new JButton("3"));
        this.add(new JButton("4"));
        this.add(new JButton("5"));
        this.add(new JButton("6"));
        this.add(new JButton("7"));
        this.add(new JButton("8"));
        this.add(new JButton("9"));
        this.add(new JButton("#"));
        this.add(new JButton("0"));
        this.add(new JButton("*"));
    }
}

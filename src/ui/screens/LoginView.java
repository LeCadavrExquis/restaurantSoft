package ui.screens;

import ui.Destination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JPanel implements Destination {

    public ActionListener onLogIn;
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

    @Override
    public String getDestinationName() {
        return "LOGIN";
    }
}

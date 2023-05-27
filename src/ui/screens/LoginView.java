package ui.screens;

import ui.Destination;
import ui.components.Keypad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;

public class LoginView extends JPanel implements ActionListener, Destination {

    private JLabel textField;
    private Keypad keypad;

    private JButton logInBtn;
    private JButton clearBtn;

    public ActionListener onLogIn;
    public LoginView() {
        this.textField = new JLabel("");

        this.keypad = new Keypad();
        this.keypad.setActionListener(this);

        this.logInBtn = new JButton("Log in");
        this.logInBtn.addActionListener(this);
        this.logInBtn.setActionCommand("LOGIN");

        this.clearBtn = new JButton("Clear");
        this.clearBtn.addActionListener(this);
        this.clearBtn.setActionCommand("CLEAR");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(this.textField);
        this.add(this.keypad);
        this.add(this.clearBtn);
        this.add(this.logInBtn);

    }

    public void setOnLogIn(ActionListener listener) {
        this.onLogIn = listener;
    }

    @Override
    public String getDestinationName() {
        return "LOGIN";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (action.equals("KEYPAD")) {
            JButton b = (JButton) e.getSource();
            String newText = this.textField.getText() + b.getText();

            this.textField.setText(newText);
        } else if (action.equals("CLEAR")) {
            // TODO: Ustaw zawartość 'textField' na ""

        } else if (action.equals("LOGIN")) {
            ActionEvent newEvent = e;
            newEvent.setSource(textField);

            this.onLogIn.actionPerformed(newEvent);
        }
    }
}

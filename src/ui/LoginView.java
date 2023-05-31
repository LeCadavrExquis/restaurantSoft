package ui;

import ui.components.Keypad;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JPanel implements ActionListener {

    private JLabel textField;
    private Keypad keypad;
    private JButton logInBtn;
    private JButton clearBtn;

    public ActionListener onLogIn;
    public LoginView() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(600, 600));

        this.textField = new JLabel("");
        this.textField.setPreferredSize(new Dimension(400, 100));
        this.textField.setBorder(new LineBorder(new Color(1,1,1)));
        this.textField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
        this.textField.setHorizontalAlignment(SwingConstants.CENTER);

        this.keypad = new Keypad();
        this.keypad.setActionListener(this);

        // TODO: trochę zwiekszyć przyciski
        this.logInBtn = new JButton("Log in");
        this.logInBtn.addActionListener(this);
        this.logInBtn.setActionCommand("LOGIN");

        this.clearBtn = new JButton("Clear");
        this.clearBtn.addActionListener(this);
        this.clearBtn.setActionCommand("CLEAR");

        this.add(Box.createVerticalStrut(16));
        JPanel textFieldPlaceholder = new JPanel();
        textFieldPlaceholder.add(this.textField);
        this.add(textFieldPlaceholder);

        this.add(Box.createVerticalStrut(16));
        this.add(this.keypad);

        this.add(Box.createVerticalStrut(32));
        JPanel buttonsPlaceholder = new JPanel();
        buttonsPlaceholder.add(this.clearBtn);
        buttonsPlaceholder.add(Box.createVerticalStrut(32));
        buttonsPlaceholder.add(this.logInBtn);
        this.add(buttonsPlaceholder);
    }

    public void setOnLogIn(ActionListener listener) {
        this.onLogIn = listener;
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
            if (this.checkIfValidInput(this.textField.getText())) {
                ActionEvent newEvent = e;
                newEvent.setSource(textField);

                this.onLogIn.actionPerformed(newEvent);
            } else {
                this.drawError();
            }
        }
    }

    public void drawError() {
        this.textField.setBorder(new LineBorder(new Color(220, 15, 15)));
        this.revalidate();
        this.repaint();
    }

    private boolean checkIfValidInput(String input) {
        // TODO: sprwdź czy dany tekst jest w formacie int#int (np. 5#1234)
        return true;
    }
}

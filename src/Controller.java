import ui.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;

    public Controller(View view) {

        this.view = view;
        this.view.setListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validatePassword(((JLabel)e.getSource()).getText());
            }
        });

    }

    private boolean validatePassword(String password) {
        System.out.println(password);
        // TODO

        this.view.goToMainView();
        return true;
    }
}

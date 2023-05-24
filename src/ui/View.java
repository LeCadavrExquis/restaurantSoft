package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {
    private JFrame window;
    private JPanel loginView;
    private JPanel mainView;

    private ActionListener l;



    public View() {
        this.window = new JFrame("Restaurant soft");
        window.setSize(800, 600);

        this.loginView = new Keypad();

        this.mainView = new JPanel(new BorderLayout());

        this.mainView.add(new TablesView(), BorderLayout.CENTER);
        this.mainView.add(new MenuView(), BorderLayout.LINE_START);

        window.add(this.loginView);
        window.setVisible(true);
    }

    public void setListener(ActionListener l) {
        this.l = l;
        ((Keypad)this.loginView).setListener(l);
    }

    public void goToMainView() {
        this.window.remove(loginView);
        this.window.add(mainView);
        this.window.revalidate();
        this.window.setVisible(true);
    }
}

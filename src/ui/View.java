package ui;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame window;
    private JPanel loginView;
    private JPanel mainView;

    public View() {
        this.window = new JFrame("Restaurant soft");
        window.setSize(800, 600);

        this.loginView = new JPanel();
        this.mainView = new JPanel();

        window.setVisible(true);
    }
}

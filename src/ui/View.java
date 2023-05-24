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

        this.loginView = new LoginView();
        this.mainView = new JPanel(new BorderLayout());

        this.mainView.add(new TablesView(), BorderLayout.CENTER);
        this.mainView.add(new MenuView(), BorderLayout.LINE_START);

        window.add(this.mainView);
        window.setVisible(true);
    }
}

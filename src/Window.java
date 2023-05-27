import model.User;
import ui.screens.AdminView;
import ui.screens.DashboardView;
import ui.screens.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    private JPanel mainView;
    private LoginView loginView;
    private DashboardView dashboardView;
    private AdminView adminView;

    private ControllerActions actions;

    public Window(String title) {
        // wołamy construktor klasy JFrame
        super(title);

        this.mainView = new JPanel();

        // pola tej klasy (Window)
        this.loginView = new LoginView();
        this.loginView.setOnLogIn(this);
        this.mainView.add(this.loginView);

        // pola/metody klasy, po której dziedziczymy (JFrame)
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.mainView);
        this.setVisible(true);
    }

    public void setControllerActions(ControllerActions actions) {
        this.actions = actions;
    }

    public void goToDashboard(User user) {
        this.mainView.removeAll();
        if (user.isAdmin()) {
            this.adminView = new AdminView(user);
            this.mainView.add(this.adminView);
        } else {
            this.dashboardView = new DashboardView(user);
            this.mainView.add(this.dashboardView);
        }
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (action.equals("LOGIN")) {
            JLabel textField = (JLabel) e.getSource();
            String text = textField.getText();
            String[] splitedText = text.split("#");

            int id = Integer.parseInt(splitedText[0]);
            int password = Integer.parseInt(splitedText[1]);

            boolean isLogInSuccessfull = this.actions.logIn(id, password);

            if (!isLogInSuccessfull) {
                // TODO: pokoloruj pole z loginem i hasłem na czerwono jeżeli są nieprawidłowe
            }
        }
    }
}

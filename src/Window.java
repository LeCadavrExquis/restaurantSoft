import model.Dania;
import model.User;
import ui.AdminView;
import ui.DashboardView;
import ui.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame implements ActionListener {
    private JPanel mainView;

    private ControllerActions actions;

    public Window(String title) {
        super(title);
        this.setSize(1365, 760);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.mainView = new JPanel();
        LoginView loginView = new LoginView();
        loginView.setOnLogIn(this);
        this.mainView.add(loginView);
        this.add(this.mainView);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        switch (action) {
            case "LOGIN":
                JLabel textField = (JLabel) e.getSource();

                String text = textField.getText();
                String[] splitedText = text.split("#");

                int id = Integer.parseInt(splitedText[0]);
                int password = Integer.parseInt(splitedText[1]);

                boolean isLogInSuccessfull = this.actions.logIn(id, password);

                if (!isLogInSuccessfull) {
                    ((LoginView)this.mainView.getComponent(0)).drawError();
                }
                break;
            case "ORDER":
                // TODO pobierz potrzebne dane z ui i wywołaj funkcję controllera 'order'
                DashboardView dashboard = (DashboardView)e.getSource();
                int currentTable = dashboard.getCurrentTable();
                ArrayList<Dania> orderedPlates = dashboard.getOrderedPlates();
                this.actions.order(currentTable, orderedPlates);
                break;
            case "PAY":
                break;
        }
    }

    public void goToDashboard(User user) {
        this.mainView.removeAll();
        if (user.isAdmin()) {
            this.mainView.add(new AdminView());
        } else {
            DashboardView dashboard = new DashboardView(user, this);
            this.mainView.add(dashboard);
        }
        this.revalidate();
        this.repaint();
    }

    public void goToLogin() {
        this.mainView.removeAll();
        this.mainView.add(new LoginView());
        this.revalidate();
        this.repaint();
    }

    public void setControllerActions(ControllerActions actions) {
        this.actions = actions;
    }
}

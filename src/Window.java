import model.AdminStatistics;
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
                DashboardView dashboard = (DashboardView)e.getSource();
                int currentTable = dashboard.getCurrentTable();
                ArrayList<Dania> orderedPlates = dashboard.getOrderedPlates();
                this.actions.order(currentTable, orderedPlates);
                break;
            case "PAY":

                //this.actions.pay();
                break;
            case "TABLE_SELECTED":
                JButton btn = (JButton) e.getSource();
                String newTableNr = btn.getText();
                int table = Integer.parseInt(newTableNr);
                ArrayList<Dania> platesForTable = this.actions.getPlatesForTable(table);
                ((DashboardView)this.mainView.getComponent(0)).setCurrentPlates(platesForTable);
                break;
        }
    }

    public void goToDashboard(User user) {
        this.mainView.removeAll();
        if (user.isAdmin()) {
            AdminStatistics stats = this.actions.getStats();
            this.mainView.add(new AdminView(stats));
        } else {
            DashboardView dashboard = new DashboardView(this);
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

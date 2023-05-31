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
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("LOGIN")) {
            JLabel textField = (JLabel) e.getSource();

            String text = textField.getText();
            String[] splitedText = text.split("#");

            int id = Integer.parseInt(splitedText[0]);
            int password = Integer.parseInt(splitedText[1]);

            boolean isLogInSuccessfull = this.actions.logIn(id, password);

            if (!isLogInSuccessfull) {
                ((LoginView)this.mainView.getComponent(0)).drawError();
            }
        }
        if (actionCommand.equals("ORDER")) {
            // TODO pobierz potrzebne dane z ui i wywołaj funkcję controllera 'order'
            int currentTable = ((DashboardView)this.mainView).getCurrentTable();
            ArrayList<Dania> orderedPlates = ((DashboardView) this.mainView).getOrderedPlates();
            this.actions.order(currentTable, orderedPlates);
            System.out.println("elko");
        }
        if (actionCommand.equals("PAY")) {
            //this.actions.pay();
        }
    }

    public void goToDashboard(User user) {
        this.mainView.removeAll();
        if (user.isAdmin()) {
            this.mainView.add(new AdminView());
        } else {
            DashboardView dashboard = new DashboardView(user);
            dashboard.setControllerActionListener(this);
            this.mainView.add(new DashboardView(user));
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

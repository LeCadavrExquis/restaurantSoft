package ui;

import ui.screens.AdminView;
import ui.screens.DashboardView;
import ui.screens.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private LoginView loginView;
    private DashboardView mainView;
    private AdminView adminView;

    public Window(String title) {
        // wołamy construktor klasy JFrame
        super(title);

        // pola tej klasy (Window)
        this.loginView = new LoginView();
        this.mainView = new DashboardView();
        this.adminView = new AdminView();

        // pola/metody klasy, po której dziedziczymy (JFrame)
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.loginView);
        this.setVisible(true);
    }
}

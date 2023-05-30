package ui;

import model.User;
import ui.components.TablesBoard;
import ui.components.DashboardSidebar;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JPanel {
    protected DashboardSidebar dashboardSidebar;
    protected TablesBoard tablesBoard;
    protected User currentUser;

    public DashboardView(User user) {
        this.dashboardSidebar = new DashboardSidebar();
        this.tablesBoard = new TablesBoard();
        this.currentUser = user;

        this.setLayout(new BorderLayout(24, 24));
        // TODO: Dodaj pasek u góry okna z nazwą programu
        this.add(new JPanel(), BorderLayout.NORTH);
        this.add(this.tablesBoard, BorderLayout.CENTER);
        this.add(this.dashboardSidebar, BorderLayout.LINE_START);
    }
}

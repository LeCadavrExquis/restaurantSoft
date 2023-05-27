package ui.screens;

import ui.Destination;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JPanel implements Destination {
    private DashboardSidebar dashboardSidebar;
    private TablesBoard tablesBoard;
    public DashboardView() {
        this.dashboardSidebar = new DashboardSidebar();
        this.tablesBoard = new TablesBoard();

        this.setLayout(new BorderLayout());
        this.add(this.tablesBoard, BorderLayout.CENTER);
        this.add(this.dashboardSidebar, BorderLayout.LINE_START);
    }

    @Override
    public String getDestinationName() {
        return "DASHBOARD";
    }
}

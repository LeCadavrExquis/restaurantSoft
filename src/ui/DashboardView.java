package ui;

import model.Dania;
import model.User;
import model.Zamowienie;
import ui.components.TablesBoard;
import ui.components.DashboardSidebar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DashboardView extends JPanel implements ActionListener {
    private DashboardSidebar dashboardSidebar;
    private TablesBoard tablesBoard;
    private User currentUser;

    private ActionListener listener;

    public DashboardView(User user, ActionListener listener) {
        this.dashboardSidebar = new DashboardSidebar();
        this.dashboardSidebar.setActionListener(this);
        this.tablesBoard = new TablesBoard();
        this.tablesBoard.setActionListener(this);
        this.currentUser = user;
        this.listener = listener;

        this.setLayout(new BorderLayout(24, 24));
        this.add(new JLabel("Restauracja Soft wita!"), BorderLayout.PAGE_START);
        this.add(new JPanel(), BorderLayout.NORTH);
        this.add(this.tablesBoard, BorderLayout.CENTER);
        this.add(this.dashboardSidebar, BorderLayout.LINE_START);
    }

    public int getCurrentTable() {
        return dashboardSidebar.getCurrentTable();
    }

    public ArrayList<Dania> getOrderedPlates() {
        return this.dashboardSidebar.getOrderedPlates();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        switch (action) {
            case "TABLE_SELECTED":
                JButton btn = (JButton) e.getSource();
                String newTableNr = btn.getText();
                int table = Integer.parseInt(newTableNr);
                this.dashboardSidebar.setCurrentTable(table);
            case "ORDER":
                e.setSource(this);
                listener.actionPerformed(e);
                break;
            case "PAY":
                e.setSource(this);
                listener.actionPerformed(e);
                break;
        }
    }
}

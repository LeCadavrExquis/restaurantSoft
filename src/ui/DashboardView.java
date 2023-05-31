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
    protected DashboardSidebar dashboardSidebar;
    protected TablesBoard tablesBoard;
    protected User currentUser;
    protected ArrayList<Zamowienie> orders;

    public DashboardView(User user) {
        this.orders = new ArrayList<Zamowienie>();
        this.dashboardSidebar = new DashboardSidebar();
        this.tablesBoard = new TablesBoard();
        this.tablesBoard.setActionListener(this);
        this.currentUser = user;

        this.setLayout(new BorderLayout(24, 24));
        // TODO: Dodaj pasek u góry okna z nazwą programu
        this.add(new JPanel(), BorderLayout.NORTH);
        this.add(this.tablesBoard, BorderLayout.CENTER);
        this.add(this.dashboardSidebar, BorderLayout.LINE_START);
    }

    public void setControllerActionListener(ActionListener listener) {
        this.dashboardSidebar.setActionListener(listener);
    }

    public int getCurrentTable() {
        return dashboardSidebar.getCurrentTable();
    }

    public ArrayList<Dania> getOrderedPlates() {
        return this.dashboardSidebar.getOrderedPlates();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("TABLE_SELECTED")) {
            JButton btn = (JButton) e.getSource();
            String newTableNr = btn.getText();
            int table = Integer.parseInt(newTableNr);
            this.dashboardSidebar.setCurrentTable(table);
        }
    }
}

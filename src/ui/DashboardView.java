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
        this.add(new JLabel("Restauracja Soft wita!"), BorderLayout.PAGE_START);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("TABLE_SELECTED")) {
            int table = Integer.parseInt(((JButton)e.getSource()).getText());
            this.dashboardSidebar.setCurrentTable(table);
            //this.dashboardSidebar.setCurrenPlates();
        }
    }
}

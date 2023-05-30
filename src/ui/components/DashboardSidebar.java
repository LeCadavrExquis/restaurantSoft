package ui.components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class DashboardSidebar extends JPanel {
    public DashboardSidebar() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(600, 600));

        JButton addPaymentButton = new JButton("Zapłać za stolik");
        JButton addOrderButton = new JButton("Złóż zamówienie");

        this.add(addOrderButton);
        this.add(addPaymentButton);
    }
}

package ui.screens;

import model.User;

import java.awt.*;

public class AdminView extends DashboardView {
    public AdminView(User user) {
        super(user);
        this.setSize(200,200);
        this.setBackground(new Color(16, 43, 16));
    }

    @Override
    public String getDestinationName() {
        return "ADMIN_VIEW";
    }
}

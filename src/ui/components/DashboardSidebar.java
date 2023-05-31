package ui.components;

import model.Dania;
import model.DaniaType;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class DashboardSidebar extends JPanel implements ActionListener {
    private JLabel currentTable;
    private JButton addPaymentButton;
    private JButton addOrderButton;

    public ArrayList<Dania> getOrderedPlates() {
        return orderedPlates;
    }

    public void setOrderedPlates(ArrayList<Dania> orderedPlates) {
        this.orderedPlates = orderedPlates;
    }

    private ArrayList<Dania> orderedPlates;
    private JPanel showOrderedPlates;
    private int currentOrderId;

    public DashboardSidebar() {
        this.currentOrderId = new Random().nextInt();
        this.orderedPlates = new ArrayList<Dania>();

        this.currentTable = new JLabel("1");
        this.addPaymentButton = new JButton("Zapłać za stolik");
        this.addOrderButton = new JButton("Złóż zamówienie");
        this.showOrderedPlates = new JPanel();
        this.showOrderedPlates.setLayout(new BoxLayout(this.showOrderedPlates, BoxLayout.Y_AXIS));
        this.showOrderedPlates.add(new JLabel("Zamówione dania:"));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(400, 400));

        this.add(new JLabel("Aktualny stolik: "));
        this.add(this.currentTable);
        this.add(new JLabel("Dostępne dania:"));

        DaniaType[] availablePlates = DaniaType.values();

        for (int i = 0; i < availablePlates.length; i++) {
            JButton btn = new JButton(availablePlates[i].name);
            btn.setActionCommand("ADD_PLATE");
            btn.addActionListener(this);
            this.add(btn);
        }

        this.add(this.showOrderedPlates);
        this.add(addOrderButton);
        this.add(addPaymentButton);
    }

    public void setCurrentTable(int table) {
        this.currentTable.setText(String.valueOf(table));
        this.revalidate();
        this.repaint();
    }

    public void setCurrenPlates(ArrayList<Dania> plates) {
        this.showOrderedPlates.removeAll();
        // TODO: dodaj wszytkie dania
        //for ()
        this.revalidate();
        this.repaint();
    }

    public int getCurrentTable() {
        return Integer.parseInt(this.currentTable.getText());
    }

    public void setActionListener(ActionListener listener) {
        this.addOrderButton.addActionListener(listener);
        this.addPaymentButton.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ADD_PLATE")) {
            JButton btn = (JButton)e.getSource();
            DaniaType type = null;
            DaniaType[] plates = DaniaType.values();

            for (int i = 0; i < plates.length; i++) {
                if (plates[i].name.equals(btn.getText())) {
                    type = plates[i];
                }
            }

            Dania newPlate = new Dania(this.currentOrderId, type.price, type.name, new Random().nextInt());
            this.orderedPlates.add(newPlate);

            this.showOrderedPlates.add(new JLabel(newPlate.type + " | " + newPlate.price + " pln"));
            this.revalidate();
            this.repaint();
        }
    }
}

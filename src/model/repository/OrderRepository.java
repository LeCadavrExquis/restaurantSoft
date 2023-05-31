package model.repository;

import model.Zamowienie;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderRepository implements Repository<Zamowienie> {
    private ArrayList<Zamowienie> orders = new ArrayList<Zamowienie>();

    public OrderRepository() {
        File orderCsv = new File("./data/orders.csv");

        try {
            Scanner scanner = new Scanner(orderCsv);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splited = line.split(",");

                int table = Integer.parseInt(splited[0]);
                int hour = Integer.parseInt(splited[1]);
                int minute = Integer.parseInt(splited[2]);
                int second = Integer.parseInt(splited[3]);
                int id = Integer.parseInt(splited[4]);

                Zamowienie readOrder = new Zamowienie(table, hour, minute, second, id);

                this.orders.add(readOrder);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Zamowienie newOrder) {
        this.orders.add(newOrder);

        try {
            FileWriter fw = new FileWriter("./data/payments.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);

            out.println(newOrder.table + "," + newOrder.hour + "," + newOrder.minute + "," + newOrder.second + ", " + newOrder.id);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Zamowienie get(int id) {
        Zamowienie order = null;

        for (int i = 0; i < this.orders.size(); i++) {
            Zamowienie iOrder = this.orders.get(i);
            if (iOrder.id == id) {
                order = iOrder;
            }
        }

        return order;
    }

    @Override
    public void update(Zamowienie zamowienie) {
        // not implemented
    }

    @Override
    public void delete(int id) {
        // not implemented
    }

    @Override
    public ArrayList<Zamowienie> getAll() {
        return this.orders;
    }
}

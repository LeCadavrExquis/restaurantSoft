package model.repository;

import model.Platnosc;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PaymentRepository implements Repository<Platnosc> {

    private ArrayList<Platnosc> payments = new ArrayList<Platnosc>();

    public PaymentRepository() {
        File paymentCsv = new File("./data/payments.csv");

        try {
            Scanner scanner = new Scanner(paymentCsv);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splited = line.split(",");

                int id = Integer.parseInt(splited[0]);
                boolean accepted = Boolean.parseBoolean(splited[1]);
                boolean byCard = Boolean.parseBoolean(splited[2]);
                int orderId = Integer.parseInt(splited[3]);

                Platnosc readPayment = new Platnosc(id, accepted, byCard, orderId);

                this.payments.add(readPayment);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Platnosc nowaPlatnosc) {
        this.payments.add(nowaPlatnosc);

        try {
            FileWriter fw = new FileWriter("./data/payments.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);

            out.println(nowaPlatnosc.id + "," + nowaPlatnosc.zatwierdzono + "," + nowaPlatnosc.czykarta + "," + nowaPlatnosc.orderid);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Platnosc get(int id) {
        Platnosc payment = null;

        for (int i = 0; i < this.payments.size(); i++) {
            Platnosc iOrder = this.payments.get(i);
            if (iOrder.id == id) {
                payment = iOrder;
            }
        }

        return payment;
    }

    @Override
    public void update(Platnosc updatedPayment) {
        // not implemented
    }

    @Override
    public void delete(int id) {
        //not implemented
    }

    @Override
    public ArrayList<Platnosc> getAll() {
        return payments;
    }
}

package model.repository;

import model.Dania;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PlateRepository implements Repository<Dania> {
    private ArrayList<Dania> plates = new ArrayList<Dania>();

    public PlateRepository() {
        File plateCsv = new File("./data/plates.csv");

        try {
            Scanner scanner = new Scanner(plateCsv);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splited = line.split(",");

                int orderId = Integer.parseInt(splited[0]);
                String type = splited[1];
                double price = Double.parseDouble(splited[2]);
                int id = Integer.parseInt(splited[3]);

                Dania plate = new Dania(orderId, price, type, id);

                this.plates.add(plate);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Dania plate) {
        for (int i = 0; i < plates.size(); i++) {
            if (plate.id == plates.get(i).id) {

            } else {
                break;
            }
        }
        plates.add(plate);
        FileWriter fw = null;
        try {
            fw = new FileWriter("./data/plates.csv", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);

        out.println(plate.orderId + "," + plate.type + "," + plate.price + "," + plate.id);
        out.close();
    }

    @Override
    public Dania get(int id) {
        // not implemented
        return null;
    }

    @Override
    public void update(Dania updatedPlate) {
        // not implemented
    }

    @Override
    public void delete(int id) {
        // not implemented
    }

    @Override
    public ArrayList<Dania> getAll() {
        return plates;
    }
}

package model.repository;

import model.Dania;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PlateRepository implements Repository<Dania> {
    private ArrayList<Dania> plates = new ArrayList<Dania>();

    public PlateRepository() {
        // TODO load repository from file
        File plateCsv = new File("./data/plates.csv");

        try {
            Scanner scanner = new Scanner(plateCsv);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splited = line.split(",");

                int orderId = Integer.parseInt(splited[0]);
                String type = splited[1];
                double price = Double.parseDouble(splited[2]);
                int id = Integer.parseInt(splited[2]);

                Dania plate = new Dania( orderId,price,type,id);

                this.plates.add(plate);


            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        this.plates.add(new Dania(88, 30.0, "Pizza", 2));
        this.plates.add(new Dania(88, 5.5, "Napój", 3));
        this.plates.add(new Dania(88, 22.0, "Pierogi", 4));
        this.plates.add(new Dania(88, 25.0, "Makaron", 5));
        this.plates.add(new Dania(88, 5.5, "Napój", 6));
    }

    @Override
    public void add(Dania plate) {
        // TODO: sprawdź czy id obiektu plate is unikalne (nie ma go w liście plates)
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

        out.println(plate.id);
        out.close();
        // TODO: zapisz płatność do pliku 'plates.csv'
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

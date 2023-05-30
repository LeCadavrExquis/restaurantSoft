package model.repository;

import model.Dania;

import java.io.File;
import java.util.ArrayList;

public class PlateRepository implements Repository<Dania> {
    private ArrayList<Dania> plates = new ArrayList<Dania>();

    public PlateRepository() {
        // TODO load repository from file
        File plateCsv = new File("./data/plates.csv");

        this.plates.add(new Dania(88, 30.0, "Pizza", 2));
        this.plates.add(new Dania(88, 5.5, "Napój", 3));
        this.plates.add(new Dania(88, 22.0, "Pierogi", 4));
        this.plates.add(new Dania(88, 25.0, "Makaron", 5));
        this.plates.add(new Dania(88, 5.5, "Napój", 6));
    }

    @Override
    public void add(Dania plate) {
        // TODO: sprawdź czy id obiektu plate is unikalne (nie ma go w liście plates)

        this.plates.add(plate);

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

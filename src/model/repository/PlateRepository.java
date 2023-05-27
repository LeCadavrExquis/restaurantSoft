package model.repository;

import model.Dania;
import model.Platnosc;

import java.util.ArrayList;

public class PlateRepository implements Repository<Dania> {
    private ArrayList<Dania> plates = new ArrayList<Dania>();
    @Override
    public void add(Dania plate) {
        // TODO: dodaj danie do 'plates'
        // TODO: zapisz płatność do pliku 'plates.csv'
    }

    @Override
    public Dania get(int id) {
        // not implemented
        return null;
    }

    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public ArrayList<Dania> getAll() {
        return plates;
    }
}

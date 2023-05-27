package model.repository;

import model.Zamowienie;

import java.util.ArrayList;

public class OrderRepository implements Repository<Zamowienie> {
    private ArrayList<Zamowienie> orders = new ArrayList<Zamowienie>();
    @Override
    public void add(Zamowienie order) {
        // TODO: dodaj danie do 'plates'
        // TODO: zapisz płatność do pliku 'plates.csv'
    }

    @Override
    public Zamowienie get(int id) {
        // not implemented
        return null;
    }

    @Override
    public void update(int id) {
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

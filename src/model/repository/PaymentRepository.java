package model.repository;

import model.Platnosc;

import java.util.ArrayList;

public class PaymentRepository implements Repository<Platnosc> {

    private ArrayList<Platnosc> payments = new ArrayList<Platnosc>();
    public PaymentRepository() {
        // TODO: wczytaj płatności z pliku csv
    }

    @Override
    public void add(Platnosc platnosc) {
        // TODO: dodaj płatność do 'payments'
        // TODO: zapisz płatność do pliku 'payments.csv'
    }

    @Override
    public Platnosc get(int id) {
        // not implemented
        return null;
    }

    @Override
    public void update(int id) {
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

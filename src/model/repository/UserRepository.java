package model.repository;

import model.User;

import java.io.File;
import java.util.ArrayList;

public class UserRepository implements Repository<User> {

    private ArrayList<User> users = new ArrayList<User>();

    public UserRepository() {
        // TODO load repository from file
        File usersCsv = new File("./data/users.csv");

        users.add(new User(1, 1234, false));
        users.add(new User(2, 4321, true));
    }

    @Override
    public void add(User newUser) {
        // TODO: sprawdź czy id obiektu plate is unikalne (nie ma go w liście plates)

        this.users.add(newUser);

        // TODO: zapisz płatność do pliku 'plates.csv'
    }

    @Override
    public User get(int id) {
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getId() == id) {
                return this.users.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(User user) {
        // not implemented
    }

    @Override
    public void delete(int id) {
        // not implemented
    }

    @Override
    public ArrayList<User> getAll() {
        return this.users;
    }
}

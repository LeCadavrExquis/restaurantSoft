package model.repository;

import model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserRepository implements Repository<User> {

    private ArrayList<User> users = new ArrayList<User>();

    public UserRepository() {
        File usersCsv = new File("./data/users.csv");

        try {
            Scanner scanner = new Scanner(usersCsv);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splited = line.split(",");

                int id = Integer.parseInt(splited[0]);
                int password = Integer.parseInt(splited[1]);
                boolean isAdmin = Boolean.parseBoolean(splited[2]);

                User readUser = new User(id, password, isAdmin);

                this.users.add(readUser);


            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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

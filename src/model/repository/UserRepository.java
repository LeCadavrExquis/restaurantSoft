package model.repository;

import model.User;

import java.io.*;
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
        this.users.add(newUser);

        try {
            FileWriter fw = new FileWriter("./data/users.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.println(newUser.getId() + "," + newUser.getPassword() + "," + newUser.isAdmin());
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

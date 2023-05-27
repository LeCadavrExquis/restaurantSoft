package model.repository;

import java.io.File;
import java.util.ArrayList;

/**
 * Interfejs deklarujące podstawowe operacje na bazie danych
 * CRUD - create, read, update, delete
 *
 * @param <T> typ obiektu jaki będzie przechowywany w bazie danych
 */
public interface Repository<T> {
    public void add(T object);
    public T get(int id);
    public void update(int id);
    public void delete(int id);

    public ArrayList<T> getAll();
}

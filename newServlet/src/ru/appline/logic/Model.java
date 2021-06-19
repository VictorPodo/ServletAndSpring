package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {
    private static final Model instance = new Model();
    private final Map<Integer, User> model;

    public static Model getInstance() {
        return instance;
    }


    private Model() {
        model = new HashMap<>();
        model.put(1, new User("Victor","Alon",55555));
        model.put(2, new User("Fred", "Kastilio", 44444));
        model.put(3, new User("German",   "Klien",   33333));
        model.put(4, new User("Goga",   "Pashinyan",   43212));
    }

    public void delete(Integer id) {
        model.remove(id);
    }

    public void put(Integer id, String name, String surname, Double salary) {
        model.put(id, new User(name, surname, salary));
    }

    public void add(User user, int id) {
        model.put(id, user);
    }

    public Map<Integer, User> getFromList(){
        return model;
    }
}

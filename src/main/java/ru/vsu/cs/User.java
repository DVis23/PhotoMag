package ru.vsu.cs;

import java.util.*;

public class User {
    private String id;
    private String name;
    private double value;
    List<Tool> tools = new ArrayList<>();
    List<Album> albums = new ArrayList<>();
    private static Set<String> allIds = new HashSet<>();

    public User(String id, String name){
        if (!allIds.add(id)) {
            do {
                id = UUID.randomUUID().toString();
            } while (!allIds.add(id));
        }
        else this.id = id;
        this.name = name;
        double value = 0;
    }

    public static Set<String> getGeneratedIds() {
        return allIds;
    }
    public static void setGeneratedIds(Set<String> generatedIds) {
        User.allIds = generatedIds;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) throws Exception {
        if (!allIds.add(id)) {
            throw new Exception("the id already exists");
        }
        else this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public void addValue(double value) {
        this.value += value;
    }

}

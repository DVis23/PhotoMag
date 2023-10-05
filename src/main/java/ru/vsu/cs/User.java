package ru.vsu.cs;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String name;
    private double value;
    List<Tool> tools = new ArrayList<>();
    List<Album> albums = new ArrayList<>();

    public User(String id, String name){
        this.id = id;
        this.name = name;
        double value = 0;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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

package ru.vsu.cs.dvis;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class User {
    private final String id;
    private String name;
    private double value;
    private final List<Album> albums = new ArrayList<>();

    @JsonCreator
    public User(@JsonProperty("id") String id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
        this.value = 0;
    }

    public String getId() { return id; }

    public void addAlbum(Album album) { albums.add(album);}
    public void addAlbums(List<Album> albs) {
        albums.addAll(albs);
    }
    public void removeAlbum(Album album) {albums.remove(album);}
    public void removeAlbum(int index) {albums.remove(index);}
    public List<Album> getAlbums() { return new ArrayList<Album>(albums); }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
    public void addValue(double value) { this.value += value; }

}

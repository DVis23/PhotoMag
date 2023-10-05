package ru.vsu.cs;

import java.util.*;

public class User {
    private String id;
    private String name;
    private double value;
    List<Tool> tools = new ArrayList<>();
    List<Album> albums = new ArrayList<>();
    private static Set<String> allUsersIds = new HashSet<>();

    public User(String id, String name, boolean autoId) throws Exception{
        if (autoId) {
            if (!allUsersIds.add(id)) {
                do {
                    id = UUID.randomUUID().toString();
                } while (!allUsersIds.add(id));
            } else this.id = id;
        } else {
            throw new Exception("the id already exists");
        }
        this.name = name;
        double value = 0;
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }
    public void addAlbums(List<Album> albs) {
        albums.addAll(albs);
    }
    public void removeAlbum(Album album) {albums.remove(album);}
    public void removeAlbum(int index) {albums.remove(index);}
    public List<Album> getAlbums() { return new ArrayList<Album>(albums); }

    public void addTool(Tool tool) {
        tools.add(tool);
    }
    public void addTools(List<Tool> tls) {
        tools.addAll(tls);
    }
    public void removeTool(Tool tool) {tools.remove(tool);}
    public void removeTool(int index) {tools.remove(index);}
    public List<Tool> getTools() { return new ArrayList<Tool>(tools); }

    public static Set<String> getAllUsersIds() {
        return allUsersIds;
    }
    public static void setAllUsersIds(Set<String> generatedIds) {
        User.allUsersIds = generatedIds;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) throws Exception {
        if (!allUsersIds.add(id)) {
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

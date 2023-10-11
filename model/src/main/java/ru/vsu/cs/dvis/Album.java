package ru.vsu.cs.dvis;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Album {
    private final String id;
    private String name;
    private final String userId;
    private final List<Image> images = new ArrayList<>();

    @JsonCreator
    public Album(@JsonProperty("id") String id, @JsonProperty("userId") String userId, @JsonProperty("name") String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
    }

    public void addImage(Image img) {
        images.add(img);
    }
    public void addImages(List<Image> imgs) { images.addAll(imgs);}
    public void removeImage(Image img) {
        images.remove(img);
    }
    public void removeImage(int index) {
        images.remove(index);
    }

    public String getUserId() {
        return userId;
    }
    public String getId() {
        return id;
    }

    public List<Image> getImages() {
        return new ArrayList<Image>(images);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

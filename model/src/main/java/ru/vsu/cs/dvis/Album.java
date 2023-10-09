package ru.vsu.cs.dvis;

import java.util.*;

public class Album {
    private String name;
    private String id;
    private String userId;
    private final List<Image> imageList= new ArrayList<>();
    private static Set<String> allAlbumsIds = new HashSet<>();

    public Album(String userId, String name){
        this.name = name;
        this.userId = userId;
        do {
            id = UUID.randomUUID().toString();
        } while (!allAlbumsIds.add(id));
    }

    public static Set<String> getAllAlbumsIds() {
        return allAlbumsIds;
    }
    public static void setAllAlbumsIds(Set<String> allAlbumsIds) {
        Album.allAlbumsIds = allAlbumsIds;
    }

    public void addImage(Image img) {
        imageList.add(img);
    }
    public void addImages(List<Image> imgs) { imageList.addAll(imgs);}
    public void removeImage(Image img) {
        imageList.remove(img);
    }
    public void removeImage(int index) {
        imageList.remove(index);
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getId() {
        return id;
    }
    public List<Image> getImageList() {
        return new ArrayList<Image>(imageList);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

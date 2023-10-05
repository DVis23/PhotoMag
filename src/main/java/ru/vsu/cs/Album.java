package ru.vsu.cs;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private final String id;
    private String userId;
    private final List<Image> imageList= new ArrayList<>();

    public Album(String userId, String id){
        this.userId = userId;
        this.id = id;
    }
    public Album(String userId, String id, Image img){
        this.userId = userId;
        this.id = id;
        imageList.add(img);
    }
    public Album(String userId, String id, List<Image> listImg){
        this.userId = userId;
        this.id = id;
        imageList.addAll(listImg);
    }

    public void addImage(Image img) {
        imageList.add(img);
    }
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
}

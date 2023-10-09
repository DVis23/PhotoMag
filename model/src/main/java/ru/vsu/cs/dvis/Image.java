package ru.vsu.cs.dvis;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Image {
    private final LocalDateTime dataTime;
    private String id;
    private Path location;
    private String albumId;
    private static Set<String> allImagesIds = new HashSet<>();

    public Image(String albumId, Path location){
        this.dataTime = LocalDateTime.now();
        this.albumId = albumId;
        this.location = location;
        do {
            id = UUID.randomUUID().toString();
        } while (!allImagesIds.add(id));
    }

    public static Set<String> getAllImagesIds() { return allImagesIds; }
    public static void setAllImagesIds(Set<String> allImagesIds) {
        Image.allImagesIds = allImagesIds;
    }
    public LocalDateTime getDateTime() {
        return dataTime;
    }
    public String getAlbumId() {
        return albumId;
    }
    public void setAlbumId(String userId){
        this.albumId = userId;
    }
    public String getId() {
        return id;
    }
    public Path getLocation() {
        return location;
    }
    public void setLocation(Path location) {
        this.location = location;
    }

}

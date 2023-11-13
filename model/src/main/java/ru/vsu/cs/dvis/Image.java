package ru.vsu.cs.dvis;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Image {
    private final String id;
    private String location;
    private final String albumId;

    @JsonCreator
    public Image(@JsonProperty("id") String id,
                 @JsonProperty("albumId") String albumId,
                 @JsonProperty("location") String location) {
        this.id = id;
        this.albumId = albumId;
        this.location = location;
    }


    public String getAlbumId() {
        return albumId;
    }
    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) { this.location = location; }

}

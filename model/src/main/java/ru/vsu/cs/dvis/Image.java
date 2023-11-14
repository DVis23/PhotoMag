package ru.vsu.cs.dvis;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public class Image {
    private final UUID id;
    private String location;
    private final UUID albumId;

    @JsonCreator
    public Image(@JsonProperty("id") UUID id,
                 @JsonProperty("albumId") UUID albumId,
                 @JsonProperty("location") String location) {
        this.id = id;
        this.albumId = albumId;
        this.location = location;
    }


    public UUID getAlbumId() {
        return albumId;
    }
    public UUID getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) { this.location = location; }

}

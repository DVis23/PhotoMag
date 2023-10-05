package ru.vsu.cs;

import java.nio.file.Path;
import java.time.LocalDateTime;

public class Image {
    private final LocalDateTime dataTime;
    private final String id;
    private Path location;
    private String userId;

    public Image(String userId, String id, Path location){
        this.dataTime = LocalDateTime.now();
        this.userId = userId;
        this.id = id;
        this.location = location;
    }

    public LocalDateTime getDataTime() {
        return dataTime;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId){
        this.userId = userId;
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

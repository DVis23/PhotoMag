package ru.vsu.cs.dvis;

import org.flywaydb.core.Flyway;

import java.sql.*;
import java.util.UUID;

public class DataBaseService {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/photo_mag";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "1111";

    private Connection connection;

    public DataBaseService() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            Flyway flyway = Flyway.configure().dataSource(DB_URL, DB_USER, DB_PASSWORD).load();
            flyway.baseline();
            flyway.migrate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUser(User user) {
        try {
            String userInsertQuery = "INSERT INTO users (id, name, value) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(userInsertQuery);
            statement.setObject(1, UUID.fromString(user.getId()));
            statement.setString(2, user.getName());
            statement.setDouble(3, user.getValue());
            statement.executeUpdate();

            for (Album album : user.getAlbums()) {
                String albumInsertQuery = "INSERT INTO albums (id, name, user_id) VALUES (?, ?, ?)";
                PreparedStatement albumStatement = connection.prepareStatement(albumInsertQuery);
                albumStatement.setObject(1, UUID.fromString(album.getId()));
                albumStatement.setString(2, album.getName());
                albumStatement.setObject(3, UUID.fromString(album.getUserId()));
                albumStatement.executeUpdate();

                for (Image image : album.getImages()) {
                    String imageInsertQuery = "INSERT INTO images (id, location, album_id) VALUES (?, ?, ?)";
                    PreparedStatement imageStatement = connection.prepareStatement(imageInsertQuery);
                    imageStatement.setObject(1, UUID.fromString(image.getId()));
                    imageStatement.setString(2, image.getLocation());
                    imageStatement.setObject(3, UUID.fromString(image.getAlbumId()));
                    imageStatement.executeUpdate();
                }
            }

            for (Tool tool : user.getTools()) {
                String toolInsertQuery = "INSERT INTO tools (id, type) VALUES (?, ?)";
                PreparedStatement toolStatement = connection.prepareStatement(toolInsertQuery);
                toolStatement.setObject(1, UUID.fromString(tool.getId()));
                toolStatement.setString(2, tool.getType());
                toolStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

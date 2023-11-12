package ru.vsu.cs.dvis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CRUDService {
    private final Connection connection;

    public CRUDService(DataBase dataBase) {
        connection = dataBase.getConnection();
    }

    public void insertUser(User user) {
        try {
            PreparedStatement userStatement = connection.prepareStatement(
                    "INSERT INTO users (id, name, value) VALUES (?, ?, ?)");
            userStatement.setObject(1, UUID.fromString(user.getId()));
            userStatement.setString(2, user.getName());
            userStatement.setDouble(3, user.getValue());
            userStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            for (Album album : user.getAlbums()) {
                insertAlbum(album);
                for (Image image : album.getImages()) {
                    insertImage(image);
                }
            }
            for (Tool tool : user.getTools()) {
                insertTool(tool);
            }
    }

    public void insertAlbum(Album album) {
        try {
            PreparedStatement albumStatement = connection.prepareStatement(
                    "INSERT INTO albums (id, name, user_id) VALUES (?, ?, ?)");
            albumStatement.setObject(1, UUID.fromString(album.getId()));
            albumStatement.setString(2, album.getName());
            albumStatement.setObject(3, UUID.fromString(album.getUserId()));
            albumStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertImage(Image image) {
        try {
            PreparedStatement imageStatement = connection.prepareStatement(
                    "INSERT INTO images (id, location, album_id) VALUES (?, ?, ?)");
            imageStatement.setObject(1, UUID.fromString(image.getId()));
            imageStatement.setString(2, image.getLocation());
            imageStatement.setObject(3, UUID.fromString(image.getAlbumId()));
            imageStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertTool(Tool tool) {
        try {
            PreparedStatement toolStatement = connection.prepareStatement(
                    "INSERT INTO tools (id, type) VALUES (?, ?)");
            toolStatement.setObject(1, UUID.fromString(tool.getId()));
            toolStatement.setString(2, tool.getType());
            toolStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<String, User> getAllUsers() {
        Map<String, User> userMap = null;
        try {
            userMap = getUsersFromRs(connection.prepareStatement("SELECT * FROM users").executeQuery());
            Map<String, List<Album>> albumMap = getAlbumsFromRs(connection.prepareStatement(
                    "SELECT * FROM albums").executeQuery());

            Map<String, List<Image>> imageMap = getImagesFromRs(connection.prepareStatement(
                    "SELECT * FROM images").executeQuery());

            for (Map.Entry<String, User> userEntry : userMap.entrySet()) {
                String userId = userEntry.getKey();
                User user = userEntry.getValue();

                List<Album> albums = albumMap.get(userId);
                for (Album album : albums) album.addImages(imageMap.get(album.getId()));
                user.addAlbums(albums);

                userMap.put(userId, user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userMap;
    }

    public User getUser(String id) {
        User user = null;
        try {
            PreparedStatement userStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE id = ?");
            userStatement.setObject(1, UUID.fromString(id));
            user = getUserFromRs(userStatement.executeQuery());

            PreparedStatement albumsStatement = connection.prepareStatement(
                    "SELECT * FROM albums WHERE user_id = ?");
            albumsStatement.setObject(1, UUID.fromString(id));
            List<Album> albums = getUsersAlbumsFromRs(albumsStatement.executeQuery());

            for (Album album : albums) {
                PreparedStatement imagesStatement = connection.prepareStatement(
                        "SELECT * FROM images WHERE album_id = ?");
                imagesStatement.setObject(1, UUID.fromString(album.getId()));
                List<Image> images = getAlbumsImagesFromRs(imagesStatement.executeQuery());
                album.addImages(images);
            }

            user.addAlbums(albums);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Album getAlbum(String id) {
        Album album = null;
        try {
            PreparedStatement albumStatement = connection.prepareStatement(
                    "SELECT * FROM albums WHERE id = ?");
            albumStatement.setObject(1, UUID.fromString(id));
            album = getAlbumFromRs(albumStatement.executeQuery());

            PreparedStatement imagesStatement = connection.prepareStatement(
                    "SELECT * FROM images WHERE album_id = ?");
            imagesStatement.setObject(1, UUID.fromString(id));
            List<Image> images = getAlbumsImagesFromRs(imagesStatement.executeQuery());
            album.addImages(images);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return album;
    }

    public Image getImage(String id) {
        Image image = null;
        try {
            PreparedStatement imagesStatement = connection.prepareStatement(
                    "SELECT * FROM images WHERE id = ?");
            imagesStatement.setObject(1, UUID.fromString(id));
            image = getImageFromRs(imagesStatement.executeQuery());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return image;
    }

    private Map<String, User> getUsersFromRs(ResultSet rs) {
        Map<String, User> users = new HashMap<>();
        try {
            while (rs.next()) {
                String id = ((UUID) rs.getObject("id")).toString();
                String name = rs.getString("name");
                User user = new User(id, name);
                user.setValue(rs.getDouble("value"));
                users.put(id, user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private User getUserFromRs(ResultSet rs) {
        User user = null;
        try {
            while (rs.next()) {
                String id = ((UUID) rs.getObject("id")).toString();
                String name = rs.getString("name");
                user = new User(id, name);
                user.setValue(rs.getDouble("value"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private Map<String, List<Album>> getAlbumsFromRs(ResultSet rs) {
        Map<String, List<Album>> albums = new HashMap<>();
        try {
            while (rs.next()) {
                String id = ((UUID) rs.getObject("id")).toString();
                String name = rs.getString("name");
                String user_id = rs.getString("user_id");
                Album album = new Album(id, user_id, name);
                if (albums.containsKey(user_id)) albums.get(user_id).add(album);
                else {
                    List<Album> usersAlbum = new ArrayList<>();
                    usersAlbum.add(album);
                    albums.put(user_id, usersAlbum);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albums;
    }

    private List<Album> getUsersAlbumsFromRs(ResultSet rs) {
        List<Album> albums = new ArrayList<>();
        try {
            while (rs.next()) {
                String id = ((UUID) rs.getObject("id")).toString();
                String name = rs.getString("name");
                String user_id = rs.getString("user_id");
                Album album = new Album(id, user_id, name);
                albums.add(album);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albums;
    }

    private Album getAlbumFromRs(ResultSet rs) {
        Album album = null;
        try {
            while (rs.next()) {
                String id = ((UUID) rs.getObject("id")).toString();
                String name = rs.getString("name");
                String user_id = rs.getString("user_id");
                album = new Album(id, user_id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return album;
    }

    private Map<String, List<Image>> getImagesFromRs(ResultSet rs) {
        Map<String, List<Image>> images = new HashMap<>();
        try {
            while (rs.next()) {
                String id = ((UUID) rs.getObject("id")).toString();
                String location = rs.getString("location");
                String album_id = rs.getString("album_id");
                Image image = new Image(id, album_id, location);
                if (images.containsKey(album_id)) images.get(album_id).add(image);
                else {
                    List<Image> albumsImage = new ArrayList<>();
                    albumsImage.add(image);
                    images.put(album_id, albumsImage);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return images;
    }

    private List<Image> getAlbumsImagesFromRs(ResultSet rs) {
        List<Image> images = new ArrayList<>();
        try {
            while (rs.next()) {
                String id = ((UUID) rs.getObject("id")).toString();
                String location = rs.getString("location");
                String album_id = rs.getString("album_id");
                Image image = new Image(id, album_id, location);
                images.add(image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return images;
    }

    private Image getImageFromRs(ResultSet rs) {
        Image image = null;
        try {
            while (rs.next()) {
                String id = ((UUID) rs.getObject("id")).toString();
                String location = rs.getString("location");
                String album_id = rs.getString("album_id");
                image = new Image(id, album_id, location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return image;
    }

}

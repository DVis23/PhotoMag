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

    public void createUsers(List<User> users) {
        for (User user : users) createUser(user);
    }

    public void createUser(User user) {
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
            createAlbums(user.getAlbums());
    }

    public void createAlbums(List<Album> albums) {
        for (Album album : albums) createAlbum(album);
    }

    public void createAlbum(Album album) {
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
        createImages(album.getImages());
    }

    public void createImages(List<Image> images) {
        for (Image image : images) createImage(image);
    }

    public void createImage(Image image) {
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

    public List <User> readAllUsers() {
        List <User> users = new ArrayList<>();
        try {
            users = getUsersFromRs(connection.prepareStatement("SELECT * FROM users").executeQuery());

            for (User user : users) {
                List<Album> albums = readAlbumByUsersId(user.getId());
                user.addAlbums(albums);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User readUser(String id) {
        User user = null;
        try {
            PreparedStatement userStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE id = ?");
            userStatement.setObject(1, UUID.fromString(id));
            user = getUserFromRs(userStatement.executeQuery());

            List<Album> albums = readAlbumByUsersId(id);
            user.addAlbums(albums);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> readUsersByName(String name) {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement userStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE name = ?");
            userStatement.setString(1, name);
            users = getUsersFromRs(userStatement.executeQuery());
            for (User user : users) {
                List<Album> albums = readAlbumByUsersId(user.getId());
                user.addAlbums(albums);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<User> readUsersByValue(double value) {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement userStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE value = ?");
            userStatement.setDouble(1, value);
            users = getUsersFromRs(userStatement.executeQuery());
            for (User user : users) {
                List<Album> albums = readAlbumByUsersId(user.getId());
                user.addAlbums(albums);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public Album readAlbum(String id) {
        Album album = null;
        try {
            PreparedStatement albumStatement = connection.prepareStatement(
                    "SELECT * FROM albums WHERE id = ?");
            albumStatement.setObject(1, UUID.fromString(id));
            album = getAlbumFromRs(albumStatement.executeQuery());

            if (album != null) {
                List<Image> images = readImagesByAlbumId(album.getId());
                album.addImages(images);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return album;
    }

    public List<Album> readAlbumByName(String name) {
        List<Album> albums = new ArrayList<>();
        try {
            PreparedStatement albumStatement = connection.prepareStatement(
                    "SELECT * FROM albums WHERE name = ?");
            albumStatement.setString(1, name);
            albums = getAlbumsFromRs(albumStatement.executeQuery());

            for (Album album : albums) {
                List<Image> images = readImagesByAlbumId(album.getId());
                album.addImages(images);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albums;
    }

    public List<Album> readAlbumByUsersId(String userId) {
        List<Album> albums = new ArrayList<>();
        try {
            PreparedStatement albumStatement = connection.prepareStatement(
                    "SELECT * FROM albums WHERE user_id = ?");
            albumStatement.setObject(1, UUID.fromString(userId));
            albums = getAlbumsFromRs(albumStatement.executeQuery());

            for (Album album : albums) {
                List<Image> images = readImagesByAlbumId(album.getId());
                album.addImages(images);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albums;
    }

    public Image readImage(String id) {
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

    public List<Image> readImagesByLocation(String location) {
        List<Image> images = new ArrayList<>();
        try {
            PreparedStatement imagesStatement = connection.prepareStatement(
                    "SELECT * FROM images WHERE location = ?");
            imagesStatement.setString(1, location);
            images = getImagesFromRs(imagesStatement.executeQuery());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return images;
    }

    public List<Image> readImagesByAlbumId(String albumId) {
        List<Image> images = new ArrayList<>();
        try {
            PreparedStatement imagesStatement = connection.prepareStatement(
                    "SELECT * FROM images WHERE album_id = ?");
            imagesStatement.setObject(1, UUID.fromString(albumId));
            Image image = getImageFromRs(imagesStatement.executeQuery());
            images.add(image);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return images;
    }

    private List<User> getUsersFromRs(ResultSet rs) {
        List<User> users = new ArrayList<>();
        try {
            while (rs.next()) {
                String id = ((UUID) rs.getObject("id")).toString();
                String name = rs.getString("name");
                User user = new User(id, name);
                user.setValue(rs.getDouble("value"));
                users.add(user);
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

    private List<Album> getAlbumsFromRs(ResultSet rs) {
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

    private List<Image> getImagesFromRs(ResultSet rs) {
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

    public void updateUserName(String id, String name) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE users SET name = ? WHERE id  = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setObject(2, UUID.fromString(id));
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserValue(String id, double value) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE users SET value = ? WHERE id  = ?");
            preparedStatement.setDouble(1, value);
            preparedStatement.setObject(2, UUID.fromString(id));
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAlbumName(String id, String name) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE albums SET name = ? WHERE id  = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setObject(2, UUID.fromString(id));
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateImageLocation(String id, String location) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE images SET location = ? WHERE id  = ?");
            preparedStatement.setString(1, location);
            preparedStatement.setObject(2, UUID.fromString(id));
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String id) {
        List<Album> albums = readAlbumByUsersId(id);
        for (Album album : albums) deleteAlbum(album.getId());
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM users WHERE id = ?");
            preparedStatement.setObject(1, UUID.fromString(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAlbum(String id) {
        List<Image> images = readImagesByAlbumId(id);
        for (Image image : images) deleteImage(image.getId());
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM albums WHERE id = ?");
            preparedStatement.setObject(1, UUID.fromString(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteImage(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM images WHERE id = ?");
            preparedStatement.setObject(1, UUID.fromString(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

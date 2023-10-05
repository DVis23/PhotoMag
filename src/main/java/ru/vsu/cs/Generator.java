package ru.vsu.cs;

import java.nio.file.Path;
import java.util.*;

public class Generator {

    public static List<User> generateUsers(int count) throws Exception {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String uniqueId = UUID.randomUUID().toString();
            String uniqueName = generateRandomName();

            User user = new User(uniqueId, uniqueName, true);
            List<Album> albums = generateRandomAlbums(user.getId());
            for (int j = 0; j < albums.size(); j++) {
                user.addAlbum(albums.get(j));
            }
            //user.addAlbums(albums);
            users.add(user);
        }

        return users;
    }

    private static String generateRandomName() {
        String[] names = {"John", "Alice", "Bob", "Eva", "Alex", "Lily"};
        int randomIndex = (int) (Math.random() * names.length);
        return names[randomIndex];
    }
    private static String generateRandomAlbumName() {
        String[] names = {"000", "happy birthday", "My photo", "123", "0_0", "family", "wow"};
        int randomIndex = (int) (Math.random() * names.length);
        return names[randomIndex];
    }

    private static List<Album> generateRandomAlbums(String userId) {
        List<Album> albums = new ArrayList<>();
        Random random = new Random();
        int countAlbums = random.nextInt(6);
        if (countAlbums != 0) {
            for (int i = 0; i < countAlbums; i++) {
                Album album = new Album(userId, generateRandomAlbumName());
                List<Image> images = generateRandomImages(album.getId());
                album.addImages(images);
                albums.add(album);
            }
        }
        return albums;
    }

    private static List<Image> generateRandomImages(String albumId) {
        List<Image> images = new ArrayList<>();
        Set<Path> allPath = new HashSet<>();
        Path [] paths = {Path.of("photoBag/1.jpg"),
                Path.of("photoBag/2.jpg"),
                Path.of("photoBag/3.jpg"),
                Path.of("photoBag/4.jpg"),
                Path.of("photoBag/5.jpg"),
                Path.of("photoBag/12.jpg"),
                Path.of("photoBag/23.jpg")};
        Random random = new Random();
        int countImages = random.nextInt(8);
        if (countImages != 0) {
            for (int i = 0; i < countImages; i++) {
                Path path;
                do {
                    path = paths[(int) (Math.random() * paths.length)];
                } while (!allPath.add(path));
                Image image = new Image(albumId, path);
                images.add(image);
            }
        }
        return images;
    }
}

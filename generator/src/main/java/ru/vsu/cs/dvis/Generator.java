package ru.vsu.cs.dvis;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class Generator {

    public static List<User> generateUsers(int count) throws IOException {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String uniqueName = generateRandomName();

            String id = UUID.randomUUID().toString();
            User user = new User(id, uniqueName);
            List<Album> albums = generateRandomAlbums(user.getId());
            user.addAlbums(albums);
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

    private static List<Album> generateRandomAlbums(String userId) throws IOException {
        List<Album> albums = new ArrayList<>();
        Random random = new Random();
        int countAlbums = random.nextInt(6);
        if (countAlbums != 0) {
            for (int i = 0; i < countAlbums; i++) {
                String id = UUID.randomUUID().toString();
                Album album = new Album(id, userId, generateRandomAlbumName());
                List<Image> images = generateRandomImages(album.getId());
                album.addImages(images);
                albums.add(album);
            }
        }
        return albums;
    }

    private static List<Image> generateRandomImages(String albumId) throws IOException {
        List<Image> images = new ArrayList<>();
        Set<Path> allPath = new HashSet<>();

        Path folderPath = Paths.get("photoBag/");

        List<Path> paths = new ArrayList<>();
        Files.walkFileTree(folderPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                paths.add(file);
                return FileVisitResult.CONTINUE;
            }
        });
        Random random = new Random();
        int countImages = random.nextInt(paths.size() + 1);
        if (countImages != 0) {
            for (int i = 0; i < countImages; i++) {
                Path path;
                do {
                    path = paths.get((int) (Math.random() * paths.size()));
                } while (!allPath.add(path));
                String id = UUID.randomUUID().toString();
                Image image = new Image(id, albumId, path.toString());
                images.add(image);
            }
        }
        return images;
    }
}

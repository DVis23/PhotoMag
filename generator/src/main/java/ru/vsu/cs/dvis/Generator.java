package ru.vsu.cs.dvis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class Generator {
    private final List<String> names = new ArrayList<>();
    private final List<String> albumNames = new ArrayList<>();
    private final List<Path> paths = new ArrayList<>();

    public Generator() throws IOException {
        try {
            File file = new File("generator/list_name.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String name = scanner.nextLine();
                names.add(name);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            File file = new File("generator/list_album_name.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String albumName = scanner.nextLine();
                albumNames.add(albumName);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Path folderPath = Paths.get("photoBag/");

        Files.walkFileTree(folderPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                paths.add(file);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public List<User> generateUsers(int count) throws IOException {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String uniqueName = generateRandomName();

            UUID id = UUID.randomUUID();
            User user = new User(id, uniqueName);
            List<Album> albums = generateRandomAlbums(user.getId());
            user.addAlbums(albums);
            users.add(user);
        }

        return users;
    }

    private String generateRandomName() {
        int randomIndex = (int) (Math.random() * names.size());
        return names.get(randomIndex);
    }
    private String generateRandomAlbumName() {
        int randomIndex = (int) (Math.random() * albumNames.size());
        return albumNames.get(randomIndex);
    }

    private List<Album> generateRandomAlbums(UUID userId) throws IOException {
        List<Album> albums = new ArrayList<>();
        Random random = new Random();
        int countAlbums = random.nextInt(6);
        if (countAlbums != 0) {
            for (int i = 0; i < countAlbums; i++) {
                UUID id = UUID.randomUUID();
                Album album = new Album(id, userId, generateRandomAlbumName());
                List<Image> images = generateRandomImages(album.getId());
                album.addImages(images);
                albums.add(album);
            }
        }
        return albums;
    }

    private List<Image> generateRandomImages(UUID albumId) throws IOException {
        List<Image> images = new ArrayList<>();
        Set<Path> allPath = new HashSet<>();

        Random random = new Random();
        int countImages = random.nextInt(paths.size() + 1);
        if (countImages != 0) {
            for (int i = 0; i < countImages; i++) {
                Path path;
                do {
                    path = paths.get((int) (Math.random() * paths.size()));
                } while (!allPath.add(path));
                UUID id = UUID.randomUUID();
                Image image = new Image(id, albumId, path.toString());
                images.add(image);
            }
        }
        return images;
    }
}

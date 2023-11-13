package ru.vsu.cs.dvis;

import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    private final Scanner scanner = new Scanner(System.in);;
    private final CRUDService crudService;

    public ConsoleApplication(DataBase dataBase) {
        crudService = new CRUDService(dataBase);
    }

    public void start() {
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("1 - CREATE");
            System.out.println("2 - READE");
            System.out.println("3 - UPDATE");
            System.out.println("4 - DELETE");
            System.out.println("5 - EXIT");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                create();
            } else if (choice == 2) {
                read();
            } else if (choice == 3) {
                update();
            }else if (choice == 4){
                delete();
            } else if (choice == 5){
                break;
            } else {
                nonExistentMenu();
            }
        }
    }

    private void create() {
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("CREATE");
            System.out.println();
            System.out.println("1 - CREATE THE USER");
            System.out.println("2 - CREATE THE ALBUM");
            System.out.println("3 - CREATE THE IMAGE");
            System.out.println("4 - BACK");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                createUser();
            } else if (choice == 2) {
                createAlbum();
            } else if (choice == 3) {
                createImage();
            } else if (choice == 4) {
                break;
            } else {
                nonExistentAction();
            }
        }
    }

    private void createUser() {
        System.out.println("--------------------------------------------------------");
        System.out.println("CREATE THE USER");
        System.out.println("Enter data:");
        System.out.println();
        System.out.print("ID (UUID format): ");
        String id = scanner.next();
        System.out.println();
        System.out.print("Username: ");
        String name = scanner.next();
        System.out.println();
        System.out.print("Value: ");
        double value = scanner.nextDouble();
        System.out.println();

        User user = new User(id, name);
        user.setValue(value);
        crudService.createUser(user);
        System.out.println("User successfully created");
    }

    private void createAlbum() {
        System.out.println("--------------------------------------------------------");
        System.out.println("CREATE THE ALBUM");
        System.out.println("Enter data:");
        System.out.println();
        System.out.print("ID (UUID format): ");
        String id = scanner.next();
        System.out.println();
        System.out.print("Album name: ");
        String name = scanner.next();
        System.out.println();
        System.out.print("User-ID (UUID format): ");
        String userId = scanner.next();
        System.out.println();

        Album album = new Album(id, userId, name);
        crudService.createAlbum(album);
        System.out.println("Album successfully created");
    }

    private void createImage() {
        System.out.println("--------------------------------------------------------");
        System.out.println("CREATE THE IMAGE");
        System.out.println("Enter data:");
        System.out.println();
        System.out.print("ID (UUID format): ");
        String id = scanner.next();
        System.out.println();
        System.out.print("Location: ");
        String location = scanner.next();
        System.out.println();
        System.out.print("Album-ID (UUID format): ");
        String albumId = scanner.next();
        System.out.println();

        Image image = new Image(id, albumId, location);
        crudService.createImage(image);
        System.out.println("Image successfully created");
    }

    private void read() {
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("READ");
            System.out.println();
            System.out.println("1 - READ THE USERS");
            System.out.println("2 - READ THE ALBUMS");
            System.out.println("3 - READ THE IMAGES");
            System.out.println("4 - BACK");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                readUsers();
            } else if (choice == 2) {
                readAlbums();
            } else if (choice == 3) {
                readImages();
            } else if (choice == 4) {
                break;
            } else {
                nonExistentAction();
            }
        }
    }

    private void readUsers() {
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("READ THE USERS");
            System.out.println();
            System.out.println("1 - READ ALL THE USERS");
            System.out.println("2 - READ THE USERS BY NAME");
            System.out.println("3 - READ THE USERS BY VALUE");
            System.out.println("4 - READ THE USER BY ID");
            System.out.println("5 - BACK");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                readAllUsers();
            } else if (choice == 2) {
                readUsersByName();
            } else if (choice == 3) {
                readUsersByValue();
            } else if (choice == 4) {
                readUserById();
            } else if (choice == 5) {
                break;
            } else {
                nonExistentAction();
            }
        }
    }

    private void readAllUsers() {
        List<User> users = crudService.readAllUsers();
        for (User user : users) printUser(user, true);
    }

    private void readUsersByName() {
        System.out.println("--------------------------------------------------------");
        System.out.println("READ THE USERS BY NAME");
        System.out.println("Enter data:");
        System.out.println();
        System.out.print("Username: ");
        String name = scanner.next();
        System.out.println();

        List<User> users = crudService.readUsersByName(name);
        for (User user : users) printUser(user, true);
    }

    private void readUsersByValue() {
        System.out.println("--------------------------------------------------------");
        System.out.println("READ THE USERS BY VALUE");
        System.out.println("Enter data:");
        System.out.println();
        System.out.print("Value: ");
        double value = scanner.nextDouble();
        System.out.println();

        List<User> users = crudService.readUsersByValue(value);
        for (User user : users) printUser(user, true);
    }

    private void readUserById() {
        System.out.println("--------------------------------------------------------");
        System.out.println("READ THE USER BY ID");
        System.out.println("Enter data:");
        System.out.println();
        System.out.print("ID (UUID format): ");
        String id = scanner.next();
        System.out.println();

        User user = crudService.readUser(id);
        printUser(user, true);
    }

    private void printUser(User user, boolean whole) {
        if (user != null) {
            System.out.println("***------------------***");
            System.out.println("ID: " + user.getId());
            System.out.println("Username: " + user.getName());
            System.out.println("Value: " + user.getValue());
            if (whole) {
                System.out.println("User Albums: ");
                for (Album album : user.getAlbums()) printAlbum(album, true);
            }
            System.out.println("***------------------***");
        }
    }

    private void readAlbums() {
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("READ THE ALBUMS");
            System.out.println();
            System.out.println("1 - READ THE ALBUMS BY NAME");
            System.out.println("2 - READ THE ALBUMS BY USER-ID");
            System.out.println("3 - READ THE ALBUM BY ID");
            System.out.println("4 - BACK");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                readAlbumsByName();
            } else if (choice == 2) {
                readAlbumByUsersId();
            } else if (choice == 3) {
                readAlbumById();
            } else if (choice == 4) {
                break;
            } else {
                nonExistentAction();
            }
        }
    }

    private void readAlbumsByName() {
        System.out.println("--------------------------------------------------------");
        System.out.println("READ THE ALBUMS BY NAME");
        System.out.println("Enter data:");
        System.out.println();
        System.out.print("Album name: ");
        String name = scanner.next();
        System.out.println();

        List<Album> albums = crudService.readAlbumByName(name);
        for (Album album : albums) printAlbum(album, true);
    }

    private void readAlbumByUsersId() {
        System.out.println("--------------------------------------------------------");
        System.out.println("READ THE ALBUMS BY USER-ID");
        System.out.println("Enter data:");
        System.out.println();
        System.out.print("User-ID (UUID format): ");
        String userId = scanner.next();
        System.out.println();

        List<Album> albums = crudService.readAlbumByUsersId(userId);
        for (Album album : albums) printAlbum(album, true);
    }

    private void readAlbumById() {
        System.out.println("--------------------------------------------------------");
        System.out.println("READ THE ALBUM BY ID");
        System.out.println("Enter data:");
        System.out.println();
        System.out.print("Album-ID (UUID format): ");
        String id = scanner.next();
        System.out.println();

        Album album = crudService.readAlbum(id);
        printAlbum(album, true);
    }

    private void printAlbum(Album album, boolean whole) {
        if (album != null) {
            System.out.println("**------------**");
            System.out.println("Album-ID: " + album.getId());
            System.out.println("Album name: " + album.getName());
            System.out.println("User-ID: " + album.getUserId());
            if (whole) {
                System.out.println("Album Images: ");
                for (Image image : album.getImages()) printImage(image);
            }
            System.out.println("**------------**");
        }
    }

    private void readImages() {
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("READ THE IMAGES");
            System.out.println();
            System.out.println("1 - READ THE IMAGES BY LOCATION");
            System.out.println("2 - READ THE IMAGES BY ALBUM-ID");
            System.out.println("3 - READ THE IMAGE BY ID");
            System.out.println("4 - BACK");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                readImagesByLocation();
            } else if (choice == 2) {
                readImagesByAlbumsId();
            } else if (choice == 3) {
                readImageById();
            } else if (choice == 4) {
                break;
            } else {
                nonExistentAction();
            }
        }
    }

    private void readImagesByLocation() {
        System.out.println("--------------------------------------------------------");
        System.out.println("READ THE IMAGES BY LOCATION");
        System.out.println("Enter data:");
        System.out.println();
        System.out.print("Location: ");
        String location = scanner.next();
        System.out.println();

        List<Image> images = crudService.readImagesByLocation(location);
        for (Image image : images) printImage(image);
    }

    private void readImagesByAlbumsId() {
        System.out.println("--------------------------------------------------------");
        System.out.println("READ THE IMAGES BY ALBUM-ID");
        System.out.println("Enter data:");
        System.out.println();
        System.out.print("User-ID (UUID format): ");
        String albumId = scanner.next();
        System.out.println();

        List<Image> images = crudService.readImagesByAlbumId(albumId);
        for (Image image : images) printImage(image);
    }

    private void readImageById() {
        System.out.println("--------------------------------------------------------");
        System.out.println("READ THE IMAGE BY ID");
        System.out.println("Enter data:");
        System.out.println();
        System.out.print("ID (UUID format): ");
        String id = scanner.next();
        System.out.println();

        Image image = crudService.readImage(id);
        printImage(image);
    }

    private void printImage(Image image) {
        if (image != null) {
            System.out.println("*------*");
            System.out.println("Image-ID: " + image.getId());
            System.out.println("Location: " + image.getLocation());
            System.out.println("Album-ID: " + image.getAlbumId());
            System.out.println("*------*");
        }
    }

    private void update() {
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("UPDATE");
            System.out.println();
            System.out.println("1 - UPDATE THE USER");
            System.out.println("2 - UPDATE THE ALBUM");
            System.out.println("3 - UPDATE THE IMAGE");
            System.out.println("4 - BACK");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                updateUser();
            } else if (choice == 2) {
                updateAlbum();
            } else if (choice == 3) {
                updateImage();
            } else if (choice == 4) {
                break;
            } else {
                nonExistentAction();
            }
        }
    }

    private void updateUser() {
        System.out.println("--------------------------------------------------------");
        System.out.println("UPDATE THE USER");
        System.out.print("Enter the ID (UUID format): ");
        String id = scanner.next();
        while (true) {
            printUser(crudService.readUser(id), false);
            System.out.println();
            System.out.println("1 - UPDATE THE USERNAME");
            System.out.println("2 - UPDATE THE VALUE");
            System.out.println("3 - BACK");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Enter the new username: ");
                String name = scanner.next();
                crudService.updateUserName(id, name);
            } else if (choice == 2) {
                System.out.print("Enter the new value: ");
                double value = scanner.nextDouble();
                crudService.updateUserValue(id, value);
            } else if (choice == 3) {
                break;
            }  else {
                nonExistentAction();
            }
        }
    }

    private void updateAlbum() {
        System.out.println("--------------------------------------------------------");
        System.out.println("UPDATE THE ALBUM");
        System.out.print("Enter the ID (UUID format): ");
        String id = scanner.next();
        while (true) {
            printAlbum(crudService.readAlbum(id), false);
            System.out.println();
            System.out.println("1 - UPDATE THE ALBUM NAME");
            System.out.println("2 - BACK");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Enter the new album name: ");
                String name = scanner.next();
                crudService.updateAlbumName(id, name);
            }  else if (choice == 2) {
                break;
            }  else {
                nonExistentAction();
            }
        }
    }

    private void updateImage() {
        System.out.println("--------------------------------------------------------");
        System.out.println("UPDATE THE IMAGE");
        System.out.print("Enter the ID (UUID format): ");
        String id = scanner.next();
        while (true) {
            printImage(crudService.readImage(id));
            System.out.println();
            System.out.println("1 - UPDATE THE LOCATION");
            System.out.println("2 - BACK");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Enter the new location: ");
                String location = scanner.next();
                crudService.updateImageLocation(id, location);
            }  else if (choice == 2) {
                break;
            }  else {
                nonExistentAction();
            }
        }
    }

    private void delete() {
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("DELETE");
            System.out.println();
            System.out.println("1 - DELETE THE USER");
            System.out.println("2 - DELETE THE ALBUM");
            System.out.println("3 - DELETE THE IMAGE");
            System.out.println("4 - BACK");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                deleteUser();
            } else if (choice == 2) {
                deleteAlbum();
            } else if (choice == 3) {
                deleteImage();
            } else if (choice == 4) {
                break;
            } else {
                nonExistentAction();
            }
        }
    }

    private void deleteUser() {
        System.out.println("--------------------------------------------------------");
        System.out.println("DELETE THE USER");
        System.out.print("Enter the ID (UUID format): ");
        String id = scanner.next();
        printUser(crudService.readUser(id), false);
        while (true) {
            System.out.println();
            System.out.println("1 - DELETE");
            System.out.println("2 - BACK");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                crudService.deleteUser(id);
                break;
            } else if (choice == 2) {
                break;
            }  else {
                nonExistentAction();
            }
        }
    }

    private void deleteAlbum() {
        System.out.println("--------------------------------------------------------");
        System.out.println("DELETE THE ALBUM");
        System.out.print("Enter the ID (UUID format): ");
        String id = scanner.next();
        printAlbum(crudService.readAlbum(id), false);
        while (true) {
            System.out.println();
            System.out.println("1 - DELETE");
            System.out.println("2 - BACK");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                crudService.deleteAlbum(id);
                break;
            } else if (choice == 2) {
                break;
            }  else {
                nonExistentAction();
            }
        }
    }

    private void deleteImage() {
        System.out.println("--------------------------------------------------------");
        System.out.println("DELETE THE IMAGE");
        System.out.print("Enter the ID (UUID format): ");
        String id = scanner.next();
        printImage(crudService.readImage(id));
        while (true) {
            System.out.println();
            System.out.println("1 - DELETE");
            System.out.println("2 - BACK");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                crudService.deleteImage(id);
                break;
            } else if (choice == 2) {
                break;
            }  else {
                nonExistentAction();
            }
        }
    }

    private void nonExistentAction() {
        System.out.println("ERROR: A NON-EXISTENT ACTION HAS BEEN SELECTED");
        System.out.println();
    }

    private void nonExistentMenu() {
        System.out.println("ERROR: A NON-EXISTENT MENU HAS BEEN SELECTED");
        System.out.println();
    }

}

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
            System.out.println("Выберите действие:");
            System.out.println();
            System.out.println("1 - СОЗДАТЬ;");
            System.out.println("2 - ПРОЧИТАТЬ;");
            System.out.println("3 - ИЗМЕНИТЬ;");
            System.out.println("4 - УДАЛИТЬ;");
            System.out.println("5 - ВЫЙТИ.");
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
                System.out.println("ОШИБКА: ВЫБРАНО НЕСУЩЕСТВУЮЩЕЕ МЕНЮ");
                System.out.println();
            }
            System.out.println("--------------------------------------------------------");
        }
    }

    private void create() {
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("СОЗДАТЬ;");
            System.out.println("Выберите действие:");
            System.out.println();
            System.out.println("1 - СОЗДАТЬ ПОЛЬЗОВАТЕЛЯ;");
            System.out.println("2 - СОЗДАТЬ АЛЬБОМ;");
            System.out.println("3 - СОЗДАТЬ ИЗОБРАЖЕНИЕ;");
            System.out.println("4 - НАЗАД.");
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
                System.out.println("ОШИБКА: ВЫБРАНО НЕСУЩЕСТВУЮЩЕЕ ДЕЙСТВИЕ");
                System.out.println();
            }
            System.out.println("--------------------------------------------------------");
        }
    }

    private void createUser() {
        System.out.println("--------------------------------------------------------");
        System.out.println("СОЗДАТЬ ПОЛЬЗОВАТЕЛЯ;");
        System.out.println("Введите данные:");
        System.out.println();
        System.out.print("ID (формат UUID): ");
        String id = scanner.next();
        System.out.println();
        System.out.print("Имя пользователя: ");
        String name = scanner.next();
        System.out.println();
        System.out.print("Баланс пользователя: ");
        double value = scanner.nextDouble();
        System.out.println();

        User user = new User(id, name);
        user.setValue(value);
        crudService.createUser(user);
        System.out.println("Пользователь успешно создан");
        System.out.println("--------------------------------------------------------");
    }

    private void createAlbum() {
        System.out.println("--------------------------------------------------------");
        System.out.println("СОЗДАТЬ АЛЬБОМ;");
        System.out.println("Введите данные:");
        System.out.println();
        System.out.print("ID (формат UUID): ");
        String id = scanner.next();
        System.out.println();
        System.out.print("Имя альбома: ");
        String name = scanner.next();
        System.out.println();
        System.out.print("ID пользователя (формат UUID): ");
        String userId = scanner.next();
        System.out.println();

        Album album = new Album(id, userId, name);
        crudService.createAlbum(album);
        System.out.println("Альбом успешно создан");
        System.out.println("--------------------------------------------------------");
    }

    private void createImage() {
        System.out.println("--------------------------------------------------------");
        System.out.println("СОЗДАТЬ ИЗОБРАЖЕНИЕ;");
        System.out.println("Введите данные:");
        System.out.println();
        System.out.print("ID (формат UUID): ");
        String id = scanner.next();
        System.out.println();
        System.out.print("Место расположения: ");
        String location = scanner.next();
        System.out.println();
        System.out.print("ID альбома (формат UUID): ");
        String albumId = scanner.next();
        System.out.println();

        Image image = new Image(id, albumId, location);
        crudService.createImage(image);
        System.out.println("Изображение успешно создано");
        System.out.println("--------------------------------------------------------");
    }

    private void read() {
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("ПРОЧИТАТЬ");
            System.out.println("Выберите действие:");
            System.out.println();
            System.out.println("1 - ПРОЧИТАТЬ ПОЛЬЗОВАТЕЛЕЙ;");
            System.out.println("2 - ПРОЧИТАТЬ АЛЬБОМЫ;");
            System.out.println("3 - ПРОЧИТАТЬ ИЗОБРАЖЕНИЯ;");
            System.out.println("4 - НАЗАД.");
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
                System.out.println("ОШИБКА: ВЫБРАНО НЕСУЩЕСТВУЮЩЕЕ ДЕЙСТВИЕ");
                System.out.println();
            }
            System.out.println("--------------------------------------------------------");
        }
    }

    private void readUsers() {
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("ПРОЧИТАТЬ ПОЛЬЗОВАТЕЛЕЙ;");
            System.out.println("Выберите действие:");
            System.out.println();
            System.out.println("1 - ПРОЧИТАТЬ ВСЕХ ПОЛЬЗОВАТЕЛЕЙ;");
            System.out.println("2 - ПРОЧИТАТЬ ПОЛЬЗОВАТЕЛЕЙ ПО ИМЕНИ;");
            System.out.println("3 - ПРОЧИТАТЬ ПОЛЬЗОВАТЕЛЕЙ ПО БАЛАНСУ;");
            System.out.println("4 - ПРОЧИТАТЬ ПОЛЬЗОВАТЕЛЯ ПО ID;");
            System.out.println("5 - НАЗАД.");
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
                System.out.println("ОШИБКА: ВЫБРАНО НЕСУЩЕСТВУЮЩЕЕ ДЕЙСТВИЕ");
                System.out.println();
            }
            System.out.println("--------------------------------------------------------");
        }
    }

    private void readAllUsers() {
        List<User> users = crudService.readAllUsers();
        for (User user : users) printUser(user, true);
    }

    private void readUsersByName() {
        System.out.println("--------------------------------------------------------");
        System.out.println("ПРОЧИТАТЬ ПОЛЬЗОВАТЕЛЕЙ ПО ИМЕНИ;");
        System.out.println("Введите данные:");
        System.out.println();
        System.out.print("Имя пользователя: ");
        String name = scanner.next();
        System.out.println();

        List<User> users = crudService.readUsersByName(name);
        for (User user : users) printUser(user, true);
        System.out.println("--------------------------------------------------------");
    }

    private void readUsersByValue() {
        System.out.println("--------------------------------------------------------");
        System.out.println("ПРОЧИТАТЬ ПОЛЬЗОВАТЕЛЕЙ ПО БАЛАНСУ;");
        System.out.println("Введите данные:");
        System.out.println();
        System.out.print("Баланс пользователя: ");
        double value = scanner.nextDouble();
        System.out.println();

        List<User> users = crudService.readUsersByValue(value);
        for (User user : users) printUser(user, true);
        System.out.println("--------------------------------------------------------");
    }

    private void readUserById() {
        System.out.println("--------------------------------------------------------");
        System.out.println("ПРОЧИТАТЬ ПОЛЬЗОВАТЕЛЯ ПО ID;");
        System.out.println("Введите данные:");
        System.out.println();
        System.out.print("ID (формат UUID): ");
        String id = scanner.next();
        System.out.println();

        User user = crudService.readUser(id);
        printUser(user, true);
        System.out.println("--------------------------------------------------------");
    }

    private void printUser(User user, boolean whole) {
        System.out.println("***------------------***");
        System.out.println("ID: " + user.getId());
        System.out.println("Имя пользователя: " + user.getName());
        System.out.println("Баланс: " + user.getValue());
        if (whole) {
            System.out.println("Альбомы пользователя: ");
            for (Album album : user.getAlbums()) printAlbum(album, true);
        }
        System.out.println("***------------------***");
    }

    private void readAlbums() {
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("ПРОЧИТАТЬ АЛЬБОМЫ;");
            System.out.println("Выберите действие:");
            System.out.println();
            System.out.println("1 - ПРОЧИТАТЬ АЛЬБОМЫ ПО ИМЕНИ;");
            System.out.println("2 - ПРОЧИТАТЬ АЛЬБОМЫ ПО ID ПОЛЬЗОВАТЕЛЯ;");
            System.out.println("3 - ПРОЧИТАТЬ АЛЬБОМ ПО ID;");
            System.out.println("4 - НАЗАД.");
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
                System.out.println("ОШИБКА: ВЫБРАНО НЕСУЩЕСТВУЮЩЕЕ ДЕЙСТВИЕ");
                System.out.println();
            }
            System.out.println("--------------------------------------------------------");
        }
    }

    private void readAlbumsByName() {
        System.out.println("--------------------------------------------------------");
        System.out.println("ПРОЧИТАТЬ АЛЬБОМЫ ПО ИМЕНИ;");
        System.out.println("Введите данные:");
        System.out.println();
        System.out.print("Имя альбома: ");
        String name = scanner.next();
        System.out.println();

        List<Album> albums = crudService.readAlbumByName(name);
        for (Album album : albums) printAlbum(album, true);
        System.out.println("--------------------------------------------------------");
    }

    private void readAlbumByUsersId() {
        System.out.println("--------------------------------------------------------");
        System.out.println("ПРОЧИТАТЬ АЛЬБОМЫ ПО ID ПОЛЬЗОВАТЕЛЯ;");
        System.out.println("Введите данные:");
        System.out.println();
        System.out.print("ID пользователя (формат UUID): ");
        String userId = scanner.next();
        System.out.println();

        List<Album> albums = crudService.readAlbumByUsersId(userId);
        for (Album album : albums) printAlbum(album, true);
        System.out.println("--------------------------------------------------------");
    }

    private void readAlbumById() {
        System.out.println("--------------------------------------------------------");
        System.out.println("ПРОЧИТАТЬ АЛЬБОМ ПО ID;");
        System.out.println("Введите данные:");
        System.out.println();
        System.out.print("ID (формат UUID): ");
        String id = scanner.next();
        System.out.println();

        Album album = crudService.readAlbum(id);
        printAlbum(album, true);
        System.out.println("--------------------------------------------------------");
    }

    private void printAlbum(Album album, boolean whole) {
        if (album != null) {
            System.out.println("**------------**");
            System.out.println("ID: " + album.getId());
            System.out.println("Имя альбома: " + album.getName());
            System.out.println("ID пользователя: " + album.getUserId());
            if (whole) {
                System.out.println("Изображения в альбоме: ");
                for (Image image : album.getImages()) printImage(image);
                System.out.println("**------------**");
            }
        }
    }

    private void readImages() {
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("ПРОЧИТАТЬ ИЗОБРАЖЕНИЯ;");
            System.out.println("Выберите действие:");
            System.out.println();
            System.out.println("1 - ПРОЧИТАТЬ ИЗОБРАЖЕНИЯ ПО МЕСТУ РАСПОЛОЖЕНИЯ;");
            System.out.println("2 - ПРОЧИТАТЬ ИЗОБРАЖЕНИЯ ПО ID АЛЬБОМА;");
            System.out.println("3 - ПРОЧИТАТЬ ИЗОБРАЖЕНИЕ ПО ID;");
            System.out.println("4 - НАЗАД.");
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
                System.out.println("ОШИБКА: ВЫБРАНО НЕСУЩЕСТВУЮЩЕЕ ДЕЙСТВИЕ");
                System.out.println();
            }
            System.out.println("--------------------------------------------------------");
        }
    }

    private void readImagesByLocation() {
        System.out.println("--------------------------------------------------------");
        System.out.println("ПРОЧИТАТЬ ИЗОБРАЖЕНИЯ ПО МЕСТУ РАСПОЛОЖЕНИЯ;");
        System.out.println("Введите данные:");
        System.out.println();
        System.out.print("Место расположения: ");
        String location = scanner.next();
        System.out.println();

        List<Image> images = crudService.readImagesByLocation(location);
        for (Image image : images) printImage(image);
        System.out.println("--------------------------------------------------------");
    }

    private void readImagesByAlbumsId() {
        System.out.println("--------------------------------------------------------");
        System.out.println("ПРОЧИТАТЬ ИЗОБРАЖЕНИЯ ПО ID АЛЬБОМА;");
        System.out.println("Введите данные:");
        System.out.println();
        System.out.print("ID пользователя (формат UUID): ");
        String albumId = scanner.next();
        System.out.println();

        List<Image> images = crudService.readImagesByAlbumId(albumId);
        for (Image image : images) printImage(image);
        System.out.println("--------------------------------------------------------");
    }

    private void readImageById() {
        System.out.println("--------------------------------------------------------");
        System.out.println("ПРОЧИТАТЬ ИЗОБРАЖЕНИЕ ПО ID;");
        System.out.println("Введите данные:");
        System.out.println();
        System.out.print("ID (формат UUID): ");
        String id = scanner.next();
        System.out.println();

        Image image = crudService.readImage(id);
        printImage(image);
        System.out.println("--------------------------------------------------------");
    }

    private void printImage(Image image) {
        if (image != null) {
            System.out.println("*------*");
            System.out.println("ID: " + image.getId());
            System.out.println("Место расположения: " + image.getLocation());
            System.out.println("ID альбома: " + image.getAlbumId());
            System.out.println("*------*");
        }
    }

    private void update() {
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("ИЗМЕНИТЬ");
            System.out.println("Выберите действие:");
            System.out.println();
            System.out.println("1 - ИЗМЕНИТЬ ПОЛЬЗОВАТЕЛЯ;");
            System.out.println("2 - ИЗМЕНИТЬ АЛЬБОМ;");
            System.out.println("3 - ИЗМЕНИТЬ ИЗОБРАЖЕНИЕ;");
            System.out.println("4 - НАЗАД.");
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
                System.out.println("ОШИБКА: ВЫБРАНО НЕСУЩЕСТВУЮЩЕЕ ДЕЙСТВИЕ");
                System.out.println();
            }
            System.out.println("--------------------------------------------------------");
        }
    }

    private void updateUser() {
        System.out.println("--------------------------------------------------------");
        System.out.println("ИЗМЕНИТЬ ПОЛЬЗОВАТЕЛЯ;");
        System.out.print("Введите ID (формат UUID):");
        String id = scanner.next();
        while (true) {
            printUser(crudService.readUser(id), false);
            System.out.println("Выберите действие:");
            System.out.println();
            System.out.println("1 - ИЗМЕНИТЬ ИМЯ;");
            System.out.println("2 - ИЗМЕНИТЬ БАЛАНС;");
            System.out.println("3 - НАЗАД.");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Введите новое имя: ");
                String name = scanner.next();
                crudService.updateUserName(id, name);
            } else if (choice == 2) {
                System.out.println("Введите новый баланс: ");
                double value = scanner.nextDouble();
                crudService.updateUserValue(id, value);
            } else if (choice == 3) {
                break;
            }  else {
                System.out.println("ОШИБКА: ВЫБРАНО НЕСУЩЕСТВУЮЩЕЕ ДЕЙСТВИЕ");
                System.out.println();
            }
        }
        System.out.println("--------------------------------------------------------");
    }

    private void updateAlbum() {
        System.out.println("--------------------------------------------------------");
        System.out.println("ИЗМЕНИТЬ АЛЬБОМ;");
        System.out.print("Введите ID (формат UUID):");
        String id = scanner.next();
        while (true) {
            printAlbum(crudService.readAlbum(id), false);
            System.out.println("Выберите действие:");
            System.out.println();
            System.out.println("1 - ИЗМЕНИТЬ ИМЯ;");
            System.out.println("2 - НАЗАД.");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Введите новое имя: ");
                String name = scanner.next();
                crudService.updateAlbumName(id, name);
            }  else if (choice == 2) {
                break;
            }  else {
                System.out.println("ОШИБКА: ВЫБРАНО НЕСУЩЕСТВУЮЩЕЕ ДЕЙСТВИЕ");
                System.out.println();
            }
        }
        System.out.println("--------------------------------------------------------");
    }

    private void updateImage() {
        System.out.println("--------------------------------------------------------");
        System.out.println("ИЗМЕНИТЬ ИЗОБРАЖЕНИЕ;");
        System.out.print("Введите ID (формат UUID):");
        String id = scanner.next();
        while (true) {
            printImage(crudService.readImage(id));
            System.out.println("Выберите действие:");
            System.out.println();
            System.out.println("1 - ИЗМЕНИТЬ МЕСТО РАСПОЛОЖЕНИЯ;");
            System.out.println("2 - НАЗАД.");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Введите новое имя: ");
                String location = scanner.next();
                crudService.updateImageLocation(id, location);
            }  else if (choice == 2) {
                break;
            }  else {
                System.out.println("ОШИБКА: ВЫБРАНО НЕСУЩЕСТВУЮЩЕЕ ДЕЙСТВИЕ");
                System.out.println();
            }
        }
        System.out.println("--------------------------------------------------------");
    }

    private void delete() {
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("УДАЛИТЬ");
            System.out.println("Выберите действие:");
            System.out.println();
            System.out.println("1 - УДАЛИТЬ ПОЛЬЗОВАТЕЛЯ;");
            System.out.println("2 - УДАЛИТЬ АЛЬБОМ;");
            System.out.println("3 - УДАЛИТЬ ИЗОБРАЖЕНИЕ;");
            System.out.println("4 - НАЗАД.");
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
                System.out.println("ОШИБКА: ВЫБРАНО НЕСУЩЕСТВУЮЩЕЕ ДЕЙСТВИЕ");
                System.out.println();
            }
            System.out.println("--------------------------------------------------------");
        }
    }

    private void deleteUser() {
        System.out.println("--------------------------------------------------------");
        System.out.println("УДАЛИТЬ ПОЛЬЗОВАТЕЛЯ;");
        System.out.print("Введите ID (формат UUID):");
        String id = scanner.next();
        printUser(crudService.readUser(id), false);
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println();
            System.out.println("1 - УДАЛИТЬ;");
            System.out.println("2 - НАЗАД.");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                crudService.deleteUser(id);
                System.out.println("Пользователь успешно удален");
                break;
            } else if (choice == 2) {
                break;
            }  else {
                System.out.println("ОШИБКА: ВЫБРАНО НЕСУЩЕСТВУЮЩЕЕ ДЕЙСТВИЕ");
                System.out.println();
            }
        }
        System.out.println("--------------------------------------------------------");
    }

    private void deleteAlbum() {
        System.out.println("--------------------------------------------------------");
        System.out.println("УДАЛИТЬ АЛЬБОМ;");
        System.out.print("Введите ID (формат UUID):");
        String id = scanner.next();
        printAlbum(crudService.readAlbum(id), false);
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println();
            System.out.println("1 - УДАЛИТЬ;");
            System.out.println("2 - НАЗАД.");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                crudService.deleteAlbum(id);
                System.out.println("Альбом успешно удален");
                break;
            } else if (choice == 2) {
                break;
            }  else {
                System.out.println("ОШИБКА: ВЫБРАНО НЕСУЩЕСТВУЮЩЕЕ ДЕЙСТВИЕ");
                System.out.println();
            }
        }
        System.out.println("--------------------------------------------------------");
    }

    private void deleteImage() {
        System.out.println("--------------------------------------------------------");
        System.out.println("УДАЛИТЬ ИЗОБРАЖЕНИЕ;");
        System.out.print("Введите ID (формат UUID):");
        String id = scanner.next();
        printImage(crudService.readImage(id));
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println();
            System.out.println("1 - УДАЛИТЬ;");
            System.out.println("2 - НАЗАД.");
            System.out.println();
            int choice = scanner.nextInt();
            if (choice == 1) {
                crudService.deleteImage(id);
                System.out.println("Изображение успешно удален");
                break;
            } else if (choice == 2) {
                break;
            }  else {
                System.out.println("ОШИБКА: ВЫБРАНО НЕСУЩЕСТВУЮЩЕЕ ДЕЙСТВИЕ");
                System.out.println();
            }
        }
        System.out.println("--------------------------------------------------------");
    }

}

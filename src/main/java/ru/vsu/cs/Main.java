package ru.vsu.cs;

import ru.vsu.cs.tools.Brush;
import ru.vsu.cs.tools.brushes.Align;

import java.util.List;

public class Main {

    public static void printUser(User user) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Id: " + user.getId());
        System.out.println("User: " + user.getName());
        System.out.println(user.getValue());
        List<Album> albums = user.getAlbums();
        System.out.println(albums.size());
        for (Album item : albums) {
            System.out.println();
            System.out.println();
            System.out.println("Album: " + item.getName());
            System.out.println(item.getId());
            System.out.println(item.getUserId());

            List<Image> images = item.getImageList();
            for (Image value : images) {
                System.out.println();
                System.out.println(value.getLocation());
                System.out.println(value.getUserId());
                System.out.println(value.getId());
                System.out.println(value.getDataTime());
            }
        }
    }

    public static void main(String [] args) throws Exception {
        List<User> users = Generator.generateUsers(10);
        for (User user : users) {
            printUser(user);
        }
    }
}

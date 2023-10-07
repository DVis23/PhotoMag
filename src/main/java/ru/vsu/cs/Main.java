package ru.vsu.cs;

import ru.vsu.cs.tools.Sliders;
import ru.vsu.cs.tools.brushes.Align;
import ru.vsu.cs.tools.brushes.Lighten;
import ru.vsu.cs.tools.framing.Crop;
import ru.vsu.cs.tools.framing.Respective;
import ru.vsu.cs.tools.framing.Rotate;
import ru.vsu.cs.tools.sliders.Bright;
import ru.vsu.cs.tools.sliders.Contrast;
import ru.vsu.cs.tools.sliders.Saturation;

import java.util.List;
import java.util.Map;

public class Main {

    public static void printUser(User user) {
        System.out.println();
        System.out.println("-------------------------------------User------------------------------------------------");
        System.out.println("Username: " + user.getName());
        System.out.println("Id: " + user.getId());
        System.out.println("Value " + user.getValue());
        List<Album> albums = user.getAlbums();
        System.out.println("------------Albums------------");
        for (Album album : albums) {
            System.out.println("-------Album-------");
            System.out.println("Name of album: " + album.getName());
            System.out.println("Id: " + album.getId());
            System.out.println("User id: " + album.getUserId());
            List<Image> images = album.getImageList();
            for (Image image : images) {
                System.out.println("-Image-");
                System.out.println("Location: " + image.getLocation());
                System.out.println("Id: " + image.getId());
                System.out.println("Album id: " + image.getAlbumId());
                System.out.println("Date" + image.getDateTime());
            }
        }
        List<Tool> tools = user.tools;
        System.out.println("------------Tools-------------");
        for (Tool tool : tools) {
            System.out.println("-Tool-");
            System.out.println("Type: " + tool.getType());
            System.out.println("Id: " + tool.getId());
            Map<String, Object> parameters = tool.getParameters();
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                System.out.println(key + ": " + value);
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

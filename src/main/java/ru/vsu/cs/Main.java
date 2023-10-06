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
            if (tool instanceof Sliders) {
                Sliders sliders= (Sliders) tool;
                System.out.println("Value: " + sliders.getValue());
            } else if (tool instanceof Align) {
                Align align = (Align) tool;
                System.out.println("x: " + align.getX() + "; y: " + align.getY());
            } else if (tool instanceof Lighten) {
                Lighten lighten = (Lighten) tool;
                System.out.println("x: " + lighten.getX() + "; y: " + lighten.getY());
                System.out.println("Value: " + lighten.getValue());
            } else if (tool instanceof Crop) {
                Crop crop = (Crop) tool;
                System.out.println("x1: " + crop.getX1() + "; y1: " + crop.getY1());
                System.out.println("x2: " + crop.getX2() + "; y2: " + crop.getY2());
                System.out.println("x3: " + crop.getX3() + "; y3: " + crop.getY3());
                System.out.println("x4: " + crop.getX4() + "; y4: " + crop.getY4());
                System.out.println("Deformation is " + crop.isDeformation());
            } else if (tool instanceof Respective) {
                Respective respective = (Respective) tool;
                System.out.println("x: " + respective.getX() + "; y: " + respective.getY() + "; z: " + respective.getZ());
            } else if (tool instanceof Rotate) {
                Rotate rotate = (Rotate) tool;
                System.out.println("Angel: " + rotate.getAngel());
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

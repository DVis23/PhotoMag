package ru.vsu.cs;

import ru.vsu.cs.tools.Brush;
import ru.vsu.cs.tools.brushes.Align;

import java.util.List;

public class Main {

    public static void printUser(User user) {
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getValue());
    }

    public static void main(String [] args) {
        List<User> users = Generator.generateUsers(1000000);
        for (User user : users) {
            printUser(user);
        }
    }
}

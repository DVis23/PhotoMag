package ru.vsu.cs.dvis;

import java.util.List;

public class DataBaseFilling {

    public static void filling(DataBaseService dataBaseService, List<User> users) {
        for (User user : users) {
            dataBaseService.insertUser(user);
        }
    }
}

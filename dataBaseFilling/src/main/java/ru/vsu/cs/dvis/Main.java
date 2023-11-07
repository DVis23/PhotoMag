package ru.vsu.cs.dvis;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        UserWriterJson.writeUsers(users, "jsonfile/users.json");
        DataBaseService dataBaseService = new DataBaseService();
        DataBaseFilling.filling(dataBaseService, users);
    }
}

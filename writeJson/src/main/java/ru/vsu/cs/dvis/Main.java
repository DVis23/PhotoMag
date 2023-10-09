package ru.vsu.cs.dvis;

import java.io.IOException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        List<User> users = Generator.generateUsers(1000);
        String jsonFile = "jsonfile/users.json";
        WriteJson.writeUsers(users, jsonFile);

    }
}

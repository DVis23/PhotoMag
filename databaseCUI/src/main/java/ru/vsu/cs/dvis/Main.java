package ru.vsu.cs.dvis;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Generator generator = new Generator();
        List<User> users = generator.generateUsers(20);
        UserWriterJson.writeUsers(users, "jsonfile/users.json");
        List<User> userFromJson = UserReaderJson.readUsers("jsonfile/users.json");
        DataBase dataBase = new DataBase();
        CRUDService crudService = new CRUDService(dataBase);
        crudService.createUsers(userFromJson);
        ConsoleApplication consoleApplication = new ConsoleApplication(dataBase);
        consoleApplication.start();

    }
}

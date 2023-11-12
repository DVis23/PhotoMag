package ru.vsu.cs.dvis;

import java.util.List;

public class DataBaseFilling {

    public static void filling(DataBase dataBase, List<User> users) {
        for (User user : users) {
            CRUDService crudService = new CRUDService(dataBase);
            crudService.insertUser(user);
        }
    }
}

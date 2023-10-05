package ru.vsu.cs;

import java.util.*;

public class Generator {

    public static List<User> generateUsers(int count) {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String uniqueId = UUID.randomUUID().toString();
            String uniqueName = generateRandomName(); // Метод для генерации уникального имени

            User user = new User(uniqueId, uniqueName);
            users.add(user);
        }

        return users;
    }

    private static String generateRandomName() {
        // Здесь может быть логика для генерации случайных имен пользователей
        // Например, можно использовать массив имен и случайным образом выбирать из него
        String[] names = {"John", "Alice", "Bob", "Eva", "Alex", "Lily"};
        int randomIndex = (int) (Math.random() * names.length);
        return names[randomIndex];
    }
}

package ru.vsu.cs.dvis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserWriterJson {

    public static void writeUsers(List<User> users, String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(new File(filename), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

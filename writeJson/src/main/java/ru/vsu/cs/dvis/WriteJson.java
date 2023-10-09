package ru.vsu.cs.dvis;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class WriteJson {

    public static void writeUsers(List<User> users, String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        SimpleModule module = new SimpleModule();
        module.addSerializer(Path.class, new PathSerializer());
        objectMapper.registerModule(module);

        try {
            objectMapper.writeValue(new File(filename), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Собственный сериализатор для Path
    public static class PathSerializer extends JsonSerializer<Path> {
        @Override
        public void serialize(Path value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }
}

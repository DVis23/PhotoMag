package ru.vsu.cs.dvis;

import org.flywaydb.core.Flyway;

import java.sql.*;
import java.util.UUID;

public class DataBase {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/photo_mag";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "1111";

    private Connection connection;

    public DataBase() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            Flyway flyway = Flyway.configure().dataSource(DB_URL, DB_USER, DB_PASSWORD).load();
            flyway.baseline();
            flyway.migrate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

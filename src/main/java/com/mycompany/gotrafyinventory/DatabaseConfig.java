package com.mycompany.gotrafyinventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConfig {
    private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/trafy_inventory";
    private static final String DEFAULT_USER = "root";

    private DatabaseConfig() {
    }

    private static String firstNonBlank(String... values) {
        for (String value : values) {
            if (value != null && !value.isBlank()) {
                return value;
            }
        }
        return null;
    }

    public static Connection getConnection() throws SQLException {
        String url = firstNonBlank(
            System.getProperty("db.url"),
            System.getenv("DB_URL"),
            DEFAULT_URL
        );

        String user = firstNonBlank(
            System.getProperty("db.user"),
            System.getenv("DB_USER"),
            DEFAULT_USER
        );

        String password = firstNonBlank(
            System.getProperty("db.password"),
            System.getenv("DB_PASSWORD"),
            System.getenv("MYSQL_PWD")
        );

        if (password == null) {
            password = "";
        }

        return DriverManager.getConnection(url, user, password);
    }
}

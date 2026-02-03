package com.mycompany.waktuku.util;

import java.nio.file.Path;
import java.sql.*;

public class DatabaseHelper {

    private static final String URL = "jdbc:sqlite:waktuku.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initDatabase() {

        String createSession = """
            CREATE TABLE IF NOT EXISTS pomodoro_session (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                start_time TEXT,
                end_time TEXT,
                status TEXT
            );
        """;

        String createInterval = """
            CREATE TABLE IF NOT EXISTS pomodoro_interval (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                session_id INTEGER,
                type TEXT,
                start_time TEXT,
                end_time TEXT,
                duration INTEGER,
                extended INTEGER DEFAULT 0,
                FOREIGN KEY(session_id) REFERENCES pomodoro_session(id)
            );
        """;
        String Change_Backround="""
                Create Tabel If Not EXISTS Backround(
                Path Text ;
                );
                """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(createSession);
            stmt.execute(createInterval);

            System.out.println("Database & tabel siap.");

        } catch (Exception e) {
            System.out.println("Init DB gagal: " + e.getMessage());
        }
    }
}

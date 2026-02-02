package com.mycompany.waktuku.dao;

import com.mycompany.waktuku.util.DatabaseHelper;
import java.sql.Connection;
import java.sql.Statement;

public class Dao_Pomodoro_History {

    public void createTable() {
        String sql =
            "CREATE TABLE IF NOT EXISTS pomodoro_history (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "hari TEXT," +
            "mulai INTEGER," +
            "berhenti INTEGER," +
            "status TEXT" +
            ");";

        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Tabel pomodoro_history siap.");

        } catch (Exception e) {
            System.out.println("Gagal buat tabel: " + e.getMessage());
        }
    }
}

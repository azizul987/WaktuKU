package com.mycompany.waktuku.dao;

import com.mycompany.waktuku.util.DatabaseHelper;
import java.sql.*;

public class PomodoroIntervalDAO {

    // Mulai kerja atau istirahat
    public int startInterval(int sessionId, String type) {
        String sql = "INSERT INTO pomodoro_interval(session_id, type, start_time) VALUES(?,?,datetime('now'))";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, sessionId);
            stmt.setString(2, type);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // interval_id
            }

        } catch (Exception e) {
            System.out.println("Gagal start interval: " + e.getMessage());
        }

        return -1;
    }

    // Hentikan interval (kerja atau istirahat)
    public void endInterval(int intervalId, boolean extended) {
        String sql = """
            UPDATE pomodoro_interval
            SET end_time = datetime('now'),
                duration = (strftime('%s','now') - strftime('%s',start_time)),
                extended = ?
            WHERE id = ?
        """;

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, extended ? 1 : 0);
            stmt.setInt(2, intervalId);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Gagal end interval: " + e.getMessage());
        }
    }
}

package com.mycompany.waktuku.dao;

import com.mycompany.waktuku.util.DatabaseHelper;
import java.sql.*;

public class PomodoroSessionDAO {

    // Buat 1 sesi baru
    public int startSession() {
        String sql = "INSERT INTO pomodoro_session(start_time, status) VALUES(datetime('now'), 'RUNNING')";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // session_id
            }

        } catch (Exception e) {
            System.out.println("Gagal start session: " + e.getMessage());
        }

        return -1;
    }

    // Tutup sesi
    public void endSession(int sessionId) {
        String sql = "UPDATE pomodoro_session SET end_time=datetime('now'), status='FINISHED' WHERE id=?";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, sessionId);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Gagal end session: " + e.getMessage());
        }
    }

    // Ambil sesi yang sedang aktif
    public Integer getActiveSession() {
        String sql = "SELECT id FROM pomodoro_session WHERE status='RUNNING' LIMIT 1";

        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getInt("id");
            }

        } catch (Exception e) {
            System.out.println("Gagal ambil active session: " + e.getMessage());
        }

        return null;
    }
}

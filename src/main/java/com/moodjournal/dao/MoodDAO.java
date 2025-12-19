package com.moodjournal.dao;

import com.moodjournal.db.DBConnector;
import com.moodjournal.dto.MoodDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MoodDAO {

    /* ===============================
       ADD MOOD
       =============================== */
    public void addMood(MoodDTO mood) {

        String sql = "INSERT INTO moods (mood, note, mood_date, user_id) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mood.getMood());
            ps.setString(2, mood.getNote());
            ps.setDate(3, java.sql.Date.valueOf(mood.getDate()));
            ps.setInt(4, mood.getUserId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* ===============================
       GET ALL MOODS BY USER
       =============================== */
    public List<MoodDTO> getAllMoodsByUser(int userId) {

        List<MoodDTO> list = new ArrayList<>();

        String sql = "SELECT id, mood, note, mood_date FROM moods " +
                "WHERE user_id=? ORDER BY mood_date DESC";

        try (Connection con = DBConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MoodDTO mood = new MoodDTO();

                mood.setId(rs.getInt("id"));
                mood.setMood(rs.getString("mood"));
                mood.setNote(rs.getString("note"));
                mood.setDate(rs.getDate("mood_date").toLocalDate());
                mood.setUserId(userId);

                list.add(mood);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    /* ===============================
       UPDATE MOOD
       =============================== */
    public void updateMood(MoodDTO mood) {

        String sql = "UPDATE moods SET mood=?, note=? WHERE id=?";

        try (Connection con = DBConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mood.getMood());
            ps.setString(2, mood.getNote());
            ps.setInt(3, mood.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* ===============================
       DELETE MOOD
       =============================== */
    public void deleteMood(int id) {

        String sql = "DELETE FROM moods WHERE id=?";

        try (Connection con = DBConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* ===============================
       GET SINGLE MOOD BY ID
       (Used for Edit Page)
       =============================== */
    public MoodDTO getMoodById(int id) {

        MoodDTO mood = null;

        String sql = "SELECT id, mood, note, mood_date, user_id FROM moods WHERE id=?";

        try (Connection con = DBConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                mood = new MoodDTO();
                mood.setId(rs.getInt("id"));
                mood.setMood(rs.getString("mood"));
                mood.setNote(rs.getString("note"));
                mood.setDate(rs.getDate("mood_date").toLocalDate());
                mood.setUserId(rs.getInt("user_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mood;
    }
}

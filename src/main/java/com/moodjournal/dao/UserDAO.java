package com.moodjournal.dao;

import com.moodjournal.db.DBConnector;
import com.moodjournal.dto.UserDTO;

import java.sql.*;

public class UserDAO {

    public UserDTO getUserByEmail(String email) {
        UserDTO user = null;

        try (Connection con = DBConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT id, name, email FROM userregisteration WHERE email=?")) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new UserDTO();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}

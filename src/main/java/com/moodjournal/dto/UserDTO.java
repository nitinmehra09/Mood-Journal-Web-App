package com.moodjournal.dto;

import com.moodjournal.db.DBConnector;
//import db.DBConnector;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
    /**
     *
     * @author Nitin Mehra
     */
    public class UserDTO
    {
        int id;
        String email;
        String password;
        String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPassword() {
            return password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        private void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public static UserDTO getUserDetails(String email) {
            UserDTO user = null;
            try (Connection con = DBConnector.getConnection();
                 PreparedStatement ps = con.prepareStatement("SELECT name,email FROM userregisteration WHERE email=?")) {

                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    user = new UserDTO();
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return user;
        }
    }

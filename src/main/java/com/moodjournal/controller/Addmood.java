package com.moodjournal.controller;

import com.moodjournal.db.DBConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/addMood")
public class Addmood extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false); // 🔥 MISSING LINE

        if (session == null || session.getAttribute("userId") == null) {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }

        String mood = req.getParameter("mood");
        String note = req.getParameter("note");
        int userId = (int) session.getAttribute("userId");

        try {
            Connection con = DBConnector.getConnection();
            PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO moods(user_id, mood, note) VALUES (?, ?, ?)"
            );
            pst.setInt(1, userId);
            pst.setString(2, mood);
            pst.setString(3, note);
            pst.executeUpdate();

            resp.sendRedirect(req.getContextPath() + "/pages/home.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/register.jsp?error=1");
        }
    }

}

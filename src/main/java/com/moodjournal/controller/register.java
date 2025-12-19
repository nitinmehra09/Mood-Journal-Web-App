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

@WebServlet("/register")
public class register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String confirm = req.getParameter("confirmPassword");
        String email = req.getParameter("email");
        if(password.equals(confirm)) {
            try {

                Connection con = DBConnector.getConnection();
                PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO user(name, password, email) VALUES (?, ?, ?)"
                );
                pst.setString(1, name);
                pst.setString(2, password);
                pst.setString(3, email);
                pst.executeUpdate();

                HttpSession session = req.getSession(true);
                session.setAttribute("email", email);
                session.setAttribute("name", name);
                resp.sendRedirect(req.getContextPath() + "/pages/login.jsp");

            } catch (SQLException e) {
                resp.sendRedirect("register.jsp?error=1");
            }
        }
        else {
            resp.sendRedirect(req.getContextPath() + "/pages/register.jsp");
        }
    }
}

package com.moodjournal.controller;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.moodjournal.db.DBConnector;
import com.moodjournal.dto.UserDTO;
import com.moodjournal.model.LoginAuthenticator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Login")

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("pages/login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDTO user = new UserDTO();
        user.setEmail(email);
        user.setPassword(password);

        LoginAuthenticator l1 = new LoginAuthenticator();
        boolean login = l1.isLogin(user);

        String tablePassword = "";
        if(login)
        {
            HttpSession session = req.getSession(true);
            session.setAttribute("email", email);
            session.setAttribute("userId", user.getId());
            System.out.println("login done");
            resp.sendRedirect(req.getContextPath() + "/pages/home.jsp");
        }
        else
        {
            resp.sendRedirect(req.getContextPath() + "/pages/login.jsp");
        }
    }
}

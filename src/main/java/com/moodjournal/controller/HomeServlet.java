package com.moodjournal.controller;

import com.moodjournal.dao.MoodDAO;
import com.moodjournal.dto.MoodDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("🔥 HomeServlet HIT");

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        int userId = (int) session.getAttribute("userId");

        MoodDAO dao = new MoodDAO();
        List<MoodDTO> moodList = dao.getAllMoodsByUser(userId);

        System.out.println("Mood list size = " + moodList.size());

        request.setAttribute("moodList", moodList);
        request.getRequestDispatcher("pages/home.jsp")
                .forward(request, response);
    }
}




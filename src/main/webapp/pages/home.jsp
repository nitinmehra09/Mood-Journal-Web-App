<%@ page import="com.moodjournal.dao.MoodDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.moodjournal.dto.MoodDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%-- @elvariable id="moodList" type="java.util.List<com.moodjournal.dto.MoodDTO>" --%>

<!DOCTYPE html>
<html>
<head>
    <title>Mood Journal Dashboard</title>

    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: "Segoe UI", sans-serif;
            background: #efe7ff;
        }

        /* ===== MAIN LAYOUT ===== */
        .app {
            display: flex;
            height: 100vh;
            padding: 20px;
        }

        /* ===== SIDEBAR ===== */
        .sidebar {
            width: 220px;
            background: #6d28d9;
            color: white;
            border-radius: 16px;
            padding: 25px 20px;
        }

        .sidebar h2 {
            margin-bottom: 40px;
        }

        .menu a {
            display: block;
            color: white;
            text-decoration: none;
            margin-bottom: 20px;
            font-weight: 500;
            opacity: 0.9;
        }

        .menu a.active {
            background: rgba(255,255,255,0.2);
            padding: 10px;
            border-radius: 8px;
        }

        /* ===== CONTENT ===== */
        .content {
            flex: 1;
            background: #ffffff;
            margin-left: 20px;
            border-radius: 16px;
            padding: 30px;
            display: grid;
            grid-template-columns: 2.5fr 1.2fr;
            gap: 25px;
        }

        /* ===== CALENDAR ===== */
        .calendar {
            background: #fafafa;
            border-radius: 14px;
            padding: 20px;
        }

        .calendar h3 {
            margin-bottom: 20px;
        }

        .grid {
            display: grid;
            grid-template-columns: repeat(7, 1fr);
            gap: 12px;
        }

        .day {
            height: 90px;
            background: white;
            border-radius: 10px;
            padding: 8px;
            font-size: 13px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.05);
        }

        .date {
            font-size: 11px;
            color: #666;
        }

        .mood {
            margin-top: 10px;
            font-weight: bold;
        }

        /* ===== ADD PANEL ===== */
        .panel {
            background: #f8f7ff;
            border-radius: 14px;
            padding: 20px;
        }

        .panel h3 {
            margin-bottom: 15px;
        }

        label {
            font-size: 13px;
            font-weight: 600;
        }

        select, textarea, button {
            width: 100%;
            margin-top: 8px;
            margin-bottom: 15px;
            padding: 10px;
            border-radius: 8px;
            border: 1px solid #ccc;
            font-family: inherit;
        }

        textarea {
            resize: none;
            height: 80px;
        }

        button {
            background: #6d28d9;
            color: white;
            border: none;
            cursor: pointer;
            font-weight: 600;
        }

        button:hover {
            background: #5b21b6;
        }

        /* ===== MOOD COLORS ===== */
        .Happy { color: #16a34a; }
        .Sad { color: #2563eb; }
        .Angry { color: #dc2626; }
        .Neutral { color: #6b7280; }
        .Tired { color: #7c3aed; }
    </style>
</head>

<body>

<div class="app">

    <!-- SIDEBAR -->
    <div class="sidebar">
        <h2>MoodMe</h2>

        <div class="menu">
            <a class="active">📅 Journal</a>
            <a href="">📊 Insights</a>
            <a href="">⚙ Settings</a>
            <a href="profile.jsp">👤 Profile</a>
            <form action="${pageContext.request.contextPath}/logout" method="post">
                <button type="submit">🚪 Logout</button>
            </form>

        </div>

    </div>

    <!-- MAIN CONTENT -->
    <div class="content">

        <!-- CALENDAR -->
        <div class="calendar">
            <h3>January 2025</h3>

            <div class="grid">

                <c:forEach var="m" items="${moodList}">
                    <div class="day">
                        <div class="date">${m.date}</div>
                        <div class="mood ${m.mood}">
                                ${m.mood}
                        </div>
                    </div>
                </c:forEach>

            </div>

        </div>

        <!-- ADD MOOD PANEL -->
        <div class="panel">
            <h3>Add Mood</h3>

            <form action="${pageContext.request.contextPath}/addMood" method="post">

            <label>Mood</label>
                <select name="mood" required>
                    <option value="">Select</option>
                    <option value="Happy">😊 Happy</option>
                    <option value="Neutral">😐 Neutral</option>
                    <option value="Sad">😢 Sad</option>
                    <option value="Angry">😠 Angry</option>
                    <option value="Tired">😴 Tired</option>
                </select>

                <label>Note</label>
                <textarea name="note" placeholder="Write something..." required></textarea>

                <button type="submit">Save Mood</button>
            </form>
        </div>

    </div>
</div>

</body>
</html>

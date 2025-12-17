<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Mood Journal</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 900px;
            margin: 40px auto;
            background: #ffffff;
            padding: 30px;
            border-radius: 8px;
        }

        h1, h2 {
            color: #333;
            margin-bottom: 15px;
        }

        /* FORM SECTION */
        .form-section {
            border-bottom: 1px solid #ddd;
            padding-bottom: 25px;
            margin-bottom: 30px;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        select, textarea, button {
            width: 100%;
            margin-top: 8px;
            padding: 10px;
            font-size: 14px;
        }

        textarea {
            resize: none;
            height: 80px;
        }

        button {
            margin-top: 20px;
            background-color: #2c7be5;
            color: white;
            border: none;
            cursor: pointer;
            border-radius: 4px;
        }

        button:hover {
            background-color: #1a5dc9;
        }

        /* HISTORY SECTION */
        .calendar {
            display: grid;
            grid-template-columns: repeat(7, 1fr);
            gap: 10px;
        }

        .day {
            border: 1px solid #ddd;
            padding: 10px;
            min-height: 80px;
            border-radius: 5px;
            background-color: #fafafa;
        }

        .date {
            font-size: 12px;
            color: #666;
        }

        .mood {
            margin-top: 10px;
            font-size: 14px;
            font-weight: bold;
        }
    </style>
</head>

<body>

<div class="container">

    <!-- 🔹 ADD MOOD FORM -->
    <div class="form-section">
        <h1>📝 Mood Journal</h1>

        <form action="<%= request.getContextPath() %>/addMood" method="post">
            <label for="mood">Today’s Mood</label>
            <select name="mood" id="mood" required>
                <option value="">-- Select Mood --</option>
                <option value="Happy">😊 Happy</option>
                <option value="Neutral">😐 Neutral</option>
                <option value="Sad">😢 Sad</option>
                <option value="Angry">😠 Angry</option>
                <option value="Tired">😴 Tired</option>
            </select>

            <label for="note">Short Note</label>
            <textarea name="note" id="note" placeholder="How was your day?" required></textarea>

            <button type="submit">Save Mood</button>
        </form>
    </div>

    <!-- 🔹 MOOD HISTORY (CALENDAR STYLE) -->
    <div class="history-section">
        <h2>📅 Mood History</h2>

        <div class="calendar">

            <!-- SAMPLE STATIC DATA (Later replaced by JSTL loop) -->
            <div class="day">
                <div class="date">01 Dec</div>
                <div class="mood">😊 Happy</div>
            </div>

            <div class="day">
                <div class="date">02 Dec</div>
                <div class="mood">😐 Neutral</div>
            </div>

            <div class="day">
                <div class="date">03 Dec</div>
                <div class="mood">😢 Sad</div>
            </div>

            <div class="day">
                <div class="date">04 Dec</div>
                <div class="mood">😊 Happy</div>
            </div>

            <!-- More days will come dynamically -->

        </div>
    </div>

</div>

</body>
</html>

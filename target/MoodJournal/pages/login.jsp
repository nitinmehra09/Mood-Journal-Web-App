<%--
  Created by IntelliJ IDEA.
  User: Nitin Mehra
  Date: 16-12-2025
  Time: 08:00 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Mood Journal | Login</title>

  <!-- Google Font -->
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">

  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Poppins', sans-serif;
    }

    body {
      height: 100vh;
      background: linear-gradient(135deg, #667eea, #764ba2);
      display: flex;
      align-items: center;
      justify-content: center;
      overflow: hidden;
    }

    .circle {
      position: absolute;
      border-radius: 50%;
      background: rgba(255,255,255,0.15);
      animation: float 8s infinite ease-in-out;
    }

    .circle.one {
      width: 200px;
      height: 200px;
      top: 10%;
      left: 15%;
    }

    .circle.two {
      width: 300px;
      height: 300px;
      bottom: 15%;
      right: 10%;
      animation-delay: 2s;
    }

    @keyframes float {
      0% { transform: translateY(0); }
      50% { transform: translateY(-30px); }
      100% { transform: translateY(0); }
    }

    .card {
      position: relative;
      width: 380px;
      padding: 40px;
      background: rgba(255,255,255,0.15);
      backdrop-filter: blur(12px);
      border-radius: 16px;
      box-shadow: 0 15px 35px rgba(0,0,0,0.2);
      text-align: center;
      animation: slideUp 1.2s ease;
    }

    @keyframes slideUp {
      from { opacity: 0; transform: translateY(60px); }
      to { opacity: 1; transform: translateY(0); }
    }

    h2 {
      color: #fff;
      margin-bottom: 20px;
    }

    input {
      width: 100%;
      padding: 12px;
      margin: 10px 0;
      border: none;
      border-radius: 25px;
      outline: none;
    }

    .btn {
      width: 100%;
      padding: 12px;
      margin-top: 15px;
      border: none;
      border-radius: 25px;
      cursor: pointer;
      font-size: 16px;
      background: #fff;
      color: #333;
      transition: 0.3s;
    }

    .btn:hover {
      transform: scale(1.05);
    }

    .link {
      margin-top: 15px;
      font-size: 14px;
      color: #eee;
    }

    .link a {
      color: #fff;
      text-decoration: none;
      font-weight: 600;
    }
  </style>
</head>

<body>

<div class="circle one"></div>
<div class="circle two"></div>

<div class="card">
  <h2>🔐 Login</h2>

  <form action="<%= request.getContextPath() %>/Login" method="post">
    <input type="email" name="email" placeholder="Email" required>
    <input type="password" name="password" placeholder="Password" required>

    <button type="submit" class="btn">Login</button>
  </form>

  <div class="link">
    Don’t have an account?
    <a href="./register.jsp">Register</a>
  </div>
</div>

</body>
</html>


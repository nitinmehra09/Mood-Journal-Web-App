<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mood Journal | Welcome</title>

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

        /* floating background circles */
        .circle {
            position: absolute;
            border-radius: 50%;
            background: rgba(255,255,255,0.15);
            animation: float 8s infinite ease-in-out;
        }

        .circle:nth-child(1) {
            width: 200px;
            height: 200px;
            top: 10%;
            left: 15%;
        }

        .circle:nth-child(2) {
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

        /* main card */
        .container {
            position: relative;
            width: 380px;
            padding: 40px;
            background: rgba(255, 255, 255, 0.15);
            backdrop-filter: blur(12px);
            border-radius: 16px;
            text-align: center;
            box-shadow: 0 15px 35px rgba(0,0,0,0.2);
            animation: slideUp 1.2s ease;
        }

        @keyframes slideUp {
            from {
                opacity: 0;
                transform: translateY(60px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        h1 {
            color: #fff;
            font-weight: 600;
            margin-bottom: 10px;
        }

        p {
            color: #eee;
            font-size: 14px;
            margin-bottom: 30px;
        }

        .btn {
            display: block;
            width: 100%;
            padding: 12px;
            margin: 12px 0;
            border: none;
            border-radius: 30px;
            font-size: 16px;
            cursor: pointer;
            transition: all 0.3s ease;
            text-decoration: none;
        }

        .login {
            background: #ffffff;
            color: #333;
        }

        .login:hover {
            background: #f1f1f1;
            transform: scale(1.03);
        }

        .register {
            background: transparent;
            color: #fff;
            border: 1px solid #fff;
        }

        .register:hover {
            background: rgba(255,255,255,0.2);
            transform: scale(1.03);
        }

        footer {
            margin-top: 20px;
            font-size: 12px;
            color: #ddd;
        }
    </style>
</head>

<body>

<!-- animated background -->
<div class="circle"></div>
<div class="circle"></div>

<div class="container">
    <h1>😊 Mood Journal</h1>
    <p>Track your feelings, understand yourself better</p>

    <!-- These links will later point to controllers -->
    <a href="./pages/login.jsp" class="btn login">Login</a>
    <a href="./pages/register.jsp" class="btn register">Register</a>

    <footer>
        Made with ❤️ using Java MVC
    </footer>
</div>

</body>
</html>

# 🌈 Mood Journal Web App

A simple and creative **Mood Journal Web Application** that allows users to record their daily moods and write short personal reflections.  
This project is built using **Java, Servlets, JSP, JDBC, and MySQL**, following the **MVC (Model–View–Controller) architecture**.

---

## 🎯 Project Objective
To create a user-friendly web application where users can:
- Track their daily mood
- Write short journal notes
- View, edit, and delete past mood entries
- Understand Java Web development using real-world concepts

---

## ✨ Features
- Add daily mood with a short note
- View mood history in a clean layout
- Edit or delete mood entries
- Date-wise mood tracking
- Simple and responsive UI

---

## 🛠 Tech Stack
### Backend
- Java
- Servlets
- JSP
- JDBC
- MySQL

### Frontend
- HTML
- CSS
- JavaScript

### Server & Tools
- Apache Tomcat
- Eclipse / IntelliJ IDEA
- Git & GitHub

---

## 🧠 Concepts Used
- Object-Oriented Programming (OOP)
- MVC Architecture
- CRUD Operations
- Form Handling
- JDBC Database Connectivity
- Clean Code Practices

---

## 🗄 Database Design

### Table: `moods.`

| Column | Type |
|------|------|
| id | INT (Primary Key, Auto Increment) |
| mood | VARCHAR(50) |
| note | TEXT |
| date | DATE |

---

## 📁 Project Folder Structure

```

Mood-Journal-Web-App/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── moodjournal/
│       │           ├── controller/        # Servlets (Handle requests & responses)
│       │           ├── model/             # Business logic
│       │           ├── dao/               # Database access (CRUD operations)
│       │           ├── dto/               # Data Transfer Objects
│       │           └── db/                # Database connection utility
│       │
│       └── webapp/
│           ├── css/                       # Stylesheets
│           ├── js/                        # JavaScript files (if any)
│           ├── images/                   # Images & assets
│           │
│           ├── pages/                    # JSP pages (UI layer)
│           │   ├── login.jsp
│           │   ├── register.jsp
│           │   ├── dashboard.jsp
│           │   └── history.jsp
│           │
│           ├── WEB-INF/
│           │   └── web.xml                # Servlet configuration
│           │
│           └── index.jsp                  # Entry point
│
├── pom.xml                                # Maven dependencies & build config
├── .gitignore                             # Ignored files & folders
├── README.md                              # Project documentation

```

## 🚀 How to Run the Project

1. Clone the repository  
```

git clone [https://github.com/your-username/mood-journal-web-app.git](https://github.com/your-username/mood-journal-web-app.git)

```

2. Import the project into **Eclipse / IntelliJ**

3. Configure **Apache Tomcat Server**

4. Create the MySQL database and table

5. Update database credentials in `DBConnection.java.`

6. Run the project on the server

---

## 📌 Future Enhancements
- User authentication (Login/Signup)
- Mood analytics & charts
- Calendar-based mood view
- Email reminders
- Dark mode UI

---

## 👨‍💻 Author
**Nitin Mehra**  
B.Tech CSE  

---

## 📜 License
This project is licensed under the **MIT License** – feel free to use and modify it.

---

## ⭐ If you like this project
Give it a ⭐ on GitHub — it motivates learning!

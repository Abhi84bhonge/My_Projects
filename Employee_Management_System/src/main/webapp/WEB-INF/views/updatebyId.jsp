<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update Employee - Enter ID</title>
    <link rel="stylesheet" href="/updatebyId.css">
</head>
<body>
<div class="container">
    <h2>Enter Employee ID to Update</h2>

    <form action="/updatebyId" method="post">
        Employee ID: <input type="number" name="id" required>
        <button type="submit">Fetch Employee</button>
    </form>

    <c:if test="${not empty msg}">
        <p class="error">${msg}</p>
    </c:if>

    <a href="/" class="home-btn">Home</a>
    <a href="operations" class="home-btn">Employee Operations</a>
</div>
<br><br>
<div class="footer">
    © 2026 Employee Management System | Designed by Abhijeet Bhonge
</div>
</body>
</html>

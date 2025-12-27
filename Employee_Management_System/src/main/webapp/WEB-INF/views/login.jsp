<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <link rel="stylesheet" href="login.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

<c:if test="${not empty error}">
    <p style="color:red; position: relative; z-index: 100;">${error}</p>
</c:if>

<div class="panda">
    <div class="ear"></div>
    <div class="face">
        <div class="eye-shade"></div>
        <div class="eye-white">
            <div class="eye-ball"></div>
        </div>
        <div class="eye-shade rgt"></div>
        <div class="eye-white rgt">
            <div class="eye-ball"></div>
        </div>
        <div class="nose"></div>
    </div>
</div>

<form action="${pageContext.request.contextPath}/login" method="post" id="loginForm">

    <div class="hand"></div>
    <div class="hand rgt"></div>

    <h1><u>Admin Login</u></h1>

    <div class="form-group">
        <input type="text" name="username" required class="form-control"/>
        <label class="form-label">Username</label>
    </div>

    <div class="form-group">
        <input id="password" name="password" type="password" required class="form-control"/>
        <label class="form-label">Password</label>
        <button type="submit" class="btn1">Login</button>
    </div><hr>
    <div class="btn-group">
   
    <a href="index" class="btn link-btn">Home</a>
    <a href="getadminpage" class="btn link-btn">Admin</a>
</div>
</form>
<br><br>
<div class="footer">
    © 2026 Employee Management System | Designed by Abhijeet Bhonge
</div>


<script>

$(document).ready(function() {
    const passwordInput = document.getElementById("password");
    const form = document.querySelector("form");
    const panda = document.querySelector(".panda"); // Select the panda

    passwordInput.addEventListener("focus", function() {
    	  form.classList.add("up");
    	  panda.classList.add("close-eyes"); // This triggers the .eye-white slit
    	});

    	passwordInput.addEventListener("blur", function() {
    	  form.classList.remove("up");
    	  panda.classList.remove("close-eyes");
    	});
});
</script>


</body>
</html>
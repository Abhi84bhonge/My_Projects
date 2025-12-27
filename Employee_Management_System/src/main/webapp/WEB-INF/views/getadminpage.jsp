<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="stylesheet" href="getadminpage.css">
</head>
<body>

<c:if test="${not empty error}">
    <p style="color:red; position: relative; z-index: 100;">${error}</p>
</c:if>
<h1><u>Admin Form</u></h1>


<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
<form action="${pageContext.request.contextPath}/getadminpage" method="post">


    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div class="form-group">
        <label class="form-label">Admin Username</label>
        <input type="text"
               name="username"
               class="form-control"
               placeholder=" "
               required>
    </div>

    <div class="form-group">
     <label class="form-label">Admin Password</label>
        <input type="password"
               name="password"
               class="form-control"
               placeholder=" "
               required>
    </div>

    <button type="submit" class="btn">Add Admin</button>
         <br>
<span>
<hr><br>
<a href="login" class="btn" >Login</a>
</span>
</form>
<br><br>

<br>
<div class="footer">
    © 2026 Employee Management System | Designed by Abhijeet Bhonge
</div>
</body>
</html>
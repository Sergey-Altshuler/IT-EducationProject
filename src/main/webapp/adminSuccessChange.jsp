<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 17.07.2021
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin_successChange</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1> Your role: Admin <br> New login and password </h1>
<br>
<br>
<a href="adminValidate.jsp"> Log out </a>
<a href="adminActions.jsp"> Go back </a>
<br>
<h3> The changes have been confirmed. </h3>
<br>
<div align="center">
    <h3>
        New login: ${login}
        New password: ${password}
    </h3>
</div>
</body>
</html>

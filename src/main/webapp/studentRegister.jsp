<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>
<html lang="${language}">
<head>
    <title>StudentRegister</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="myStyles.css" type="text/css">
</head>
<body>
<h1><fmt:message key="label.yourRoleStudent"/> <br> <fmt:message key="label.fillTheForm"/></h1>
<br>
<br>
<a href="studentValidate.jsp"> <fmt:message key="label.goBack"/> </a>
<br>
<div align="center">
    <form action="studentRegister" method="POST">
        <br>
        <fmt:message key="label.login"/>
        <br>
        <input name="login" required type="text">
        <br>
        <fmt:message key="label.password"/>
        <br>
        <input name="password" required type="password">
        <br>
        <fmt:message key="label.confirmPassword"/>
        <br>
        <input name="repeated" required type="password">
        <br>
        <fmt:message key="label.name"/>
        <br>
        <input name="name" required type="text">
        <br>
        <fmt:message key="label.surname"/>
        <br>
        <input name="surname" required type="text">
        <br>
        <fmt:message key="label.age"/>
        <br>
        <input name="age" required type="text" pattern="[1-9][0-9]{0,2}">
        <br>
        <fmt:message key="label.interests"/>
        <br>
        <input name="interests" required type="text">
        <br>
        <br>
        <input type="submit" value="OK"/>

    </form>
</div>
</body>
</html>

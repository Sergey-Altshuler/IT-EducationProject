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
    <title>ChooseRole</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1> <fmt:message key="label.selectRole"/> </h1>
<a href="welcome.jsp"> <fmt:message key="label.goBack"/> </a>
<div align="center">
<form action="chooseRole-servlet" method="post">
    <p><input name="role" type="radio" value="admin"> <fmt:message key="label.admin"/></p>
    <p><input name="role" type="radio" value="student"> <fmt:message key="label.student"/></p>
    <p><input name="role" type="radio" value="coach" checked> <fmt:message key="label.coach"/></p>
    <p><input type="submit" value="OK" class="button"></p>
</form>
</div>
</body>
</html>

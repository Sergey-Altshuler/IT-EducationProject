<%@ page import="com.Altshuler.info.ProjectInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>
<!DOCTYPE html>
<html lang="${language}">
<head>
    <title>Welcome</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles.css" type="text/css">
</head>
<body>
<h1 align="center" style="color: aliceblue;
    background-color: darkblue;
    text-align: center;
    font-family: Arial, serif;
    font-weight: bold;"><fmt:message key="label.welcomeToITCenter"/>
</h1>
<br>
<a href="chooseLanguage.jsp" style="
    display: inline-block;
    text-decoration: none;
    text-transform: uppercase;
    letter-spacing: 1px;
    margin: 15px 25px;
    padding: 15px 20px;
    font-size: 20px;
    font-weight: bold;
    font-family: 'Montserrat', sans-serif;
    transition: 0.5s ease-in-out;"> <fmt:message key="label.goBack"/></a>
<br>
<br>
<h3 align="center" style="color: black;
    font-family: Arial, sans-serif;
font-weight: bold;
text-align: center;"><fmt:message key="label.wantToStart"/></h3>
<br>
<div align="center">
    <a href="chooseRole.jsp" style="
    display: inline-block;
    text-decoration: none;
    text-transform: uppercase;
    letter-spacing: 1px;
    margin: 15px 25px;
    padding: 15px 20px;
    font-size: 20px;
    font-weight: bold;
    font-family: 'Montserrat', sans-serif;
    transition: 0.5s ease-in-out;"><fmt:message key="label.getStarted"/></a>
</div>
</body>
</html>

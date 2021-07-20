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
    <title>Admin_successChange</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1> <fmt:message key="label.yourRoleAdmin"/><br> <fmt:message key="label.newLoginAndPassword"/></h1>
<br>
<br>
<a href="adminValidate.jsp"> <fmt:message key="label.logOut"/></a>
<a href="adminActions.jsp"><fmt:message key="label.goBack"/></a>
<br>
<h3> <fmt:message key="label.changesConfirmed"/> </h3>
<br>
<div align="center">
    <h3>
        <fmt:message key="label.newLogin"/> ${login}
        <fmt:message key="label.newPassword"/> ${password}
    </h3>
</div>
</body>
</html>

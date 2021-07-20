<%@ page import="com.Altshuler.info.ProjectInfo" %>
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
    <title>CoachDisplayStats</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1><fmt:message key="label.hello"/> <%=ProjectInfo.getCoach().getName()%> <%=ProjectInfo.getCoach().getSurname()%>!<br>
    <fmt:message key="label.statistics"/></h1>
<br>
<br>
<a href="coachValidate.jsp"> <fmt:message key="label.logOut"/> </a>
<a href="coachRedirect.jsp"> <fmt:message key="label.goBack"/></a>
<br>
<table>
    <tr>
        <th><fmt:message key="label.id"/></th>
        <th><fmt:message key="label.title"/></th>
        <th><fmt:message key="label.subgroup"/></th>
        <th><fmt:message key="label.avgMark"/></th>
        <th><fmt:message key="label.attendance"/></th>
    </tr>
    <c:forEach var="stats" items="${stats}">
        <tr>
            <td>${stats.id}</td>
            <c:set var="course" value="${stats.course}"/>
            <c:set var="title" value="${course.title}"/>
            <c:set var="subgroup" value="${course.subgroupNum}"/>
            <td>${title}</td>
            <td>${subgroup}</td>
            <td>${stats.avgMark}</td>
            <td>${stats.attendance}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

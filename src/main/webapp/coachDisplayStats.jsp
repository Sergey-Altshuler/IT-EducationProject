<%@ page import="com.Altshuler.info.ProjectInfo" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CoachDisplayStats</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1>Hello, <%=ProjectInfo.getCoach().getName()%> <%=ProjectInfo.getCoach().getSurname()%>!<br>
Total Stats</h1>
<br>
<br>
<a href="coachValidate.jsp"> Log out </a>
<a href="coachRedirect.jsp"> Go back </a>
<br>
<table>
    <tr>
        <th>id</th>
        <th>Title_of_Course</th>
        <th>Subgroup</th>
        <th>averageMark</th>
        <th>attendance</th>
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

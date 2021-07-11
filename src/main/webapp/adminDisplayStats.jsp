<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 08.07.2021
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>adminDisplayStats</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1>Statistics</h1>
<table>
    <tr>
        <th>id</th>
        <th>Title of Course</th>
        <th>Subgroup</th>
        <th>averageMark</th>
        <th>attendance</th>
    </tr>
    <c:forEach var="stats" items="${stats}">
        <tr>
            <td>${stats.id}</td>
            <c:set var="course" value="${stats.course}"/>
            <c:set var="title" value="${course.title}"/>
            <c:set var="subgroup" value="${course.subgroup}"/>
            <td>${title}</td>
            <td>${subgroup}</td>
            <td>${stats.avgMark}</td>
            <td>${stats.attendance}</td>
        </tr>
    </c:forEach>
</table>
<h3> Click here to return</h3>
<a href="adminValidate.jsp">Go back</a>
</body>
</html>

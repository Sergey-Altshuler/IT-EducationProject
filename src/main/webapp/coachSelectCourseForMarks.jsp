<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10.07.2021
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<html>
<head>
    <title>CoachSelectCourseForMarks</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>subgroup</th>
        <th>EducationType</th>
        <th>price</th>
        <th>address</th>
        <th>startDate</th>
        <th>finishDate</th>
        <th>Remaining</th>
        <th>CoachRequired</th>
        <th>IsStarted</th>
    </tr>
    <c:forEach var="courses" items="${courses}">
        <tr>
            <td>${courses.id}</td>
            <td>${courses.title}</td>
            <td>${courses.subgroupNum}</td>
            <td>${courses.educationType}</td>
            <td>${courses.price}</td>
            <td>${courses.address}</td>
            <td>${courses.startDate}</td>
            <td>${courses.finishDate}</td>
            <td>${courses.remaining}</td>
            <td>${courses.coachRequired}</td>
            <td>${courses.isStarted}
        </tr>
    </c:forEach>
</table>
<br>
<br>
<h3> Please, insert the number of course you want to put marks down </h3>

<form action="coachPutMarksServlet" method="post">
    Number of course:
    <br>
    <input name="number" type="text"/>
    <br>
    <input type="submit" value="OK"/>
</form>
</body>
</html>

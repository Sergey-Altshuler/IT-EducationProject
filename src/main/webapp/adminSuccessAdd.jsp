<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin_successAdd</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1> Your role: Admin <br> Course has been successfully added!</h1>
<br>
<br>
<a href="adminValidate.jsp"> Log out </a>
<a href="adminActions.jsp"> Go back </a>
<br>
<div align="center">
    <table>
        <tr>
            <th>id</th>
            <th>title</th>
            <th>subgroup</th>
            <th>Number of students</th>
            <th>EducationType</th>
            <th>price</th>
            <th>address</th>
            <th>startDate</th>
            <th>finishDate</th>
            <th>Places remaining</th>
            <th>Is started</th>
        </tr>
        <c:forEach var="courses" items="${courses}">
            <tr>
                <td>${courses.id}</td>
                <td>${courses.title}</td>
                <td>${courses.subgroupNum}</td>
                <td>${courses.numOfStudents}</td>
                <td>${courses.educationType}</td>
                <td>${courses.price}</td>
                <td>${courses.address}</td>
                <td>${courses.startDate}</td>
                <td>${courses.finishDate}</td>
                <td>${courses.remaining}</td>
                <td>${courses.isStarted}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

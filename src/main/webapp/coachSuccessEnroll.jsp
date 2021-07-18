<%@ page import="com.Altshuler.info.ProjectInfo" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>CoachSuccessEnroll</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1>Hello, <%=ProjectInfo.getCoach().getName()%> <%=ProjectInfo.getCoach().getSurname()%>!<br>
    You have been successfully enrolled!</h1>
<br>
<br>
<a href="coachValidate.jsp"> Log out </a>
<a href="coachRedirect.jsp"> Go back </a>
<br>
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
    </tr>
    <tr>
        <td>${course.id}</td>
        <td>${course.title}</td>
        <td>${course.subgroupNum}</td>
        <td>${course.educationType}</td>
        <td>${course.price}</td>
        <td>${course.address}</td>
        <td>${course.startDate}</td>
        <td>${course.finishDate}</td>
        <td>${course.remaining}</td>
        <td>${course.coachRequired}</td>
    </tr>
</table>
</body>
</html>

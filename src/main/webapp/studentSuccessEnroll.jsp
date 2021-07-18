<%@ page import="com.Altshuler.info.ProjectInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>StudentSuccessEnroll</title>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1>Hello, <%=ProjectInfo.getStudent().getName()%> <%=ProjectInfo.getStudent().getSurname()%>!<br>
  You have been successfully enrolled!</h1>
<br>
<br>
<a href="studentValidate.jsp"> Log out </a>
<a href="studentRedirect.jsp"> Go back </a>
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
    </tr>
</table>
</body>
</html>

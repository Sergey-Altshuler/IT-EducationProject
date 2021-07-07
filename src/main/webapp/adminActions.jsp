<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 07.07.2021
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin_actions</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1> Create a new course </h1>
<br>
<br>
<br>
<form action="addCourseServlet" method="POST">
    <br>
    Title:
    <br>
    <input name="title" required type="text">
    <br>
    Education type:
    <br>
    <select name="educationType" required>
        <option disabled> Please choose type of course</option>
        <option value="online"> online</option>
        <option value="evening"> evening</option>
    </select>
    <br>
    Price:
    <br>
    <input name="price" required type="text">
    <br>
    Address:
    <br>
    <select name="address" required>
        <option disabled> Please choose an address</option>
        <option value="Минск, Скрыганова-14"> Минск, Скрыганова-14</option>
        <option value="Минск, Гикало-3"> Минск, Гикало-3</option>
        <option value="Могилев"> Могилев</option>
    </select>
    <br>
    Number of students:
    <br>
    <select name="numOfStudents" required>
        <option disabled> How many students are in the group?</option>
        <option value="3"> 3</option>
        <option value="4"> 4</option>
        <option value="5"> 5</option>
        <option value="6"> 6</option>
    </select>
    <br>
    Start Date (enter like YYYY-MM-dd)
    <br>
    <input name="startDate" type="text" required>
    <br>
    Finish Date (enter like YYYY-MM-dd)
    <br>
    <input name="finishDate" type="text" required>
    <br>
    <input type="submit" value="create a Course"/>

</form>
</body>
</html>

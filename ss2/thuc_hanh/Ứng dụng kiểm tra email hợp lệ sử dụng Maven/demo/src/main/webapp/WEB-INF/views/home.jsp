<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 27/02/2023
  Time: 10:51 SA
  To change this template use File | Settings | File Templates.
--%>
Tạo trang home.jsp

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Email Validate</h1>
<h3 style="color:red">${message}</h3>
<form action="validate" method="post">
    <input type="text" name="email"><br>
    <input type="submit" value="Validate">
</form>
</body>
</html>

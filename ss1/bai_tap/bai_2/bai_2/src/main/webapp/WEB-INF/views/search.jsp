<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 24/02/2023
  Time: 3:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/search">
    <label>Search</label>
    <input type="text" name="word">
    <input type="submit" value="Submit">
</form>
<div>${search}</div>
</body>
</html>

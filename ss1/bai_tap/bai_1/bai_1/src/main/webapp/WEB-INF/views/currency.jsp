<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 24/02/2023
  Time: 2:44 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency</title>
</head>
<body>
<form action="/currency">
  <label>Currency USD (23000)</label>
  <input type="number" value="usd" name="usd">
  <input type="submit" value="Submit">
</form>
<div>${vnd} VND</div>
</body>
</html>

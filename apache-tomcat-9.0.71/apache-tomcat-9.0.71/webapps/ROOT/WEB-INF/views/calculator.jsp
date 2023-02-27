<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 27/02/2023
  Time: 1:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator", method="post">
  <input type="number" name="firstNumber">
  <input type="number" name="secondNumber">
  <br>
  <br>

  <input type="submit" name="calculation" value="Addition">
  <input type="submit" name="calculation" value="Subtraction">
  <input type="submit" name="calculation" value="Multiplication">
  <input type="submit" name="calculation" value="Division">
</form>
<div>Result: ${result}</div>
</body>
</html>

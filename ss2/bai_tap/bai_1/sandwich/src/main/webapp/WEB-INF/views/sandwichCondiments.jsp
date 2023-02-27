<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 27/02/2023
  Time: 12:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<div>
    <h1>Sandwich Condiments</h1>
  <form action="/save", method="post">
      <input type="checkbox" value="Lettuce" name="condiment">Lettuce
      <input type="checkbox" value="Tomato" name="condiment">Tomato
      <input type="checkbox" value="Mustard" name="condiment">Mustard
      <input type="checkbox" value="Sprouts" name="condiment">Sprouts
      <input type="submit" value="Save">
  </form>
<div>${listCondiments}</div>
</div>
</body>
</html>

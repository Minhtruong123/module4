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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <style>
        .calculate{
            border: 1px solid black;
            display: inline-block;
            width: 30%;
            height: 30%;
        }
    </style>
</head>
<body class="pt-5 d-flex" style="justify-content: center">
<div class="calculate ps-3">
    <h1 class="text-center">Calculator</h1>
    <form action="/calculator" , method="post">
        <input type="number" name="firstNumber">
        <input type="number" name="secondNumber">
        <br>
        <br>

        <input class="btn btn-primary mb-3" type="submit" name="calculation" value="Addition">
        <input class="btn btn-primary mb-3" type="submit" name="calculation" value="Subtraction">
        <input class="btn btn-primary mb-3" type="submit" name="calculation" value="Multiplication">
        <input class="btn btn-primary mb-3" type="submit" name="calculation" value="Division">
    </form>
    <div>Result: ${result}</div>
</div>
</body>
</html>

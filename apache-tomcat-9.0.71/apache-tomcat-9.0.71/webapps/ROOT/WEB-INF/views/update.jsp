<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 28/02/2023
  Time: 11:46 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Information</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body class="d-flex justify-content-center">
<div class="px-3 py-3 mt-5" style="border: 1px solid black; display: inline-block; height: 40%">
    <h1 class="mb-3">Setting</h1>
    <form:form modelAttribute="mailBox" action="/updateEmail" method="post">
        <div class="form-group">
            <label>Languages</label>
            <form:select path="languages" items="${languages}"/>
        </div>
        <div class="form-group mt-2">
            <label>Page Size: show </label>
            <form:select path="pageSize" items="${pageSize}"/>
            <span> emails per page</span>
        </div>
        <div class="form-check mt-2">
            <label class="form-check-label" for="defaultCheck1">
                Spam Filter
            </label>
            <form:checkbox path="spamFilter" class="form-check-input" value="${mailBox.spamFilter}"
                        id="defaultCheck1"/>
        </div>
        <div class="form-group mt-3">
            <label>Signature</label>
            <form:textarea path="signature"/>
        </div>
        <button class="btn btn-danger my-3" type="button"><a class="text-white" style="text-decoration: none"
                                                             href="/showMail">Cancel</a></button>
        <button class="btn btn-primary my-3" type="submit">Update</button>
    </form:form>
</div>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hòm thư điện tử</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body class="d-flex justify-content-center">
<div class="px-3 py-3 mt-5" style="border: 1px solid black; display: inline-block">
    <h1 class="text-center">Show Information</h1>
    <h3 class="text-center">${msg}</h3>
    <br/>
    <div>
        <div>Languages: ${mailBox.languages}</div>

        <div>Page size: Show ${mailBox.pageSize} emails per page</div>

        <div>Spam filter: ${spamFilter}</div>

        <div>Signature: ${mailBox.signature}</div>

        <button class="mt-3 btn btn-primary"><a class="text-white" href="/updateFormMail" style="text-decoration: none">Update</a></button>
    </div>
</div>
</body>
</html>
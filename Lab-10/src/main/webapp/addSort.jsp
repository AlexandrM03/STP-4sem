<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add sort</title>
</head>
<body>
<h3>New method</h3>
<form action="AddMethodServlet" method="post">
    <label>Name</label>
    <br>
    <input type="text" name="name">
    <br>
    <label>Speed</label>
    <br>
    <input type="text" name="speed">
    <br>
    <input type="submit" value="add">
</form>
</body>
</html>

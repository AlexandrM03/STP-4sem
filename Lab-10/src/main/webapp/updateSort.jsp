<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update sort</title>
</head>
<body>
<h3>Update method</h3>
<form action="UpdateMethodServlet" method="post">
    <label>Name</label>
    <br>
    <input type="text" name="name">
    <br>
    <label>Speed</label>
    <br>
    <input type="text" name="speed">
    <br>
    <input type="submit" value="update">
</form>
</body>
</html>

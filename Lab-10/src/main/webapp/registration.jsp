<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h3 style="color: red">${message}</h3>
<fieldset>
    <legend>Registration</legend>
    <form action="RegistrationServlet" method="POST">
        <input name="login" type="text" placeholder="login">
        <input name="password" type="text" placeholder="password">
        <input type="submit" value="Register">
    </form>
</fieldset>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3 style="color: red">${message}</h3>
<fieldset>
    <legend>Login</legend>
    <form action="LoginServlet" method="POST">
        <input name="login" type="text" placeholder="login">
        <input name="password" type="text" placeholder="password">
        <input type="submit" value="Login">
    </form>
    <form action="RegistrationRedirect" method="POST">
        <input type="submit" value="Registration">
    </form>
</fieldset>
</body>
</html>

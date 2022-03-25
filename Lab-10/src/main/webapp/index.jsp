<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.User" %>
<%@ page import="requests.SortRequest" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.SortMethod" %>
<html>
<head>
    <title>Lab-10</title>
    <style>
        form {
            display: inline-block;
            margin-right: 70px;
        }
        table {
            border: 1px solid black;
            border-collapse: collapse;
            min-width: 300px;
            background: #92eeff;
            text-align: center;
        }
    </style>
</head>
<body>
<%@include file="header.jsp" %>
<br>

<% User user = (User) session.getAttribute("current_user"); %>
<h1>Welcome, <%= user.getLogin() %>. Role is <%= user.getRole() %>
</h1>
<h3>Methods:</h3>
<%
    try {
        SortRequest sortRequest = new SortRequest();
        ArrayList<SortMethod> methods = sortRequest.selectSorts();
        for (SortMethod method : methods) {
%>
<table>
    <tr>
        <td><%= method.getName() %></td>
        <td><%= method.getSpeed() %></td>
    </tr>
</table>
<%
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>

<form action="addSort.jsp" method="post">
    <input type="submit" value="add">
</form>
<form action="updateSort.jsp" method="post">
    <input type="submit" value="update">
</form>
<form action="deleteSort.jsp" method="post">
    <input type="submit" value="delete">
</form>

<br>
<%@include file="footer.jsp" %>
</body>
</html>
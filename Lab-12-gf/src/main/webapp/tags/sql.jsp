<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
    <title>Sql JSTL tags</title>
    <style>
        table {
            border-collapse: collapse;
        }
        td {
            border: 1px solid black;
            padding: 5px;
            width: 100px;
        }
    </style>
</head>
<body>
    <sql:setDataSource var="methods" 
        url="jdbc:sqlserver://ALEXANDER;databaseName=java_servlet;trustServerCertificate=true;encrypt=false;IntegratedSecurity=false"
        driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" user="sa" password="1111"/>

    <sql:query var="rs" dataSource="${methods}">
        select * from sort_methods;
    </sql:query>

    <table>
        <tr>
            <th>name</th>
            <th>speed</th>
        </tr>
        <c:forEach items="${rs.rows}" var="row">
            <tr>
                <td>${row.name}</td>
                <td>${row.speed}</td>
            </tr>
        </c:forEach>
        </tr>
    </table>
</body>
</html>

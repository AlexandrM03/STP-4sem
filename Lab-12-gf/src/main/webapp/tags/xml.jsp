<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<html>
<head>
    <title>Xml JSTL tags</title>
    <style>
        table {
            border-collapse: collapse;
        }
        td, th {
            border: 1px solid black;
            padding: 5px;
            width: 250px;
        }
    </style>
</head>
<body>
<x:parse var="novels">
    <c:import url="novels.xml"/>
</x:parse>

<c:catch var="exception">
    <table>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
        </tr>
        <x:forEach var="item" select="$novels/books/book">
            <tr>
                <td><x:out select="$item/name/text()"/></td>
                <td><x:out select="$item/author/text()"/></td>
                <td><x:out select="$item/price/text()"/></td>
            </tr>
        </x:forEach>
    </table>
</c:catch>
<c:if test="${exception != null}">
    <p>Exception : ${exception} <br/>
        Message : ${exception.message}</p>
</c:if>
</body>
</html>

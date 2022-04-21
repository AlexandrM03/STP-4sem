<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="my" uri="myTags.tld" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lab12</title>
</head>
<body>
<fieldset>
    <legend>Tags</legend>
    <form action="tags/core.jsp">
        <my:MADSubmit label="Core"/>
    </form>
    <form action="tags/formatting.jsp">
        <my:MADSubmit label="Formatting"/>
    </form>
    <form action="tags/sql.jsp">
        <my:MADSubmit label="Sql"/>
    </form>
    <form action="tags/xml.jsp">
        <my:MADSubmit label="Xml"/>
    </form>
    <form action="tags/functions.jsp">
        <my:MADSubmit label="Funtions"/>
    </form>
    <form action="table.jsp">
        <my:MADSubmit label="Table"/>
    </form>
</fieldset>
</body>
</html>
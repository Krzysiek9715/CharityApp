<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 27.06.2022
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/form3" method="post">
    <c:forEach items="${allInstitutions}" var="institution">
        <input type="checkbox" name="institution" value="${institution.id}"> ${institution.name}</br>
        ${institution.description} </br>
    </c:forEach>
    <input type="submit" value="next">
</form>

<%--<form action="/form3" method="post">--%>
<%--    <select name="institution">--%>
<%--        <c:forEach items="${allInstitutions}" var="institution">--%>
<%--            <option name="institution" value="${institution.id}">${institution.name}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
<%--    <input type="submit" value="next">--%>
<%--</form>--%>
</body>
</html>

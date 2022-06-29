<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 24.06.2022
  Time: 23:45
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
Instytucja:
<c:out value="${sessionInstitution}"/>
Kategoria
<c:forEach items="${session.categories}" var="category">
<c:out value="${category.name}"/>
</c:forEach>
Liczba worków:
<c:out value="${session.quantity}"/>

</body>
</html>

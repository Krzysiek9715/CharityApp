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
<form action="/formSum" method="post">
Instytucja:
<c:out value="${sessionData.institution.name}"/></br>
<c:out value="${sessionData.institution.description}"/></br>
</br>
Kategoria
<c:forEach items="${sessionData.categories}" var="category">
<c:out value="${category.name}"/></br>
</c:forEach>
</br>
Liczba worków:
<c:out value="${sessionData.quantity}"/>
</br>
Ulica:
<c:out value="${sessionData.street}"/>
</br>
Miasto:
<c:out value="${sessionData.city}"/>
</br>
kod pocztowy:
<c:out value="${sessionData.zipCode}"/>
</br>
data odbioru:
<c:out value="${sessionData.pickUpDate}"/>
</br>
godzina odbioru:
<c:out value="${sessionData.pickUpTime}"/>
</br>
komentarz:
<c:out value="${sessionData.pickUpComment}"/>
</br>
<input type="submit" value="send">
</form>
</body>
</html>

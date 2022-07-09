<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 03.07.2022
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp" %>


<%--<form:form action="/register" method="post" modelAttribute="user">--%>
<%--    <input type="email" name="email" placeholder="Email">--%>
<%--    <input type="text" name="login" placeholder="Nazwa użytkownika">--%>
<%--    <input type="password" name="password" placeholder="Hasło">--%>

<%--    <button type="submit">Załóż konto</button>--%>

<%--</form:form>--%>

<section class="login-page">
<h2>Załóż konto</h2>
<form:form action="/register" method="post" modelAttribute="user">
    <div class="form-group">
    <input type="email" name="email" placeholder="Email">
    </div>
    <div class="form-group">
    <input type="text" name="login" placeholder="Nazwa użytkownika">
    </div>
    <div class="form-group">
    <input type="password" name="password" placeholder="Hasło">
    </div>


    <div class="form-group form-group--buttons">
    <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
    <button class="btn" type="submit">Załóż konto</button>
    </div>
</form:form>
    </section>

    <%@include file="footer.jsp"%>

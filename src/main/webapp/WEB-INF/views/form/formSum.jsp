<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 24.06.2022
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@include file="header.jsp" %>


<section class="form--steps">
    <div class="form--steps-container">

        <form action="/formSum" method="post">
        <div data-step="5" class="active">
            <h3>Podsumowanie Twojej darowizny</h3>

            <div class="summary">
                <div class="form-section">
                    <h4>Oddajesz:</h4>
                    <ul>
                        <li>
                            <span class="icon icon-bag"></span>
                            <span class="summary--text">
                                Liczba worków: <c:out value="${sessionData.quantity}"/> </br> kategoria:
                                <c:forEach items="${sessionData.categories}" var="category">
                                <c:out value="${category.name}"/></br>
                                </c:forEach>
                            </span>
                        </li>

                        <li>
                            <span class="icon icon-hand"></span>
                            <span class="summary--text"
                            >Dla fundacji <c:out value="${sessionData.institution.name}"/></span
                            >
                        </li>
                    </ul>
                </div>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru:</h4>
                        <ul>
                            <li><c:out value="${sessionData.street}"/></li>
                            <li><c:out value="${sessionData.city}"/></li>
                            <li><c:out value="${sessionData.zipCode}"/></li>
                        </ul>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru:</h4>
                        <ul>
                            <li><c:out value="${sessionData.pickUpDate}"/></li>
                            <li><c:out value="${sessionData.pickUpTime}"/></li>
                            <li><c:out value="${sessionData.pickUpComment}"/></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="form-group form-group--buttons">
                <a href="/form2" class="btn">Wstecz</a>
                <input type="submit" class="btn" value="Potwierdzam"/>
            </div>
        </div>
        </form>
    </div>
</section>

<%@include file="footer.jsp" %>



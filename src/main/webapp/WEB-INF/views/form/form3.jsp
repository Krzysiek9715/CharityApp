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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp"%>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3><br/>
            <p>Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy wiedzieć komu najlepiej je przekazać
            </p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter"> Krok 3/4</div>


        <form action="/form3" method="post">
            <div data-step="3" class="active">
            <h3>Wybierz organizacje, której chcesz pomóc:</h3></br>

                <div class="form-group form-group--checkbox">
                        <c:forEach items="${allInstitutions}" var="institution">

                                <label>
                            <input type="radio" name="institution" value="${institution.id}">
                            <span class="checkbox radio"></span>
                            <span class="description">
                    <div class="title"> ${institution.name}</div>
                    <div class="description">${institution.description}</div>
                </span>
                                </label>
                        </c:forEach>
                </div>

                <div class="form-group form-group--buttons">
                    <a href="/form1" class="btn">Wstecz</a>
                    <input type="submit" class="btn" value="Dalej"/>
                </div>
            </div>
        </form>
    </div>
</section>

<%@include file="footer.jsp"%>

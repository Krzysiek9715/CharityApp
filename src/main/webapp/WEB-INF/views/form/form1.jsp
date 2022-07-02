<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 24.06.2022
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="header.jsp" %>


<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3><br/>
            <p>Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy wiedzieć komu najlepiej je przekazać
            </p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter"> Krok 1/4</div>

        <form action="/form1" method="post">
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3></br>


                <div class="form-group form-group--checkbox">
                    <c:forEach items="${allCategories}" var="category">
                        <label>
                            <input type="checkbox" name="categories" value="${category.id}"/>
                            <span class="checkbox"></span>
                            <span class="description">${category.name}</span>
                        </label>
                    </c:forEach>
                </div>
                <div class="form-group--buttons">
                    <input type="submit" class="btn" value="Dalej">
                </div>
            </div>

        </form>
    </div>
    </div>
</section>

<%@include file="footer.jsp" %>

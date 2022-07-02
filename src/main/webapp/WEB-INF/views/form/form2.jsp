<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 27.06.2022
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
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
        <div class="form--steps-counter"> Krok 2/4</div>



            <form action="/form2" method="post">
                <div data-step="2" class="active">
                    <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>
                    </br>
                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <input type="number" name="quantity" step="1" min="1">
                    </label>
                </div>
                <br/>
                <div class="form-group form-group--buttons">
                    <a href="form" class="btn">Wstecz</a>
                    <input type="submit" class="btn" value="Dalej"/>
                </div>
                </div>
            </form>
    </div>
</section>


<%@include file="footer.jsp" %>
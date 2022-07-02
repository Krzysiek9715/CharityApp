<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 30.06.2022
  Time: 20:19
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
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3><br/>
            <p>Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy wiedzieć komu najlepiej je przekazać
            </p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter"> Krok 4/4</div>

        <form method="post" action="/form4">
            <div data-step="4" class="active">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label>Ulica <input type="text" name="street"></label>
                        </div>
                        <div class="form-group form-group--inline">
                            <label>Miasto <input type="text" name="city"></label>
                        </div>
                        <div class="form-group form-group--inline">
                            <label>Kod pocztowy <input type="text" name="zipCode"></label>
                        </div>
                    </div>
                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label>Data <input type="date" name="pickUpDate"></label>
                        </div>
                        <div class="form-group form-group--inline">
                            <label>Godzina <input type="time" name="pickUpTime"></label>
                        </div>
                        <div class="form-group form-group--inline">
                            <label> Uwagi dla kuriera <input type="text" name="pickUpComment"></label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <a href="/form2" class="btn">Wstecz</a>
                    <input type="submit" class="btn" value="Dalej"/>
                </div>
            </div>
        </form>
    </div>
    </div>
</section>

<%@include file="footer.jsp" %>

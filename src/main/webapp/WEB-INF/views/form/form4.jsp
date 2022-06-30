<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 30.06.2022
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/form4">
Podaj adres oraz termin odbioru rzeczy przez kuriera:</br>
Adres odbioru</br>
Ulica: <input type="text" name="street"></br>
Miasto: <input type="text" name="city"></br>
Kod pocztowy: <input type="text" name="zipCode"></br>
</br>
Termin odbioru
</br>
Data: <input type="date" name="pickUpDate"></br>
Godzina: <input type="time" name="pickUpTime"></br>
Uwagi dla kuriera: <input type="text" name="pickUpComment"></br>
<input type="submit" value="next">
</form>
</body>
</html>

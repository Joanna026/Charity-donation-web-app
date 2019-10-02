<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>"/>
</head>
<body>
<%@include file="header.jsp" %>

<div class="contact">
    <h2>Wypełnij formularz</h2>
    <form:form class="form--contact" method="post" modelAttribute="donationDTO">
        <div class="form-section--checkboxes form-group--50" style="font-size: 4rem"><form:checkboxes path="categories"
                                                               items="${categories}" itemLabel="name" itemValue="id"/>
        </div>
        <div class="form-group--dropdown form-group--50">
            <form:select path="institution" items="${institutions}" itemLabel="name" itemValue="id"/>
        </div>
        <div class="form-group form-group--50"><form:input path="zipCode" placeholder="Kod pocztowy"/></div>
        <div class="form-group form-group--50"><form:input path="street" placeholder="Ulica"/></div>
        <div class="form-group form-group--50"><form:input path="city" placeholder="Miasto"/></div>
        <div class="form-group form-group--50"><form:input path="quantity" placeholder="Liczba worków"/></div>
        <div class="form-group"><form:textarea path="pickUpComment" placeholder="Dodatkowe uwagi"/></div>
        <div class="form-group form-group--50"><form:input type="date" path="pickUpDate"
                                                           placeholder="Data odbioru"/></div>
        <div class="form-group form-group--50"><form:input type="time" path="pickUpTime"
                                                           placeholder="Godzina odbioru"/></div>
        <div style="text-align: center"> <button class="btn" type="submit">Zatwierdź</button> </div>
    </form:form>
</div>

<%@include file="footer.jsp" %>

<script src="<c:url value="../../resources/js/app.js"/>"></script>
</body>
</html>
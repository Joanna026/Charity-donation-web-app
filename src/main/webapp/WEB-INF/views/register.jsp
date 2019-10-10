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
    <title><spring:message code="app.title"/></title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<%@include file="header.jsp" %>


<section class="login-page">
    <h2><spring:message code="createAccount.message"/></h2>
    <form:form method="post" modelAttribute="userDTO">
        <div class="form-group">
            <spring:message code="username.placeholder" var="usernamePlaceholder"/>
            <form:input type="text" path="username" placeholder="${usernamePlaceholder}" />
        </div>
        <div class="form-group">
            <spring:message code="firstname.placeholder" var="firstnamePlaceholder"/>
            <form:input type="text" path="firstname" placeholder="${firstnamePlaceholder}" />
        </div>
        <div class="form-group">
            <spring:message code="lastname.placeholder" var="lastnamePlaceholder"/>
            <form:input type="text" path="lastname" placeholder="${lastnamePlaceholder}" />
        </div>
        <div class="form-group">
            <form:input type="email" path="email" placeholder="Email" />
        </div>
        <div class="form-group">
            <spring:message code="password.placeholder" var="passwordPlaceholder"/>
            <form:input path="password" type="password"  placeholder="${passwordPlaceholder}" />
        </div>
        <div class="form-group">
            <input type="password" name="password2" placeholder="<spring:message code="repeatPassword.placeholder"/>" />
        </div>

        <div class="form-group form-group--buttons">
            <a href="<c:url value="/login"/>" class="btn btn--without-border"><spring:message code="login.message"/></a>
            <button class="btn" type="submit"><spring:message code="createAccount.message"/></button>
        </div>
    </form:form>
</section>

<%@include file="footer.jsp"%>
</body>
</html>

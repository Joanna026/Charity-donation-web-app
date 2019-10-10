<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title><spring:message code="app.title"/></title>
    <link rel="stylesheet" href="/resources/css/style.css" />

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="header.jsp"%>


<section class="login-page">
    <h2><spring:message code="login.message"/></h2>
    <form action="login" method="POST">
        <div class="form-group">
            <input type="text" name="username" placeholder="<spring:message code="username.placeholder"/>" />
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="<spring:message code="password.placeholder"/>" />
            <a href="#" class="btn btn--small btn--without-border reset-password"><spring:message code="remindPassword.message"/></a>
        </div>

        <div class="form-group form-group--buttons">
            <a href="<c:url value="/add"/>" class="btn btn--without-border"><spring:message code="createAccount.message"/></a>
            <button class="btn" type="submit"><spring:message code="login.message"/></button>
        </div>
    </form>
</section>

<%@include file="footer.jsp"%>

<script type="text/javascript" src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>

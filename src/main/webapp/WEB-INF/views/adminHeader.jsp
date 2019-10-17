<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 10/17/19
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
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
    <link rel="stylesheet" href="../../resources/css/style.css"/>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
</head>
<body>

<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li class="logged-user">
                <spring:message code="hello.message" arguments="${pageContext.request.userPrincipal.name}"/>
                <ul class="dropdown">
                    <li><a href="#"><spring:message code="myProfile.message"/></a></li>
                    <li><a href="<c:url value="/logout"/>"><spring:message code="logout.message"/></a></li>
                </ul>
            </li>
        </ul>

        <ul>
            <li><a href="<c:url value="/"/>" class="btn btn--without-border active"><spring:message code="start.message"/></a></li>
            <li><a href="<c:url value="/admin/institutions"/>" class="btn btn--without-border"><spring:message code="institutions.message"/></a></li>
            <li><a href="#" class="btn btn--without-border"><spring:message code="contact.message"/></a></li>
        </ul>
    </nav>
</header>


</body>
</html>

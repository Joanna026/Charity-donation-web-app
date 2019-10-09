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
    <link rel="stylesheet" href="../../resources/css/style.css" />

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
</head>
<body>
<header class="header--form-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li class="logged-user">
                <spring:message code="hello.message" arguments="${'#httpServletRequest.remoteUser'}"/>
                <ul class="dropdown">
                    <li><a href="#"><spring:message code="myProfile.message"/></a></li>
                    <li><a href="#"><spring:message code="myDonations.message"/></a></li>
                    <li><a href="#"><spring:message code="logout.message"/></a></li>
                </ul>
            </li>
        </ul>

        <ul>
            <li><a href="#" class="btn btn--without-border active"><spring:message code="start.message"/></a></li>
            <li><a href="#" class="btn btn--without-border"><spring:message code="what.message"/></a></li>
            <li><a href="#" class="btn btn--without-border"><spring:message code="aboutUsTitle.message"/> </a></li>
            <li><a href="#" class="btn btn--without-border"><spring:message code="institutions.message"/></a></li>
            <li><a href="#" class="btn btn--without-border"><spring:message code="contact.message"/></a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <h2>
            <spring:message code="thankYou.message"/>
        </h2>
    </div>
</header>


<%@include file="footer.jsp"%>

<script type="text/javascript" src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>

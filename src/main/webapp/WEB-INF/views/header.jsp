<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title><spring:message code="app.title"/></title>

    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>"/>

</head>
<body>


<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="" class="btn btn--small btn--without-border"><spring:message code="login.message"/></a></li>
            <li><a href="#" class="btn btn--small btn--highlighted"><spring:message code="createAccount.message"/>o</a></li>
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
        <div class="slogan--item">
            <h1>
                <spring:message code="startHelping.message"/><br/>
                <spring:message code="give.message"/>
            </h1>
        </div>
    </div>
</header>

<script src="<c:url value="../../resources/js/app.js"/>"></script>
</body>
</html>

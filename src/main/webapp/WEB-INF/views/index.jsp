<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title><spring:message code="app.title"/></title>

    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>"/>
</head>
<body>

<%--depending includeded header version on authorisation and role--%>

<sec:authorize access="isAnonymous()">
    <%@include file="header.jsp" %>
</sec:authorize>

<sec:authorize access="hasRole('USER')">
    <%@include file="loggedInHeader.jsp"%>
</sec:authorize>

<sec:authorize access="hasRole('ADMIN')">
    <%@include file="adminHeader.jsp"%>
</sec:authorize>

<%--HOMEPAGE FOR USER ROLE--%>
<sec:authorize access="hasRole('USER')">

<%--displaying total quantity of donated bags and supported institutions--%>

<section class="stats">
    <div class="container container--85">
        <div class="stats--item">
            <em>${totalQuantity}</em>

            <h3><spring:message code="donatedBags.message"/></h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae, quod accusamus illum
                tempora!</p>
        </div>

        <div class="stats--item">
            <em>${institutionNumber}</em>
            <h3><spring:message code="supportedInstitutions.message"/></h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam, sint nihil cupiditate quas
                quam.</p>
        </div>

    </div>
</section>

<%--description of donating precedure--%>

<section class="steps">
    <h2><spring:message code="intro.message"/></h2>

    <div class="steps--container">
        <div class="steps--item">
            <span class="icon icon--hands"></span>
            <h3><spring:message code="step1Title.message"/></h3>
            <p><spring:message code="step1Desc.message"/></p>
        </div>
        <div class="steps--item">
            <span class="icon icon--arrow"></span>
            <h3><spring:message code="step2Title.message"/></h3>
            <p><spring:message code="step2Desc.message"/></p>
        </div>
        <div class="steps--item">
            <span class="icon icon--glasses"></span>
            <h3><spring:message code="step3Title.message"/></h3>
            <p><spring:message code="step3Desc.message"/></p>
        </div>
        <div class="steps--item">
            <span class="icon icon--courier"></span>
            <h3><spring:message code="step4Title.message"/></h3>
            <p><spring:message code="step4Desc.message"/></p>
        </div>
    </div>

    <a href="<c:url value="/add"/>" class="btn btn--large"><spring:message code="createAccount.message"/></a>
</section>

<%--description of organisation goals--%>

<section class="about-us">
    <div class="about-us--text">
        <h2><spring:message code="aboutUsTitle.message"/></h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas vitae animi rem pariatur incidunt libero
            optio esse quisquam illo omnis.</p>
        <img src="<c:url value="../../resources/images/signature.svg"/>" class="about-us--text-signature"
             alt="Signature"/>
    </div>
    <div class="about-us--image"><img src="<c:url value="../../resources/images/about-us.jpg"/>"
                                      alt="People in circle"/>
    </div>
</section>

<%--list of all available institutions--%>

<section class="help">
    <h2><spring:message code="helpTitle.message"/></h2>

    <!-- SLIDE 1 -->
    <div class="help--slides active" data-id="1">
        <p><spring:message code="helpContent.message"/></p>

        <ul class="help--slides-items">
            <c:forEach items="${institutions}" var="institution" varStatus="count">
                <c:if test="${count.index % 2 == 0}">
                    <li>
                </c:if>
                <div class="col">
                    <div class="title"><spring:message code="foundationName.message" arguments="${institution.name}"/> </div>
                    <div class="subtitle"><spring:message code="foundationGoals.message" arguments="${institution.description}"/></div>
                </div>
                <c:if test="${count.index % 2 == 1}">
                    </li>
                </c:if>
            </c:forEach>
        </ul>
    </div>

</section>

</sec:authorize>

<%--HOMEPAGE FOR ADMIN ROLE--%>
<sec:authorize access="hasRole('ADMIN')">

</sec:authorize>


<%@include file="footer.jsp" %>

<script src="<c:url value="../../resources/js/app.js"/>"></script>
</body>
</html>

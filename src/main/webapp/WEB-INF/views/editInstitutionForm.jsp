<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 10/17/19
  Time: 9:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
<%@include file="adminHeader.jsp" %>

<section class="login-page">
    <h2><spring:message code="addInstitution.message"/></h2>
    <form:form method="post" modelAttribute="institutionToEdit">
        <form:hidden path="id"/>
        <div class="form-group">
            <spring:message code="institutionName.placeholder" var="institutionNamePlaceholder"/>
            <form:input type="text" path="name" placeholder="${institutionNamePlaceholder}" autofocus="true"/>
        </div>
        <div class="form-group">
            <spring:message code="institutionDescription.placeholder" var="institutionDescriptionPlaceholder"/>
            <form:input type="text" path="description" placeholder="${institutionDescriptionPlaceholder}"/>
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit"><spring:message code="edit-institution.message"/></button>
        </div>
    </form:form>
</section>

<%@include file="footer.jsp" %>
<script src="<c:url value="../../resources/js/app.js"/>"></script>
</body>
</html>

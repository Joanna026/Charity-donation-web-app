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

<%@include file="adminHeader.jsp" %>

<section class="help">
    <h2><spring:message code="listTitle.message"/></h2>


    <!-- list of all available institutions -->

    <div class="help--slides active" data-id="1">

        <ul class="help--slides-items" style="text-align: left">
            <c:forEach items="${institutions}" var="institution" varStatus="counter">
                <li>
                    <div class="col">
                        <div class="title"> ${counter.count}. ${institution.name}
                            <a href="<c:url value="/admin/institution/edit?id=${institution.id}"/>"
                               class="btn btn--without-border"><spring:message code="edit.message"/></a>
                            <a href="<c:url value="/admin/institutions/delete?id=${institution.id}"/>"
                               class="btn btn--without-border"><spring:message code="delete.message"/></a>
                        </div>
                        <div class="subtitle"><spring:message code="foundationGoals.message"
                                                              arguments="${institution.description}"/></div>
                    </div>
                </li>
            </c:forEach>
            <li>
                <a href="<c:url value="/admin/institution/add"/>" class="btn btn--without-border active"><spring:message
                        code="addInstitution.message"/></a>
            </li>
        </ul>
    </div>

</section>

<%@include file="footer.jsp" %>

<script src="<c:url value="../../resources/js/app.js"/>"></script>
</body>
</html>

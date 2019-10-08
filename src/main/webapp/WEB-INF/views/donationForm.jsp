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
<%@ include file="header.jsp"%>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3><spring:message code="importantTitle.message"/></h3>
            <p data-step="1" class="active">
                <spring:message code="importantStep1-2.message"/>
            </p>
            <p data-step="2">
                <spring:message code="importantStep1-2.message"/>
            </p>
            <p data-step="3">
                <spring:message code="importantStep3.message"/>
            </p>
            <p data-step="4"><spring:message code="importantStep4.message"/>
            </p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter"><spring:message code="stepCounter.message"/><span>1</span>/4</div>

        <form:form method="post" modelAttribute="donationDTO">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3><spring:message code="step1.message"/></h3>


                        <c:forEach items="${categories}" var="category">
                <div class="form-group form-group--checkbox">
                            <label>
                                <input type="checkbox" name="categories" value="${category.id}"
                                       data-name="${category.name}"/>
                            <span class="checkbox"><form:checkbox path="categoryDTO" value="category"/></span>
                            <span class="description">${category.name}</span>
                            </label>
                </div>
                        </c:forEach>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step"><spring:message code="nextBtn.message"/></button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3><spring:message code="step2.message"/></h3>

                <div class="form-group form-group--inline">
                    <label>
                        <spring:message code="step2Label.message"/>
                        <input type="number" name="bags" id="quantity" step="1" min="1" />
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><spring:message code="prevBtn.message"/></button>
                    <button type="button" class="btn next-step"><spring:message code="nextBtn.message"/></button>
                </div>
            </div>



            <!-- STEP 4 -->
            <div data-step="3">
                <h3><spring:message code="step3.message"/></h3>


                <c:forEach items="${institutions}" var="institution">
                <div class="form-group form-group--checkbox">
                    <label>
                        <input type="radio" name="organization" value="${institution.name}"/>
                        <span class="checkbox radio"><form:radiobutton path="institutionDTO" value="institution"/></span>
                        <span class="description">
                  <div class="title"><spring:message code="foundationName.message" arguments="${institution.name}"/></div>
                  <div class="subtitle">
                    <spring:message code="foundationGoals.message" arguments="${institution.description}"/>
                  </div>
                </span>
                    </label>
                </div>
                </c:forEach>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><spring:message code="prevBtn.message"/></button>
                    <button type="button" class="btn next-step"><spring:message code="nextBtn.message"/></button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="4">
                <h3><spring:message code="step4.message"/></h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4><spring:message code="address.message"/></h4>
                        <div class="form-group form-group--inline">
                            <label> <spring:message code="street.message"/> <form:input path="street" id="street" /> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> <spring:message code="city.message"/> <form:input path="city" id="city" var="city" /> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                <spring:message code="postcode.message"/> <form:input path="zipCode" id="postcode" />
                            </label>
                        </div>

<%--                        <div class="form-group form-group--inline">--%>
<%--                            <label>--%>
<%--                                <spring:message code="phone.message"/> <form:input path="" name="phone" />--%>
<%--                            </label>--%>
<%--                        </div>--%>
                    </div>

                    <div class="form-section--column">
                        <h4><spring:message code="pickUpTime.message"/> </h4>
                        <div class="form-group form-group--inline">
                            <label> <spring:message code="date.message"/>  <form:input path="pickUpDate" id="date" type="date" pattern = "dd-MM-yyyy"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label><spring:message code="time.message"/>  <form:input path="pickUpTime" id="time" type="time" /> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                <spring:message code="comment.message"/>
                                <form:textarea path="pickUpComment" id="more-info" rows="5"/>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><spring:message code="prevBtn.message"/></button>
                    <button type="button" class="btn next-step"><spring:message code="nextBtn.message"/></button>
                </div>
            </div>

            <!-- STEP 6 -->
            <div data-step="5">
                <h3><spring:message code="step5.message"/></h3>

                <div class="summary">
                    <div class="form-section">
                        <h4><spring:message code="summaryTitle.message"/></h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text" id="quantity-summary">
                                    <input id="quantity1Message" type="hidden" value="<spring:message code='summaryQuantity1.message'/>"/>
                                    <input id="quantity2-4Message" type="hidden" value="<spring:message code='summaryQuantity2-4.message'/>"/>
                                    <input id="quantity5andMoreMessage" type="hidden" value="<spring:message code='summaryQuantity5andMore.message'/>"/>
                                </span>
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text" id="institution-summary">
                                    <input id="institutionMessage1" type="hidden" value="<spring:message code='summaryInstitutionPart1.message'/>"/>
                                    <input id="institutionMessage2" type="hidden" value="<spring:message code='summaryInstitutionPart2.message'/>"/>
                                </span>
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4><spring:message code="address.message"/></h4>
                            <ul id="address"> </ul>
                        </div>

                        <div class="form-section--column">
                            <h4><spring:message code="pickUpTime.message"/></h4>
                            <ul id="date-time">
                            <c:set var="message"> <spring:message code="noComment.message"/> </c:set>
                                <input id="noComment" type="hidden" value="${message}"/>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><spring:message code="prevBtn.message"/></button>
                    <button type="submit" class="btn"><spring:message code="submitBtn.message"/></button>
                </div>
            </div>
        </form:form>
    </div>
</section>

<%@include file="footer.jsp"%>

<script type="text/javascript" src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>

<%-- 
    Document   : user
    Created on : 21 déc. 2016, 16:03:28
    Author     : cdi305
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:choose>
    <c:when test="${not empty user}">

        <li class="dropdown">
            <c:url value="/" var="url">
                <c:param name="section" value="security" />
                <c:param name="action" value="logout" />
            </c:url>

            <a data-toggle="dropdown" class="dropdown-toggle" href="#" aria-expanded="false">
                <span class="glyphicon glyphicon-user"></span>
                <span class="caret"></span>
            </a>

            <ul class="dropdown-menu">
                <li class="dropdown-header"> <c:out value="${ user.nom }" /> </li>

                <li><a href="${ url }"> Se déconnecter </a></li>
            </ul>
        </li>
    </c:when>

    <c:otherwise>
        <c:url value="/" var="url">
            <c:param name="section" value="security" />
            <c:param name="action" value="login" />
        </c:url>
        <li>
            <a href="${ url }"> Se connecter </a>
        </li>
    </c:otherwise>
</c:choose>
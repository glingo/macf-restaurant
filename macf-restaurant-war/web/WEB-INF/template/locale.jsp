<%-- 
    Document   : locale
    Created on : 21 déc. 2016, 16:27:55
    Author     : cdi305
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:if test="${empty lang}">
    <c:set var="lang" value="${ pageContext.request.locale.language }" />
    <fmt:setLocale value="${ lang }"/>
</c:if>

<li class="dropdown">

    <a data-toggle="dropdown" class="dropdown-toggle" href="#" aria-expanded="false">
        Langues
        <span class="caret"></span>
    </a>

    <ul class="dropdown-menu">
        <li <c:if test="${lang eq 'en'}"> class="active"</c:if>>
                <a href="/macf-restaurant-war/?section=locale&lang=en">Anglais</a>
            </li>
            <li <c:if test="${lang eq 'fr'}"> class="active"</c:if>>
            <a href="/macf-restaurant-war/?section=locale&lang=fr">Francais</a>
        </li>
    </ul>
</li>
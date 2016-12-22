<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="config.error" var="error" />
<fmt:setBundle basename="config.button" var="button" />

<t:template title="error-404">
    
    <jsp:attribute name="header">
        <header>
            <div class="container logo">
                <a href="/macf-restaurant-war/">
                    <img class="img-responsive" src="/macf-restaurant-war/images/logos/logo.png" alt="">
                </a>
            </div>
        </header>
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="http-error">
                <h1><fmt:message key="not.found.code" bundle="${ error }"/></h1>
                <p><fmt:message key="not.found" bundle="${ error }" /></p>
                <p class="text-muted"><fmt:message key="not.found.add" bundle="${ error }"/></p>
                <a href="/macf-restaurant-war/" class="btn btn-primary">
                    <fmt:message key="back.home" bundle="${ button }"/>
                </a>
            </div>
        </div>
    </jsp:body>
</t:template>
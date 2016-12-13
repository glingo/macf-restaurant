<%-- 
    Document   : 404
    Created on : 13 déc. 2016, 15:20:21
    Author     : cdi305
--%>

<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="config.error" />

<t:template title="error-404">

    <jsp:body>
        
        <div class="col-lg-12">
            <fmt:message key="not.found" />
            <br />
            message : <c:out value="${ requestScope['javax.servlet.error.message'] }" />
        <br />
        
        
        </div>
    </jsp:body>
</t:template>

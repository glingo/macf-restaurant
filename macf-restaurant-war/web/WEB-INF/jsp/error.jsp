<%@page isErrorPage="true" import="java.io.*" contentType="text/html"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="config.error" />

<t:template title="error-404">

    <jsp:body>
        <div class="col-lg-12">
            <br />

            URI : <c:out value="${ pageContext.errorData.requestURI }" />
            <br />

            Code : <c:out value="${ pageContext.errorData.statusCode }" />
            <br />

            Name : <c:out value="${ pageContext.errorData.servletName }" />
            <br />

            Trace : <c:out value="${ pageContext.errorData.throwable.printStackTrace() }" />
            <br />

            Exception : <c:out value="${ exception }" />
            <br />

            Message : <c:out value="${ pageContext.errorData.throwable.message }" />
            <br />

            javax.servlet.error.message : <c:out value="${ javax.servlet.error.message }" />

            <br />
        
        
        </div>
    </jsp:body>
</t:template>
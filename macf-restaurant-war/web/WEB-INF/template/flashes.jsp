<%-- 
    Document   : flashes
    Created on : 20 déc. 2016, 14:57:37
    Author     : cdi305
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:if test="${not empty flashbag}">

    <c:forEach var="entry" items="${ flashbag.getAll() }">

        <c:forEach var="flash" items="${ entry.value }">
            
            <div class="alert alert-${ entry.key } alert-dismissible" role="alert">
                
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>

                <c:out value="${ flash }" />
                
            </div>

        </c:forEach>


    </c:forEach>

</c:if>
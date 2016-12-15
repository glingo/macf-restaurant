<%-- 
    Document   : commande
    Created on : 14 déc. 2016, 16:03:22
    Author     : cdi301
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="liste des commandes">

    <jsp:attribute name="styles">
    </jsp:attribute>

    <jsp:attribute name="scripts">
    </jsp:attribute>
    
    <jsp:body>
        <div class="col-lg-12">
            
             <c:forEach var="commande" items="${ commandes }">
        
                <li>
                    
                    <c:url value="/" var="url">
                        <c:param name="section" value="commande" />
                        <c:param name="action" value="listDetailCommande" />
                        <c:param name="numero" value="${ commande.numero }" />
                    </c:url>
                    
                    <a href="${ url }"><c:out value="${ commande.numero } "></c:out></a>
                </li>

            </c:forEach>
        </div>
    </jsp:body>
</t:template>
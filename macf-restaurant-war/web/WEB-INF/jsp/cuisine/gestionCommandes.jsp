<%-- 
    Document   : list
    Created on : 13 déc. 2016, 15:50:47
    Author     : cdi309
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="macf-restaurant">

    <jsp:attribute name="styles">
    </jsp:attribute>

    <jsp:attribute name="scripts">
    </jsp:attribute>

    <jsp:body>
       
        <div class="col-lg-12">
            
            <c:forEach var="commandes" items="${ commandes }"><br>
        
                <li>
                    
                    <c:url value="/" var="url">
                        <c:param name="section" value="commande" />
                        <c:param name="action" value="listCommandeAttente" />
                        <c:param name="numero" value="${ commande.numero }" />
                    </c:url>
                 
                    Commande n° : ${ commande.numero }
                </li>

            </c:forEach>
        </div>
    </jsp:body>
</t:template>



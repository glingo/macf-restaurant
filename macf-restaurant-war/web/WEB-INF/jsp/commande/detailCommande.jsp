<%-- 
    Document   : detailCommande
    Created on : 15 déc. 2016, 15:06:56
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

            Detail de la commande numero : <c:out value="${ commande.getNumero() }" />

            <c:choose>
                <c:when test="${ not empty commande.getLigneDeCommandes() }">
                    <ul>
                        <c:forEach var="ligne" items="${ commande.getLigneDeCommandes() }"><br>

                            <li>
                                <c:out value="${ ligne.getLibelle() } ${ ligne.statut }" />
                                <c:if test="${ not empty ligne.menu }">
                                    <ul>
                                        <c:forEach var="sousLigne" items="${ ligne.sousLigneDeCommande }">
                                            <li>
                                                <c:out value="${ sousLigne.getLibelle() } ${ sousLigne.statut }" />
                                            </li>
                                        </c:forEach>
                                    </ul><br>
                                </c:if>
                            </li>

                        </c:forEach>
                       
                    </ul>
                </c:when>
                <c:otherwise>
                    Pas de ligne de commande
                </c:otherwise>
            </c:choose>
            
        </div>
    </jsp:body>
</t:template>

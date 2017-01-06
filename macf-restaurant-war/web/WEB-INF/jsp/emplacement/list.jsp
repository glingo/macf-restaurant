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
        <div>
            <meta http-equiv="refresh" content="5">
             
             
             <p>Nous sommes le ${today}.</p>
        </div>
        <div class="col-lg-12">
            <table style="width:100%">
            
            



                <tr>
                    <td>    
                        <c:forEach var="emplacement" items="${ emplacements }">
                            <!-- attention à mettre le meme nom ici que dans le setAttribute dans le controller-->

                            <c:url value="" var="url">
                                <c:param name="section" value="emplacement" />
                                <c:param name="action" value="listDetailEmplacement" />
                                <c:param name="id" value="${ emplacement.id }" />
                            </c:url>
                            
                            <h3>Emplacement numéro : <c:out value="${ emplacement.getNumero() }" /><h3>

                                <ul>
                                    <li>
                                    Numéros de table :<c:out value=" ${ emplacement.numero }"/>
                                </li>
                                <li>
                                    Nombre de place :<c:out value=" ${ emplacement.nombrePlace }"/>
                                </li>
                                <li>
                                    Zone : <c:out value="${ emplacement.zone.numero }"/>
                                </li>
                                <li>
                                    Statut :<c:out value=" ${ emplacement.statut}"/>
                                </li>
                            </ul>

                            <c:url value="" var="url01">
                                <c:param name="section" value="emplacement" />
                                <c:param name="action" value="updateStatut" />
                                <c:param name="id" value="${ emplacement.id }" />
                                <c:param name="statut" value="LIBRE" />
                            </c:url>
                            <c:url value="" var="url02">
                                <c:param name="section" value="emplacement" />
                                <c:param name="action" value="updateStatut" />
                                <c:param name="id" value="${ emplacement.id }" />
                                <c:param name="statut" value="EN_NETTOYAGE" />
                            </c:url>
                            <c:url value="" var="url03">
                                <c:param name="section" value="emplacement" />
                                <c:param name="action" value="updateStatut" />
                                <c:param name="id" value="${ emplacement.id }" />
                                <c:param name="statut" value="OCCUPE" />
                            </c:url>  
                            <c:if test="${ emplacement.statut.code != 'LIB'}"> <a href="${url01}" class="btn bg-success">Libre</a></c:if>
                            <c:if test="${ emplacement.statut.code != 'ENT'}"><a href="${url02}" class="btn bg-warning">A nettoyer</a></c:if>
                            <c:if test="${ emplacement.statut.code != 'OCC'}"><a href="${url03}" class="btn bg-danger">Occupé</a></c:if>
                            <br>
                            <br>
                            <c:url value="" var="url04">
                                <c:param name="section" value="commande"/>
                                <c:param name="action" value="listCommande"/>
                            </c:url>
                            <a href="${url04}" class="btn bg-primary">Passer une commande</a>
                            
                        
                        </c:forEach>
                    </td>
                    
                </tr>
                
                
            </table>

        </div>
    </jsp:body>
</t:template>


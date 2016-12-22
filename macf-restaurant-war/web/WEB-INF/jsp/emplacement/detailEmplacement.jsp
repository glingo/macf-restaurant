
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="liste detail emplacement">

    <jsp:attribute name="styles">
    </jsp:attribute>

    <jsp:attribute name="scripts">
    </jsp:attribute>

    <jsp:body>
        <div class="col-lg-12">
            <h3>Detail de l'emplacement numero : <c:out value="${ empl01.getNumero() }" /><h3>
                    <ul>
                        <li>
                            Numéros de table :<c:out value=" ${ empl01.numero }"/>
                        </li>
                        <li>
                            Nombre de place :<c:out value=" ${ empl01.nombrePlace }"/>
                        </li>
                        <li>
                            Zone : <c:out value="${ empl01.zone.numero }"/>
                        </li>
                        <li>
                            Statut :<c:out value=" ${ empl01.statut }"/>
                        </li>
                    </ul>

                    <c:url value="" var="url01">
                        <c:param name="section" value="emplacement" />
                        <c:param name="action" value="updateStatut" />
                        <c:param name="id" value="${ empl01.id }" />
                        <c:param name="statut" value="LIBRE" />
                    </c:url>
                    <c:url value="" var="url02">
                        <c:param name="section" value="emplacement" />
                        <c:param name="action" value="updateStatut" />
                        <c:param name="id" value="${ empl01.id }" />
                        <c:param name="statut" value="EN_NETTOYAGE" />
                    </c:url>
                    <c:url value="" var="url03">
                        <c:param name="section" value="emplacement" />
                        <c:param name="action" value="updateStatut" />
                        <c:param name="id" value="${ empl01.id }" />
                        <c:param name="statut" value="OCCUPE" />
                    </c:url>  
                    <c:if test="${ empl01.statut.code != 'LIB'}"> <a href="${url01}" class="btn bg-success">Libre</a></c:if>
                    <c:if test="${ empl01.statut.code != 'ENT'}"><a href="${url02}" class="btn bg-warning">A nettoyer</a></c:if>
                    <c:if test="${ empl01.statut.code != 'OCC'}"><a href="${url03}" class="btn bg-danger">Occupé</a></c:if>
   </div>
                </jsp:body>
            </t:template>

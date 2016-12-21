
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
                    Numéros de table : ${ empl01.numero }
                </li>
                <li>
                    Nombre de place : ${ empl01.nombrePlace }
                </li>
                <li>
                    Zone : ${ empl01.zone }
                </li>
                <li>
                    Statut : ${ empl01.statut }
                </li>
            </ul>

            <c:url value="" var="url01">
                <c:param name="section" value="emplacement" />
                <c:param name="action" value="updateStatut" />
                <c:param name="id" value="${ empl01.id }" />
                <c:param name="statut" value="libre" />
            </c:url>
            <c:url value="" var="url02">
                <c:param name="section" value="emplacement" />
                <c:param name="action" value="updateStatut" />
                <c:param name="id" value="${ empl01.id }" />
                <c:param name="statut" value="nettoyer" />
            </c:url>
            <c:url value="" var="url03">
                <c:param name="section" value="emplacement" />
                <c:param name="action" value="updateStatut" />
                <c:param name="id" value="${ empl01.id }" />
                <c:param name="statut" value="occupe" />
            </c:url>  
            <a href="${url01}" class="btn bg-primary">Libre</a>
            <a href="${url02}" class="btn bg-primary">A nettoyer</a>
            <a href="${url03}" class="btn bg-primary">Occupé</a>

        </div>
    </jsp:body>
</t:template>

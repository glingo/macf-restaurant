
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Détail d'un menu">

    <jsp:attribute name="styles">
    </jsp:attribute>

    <jsp:attribute name="scripts">
    </jsp:attribute>

    <jsp:body>
        <div class="col-lg-12"> 
            
            <c:out value="${ menu.libelle }" /> . . . . . . . . . . . . . .${ menu.prix }</a>
        <ul>
            <c:forEach var="article" items="${menu.articles}">
                <li>
                     <c:url value="" var="url">
                        <c:param name="section" value="carte" />
                        <c:param name="action" value="afficherDetailArticle" />
                        <c:param name="article" value="${ article.id }" />
                    </c:url>

                    <a href="${url}"><c:out value="${ article.libelle }"></c:out>
                </li>        
            </c:forEach>
        </ul>
        </div>
</jsp:body>
</t:template>

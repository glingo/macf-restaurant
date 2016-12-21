
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
                    ${article.libelle}
                </li>        
            </c:forEach>
        </ul>
        </div>
</jsp:body>
</t:template>

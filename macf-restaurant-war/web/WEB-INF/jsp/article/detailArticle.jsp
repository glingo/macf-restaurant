
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Détail d'un article">

    <jsp:attribute name="styles">
    </jsp:attribute>

    <jsp:attribute name="scripts">
    </jsp:attribute>

    <jsp:body>
        <div class="col-lg-12"> 
            
            <c:out value="${ article.libelle }" /> ${article.valeursNutritives}kC. . . . . . . . . . . . . .${ article.prix }</a>
        <ul>
            <c:forEach var="ingredient" items="${article.ingredients}">
                <li>
                    ${ingredient.nom}
                </li>        
            </c:forEach>
        </ul>
        </div>
</jsp:body>
</t:template>
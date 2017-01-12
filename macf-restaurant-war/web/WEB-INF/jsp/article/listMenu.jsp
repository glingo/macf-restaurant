<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="liste des menus">

    <jsp:attribute name="styles">
    </jsp:attribute>

    <jsp:attribute name="scripts">
    </jsp:attribute>

    <jsp:body>
        <div class="col-lg-12">

            <form method="POST" action="/macf-restaurant-war/?section=carte&action=afficherCarte">
                <select name="categorie">
                    <c:forEach var="categorie" items="${ categories }">                       
                        <option value="${ categorie.name() }"><c:out value="${ categorie.libelle }" ></c:out></option>
                    </c:forEach>
                </select>
                <input type="submit" value="choix" />
            </form>

            <ul>
            <c:forEach var="menu" items="${ menus }">

                <li>
                    <c:url value="" var="url">
                        <c:param name="section" value="carte" />
                        <c:param name="action" value="afficherDetailMenu" />
                        <c:param name="menu" value="${ menu.id }" />
                    </c:url>

                    <a href="${url}"><c:out value="${ menu.libelle }"></c:out>. . . . . . . . . . . . . .${ menu.prix }</a>
                    </li>

            </c:forEach>
            </ul>
        </div>
    </jsp:body>
</t:template>

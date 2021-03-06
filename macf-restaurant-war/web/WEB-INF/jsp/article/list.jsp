<%-- 
    Document   : home
    Created on : 30 nov. 2016, 15:41:43
    Author     : cdi305
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="liste des articles">

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
            <c:forEach var="article" items="${ articles }">

                <li>
                    <c:url value="" var="url">
                        <c:param name="section" value="carte" />
                        <c:param name="action" value="afficherDetailArticle" />
                        <c:param name="article" value="${ article.id }" />
                    </c:url>

                    <a href="${url}"><c:out value="${ article.libelle }"></c:out>. . . . . . . . . . . . . .${ article.prix }</a>
                    </li>

            </c:forEach>
            </ul>
        </div>
    </jsp:body>
</t:template>

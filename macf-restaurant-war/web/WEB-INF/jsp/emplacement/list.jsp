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

            Liste(s) emplacements
            

            <c:forEach var="emplacement" items="${ emplacements }">
                <!-- attention à mettre le meme nom ici que dans le setattribute dans le controller-->
                <li>
                    <c:url value="emplacement" var="url">
                       <c:param name="section" value="emplacement" />
                        <c:param name="action" value="list" />
                        <c:param name="numero" value="${ emplacement.numero }" />
                    </c:url>

                    Emplacement n° <a href="${ url }"><c:out value="${ emplacement.numero }" ></c:out></a>
                </li>

            </c:forEach>


        </div>
    </jsp:body>
</t:template>


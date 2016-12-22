<%-- 
    Document   : template
    Created on : 5 oct. 2016, 14:00:30
    Author     : cdi305
--%>
<%@tag description="Template princiapl de l'application." pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="title" required="true" description="Title"%>
<%@attribute name="imgPath" description="An image to identify section"%>

<%@attribute name="styles" fragment="true"%>
<%@attribute name="scripts" fragment="true"%>

<%@attribute name="header" fragment="true"%>

<!doctype html>
<%-- Cette partie permet de traiter differement les versions de IE --%>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title><c:out value="${ title }"/></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <%-- Importation des styles --%>
        <c:import url="/WEB-INF/template/styles.jsp" />

        <%-- Ajout des styles specifiques a la page. --%>
        <jsp:invoke fragment="styles"/>

    </head>
    <body>

        <%-- 
            Importation de la jsp contenant le code servant à alerter
            l'utilisateur que son navigateur est obsolète.
        --%>
        <c:import url="/WEB-INF/template/browserAlert.jsp" />
        
        <%-- 
            On doit invoquer le fragment et le stocker dans une variable 
            afin de tester si il a été initialisé 
        --%>
        <jsp:invoke fragment="header" var="_header" />
        
        <c:choose>
            
            <c:when test="${ empty _header }">
                <%-- Importation de la jsp contenant le header --%>
                <c:import url="/WEB-INF/template/header.jsp"/>
            </c:when>
            
            <c:otherwise>
                <jsp:invoke fragment="header"/>
            </c:otherwise>
            
        </c:choose>
 
        <section class="container">
            
            <%-- Importation de la jsp contenant les flashes --%>
            <c:import url="/WEB-INF/template/flashes.jsp"/>

            <jsp:doBody />
            
        </section>

        <%-- Importation de la jsp contenant le footer --%>
        <c:import url="/WEB-INF/template/footer.jsp"/>

        <%-- Importation de la jsp contenant les scripts javascript --%>
        <c:import url="/WEB-INF/template/scripts.jsp"/>

        <%-- Ajout des scripts specifiques a la page. --%>
        <jsp:invoke fragment="scripts"/>

    </body>
</html>

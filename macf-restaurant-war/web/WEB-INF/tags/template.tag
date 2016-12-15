<%-- 
    Document   : template
    Created on : 5 oct. 2016, 14:00:30
    Author     : cdi305
--%>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="title" required="true" description="Title"%>
<%@attribute name="imgPath" description="An image to identify section" %>
<%@attribute name="styles" fragment="true" %>
<%@attribute name="scripts" fragment="true" %>

<c:set var="baseDIR" value="/WEB-INF/jsp/"/>

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
        <c:import url="${ baseDIR }/template/styles.jsp" />

        <%-- Ajout des styles specifiques a la page. --%>
        <jsp:invoke fragment="styles"/>

        <!--[if lt IE 9]>
            <script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
            <script>window.html5 || document.write('<script src="js/vendor/html5shiv.js"><\/script>')</script>
        <![endif]-->
    </head>
    <body>

        <%-- 
            Importation de la jsp contenant le code servant à alerter
            l'utilisateur que son navigateur est obsolète.
        --%>
        <c:import url="${ baseDIR }template/browserAlert.jsp" />

        <nav class="navbar navbar-default navbar-fixed-top">
            
            <div class="container-fluid">
                
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#main-menu" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    
                    <a class="navbar-brand" href="/macf-restaurant-war/">
                        <img alt="" src="images/logo.png" class="logo visible-md visible-lg">
                        <img alt="" src="images/mobile-logo.png" class="logo hidden-md hidden-lg">
                    </a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="main-menu">
                    
                    <ul class="nav navbar-nav">
                        
                        <li class="active">
                            <a href="#">Link <span class="sr-only">(current)</span></a>
                        </li>
                        
                        <li>
                            <a href="#">Link</a>
                        </li>
                        
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Tests <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <!-- ajouter des menus.-->
                                <li><a href="/macf-restaurant-war/?section=emplacement&action=create">Creer un emplacement</a></li>
                                <li><a href="/macf-restaurant-war/?section=emplacement&action=delete">Supprimer un emplacement</a></li>
                                <li><a href="/macf-restaurant-war/?section=emplacement&action=list">Afficher liste emplacements</a></li>
                                <li><a href="/macf-restaurant-war/?section=emplacement&action=listZone">Afficher liste par zone</a></li>
                                <li><a href="/macf-restaurant-war/?section=emplacement&action=updateStatut">Changer statut emplacement</a></li>
                                <li><a href="/macf-restaurant-war/?section=carte&action=afficherCarte">Afficher la carte</a></li>
                                <li><a href="/macf-restaurant-war/?section=carte&action=listArticle">Afficher la liste des articles</a></li>
                                <li><a href="/macf-restaurant-war/?section=carte&action=listMenu">Afficher la liste des menus</a></li>
                                <li><a href="/macf-restaurant-war/?section=carte&action=listArticleByCategorie&categorie=ENTREE">Afficher la liste des Entrées</a></li>
                                <li><a href="/macf-restaurant-war/?section=carte&action=listArticleByCategorie&categorie=PLAT">Afficher la liste des Plats</a></li>
                                <li><a href="/macf-restaurant-war/?section=carte&action=listArticleByCategorie&categorie=DESSERT">Afficher la liste des Desserts</a></li>
                                <li><a href="/macf-restaurant-war/?section=carte&action=listArticleByCategorie&categorie=BOISSON">Afficher la liste des Boissons</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">One more separated link</a></li>
                            </ul>
                        </li>
                    </ul>
                    
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <c:choose>
                                <c:when test="${not empty user}">
                                    <c:url value="/" var="url">
                                        <c:param name="section" value="security" />
                                        <c:param name="action" value="logout" />
                                    </c:url>
                                    
                                    <a href="${ url }" class="glyphicon glyphicon-log-out"></a>
                                </c:when>

                                <c:otherwise>
                                     <c:url value="/" var="url">
                                        <c:param name="section" value="security" />
                                        <c:param name="action" value="login" />
                                    </c:url>
                                    <a href="${ url }" class="glyphicon glyphicon-log-in"></a>
                                </c:otherwise>
                            </c:choose>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        
        <c:if test="${not empty flashbag}">
            
            <c:forEach var="entry" items="${ flashbag.getAll() }">
                
                <c:forEach var="flash" items="${ entry.value }">
                    <div class="alert alert-${ entry.key } alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        
                        <c:out value="${ flash }" />
                    </div>

                </c:forEach>
                
               
            </c:forEach>
           
        </c:if>
        
        <jsp:doBody />

        <%-- Importation de la jsp contenant les scripts javascript --%>
        <c:import url="${ baseDIR }template/scripts.jsp"/>

        <%-- Ajout des scripts specifiques a la page. --%>
        <jsp:invoke fragment="scripts"/>

    </body>
</html>

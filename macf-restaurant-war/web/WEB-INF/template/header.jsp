<%-- 
    Document   : header
    Created on : 20 déc. 2016, 14:56:14
    Author     : cdi305
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<header>

    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">

            <div class="navbar-header">
                <a class="navbar-brand" href="/macf-restaurant-war/">
                    <img class="img-responsive" src="/macf-restaurant-war/images/logos/logo-xs.png" alt="">
                </a>

                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

            <div id="navbar" class="navbar-collapse collapse" aria-expanded="false">
                
                <ul class="nav navbar-nav">
                    <li class="dropdown">

                        <a data-toggle="dropdown" class="dropdown-toggle" href="#" aria-expanded="false">
                            Tests
                            <span class="caret"></span>
                        </a>

                        <ul class="dropdown-menu">

                            <li class="dropdown-header"> Emplacements</li>
                            <li><a href="/macf-restaurant-war/?section=emplacement&action=create">Creer un emplacement</a></li>
                            <li><a href="/macf-restaurant-war/?section=emplacement&action=delete">Supprimer un emplacement</a></li>
                            <li><a href="/macf-restaurant-war/?section=emplacement&action=list">Afficher liste emplacements</a></li>
                            <li><a href="/macf-restaurant-war/?section=emplacement&action=listZone">Afficher liste par zone</a></li>
                            <li><a href="/macf-restaurant-war/?section=emplacement&action=updateStatut">Changer statut emplacement</a></li>

                            <li role="separator" class="divider"></li>
                            <li class="dropdown-header"> Carte</li>
                            <li><a href="/macf-restaurant-war/?section=carte&action=afficherCarte">Afficher la carte</a></li>
                            <li><a href="/macf-restaurant-war/?section=carte&action=listArticle">Afficher la liste des articles</a></li>
                            <li><a href="/macf-restaurant-war/?section=carte&action=listMenu">Afficher la liste des menus</a></li>
                                  
                            <li role="separator" class="divider"></li>
                            <li class="dropdown-header"> Commande</li>
                            <li><a href="/macf-restaurant-war/?section=commande&action=listCommande">Afficher les commandes</a></li>
                            <li><a href="/macf-restaurant-war/?section=commande&action=listDetailCommande">Afficher detail commandes</a></li>
                        </ul>
                    </li>

                </ul>

                <ul class="nav navbar-nav navbar-right">
                    
                    <li <c:if test="${not empty user}"> class="dropdown" </c:if>>
                        <c:import url="/WEB-INF/template/user.jsp"/>
                    </li>
                    
                    <c:import url="/WEB-INF/template/locale.jsp"/>

                </ul>
            </div>

        </div>

    </nav>

</header>

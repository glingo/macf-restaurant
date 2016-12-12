<%-- 
    Document   : home
    Created on : 30 nov. 2016, 15:41:43
    Author     : cdi305
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
            
            <form name="login" method="POST" action="/macf-restaurant-war/?section=security&action=login">
                <label for="code"> Code :</label>
                <input id="code" type="password" name="code" />
                
                <input type="submit" name="login_submit"/>
            </form>
            
        </div>
    </jsp:body>
</t:template>

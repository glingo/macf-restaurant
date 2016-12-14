<%-- 
    Document   : create
    Created on : 13 déc. 2016, 16:37:52
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
            
            Creation/Suppression emplacement
            <form name="create" method="POST" action="/macf-restaurant-war/?section=emplacement&action=create">
                <label for="numero"> Numéros de table :</label>
                <input id="numero" type="text" name="numero"/>
                <br/>
                <br/>
                <label for="nbrPlace">Nombre de places</label>
                <input id="nbrPlace" type="number" name="nbrPlace"/>
                <br/>
                <br/>
                <!--<input type="text" id="statutEmpl" name="statutEmpl"/>-->
                <select name="listStatut" onChange="combo(this, 'statutEmpl')">
                    <option>Libre</option>
                    <option>En cours de nettoyage</option>
                    <option>Occupé</option>
                </select>               
                <!--<input type="text" id="zoneEmpl" name="zoneEmpl"/>-->
                <select name="listZone" onChange="combo(this, 'zoneEmpl')">
                    <option>Zone 1</option>
                    <option>Zone 2</option>
                    <option>Zone 3</option>
                    <option>Zone 4</option>
                </select>  
                
                
                <input type="submit" name="emplacement_submit" value="créer"/>
            </form> 
            
        </div>
    </jsp:body>
</t:template>

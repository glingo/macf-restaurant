<%-- 
    Document   : home
    Created on : 30 nov. 2016, 15:41:43
    Author     : cdi305
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="config.label" var="label"/>

<t:template title="macf-restaurant">

    <jsp:body>
        <div class="row">
            <div class="col-lg-12">

                <form name="login" method="POST" action="/macf-restaurant-war/?section=security&action=login">
                    <label for="code"> <fmt:message key="login.code" bundle="${ label }"/> :</label>
                    <input id="code" type="password" name="code" />

                    <input type="submit" name="login_submit"/>
                </form>

            </div>
        </div>
    </jsp:body>
</t:template>

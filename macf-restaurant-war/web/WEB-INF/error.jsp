<%-- 
    Document   : 404
    Created on : 13 déc. 2016, 11:20:28
    Author     : cdi305
--%>

<%@page isErrorPage="true" import="java.io.*" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        URI : <c:out value="${ pageContext.errorData.requestURI }" />
        <br />
        
        Code : <c:out value="${ pageContext.errorData.statusCode }" />
        <br />
        
        Name : <c:out value="${ pageContext.errorData.servletName }" />
        <br />
        
        Trace : <c:out value="${ pageContext.errorData.throwable.printStackTrace() }" />
        <br />
        
        Exception : <c:out value="${ exception }" />
        <br />
        
        Message : <c:out value="${ pageContext.errorData.throwable.message }" />
        <br />
        
        javax.servlet.error.message : <c:out value="${ javax.servlet.error.message }" />
        
    </body>
</html>

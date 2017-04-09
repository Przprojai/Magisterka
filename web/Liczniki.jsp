<%-- 
    Document   : newjsp
    Created on : Apr 3, 2017, 11:46:45 AM
    Author     : Waldek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%= JCP.MieszkanieController.setCsvFileLicznik(request.getAttribute("Name").toString()) %>
       <h:link value="powrot" action="/mieszkanie/List_2"/>     
       <jsp:forward page="/mieszkanie/List_2.xhtml"></jsp:forward>

    </body>
</html>

<%-- 
    Document   : greeting
    Created on : Sep 21, 2024, 2:07:03 PM
    Author     : sonnt-local
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="color: red;"> Hello ${sessionScope.account.displayname} </div>
    </body>
</html>

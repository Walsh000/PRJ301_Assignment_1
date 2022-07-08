<%-- 
    Document   : login
    Created on : Jun 6, 2022, 9:32:50 AM
    Author     : fpt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            Gmail: <input name="gmail" type="text" value="${requestScope.gmail}"></input> <br>
            Password: <input type="password" name="password"></input> <br/>
            <input type="submit" value="Login"/>
            <div style="color: red">${requestScope.message}</div>
        </form>
    </body>
</html>

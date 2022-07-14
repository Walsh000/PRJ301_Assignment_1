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
        <link href="css/template.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <img class ="navi" src="images/template/Detail05.png" alt=""/>
            <a href="home"><img class="headerText" src="images/template/Detail03.png" alt=""/></a>
        </header>
        <h1  class="title" style="margin-top: 120px; margin-bottom: 50px">Login</h1>
        <form action="login" method="POST" class="centerForm">
            <table class="formTable">
                <tr>
                    <td class="rowName">
                        Gmail
                    </td>
                    <td>
                        <input name="gmail" type="text" value="${requestScope.gmail}"></input>
                    </td>
                </tr>
                <tr>
                    <td class="rowName">
                        Password
                    </td>
                    <td>
                        <input type="password" name="password"></input>
                    </td>
                </tr>
            </table> 
            <input type="submit" value="Login" class="sendButton"/>
            <div style="color: red">${requestScope.message}</div>
        </form>
        <footer>
            <img class="foot" src="images/template/Detail01.png" alt=""/>
        </footer>
    </body>
</html>

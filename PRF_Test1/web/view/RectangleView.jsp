<%-- 
    Document   : RectangleView
    Created on : May 18, 2022, 8:21:49 AM
    Author     : fpt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Rectangle"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <canvas id="myCanvas" width="500" height="500" style="border:3px solid #0066ff;">
            Your browser does not support the HTML5 canvas tag.</canvas> 
        <script>
            var c = document.getElementById("myCanvas");
            var ctx = c.getContext("2d");

            ctx.font = "16px Arial";
            ctx.fillStyle = "red";
            ctx.fillText("Id: ${requestScope.id}", 10, 20);
            ctx.fillText("x: ${requestScope.rect.coordiX}", 10, 40);
            ctx.fillText("y: ${requestScope.rect.coordiY}", 10, 60);
            ctx.fillText("w: ${requestScope.rect.width}", 
            (${requestScope.rect.width} + ${requestScope.rect.coordiX}) - ${requestScope.rect.width}/ 2 - 15, 
                    ${requestScope.rect.coordiY} + 20);
            ctx.fillText("h: ${requestScope.rect.height}", 
                    ${requestScope.rect.width} + ${requestScope.rect.coordiX} - 50, 
                        (${requestScope.rect.coordiY} + ${requestScope.rect.height}) - ${requestScope.rect.height}/2);
            ctx.beginPath();
            ctx.rect(${requestScope.rect.coordiX}, ${requestScope.rect.coordiY}, ${requestScope.rect.width}, ${requestScope.rect.height});
            ctx.stroke();
        </script>

    </body>
</html>

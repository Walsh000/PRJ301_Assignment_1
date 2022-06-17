<%-- 
    Document   : attendance
    Created on : Jun 16, 2022, 11:16:17 PM
    Author     : fpt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/template.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            
        </header>
        <h1>Attendance</h1>
        <h3>${requestScope.courseID} - ${requestScope.date} - ${requestScope.slot}</h3>
        
    </body>
</html>

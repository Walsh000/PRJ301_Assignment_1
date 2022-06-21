<%-- 
    Document   : ChooseGroup
    Created on : Jun 21, 2022, 11:53:13 PM
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
        <form action="../../lecturer/attendance" method="GET" >
            GrID: <input type="text" name="groupID"/> <br>
            Date: <input type ="date" name="date"/><br>
            Slot: <input type ="number" name="slotNo"/><br>
            <input type="submit"/>
        </form>
    </body>
</html>

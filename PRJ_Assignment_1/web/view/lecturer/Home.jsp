<%-- 
    Document   : Home
    Created on : Jun 22, 2022, 9:13:49 PM
    Author     : fpt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/template.css" rel="stylesheet" type="text/css"/>
        <link href="css/table.css" rel="stylesheet" type="text/css"/>
        <title>Assignment homepage</title>
    </head>
    <body>
        <h1>Schedule table</h1>

        <table>
            <tr id=tableHead">
                <th></th>
                <th>Monday</th>
                <th>Tuesday</th>
                <th>Wednesday</th>
                <th>Thursday</th>
                <th>Friday</th>
                <th>Saturday</th>
                <th>Sunday</th>
            </tr>

            <c:forEach items="${sessionScope.schedule}" var="slot">
                <tr class="tb">
                    <th>
                        Slot
                    </th>
                    <c:forEach items="${slot}" var="session">
                        <c:if test="${session eq null}">
                            <td></td>
                        </c:if>
                        <c:if test="${session ne null}">
                            <td>
                                ${session.group.groupID}<br>
                                ${session.room.roomID}
                            </td>
                        </c:if>
                    </c:forEach>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>

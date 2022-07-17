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
        <link href="css/Template.css" rel="stylesheet" type="text/css"/>
        <link href="css/Schedule.css" rel="stylesheet" type="text/css"/>
        <title>Student homepage</title>
    </head>
    <body>
        <header>
            <img class ="navi" src="images/template/Detail05.png" alt=""/>
            <a href="home"><img class="headerText" src="images/template/Detail03.png" alt=""/></a>
            <div class="dropdown">
                <table class="headerUser dropbtn">
                    <tr>
                        <td>
                            <img class="lecturerImage" src="${sessionScope.student.imageURL}" alt=""/> 
                        </td>

                        <td>
                            <span>${sessionScope.student.username}
                            </span>
                            <span>${sessionScope.student.studentID}</span>
                        </td>

                        <td>
                            <i class="fa fa-caret-down" style="color: #fff"></i>
                        </td>
                    </tr>
                </table>
                <div class="dropdown-content">
                    <a href="logout">Logout</a>
                    <a href="attendanceStatus">Attendance status</a>
                </div>
            </div>
        </header>
        <h1 class="title" style="margin-top: 50px; margin-bottom: 20px">Schedule table</h1>
        <form action="studentSchedule" method="post" style="margin-bottom: 10px">
            <input type="date" name="date" value="${sessionScope.date}"></input>
            <button type="submit"><i class="fa fa-search"></i></button>
        </form>

        <div class="schedule">
            <table >
                <tr id="tableHead">
                    <th></th>
                    <th>Sunday <br/>${requestScope.weekDate.get(0)}</th>
                    <th>Monday <br/>${requestScope.weekDate.get(1)}</th>
                    <th>Tuesday <br/>${requestScope.weekDate.get(2)}</th>
                    <th>Wednesday <br/>${requestScope.weekDate.get(3)}</th>
                    <th>Thursday <br/>${requestScope.weekDate.get(4)}</th>
                    <th>Friday <br/>${requestScope.weekDate.get(5)}</th>
                    <th>Saturday <br/>${requestScope.weekDate.get(6)}</th>
                </tr>

                <%int i = 1;%>
                <c:forEach items="${sessionScope.schedule}" var="slot">
                    <tr class="tb">
                        <th>
                            <%="<span style=\"color: #000; padding: 0px 10px\">Slot " + i++ + "</span>"%>
                        </th>
                        <c:forEach items="${slot}" var="attendance">
                            <c:if test="${attendance eq null}">
                                <td></td>
                            </c:if>
                            <c:if test="${attendance ne null}">
                                <td style="text-align: center">
                                        <span style="color: #000">${attendance.session.group.groupID}</span>
                                        <span style="color: #06f">${attendance.session.room.roomID} - 
                                        <c:if test="${!attendance.session.attendanceChecked}">
                                                <span style="color: #000; display: inline">Not yet</span>
                                        </c:if>
                                        <c:if test="${attendance.session.attendanceChecked}">
                                            <c:if test="${!attendance.isAttend}">
                                                <span style="color: red; display: inline">Absent</span>
                                            </c:if>
                                            <c:if test="${attendance.isAttend}">
                                                <span style="color: green; display: inline">Attend</span>
                                            </c:if>
                                        </c:if>
                                        </span>
                                </td>
                            </c:if>
                        </c:forEach>
                    </tr>
                </c:forEach>

            </table>

        </div>
        <footer>
            <img class="foot" src="images/template/Detail01.png" alt=""/>
        </footer>
    </body>
</html>

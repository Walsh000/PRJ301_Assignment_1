<%-- 
    Document   : AttendanceStatus
    Created on : Jul 11, 2022, 10:59:39 PM
    Author     : fpt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="https://your.uri/jsp/tlds/format" prefix="format"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Template.css" rel="stylesheet" type="text/css"/>
        <link href="css/w3.css" rel="stylesheet" type="text/css"/>
        <link href="css/AttendanceStatus.css" rel="stylesheet" type="text/css"/>
        <title>Show attendance status</title>
    </head>
    <body>
        <header>
            <img class ="navi" src="images/template/Detail05.png" alt=""/>
            <a href="home"><img class="headerText" src="images/template/Detail03.png" alt=""/></a>

            <div class="dropdown">
                <table class="headerUser dropbtn">
                    <tr>
                        <td>
                            <img class="lecturerImage" src="${sessionScope.lecturer.imageURL}" alt=""/> 
                        </td>

                        <td>
                            <span>${sessionScope.lecturer.username}
                            </span>
                            <span>${sessionScope.lecturer.lecturerID}</span>
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
        <div>

            <h1 class="title">Attendance status</h1>
            <form method="POST" action="attendanceStatus" class="centerForm">
                Group <select name="groupID">
                    <c:forEach items="${sessionScope.groupList}" var="group">
                        <option value="${group.groupID}" 
                            <c:if test="${param.groupID eq group.groupID}">
                                selected ="selected"
                            </c:if> > 
                            ${group.groupID}
                        </option>
                    </c:forEach>

                </select>
                <input type="submit" value="View"/>
            </form>
            <c:if test="${requestScope.isPost}">
                <br/>
                <div class="table">
                    <table>
                        <c:forEach items="${requestScope.attendanceStatusList}" var="attendanceStatus">
                            <tr style="border-radius: 5px">
                                <td class="std">
                                    <span style="color: #000">${attendanceStatus.student.username}</span>
                                    <span style="color: #000">${attendanceStatus.student.studentID}</span>
                                </td>
                                <td class="progress">
                                    <div class="w3-light-grey" style="padding: 0">
                                        <div class="w3-yellow" style="width:<format:formatDouble number="${attendanceStatus.progress}" format=".2f"/>">
                                            <div class="w3-container w3-red w3-center absentBar" style="width:<format:formatDouble number="${attendanceStatus.absentRate}" format=".2f"/>; padding: 5px 0px;">
                                                <c:if test="${attendanceStatus.absentRate ne 0}">
                                                    <format:formatDouble number="${attendanceStatus.absentRate}" format=".2f"/>
                                                </c:if>
                                            </div>
                                            <div class="w3-container w3-green w3-center attendBar" style="width:<format:formatDouble number="${attendanceStatus.attendRate}" format=".2f"/>; padding: 5px 0px; float: left">
                                                <format:formatDouble number="${attendanceStatus.attendRate}" format=".2f"/>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>

                    </table>

                </div>
            </c:if>
        </div>
        <footer>
            <img class="foot" src="images/template/Detail01.png" style="position: relative; float: right; margin-bottom: 0;
                 <c:if test="${!isPost}"> position: absolute; right: 0; bottom: 0;</c:if>" alt=""/>
        </footer>
    </body>
</html>

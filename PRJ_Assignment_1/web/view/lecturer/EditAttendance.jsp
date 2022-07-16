<%-- 
    Document   : EditAttendance
    Created on : Jul 11, 2022, 10:59:27 PM
    Author     : fpt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Template.css" rel="stylesheet" type="text/css"/>
        <link href="css/AttendButton.css" rel="stylesheet" type="text/css"/>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <title>Edit Attendance</title>
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


        <div class="sessionInfor">
            <h1 class="title">Edit attendance</h1>
            <h3 class="infor">${requestScope.session.group.course.courseID}    |    ${requestScope.session.date}    |    Slot: ${requestScope.session.slot.slotNo}</h3>
        </div>
        <form action="editAttendance" method="POST">
            <div class="container">
                <c:forEach items="${requestScope.attendanceList}" var="attendance">
                    <div class="student">

                        <img class ="studentImage edit" src="${attendance.student.imageURL}" alt=""/>
                        <span class="studentInfo">${attendance.student.username}</span>
                        <span class="studentInfo">${attendance.student.studentID}</span>

                        <div class="flip-switch flip-switch-text">
                            <br/><br/>
                            <input type="checkbox" id="${attendance.student.studentID}" name="isAttend" value="${attendance.student.studentID}" 
                                   <c:if test="${attendance.isAttend}">
                                       checked
                                   </c:if>
                                   <c:if test="!${attendance.isAttend}">
                                       unchecked
                                   </c:if>/>
                            <label for="${attendance.student.studentID}"></label>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <input type="hidden" name="date" value="${requestScope.session.date}"/>
            <input type="hidden" name="groupID" value="${requestScope.session.group.groupID}"/>
            <input type="hidden" name="slotNo" value="${requestScope.session.slot.slotNo}"/>
            <input type="submit" name="Submit" value="Submit" style="width: 100px;display: block; margin: auto; font-size: 18px" class="submit"/>
        </form>

        <footer>
            <img class="foot" src="images/template/Detail01.png" style="position: relative; float: right; margin-bottom: 0" alt=""/>
        </footer>
    </body>
</html>

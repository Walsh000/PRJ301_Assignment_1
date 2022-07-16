<%-- 
    Document   : attendance
    Created on : Jun 16, 2022, 11:16:17 PM
    Author     : fpt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check attendance</title>
        <link href="css/Template.css" rel="stylesheet" type="text/css"/>
        <link href="css/AttendButton.css" rel="stylesheet" type="text/css"/>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
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
        <div class="container">

            <div class="sessionInfor">
                <h1 class="title">Attendance</h1>
                <h3 class="infor">${requestScope.session.group.course.courseID}    |    ${requestScope.session.date}    |    Slot: ${requestScope.session.slot.slotNo}</h3>
            </div>

            <form action="attendance" method="POST">
                <table class="studentInfor">

                    <tr style="height: 30px">
                        <td rowspan="4">
                            <img class ="studentImage check" src="${requestScope.student.imageURL}" alt=""/>
                            <!--<img class ="avatar" src="../image/user_Avatar/1000000000001.png" alt=""/>-->
                        </td>

                    </tr>

                    <tr style="height: 50px">
                        <td style="padding-left: 15px" colspan="2">Name: ${requestScope.student.username}</td>
                    </tr>

                    <tr style="height: 50px">
                        <td style="padding-left: 15px" colspan="2">
                            ID: ${requestScope.student.studentID}
                        </td>
                    </tr>

                    <tr>
                        <td style="padding-top: 0px; height: 110px; ">
                            <div class="flip-switch flip-switch-text">
                                <input type="checkbox" id="c3" name="isAttend" 
                                       <c:if test="${attendance.isAttend}">
                                           checked
                                       </c:if>
                                       <c:if test="!${attendance.isAttend}">
                                           unchecked
                                       </c:if>/>
                                <label for="c3"></label>
                            </div>

                            <input type="hidden" name="index" value="${requestScope.index}"/>
                            <input type="hidden" name="date" value="${requestScope.session.date}"/>
                            <input type="hidden" name="groupID" value="${requestScope.session.group.groupID}"/>
                            <input type="hidden" name="slotNo" value="${requestScope.session.slot.slotNo}"/>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2"><input class="submit" type="submit" value="Next"/></td>
                    </tr>
                </table>
            </form>
        </div>
        <footer>
            <img class="foot" src="images/template/Detail01.png" alt=""/>
        </footer>
    </body>
</html>

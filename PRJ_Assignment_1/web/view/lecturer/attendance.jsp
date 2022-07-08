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
        <script src="../js/pagger.js" type="text/javascript"></script>
        <link href="../css/AttendButton.css" rel="stylesheet" type="text/css"/>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    </head>
    <body>
        <header>
            <img class ="navi" src="../image/template/Detail05_1.png" alt=""/>
            <img class="headerText" src="../image/template/Detail03.png" alt=""/>
            <div class="dropdown">
                <table class="headerLect dropbtn">
                    <tr>
                        <td>
                            <img class="lecturerImage" src="${requestScope.lecturer.imageURL}" alt=""/> 
                        </td>

                        <td>
                            <span>${requestScope.lecturer.username}
                            </span>
                            <span>${requestScope.lecturer.lecturerID}</span>
                        </td>

                        <td>
                            <i class="fa fa-caret-down" style="color: #fff"></i>
                        </td>
                    </tr>
                </table>
                <div class="dropdown-content">
                    <a href="../logout">Logout</a>
                </div>
            </div>
        </header>
        <div class="container">

            <div class="sessionInfor">
                <h1 class="title">Attendance</h1>
                <h3 class="infor">${requestScope.session.group.course.courseID}    |    ${requestScope.session.date}    |    Slot: ${requestScope.session.slot.slotNo}</h3>
            </div>

            <form action="attendance" method="POST">
                <table class="stdInfor">

                    <tr style="height: 30px">
                        <td rowspan="4">
                            <img class ="avatar" src="${requestScope.student.imageURL}" alt=""/>
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
                                <input type="checkbox" id="c3" name="isAttend" unchecked/>
                                <label for="c3"></label>
                            </div>

                            <input type="hidden" name="index" value="${requestScope.index}"/>
                            <input type="hidden" name="date" value="${requestScope.date}"/>
                            <input type="hidden" name="groupID" value="${requestScope.session.group.groupID}"/>
                            <input type="hidden" name="slotNo" value="${requestScope.slot}"/>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2"><input class="submit" type="submit" value="Next"/></td>
                    </tr>
                </table>
            </form>
        </script>-->
    </div>
    <footer>
        <img class="foot" src="../image/template/Detail1_1.png" alt=""/>
    </footer>
</body>
</html>

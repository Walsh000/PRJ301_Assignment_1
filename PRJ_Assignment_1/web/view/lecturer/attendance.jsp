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
    </head>
    <body>
        <header>
            <img class ="navi" src="../image/template/Detail05_1.png" alt=""/>
            <img class="headerText" src="../image/template/Detail03.png" alt=""/>
        </header>
        <div class="container">

            <div class="sessionInfor">
                <h1 class="title">Attendance</h1>
                <h3 class="infor">${requestScope.course.courseID}    |    ${requestScope.date}    |    Slot: ${requestScope.slot}</h3>

            </div>


            <table class="stdInfor">

                <tr style="height: 30px">
                    <td rowspan="4">
                        <img class ="avatar" src="../image/user_Avatar/1000000000036.png" alt=""/>
                    </td>

                </tr>

                <tr style="height: 50px">
                    <td style="padding-left: 15px">Name: ${requestScope.student.username}</td>
                </tr>

                <tr style="height: 50px">
                    <td style="padding-left: 15px">
                        ID: ${requestScope.student.studentID}
                    </td>
                </tr>

                <tr>
                    <td>
                        <div class="checkboxWrapper">
                            <input type="checkbox" id="myCheckbox" checked/>
                            <label for="myCheckbox">
                                <svg class="checkmark" width="56" height="56">
                                <path d="m25,36 l14,-16"
                                      style="stroke-dasharray: 27px;"></path>
                                <path d="m25,36 l-8,-9"
                                      style="stroke-dasharray: 11px;"></path>
                                </svg>
                                <svg class="cross" width="56" height="56">
                                <path d="m28,28 l-8,-8"
                                      style="stroke-dasharray: 13px;"></path>
                                <path d="m28,28 l8,8"
                                      style="stroke-dasharray: 13px;"></path>
                                <path d="m28,28 l-8,8"
                                      style="stroke-dasharray: 13px;"></path>
                                <path d="m28,28 l8,-8"
                                      style="stroke-dasharray: 13px;"></path>
                                </svg>
                            </label>
                        </div>
                    </td>
                </tr>
            </table>

        </div>
        <footer>
            <img class="foot" src="../image/template/Detail1_1.png" alt=""/>
        </footer>
    </body>
</html>

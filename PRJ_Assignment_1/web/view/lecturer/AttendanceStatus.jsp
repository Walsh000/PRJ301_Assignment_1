<%-- 
    Document   : AttendanceStatus
    Created on : Jul 11, 2022, 10:59:39 PM
    Author     : fpt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/template.css" rel="stylesheet" type="text/css"/>
        <link href="css/w3.css" rel="stylesheet" type="text/css"/>
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
                </div>
            </div>
        </header>
        <div>

        </div>
        <footer>
            <img class="foot" src="images/template/Detail01.png" style="position: relative; float: right; margin-bottom: 0" alt=""/>
        </footer>
    </body>
</html>

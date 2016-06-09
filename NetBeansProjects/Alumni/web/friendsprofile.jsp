<%-- 
    Document   : friendsprofile
    Created on : 30-Mar-2014, 18:51:50
    Author     : ysj13kxu
--%>

<%@page import="AlumniPackage.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" type = "text/css" href = "alumnicss.css" />
        <title>Friends Page</title>
    </head>
    <body>
        <div class="container">
            <img src="Banner.jpg" class="image"/>
            <div class="gap"> 
            <%
                Student student = (Student) session.getAttribute("friendprofile");
            %>
                <br/><hr>
                <div class="rightside">
                    <div id="menu">
                        <ul>                         
                            <li><a href="schoolController"> Back </a></li>
                            <li><a href="profilepage.jsp"> Your profile </a></li> 
                            <li><a href="LogOut"> Logout </a></li>
                        </ul>
                    </div>                 
                </div> 
                <h1><%=student.getName()%>'s Profile Page</h1>
                <hr><br/>
                Name: <%=student.getName()%><br/><br/>

                Email: <%=student.getEmail()%> <br/><br/>

                Info: <%=student.getInfo()%> <br/><br/>

                School: <%=student.getSchool()%> <br/><br/>
                <hr><br/>
            </div>
        </div>
    </body>
</html>

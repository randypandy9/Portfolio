<%-- 
    Document   : SchoolAdd
    Created on : 28-Mar-2014, 21:21:22
    Author     : hta13nau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" type = "text/css" href = "alumnicss.css" />
        <title>Confirmation</title>
    </head>
    <body>
        <div class='container'>
            <img src="Banner.jpg" class="image"/>
            <div class='gap'>
            <br/><hr>
            <h1>Add Successful!</h1>
            <hr><br/>
            <jsp:useBean id="newAttendance" type="Schooldata_package.Attendance" scope="request" />

            <h2>School Added: ${newAttendance.schoolName}</h2>
            <h4>Start Date: ${newAttendance.dateStart}</h4>
            <h4>End Date: ${newAttendance.dateEnd}</h4>
            <br/>
            <p><a href="profilepage.jsp"> Back to Your profile</a></p>
            <br>
            
           
            </div>
        </div>
    </body>
</html>

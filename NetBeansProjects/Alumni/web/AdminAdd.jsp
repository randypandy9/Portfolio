<%-- 
    Document   : AdminAdd
    Created on : 18-Mar-2014, 16:05:19
    Author     : hta13nau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" type = "text/css" href = "alumnicss.css" /> 
        <title>Added</title>
    </head>
    <body>
        <div class="container">
            <div class="gap">
                <hr><br/>
                <h1>Admin page</h1>
        <jsp:useBean id="aSchool" type="admin_package.School" scope="request" />
        <hr>
        <br/>
        <h2>School Name: ${aSchool.school} Successfully Added</h2> 
        <h4>School ID: ${aSchool.schoolId} </h4>
        <h4>School Website: ${aSchool.website} </h4>
        <h4>School Info: </h4>
        <p>${aSchool.schoolInfo}</p>
        <br/>
        <hr>
        <form action="AdminDB" method="get">
            <p>
               <%-- Admin User: <input type ="text" name="Auser"/><br>  
                Admin Apass <input type="password" name="Apass"/><br> --%>
             School Name:    <input type="text" name="schoolName"/>
             School Website: <input type="text" name ="website"/>
             School info:    <input type="text" name="schoolInfo"/>
            <input type="hidden" value="add" name="type"/>
            <input type="submit" value="Add School"> 
            </p>
            </form>
                <br>
                <br>
                <form action="AdminDB" method="post">
                <input type="hidden" value="list" name="type" />
                <input type="submit" value="List School"/>
        </form>
                <br/>
            </div>
        </div>
    </body>
</html>

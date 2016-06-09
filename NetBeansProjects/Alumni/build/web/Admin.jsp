<%-- 
    Document   : Admin
    Created on : 06-Mar-2014, 22:23:45
    Author     : hta13nau
--%>


<%@page import="admin_package.AdminRequest"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <link rel = "stylesheet" type = "text/css" href = "alumnicss.css" />
    </head>
    <body>
        <div class="container">
            <div class="gap">
                <br><hr>
                <h1>Admin page</h1>
                <hr>
                <br>
                <p>School Requests</p>
                <table>
                    <tr>
                        <th>User Email</th>
                        <th>School Name</th>
                    </tr>
                <%
                    List<AdminRequest> adminRequest = (List<AdminRequest>) request.getAttribute("aRequest");
                    for (AdminRequest requestQ : adminRequest) {
                %>
                
                <tr>
                    <td><%=requestQ.getEmail() %> </td>
                    <td><%=requestQ.getSchoolName()%></td>
                </tr>

                    <%
                        }
                    %>
                </table>
                
                <form action="AdminDB" method="get">
                    <p>
                        School Name:    <input type="text" name="schoolName"/>
                        School Website: <input type="text" name ="website"/>
                        School info:    <input type="text" name="schoolInfo"/>
                        
                        <input type="hidden" value="add" name="type"/>
                        <input type="submit" value="Add School">
                    </p>
                </form>
                <br>
                <br>
                <form action="AdminDB" method="get">

                    <%-- Admin User: <input tye ="text" name="Auser"/><br>  
                     Admin Apass <input type="password" name="Apass"/><br> --%>
                    <input type="hidden" value="list" name="type" />
                    <input type="submit" value="List Data"/>
                </form> 
            </div>
        </div>
    </body>
</html>

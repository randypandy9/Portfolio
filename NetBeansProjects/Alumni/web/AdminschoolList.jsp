<%-- 
    Document   : schoolList
    Created on : 08-Mar-2014, 13:17:31
    Author     : HTA13NAU
--%>

<%@page import="admin_package.SchoolCount"%>
<%@page import="admin_package.Student"%>
<%@page import="admin_package.SchoolList"%>
<%@page import="admin_package.Attendance"%>
<%@page import="admin_package.School"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin page</title>
        <link rel = "stylesheet" type = "text/css" href = "alumnicss.css" /> 
    </head>
    <body>
        <div class="container">
            <div class="gap">
                <br /><hr>
                <h1>Current Alumni Database</h1>
                <hr>
                <table>
                    <tr>
                        <td><form action="RequestController" method="post">
                            <input type="submit" value=" Admin Home"/> </form> </td>
                            <td>
                                <form action="index.jsp" method="post"> 
                                    <input type="submit" value="Home"/> </form>
                            </td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <th>School Name</th>
                        <th>School ID</th>
                    </tr>
                    <%
                        List<SchoolList> schoolList = (List<SchoolList>) request.getAttribute("schoolList");
                        for (SchoolList school : schoolList) {
                    %>

                    <tr>
                        <td><%=school.school%></td>
                        <td><%=school.schoolId%></td>

                    </tr>

                    <%
                        }
                    %>
                </table>
                Attendance
                <table>

                    <tr>
                        <th>School Name  </th>
                        <th> Name</th>
                        <th> Date Start </th>
                        <th>Date End</th>
                    </tr> 
                    <%
                        List<Attendance> arry = (List<Attendance>) request.getAttribute("arry");
                        for (Attendance sch : arry) {
                    %>

                    <tr>
                        <td><%=sch.school%></td>
                        <td><%=sch.name%></td>
                        <td><%=sch.dateStart%></td>
                        <td><%=sch.dateEnd%></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
                <table>
                    <tr>
                        <th>Number of Users</th>
                        <th>Number of Schools</th>
                    </tr>
                    <%
                        List<SchoolCount> countSchool = (List<SchoolCount>) request.getAttribute("countSchool");
                        for (SchoolCount countSch : countSchool) {
                    %>
                    <%
                        List<Student> countUser = (List<Student>) request.getAttribute("countUser");
                        for (Student count : countUser) {
                    %>
                    <tr>
                        <td><%=count.countName%></td>
                        <td><%=countSch.countSchool%></td>
                    </tr>
                    <%
                        }
                    %>
                    <%
                        }
                    %>
                </table>
            </div>
        </div>
    </body>
</html>

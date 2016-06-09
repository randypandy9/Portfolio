<%-- 
    Document   : DetailsPage
    Created on : 27-Mar-2014, 15:00:56
    Author     : hta13nau
--%>

<%@page import="AlumniPackage.Student"%>
<%@page import="Schooldata_package.SchoolData"%>
<%@page import="Schooldata_package.Attendance"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:useBean id="thisSchool" type="Schooldata_package.SchoolData" scope="request"/> 
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" type = "text/css" href = "alumnicss.css" /> 
        <title>School Details</title>
    </head>
    <body>
        <div class="container">
            <img src="Banner.jpg" class="image"/>
            <div class="gap">
                <%
                    Student student = (Student) session.getAttribute("Studentdetails");                  
                %>                
                <hr>
                <div class="rightside">
                    <div id="menu">
                        <ul>                            
                            <li><a href="schoolController"> Back </a></li>
                            <li><a href="profilepage.jsp"> Your profile </a></li> 
                            <li><a href="LogOut"> Logout </a></li>
                        </ul>
                    </div>                 
                </div> 
                <h1><jsp:getProperty name="thisSchool" property="schoolName" /></h1> 
                <hr>
                <br>
                <h3>School Description</h3>
                <p><jsp:getProperty name="thisSchool" property="schoolInfo"/></p>
                <br>
                <p>Visit School Website :  <a href="<jsp:getProperty name="thisSchool" property="website"/>"><jsp:getProperty name="thisSchool" property="website"/> </a> </p>



                <form action="AddAttendController" method ="post" id="addattendcheck">

                    Name: <%=student.getName() %>
                    <input type= "hidden" name="School" value="<jsp:getProperty name="thisSchool" property="schoolName" />"/>
                    Year Start:<select id="selectDateStart" name ="dateStart"></select>
                    <script>
                        var minStart = 2000;
                        var maxStart = 2011;
                        var select = document.getElementById('selectDateStart');

                        for (var i = minStart; i <= maxStart; i++) {
                            var optionStart = document.createElement('option');
                            optionStart.value = i;
                            optionStart.innerHTML = i;
                            select.appendChild(optionStart);
                        }
                    </script>
                    Year End:<select id="selectDateEnd" name ="dateEnd"></select>
                    <script>
                        var minEnd = minStart + 3;
                        var maxEnd = minEnd + 11;
                        var selectEnd = document.getElementById('selectDateEnd');

                        for (var n = minEnd; n <= maxEnd; n++) {
                            var optionEnd = document.createElement('option');
                            optionEnd.value = n;
                            optionEnd.innerHTML = n;
                            selectEnd.appendChild(optionEnd);
                        }
                    </script>
                    <script>
                        function checkDate(addattendcheck)
                        {
                            if (addattendcheck.dateStart.value > addattendcheck.dateEnd.value) {
                                alert('Invalid Years Entered!');
                                return false;
                            }
                            else {
                                return true;
                            }
                        }
                    </script>
                    <input type="submit" name="append" value="Add"/> Add yourself to this school <br/>
                </form>
                <br>
                <br>
                <table>
                    <tr>
                        <th>Student name:</th>
                        <th>Start Year:</th>
                        <th>End Year</th>
                        <th></th>
                    </tr>
                    <%
                        List students = (List) session.getAttribute("DBstudents");
                        Iterator it = students.iterator();
                        while (it.hasNext()) {

                            Attendance attendance1 = (Attendance) it.next();
                    %> 
                    <tr>

                        <td><%=attendance1.getName()%></td>
                        <td><%=attendance1.getDateStart()%></td>
                        <td><%=attendance1.getDateEnd()%></td>
                        <td><form action="FriendController" method="post">
                            <input type="hidden" name="FriendName" value="<%=attendance1.getName()%>"/>
                            <input type="submit" value="Visit Page"/> 
                            </form>
                        </td>
                       
                    </tr>
                    <%
                        }
                    %>
                </table>
                <br/><hr><br/>
            </div>
        </div>
    </body>
</html>
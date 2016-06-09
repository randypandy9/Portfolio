<%-- 
    Document   : profilepage
    Created on : 11-Mar-2014, 14:37:53
    Author     : ysj13kxu
--%>
<%@page import="AlumniPackage.School"%>
<%@page import="AlumniPackage.Attendance"%>
<%@page import="AlumniPackage.Student"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="AlumniPackage.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/base/jquery-ui.css" type="text/css" media="all" /> 
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.min.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.min.js" type="text/javascript"></script>
        
        <link rel = "stylesheet" type = "text/css" href = "alumnicss.css" />
        <script src="jquery.validate.js" type="text/javascript"> </script>
        <script src="profilePageJS.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <img src="Banner.jpg" class="image"/>
            <div class="gap">
                <%
                    Student student = (Student) session.getAttribute("Studentdetails");                  
                %> 
                <br /><hr>
                <form id="updateprofile" method="POST" action="profileController">
                <h1>Welcome!</h1>                
                <hr><div class="rightside">
                    <div id="menu">
                        <ul>
                            
                            <li><a href="newmsg.jsp"> Compose New Message </a></li>
                            <li><a href="InboxController"> Inbox </a></li> 
                            <li><a href="LogOut"> Logout </a></li>
                        </ul>
                    </div>                 
                </div> 
                <br />
                Welcome to your profile page,              
                <h4><%= student.getName() %></h4>
               
                <br />
                Your email address:<br/>
                <h4><%= student.getEmail() %></h4>
                
                <br />
                About you:<br/>
                <h4><%= student.getInfo() %></h4>
                
                <br />
                Your School:<br/>
                <h4><%= student.getSchool() %></h4>
                
                <br /><hr>
                <h3>
                    Edit
                </h3>
                <p>
                <form id="newdetails" method="POST" action="profileController">
                New details form<br/>
                New name:<input type="text" id="newname" name="newname" size="20"/><br />
                New email:<input type="text" id="newemail" name="newemail" size="20"/><br />
                New info:<input type="text" id="newinfo" name="newinfo" size="20"/><br />
                New School:<select name="newschool" id="newschool">
                <%
                List schoolList = (List) session.getAttribute("bschoolList");
                Iterator it = schoolList.iterator();
                while(it.hasNext()){

                    School school = (School) it.next();
                 %>

                 <option value="<%=school.getSchoolName()%>"><%=school.getSchoolName()%></option>


                 <%
                }
                %>    
            </select><br />
                <input id="update" name="update" value="Update" type="submit">
                </form>
                </p>
                <hr>
                <h3>
                    Request to Administrator
                </h3>             
                <p>
                <form id="profiletoadmin" method="POST" action="AdminRequests">
                Name of School you would like to request:<br/><br/>
                <input type="text" id="propSchool" name="propSchool" size="20"/><br />
                <input id="SendtoAdmin" name="SendtoAdmin" value="Submit" type="submit">
                </form>
                </p>
                <hr><br />
                Alumni's that were in your school at the same time you were: <br/><br/>
                <table>
                    <tr>
                        <th>Name</th>
                        <th>School</th>
                        <th>Course Start</th>
                        <th>Course End</th>
                    </tr>
                <%
                    List friends = (List) session.getAttribute("friends");
                    Iterator friendit = friends.iterator();
                    while (friendit.hasNext())
                    {
                        Attendance afriend = (Attendance) friendit.next();
                    
                %> 
                    
                    <tr>
                        <td><%= afriend.getName()%></td>
                        <td><%= afriend.getSchoolName() %></td>
                        <td><%= afriend.getDateStart() %></td>
                        <td><%= afriend.getDateEnd() %></td>
                    </tr>
                
                <%
                    }
                %>
                </table>
                <br /><hr><br/>
                <form action="SchoolController" method ="get">
                <input type="submit" value="List schools"/> 
                </form> 
                 <br /><hr><br/>
                </div>
        </div>
                
    </body>
</html>

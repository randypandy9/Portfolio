<%-- 
    Document   : newmsg
    Created on : 30-Mar-2014, 23:38:15
    Author     : ysj13kxu
--%>

<%@page import="AlumniPackage.Message"%>
<%@page import="AlumniPackage.Attendance"%>
<%@page import="java.util.Iterator"%>
<%@page import="AlumniPackage.School"%>
<%@page import="java.util.List"%>
<%@page import="AlumniPackage.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" type = "text/css" href = "alumnicss.css" />
        <title>New Message</title>
    </head>
    <body>       
        <div class="container">
            <div class="gap">
                <%
                    Student student = (Student) session.getAttribute("Studentdetails");
                %>
                <br/><hr>
                <h1>Compose Message</h1>
                <hr><br/>
                
                <form action="newMessage" method="POST">
                <input type="hidden" name="sender" value="<%=student.getStudentID()%>" size="20"/><br />
                Recipient: 
                <select name="recipient">
                 <%                 
                        
                        List allfriends = (List) session.getAttribute("allfriends");
                        Iterator allfriendsit = allfriends.iterator();
                        while(allfriendsit.hasNext())
                        {
                            Attendance allfriend = (Attendance) allfriendsit.next();                          
                        
                %>            
             <option value="<%=allfriend.getAttid() %>"><%=allfriend.getName() %></option>           
                <%
                        }
                %>    
            </select>
                
                
                
                
                <br />
                Message Body: <input type="text" id="messagecontents" name="messagecontents" size="50"/><br />
                <input type="submit" id="sender" value="Send Message" /><br />
                </form>             
                <hr><br/>
            </div>
        </div>
    </body>
</html>

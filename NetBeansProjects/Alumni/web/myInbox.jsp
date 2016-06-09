<%-- 
    Document   : myInbox
    Created on : 30-Mar-2014, 21:54:45
    Author     : ysj13kxu
--%>

<%@page import="AlumniPackage.Attendance"%>
<%@page import="AlumniPackage.Student"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="AlumniPackage.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" type = "text/css" href = "alumnicss.css" />
        <title>Inbox</title>
    </head>
    <body>
        <div class='container'>
            <div class="gap">
                <br/>
                <hr><div class="rightside">
                    <a href="LogOut"> Logout </a>
                </div>
                <h1>Inbox</h1>                
                <hr><br/>
                <div class="rightside">
                    <a href="profilepage.jsp"> Profile Page </a>
                </div>
                <table>
                    <tr>
                        <th> Sender </th>
                        <th> Receiver </th>
                        <th> Message </th>
                        <th> Status </th>
                    </tr>
                    
                <%
                    Student student = (Student) session.getAttribute("Studentdetails");
                    int myID = student.getStudentID();
                    
                    List msgs = (List) session.getAttribute("myInbox");
                    Iterator msgit = msgs.iterator();
                    Attendance allfriend = null;
                    Attendance afriend = null;
                    while(msgit.hasNext())
                    {
                        Message msg = (Message) msgit.next();
                        List allfriends = (List) session.getAttribute("allfriends");
                        Iterator allfriendsit = allfriends.iterator();
                        while(allfriendsit.hasNext())
                        {
                            allfriend = (Attendance) allfriendsit.next();
                            if(allfriend.getAttid() == Integer.parseInt(msg.getSender()))
                            {
                                afriend = (Attendance) allfriend;
                            }                          
                        }
                %>
                <tr>
                    <td><%=afriend.getName() %></td>
                    <td><%=student.getName() %></td>
                    <td><%=msg.getMsg() %></td>
                    <td><%=msg.getStatus() %></td>
                    <td><form action="InboxChanges" method="post"/>
                    <input type="hidden" name="msgID" value="<%=msg.getMessageeID()%>"/>
                    <input type="submit" value="Read/Unread"/>
                    </form>
                    </td>
                    <td><form action="InboxDelete" method="post"/>
                    <input type="hidden" name="msgID" value="<%=msg.getMessageeID()%>"/>
                    <input type="submit" value="Delete"/>
                    </form>
                    </td>
                </tr>               
                <%
                    }
                %>
                </table>
            </div>
        </div>
    </body>
</html>

<%-- 
    Document   : schoolDataList
    Created on : 27-Mar-2014, 13:11:02
    Author     : hta13nau
--%>

<%@page import="Schooldata_package.SchoolData"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" type = "text/css" href = "alumnicss.css" /> 
        <title>Schools</title>
    </head>
    <body>
        <div class="container">
            <img src="Banner.jpg" class="image"/>
            <div class="gap">
                <br/><hr>
                <h1>List of Schools</h1>
                <hr><br/>
                <table>
                    <tr>
                        <th>School Name</th>
                        <th>           </th>
                    </tr>
                    <%

                        List listofschools = (List) request.getAttribute("schoollist");
                        Iterator iterate = listofschools.iterator();
                        while (iterate.hasNext()) {

                            SchoolData school = (SchoolData) iterate.next();
                    %>
                    <tr> 
                        <td><%=school.getSchoolName()%></td>
                        <td><form action="AttendanceController" method="post">
                                <input type="hidden" name="school" value="<%=school.getSchoolName()%>"/>
                                <input type="submit" value="Click for more Detail:"/> 
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

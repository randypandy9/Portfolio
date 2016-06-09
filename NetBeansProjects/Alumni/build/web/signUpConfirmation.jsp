<%-- 
    Document   : signUpConfirmation
    Created on : 18-Mar-2014, 15:05:09
    Author     : ysj13kxu
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="AlumniPackage.School"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up Confirmation</title>
        <link rel = "stylesheet" type = "text/css" href = "alumnicss.css" />
    </head>
    <body>
        <div class="container">
            <div class="gap">
        <jsp:useBean id="Accountsigndetails" type="AlumniPackage.Account" scope="request"/>
        <br /><hr>
        <h1>Great! Almost There!</h1>
        <hr>
       <p> You're almost there <jsp:getProperty name= "Accountsigndetails" property="name" />! Choose the School from the list and add in start and end year of your course</p>
        <br />
        <form action="SchoolUpdate" method="Post"  id="schoolupdate"onsubmit="return checkDate(this);">
            <select name="schoolAdd">
            <%
            List schoolList = (List) request.getAttribute("schoolList");
            Iterator it = schoolList.iterator();
            while(it.hasNext()){
                
                School school = (School) it.next();
             %>
             
             <option value="<%=school.getSchoolName()%>"><%=school.getSchoolName()%></option>
             
             
             <%
            }
            %>    
            </select>
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
                        var maxEnd = minEnd+11;
                        var selectEnd = document.getElementById('selectDateEnd');

                        for (var n = minEnd; n <= maxEnd; n++) {
                            var optionEnd = document.createElement('option');
                            optionEnd.value = n;
                            optionEnd.innerHTML = n;
                            selectEnd.appendChild(optionEnd);
                        }
                    </script>
                    <script>
                        function checkDate(schoolupdate)
                        {
                            if (schoolupdate.dateStart.value > schoolupdate.dateEnd.value) {
                                alert('Invalid Years Entered!');
                                return false;
                            }
                            else {
                                return true;
                            }
                        }
                    </script>
            <input type ="hidden" name="email" value="${Accountsigndetails.email}"/>
            <input type="submit" value="Attended"/>
        </form> 
        <br /><br /><hr> 
        </div>
        <br /><br />
        </div>
        
    </body>
</html>

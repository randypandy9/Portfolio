<%-- 
    Document   : index
    Created on : 18-Feb-2014, 12:47:11
    Author     : ysj13kxu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Health Page</title>
    </head>
    <body>
        <form method="POST" action="Controller"> 
            <h1>Enter details</h1>
            
            PATIENT <br/><br/>
            Name: <input type="text" name="name" size="20"/> <br/><br />
            Address: <input type="text" name="address" size="40"/> <br/><br />
            <br/><br />
            
            DOCTOR <br/><br />
            Doctor Name: <input type="text" name="doctorName" size="20"/> <br/><br />
            Room Number: <input type="text" name="Droom"/> <br/><br />
            <br/><br />
            
            TEST <br/><br />
            Test: <input type="text" name="test" size="20"/> <br/><br />
            Technician: <input type="text" name="technician" size="20"/> <br/><br />
            Outcome: <input type="text" name="outcome" size="20"/> <br/><br />
            Date: <input type="text" name="date" size="20"/> <br/><br />
            <br/><br />
            
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
            
        </form>       
    </body>
</html>

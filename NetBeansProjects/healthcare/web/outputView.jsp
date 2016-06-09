<%-- 
    Document   : outputView
    Created on : 18-Feb-2014, 14:25:30
    Author     : ysj13kxu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Output View</title>
    </head>
    <body>
        <h1>RESULTS</h1>
        <jsp:useBean id="patientdetails" type="healthpackage.Patient" scope="request" />
        <jsp:useBean id="doctordetails" type="healthpackage.Doctor" scope="request" />
        <jsp:useBean id="testdetails" type="healthpackage.Test" scope="request" />
        <br/><br/>
        <table>
            <tr>
                <th>Name</th>
                <th>Address</th>
                
            </tr>
            <tr>
                <td><jsp:getProperty name= "patientdetails" property="name" /></td>
                <td><jsp:getProperty name= "patientdetails" property="address" /></td>
                
            </tr>
        </table>
        <br/><br/>
        <table>
            <tr>
                <th>Doctor Name</th>
                <th>Doctor Room</th>
            </tr>
            <tr>
                <td><jsp:getProperty name= "doctordetails" property="doctorName" /></td>
                <td><jsp:getProperty name= "doctordetails" property="doctorRoomNumber" /></td>
            </tr>
        </table>
        <br/><br/>    
        <table>
            <tr>
                
                <th>Test</th>
                <th>Technician</th>
                <th>Outcome</th>
                <th>Date</th>
            </tr>
            <tr>
                
                <td><jsp:getProperty name= "testdetails" property="test" /></td>
                <td><jsp:getProperty name= "testdetails" property="technician" /></td>
                <td><jsp:getProperty name= "testdetails" property="outcome" /></td>
                <td><jsp:getProperty name= "testdetails" property="date" /></td>
            </tr>
        </table>
        <br/><br/>    


    </body>
</html>

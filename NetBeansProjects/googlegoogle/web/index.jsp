<%-- 
    Document   : index
    Created on : 29-Oct-2013, 14:01:37
    Author     : ysj13kxu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3> gUEAgle </h3>
        
        <p>
        <a href="https://www.google.co.uk/#q=uea"> UEA </a> <br />
        <a href="https://www.google.co.uk/#q=uea+cmp"> UEA CMP </a> <br />
        </p>
        
        <form method="get" action="http://www.bing.co.uk/search">
            <legend> Search </legend>
            <input type="text" name="q" size="40"> <br />
            <input type="submit"> <br/>
            <br/>
            <input type="radio" value="1" name="" /> 1 pages <br />
            <input type="radio" value="2" name="" /> 2 pages <br />
            <input type="radio" value="5" name="" /> 5 pages <br />
            <br/>
            number of pages: <input type="text" name="count" size="5"/> <br/>
            <br/>
            <select>
                <option value="10" name=""> 10 </option>
                <option value="20" name=""> 20 </option>
                <option value="50" name=""> 50 </option>
            </select>
            <br/> 
        </form>
        
        
        
        
    </body>
</html>

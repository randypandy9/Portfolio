<%-- 
    Document   : editProfile
    Created on : 27-Mar-2014, 19:17:44
    Author     : ysj13kxu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit page</title>
    </head>
    <body>
        <div class="container">
            <div class="gap">
            New details form
            <form id="newdetails" method="POST" action="profileController">
                New name:<input type="text" id="newname" name="newname" size="20"/><br />
                New email:<input type="text" id="newemail" name="newemail" size="20"/><br />
                New info:<input type="text" id="newinfo" name="newinfo" size="20"/><br />
                <input id="Update" name="update" value="Update" type="submit">
            </form>
            </div>
        </div>
    </body>
</html>

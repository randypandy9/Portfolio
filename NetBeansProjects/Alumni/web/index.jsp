<%-- 
    Document   : index
    Created on : 05-Mar-2014, 17:15:27
    Author     : ysj13kxu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumni Home Page</title>
        <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/base/jquery-ui.css" type="text/css" media="all" /> 
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.min.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.min.js" type="text/javascript"></script>      
        <link rel = "stylesheet" type = "text/css" href = "alumnicss.css" /> 
        <script src="jquery.validate.js" type="text/javascript"></script>
        <script src="myJS.js" type="text/javascript"></script>      
    </head>
    <body>    
        <div class="container">
            <img src="Banner.jpg" class="image"/>
            <div class="gap">
                <br /><hr>
                <div class="rightside">
                    <input name="Button" type="button" onClick="password();" value="Enter Admin Area">         
                    <script>
                        function password() { //password check
                            var testV = 1;
                            var pass1 = prompt('Please Enter Your Password', '');
                            while (testV < 3) {
                                if (!pass1)
                                    history.go(-1);
                                if (pass1.toLowerCase() === "password")
                                {
                                    alert('Correct Password');
                                    window.open('http://localhost:8084/Alumni/RequestController');
                                    break;
                                }
                                testV += 1;
                                var pass1 =
                                        prompt('Access Denied - Incorrect Password, Please Try Again.', 'Password');
                            }
                            if (pass1.toLowerCase() !== "password" & testV === 3)
                                history.go(-1);
                            return " ";
                        }
                    </script>
                </div>         
                <h1>Alumni Home Page</h1>           
                <hr>
                <div class="login">
                    <h2>
                        Log In!
                    </h2>
                    <p>          
                    <form id="login" method="POST" action="Controller">       
                        Username: <input type="text" id="loginusername" name="loginusername" size="20"/><br /><br />
                        Password: <input type="password" id="loginpassword"name="loginpassword" size="20"/><br /><br /> 
                        <input id="logIn" name="logIn" value="Log In" type="submit">
                    </form>
                    </p>
                </div>
                <hr>           
                <h2>
                    Sign Up!
                </h2>
                <p>          
                <form id="signup" onsubmit="return checkEmail(this);" method="POST" action="Controller" >
                    Full Name: <input type="text" id="signfullname" name="signfullname" size="20"/><br /><br />
                    Email: <input name="signemail" id="signemail" type="email" size="20" class="required email"/><br /><br />
                    Re-enter Email: <input name="signemailconfirm" id="signemailconfirm" type="email" size="20" class="required email"/><br /><br />
                    <script>
                        function checkEmail(signup)
                        {
                            if (signup.signemail.value !== signup.signemailconfirm.value)
                            {
                                alert('Email Addresses do not match');
                                return false;
                            }
                            else
                            {
                                return true;
                            }
                        }
                    </script>
                    Username: <input type="text" id="signusername" name="signusername" size="20"/><br /><br />
                    Password: <input type="password" id="signpassword" name="signpassword" size="20"/><br /><br />
                    <br/>
                    <input name="CreateAccount" id="CreateAccount" value="Create Account" type="submit"> 
                    <input value="Reset" id="reset" type="reset">    
                    <script>
                        $("#signup").validate();
                    </script>
                </form>
                </p>
                <hr>
                <br />           
                <br />
            </div>
        </div>
    </body>
</html>

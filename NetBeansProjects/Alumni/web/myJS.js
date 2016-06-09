$(document).ready(function()
{
    $("p").hide();
    $("h2").click(function()
    {
        $(this).next().slideToggle(300);
    });
    //hides and slides down the login and sign up forms
    $("#logIn").hide();
    $("#loginusername").keyup(function() {
    if ($(this).val().replace(/ /g, '') === '')
    {
        $("#logIn").hide(300);  
    }
    else
    {
        $("#loginpassword").keyup(function() {   
        if ($(this).val().replace(/ /g, '') === '')
        {
            $("#logIn").hide(300);  
        }
        else
        {
            $("#logIn").show(300);
        }
    });
    }    
    });
    //only shows login button if both login fields are filled in
    
    $("#CreateAccount").hide();
    $("#reset").hide();
    
    $("#signfullname").keyup(function() {   
        if ($(this).val().replace(/ /g, '') === '')
        {
            $("#CreateAccount").hide(300);
            $("#reset").hide(300);  
        }
        else
        {
            $("#signemail").keyup(function() {   
            if ($(this).val().replace(/ /g, '') === '')
            {
                $("#CreateAccount").hide(300);
                $("#reset").hide(300);  
            }
            else
            {
                $("#signemailconfirm").keyup(function() {   
                if ($(this).val().replace(/ /g, '') === '')
                {
                    $("#CreateAccount").hide(300);
                    $("#reset").hide(300);  
                }
                else
                {
                    $("#signusername").keyup(function() {   
                    if ($(this).val().replace(/ /g, '') === '')
                    {
                        $("#CreateAccount").hide(300);
                        $("#reset").hide(300);  
                    }
                    else
                    {
                        $("#signpassword").keyup(function() {   
                        if ($(this).val().replace(/ /g, '') === '')
                        {
                            $("#CreateAccount").hide(300);
                            $("#reset").hide(300);  
                        }
                        else
                        {
                            $("#CreateAccount").show(300);
                            $("#reset").show(300);
                        }
                    });
                    }
                });
                }
            });
            }
        });
        }
});
});

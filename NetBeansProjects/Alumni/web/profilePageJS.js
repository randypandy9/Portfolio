$(document).ready(function()
{
    $("p").hide();
    $("#update").hide();
    $("h3").click(function()
    {
        $(this).next().slideToggle(300);
    });
    $("#newname").keyup(function() {
        if ($(this).val().replace(/ /g, '') === '')
        {
            $("#update").hide(300);
        }
        else
        {
            $("#newemail").keyup(function() {
                if ($(this).val().replace(/ /g, '') === '')
                {
                    $("#update").hide(300);
                }
                else
                {
                    $("#newinfo").keyup(function() {
                        if ($(this).val().replace(/ /g, '') === '')
                        {
                            $("#update").hide(300);
                        }
                        else
                        {
                            $("#update").show(300);
                        }
                    });
                }
            });
        }
    });
});

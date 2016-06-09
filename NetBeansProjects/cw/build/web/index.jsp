<%-- 
    Document   : index
    Created on : 05-Dec-2013, 14:10:57
    Author     : ysj13kxu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Group ZW - Checkout </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="checkout.css" media="all">
    </head>

    <body>
        <form method="get" action="theservlet" name="checkout">
            <div class="titles"> 
                <h1> Checkout </h1>        
            </div>
            <hr>     
            <div>
                <table class="cpr">
                    <tr>
                        <th> Checkout </th> 
                        <th> Payment </th> 
                        <th> Review </th>
                    </tr>
                </table>
            </div>
            <br />
            <br />
            <hr>
            <div class="titles">
                <h2> Your order details / Basket </h2>
            </div>
            <div>
                <table>
                    <tr>
                        <th>Item(s)</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Remove</th>
                    </tr>
                    <tr align="center">
                        <td>(booked bikes would be displayed here)</td>
                        <td><select> 
                                <option value="1" id="bikesamount1"> 1 </option>
                                <option value="2" id="bikesamount2"> 2 </option>
                                <option value="3" id="bikesamount3"> 3 </option>
                            </select></td>
                        <td> £(Price of bike hire)</td>
                        <td><input type="checkbox"> Remove </td>
                    </tr>
                </table>
            </div>
            <hr>
            <div class="details1">
                <h3> Customer Details </h3>
                *First Name: <input type="text" name="fname" size="10"/>
                *Last Name: <input type="text" name="lname" size="10"/><br />
                *Address:
                <div>
                    <div class="indent">
                        *Line 1 <input type="text" name="address1" size="20"/><br />
                         Line 2 <input type="text" name="address2" size="20"/><br />
                         Line 3 <input type="text" name="address3" size="20"/><br />
                        *Town/City <input type="text" name="addresstown" size="20"/><br />
                        *County <input type="text" name="addresscounty" size="20"/><br />
                        *Post Code <input type="text" name="addresspc" size="20"/><br />
                    </div>
                </div>
                *Phone Number: <input type="text" name="email" size="20"/><br />
                *Email Address: <input type="text" name="email" size="20"/><br /><br />
                <p>Fields marked with a * must be filled in.</p>
            </div>
            <div>
                <h3> Card Details </h3>
                *Name on card: <input type="text" name="cardname" size="16"/> <br/><br />
                *Card Number: <input type="text" name="cardno" size="16"/> <br/><br />              
                <br /><br />
                *Expiration Date:
                <select>
                    <option value="01" id="expmonth1"> 01 </option>
                    <option value="02" id="expmonth2"> 02 </option>
                    <option value="03" id="expmonth3"> 03 </option>
                    <option value="04" id="expmonth4"> 04 </option>
                    <option value="05" id="expmonth5"> 05 </option>
                    <option value="06" id="expmonth6"> 06 </option>
                    <option value="07" id="expmonth7"> 07 </option>
                    <option value="08" id="expmonth8"> 08 </option>
                    <option value="09" id="expmonth9"> 09 </option>
                    <option value="10" id="expmonth10"> 10 </option>
                    <option value="11" id="expmonth11"> 11 </option>
                    <option value="12" id="expmonth12"> 12 </option>               
                </select> / <select>
                    <option value="12" id="expyear12"> 12 </option>
                    <option value="13" id="expyear13"> 13 </option>
                    <option value="14" id="expyear14"> 14 </option>
                    <option value="15" id="expyear15"> 15 </option>
                    <option value="16" id="expyear16"> 16 </option>
                </select> (MM/YY)
                <br /><br />               
            </div>
            <hr>
            <br/>
            <div class="totals">
                <table>
                    <tr>
                        <th>Subtotal:</th>
                        <th>(subtotal price)</th>
                    </tr>
                    <tr>
                        <th>VAT:</th>
                        <th>(added VAT)</th>
                    </tr>
                    <tr>
                        <th>TOTAL:</th>
                        <th>(TOTAL Price)</th>
                    </tr>
                </table>
            </div>
            <br />
            <div class="buttons">
                <input type="submit" value="Continue">
                <input type="reset" value="Reset">
            </div>
        </form>
    </body>
</html>

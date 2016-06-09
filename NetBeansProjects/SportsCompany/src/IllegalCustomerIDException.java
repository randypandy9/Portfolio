/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ysj13kxu
 */
class IllegalCustomerIDException extends Exception 
{
    public IllegalCustomerIDException(String error) //error handling
    {
        super(error); //output error from parent class
    }
}

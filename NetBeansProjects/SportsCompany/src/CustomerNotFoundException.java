/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ysj13kxu
 */
class CustomerNotFoundException extends Exception 
{
    public CustomerNotFoundException(String error) //error handling 
    {
        super(error); //output error from parent class
    }
}

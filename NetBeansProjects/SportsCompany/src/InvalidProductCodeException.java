/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ysj13kxu
 */
class InvalidProductCodeException extends Exception
{
    public InvalidProductCodeException(String error) //error handling
    {
        super(error); //output error from parent class
    }  
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ysj13kxu
 */
class IncorrectPurchaseOrderException extends Exception 
{
    public IncorrectPurchaseOrderException(String error) //error handling
    {
        super(error); //output error from parent class
    }
}

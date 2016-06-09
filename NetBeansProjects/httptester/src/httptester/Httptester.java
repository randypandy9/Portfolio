/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httptester;

import java.net.*;
import java.io.*;

public class Httptester 
{

    public static void main(String[] args) throws Exception {
        String hostname = args[0];
        Socket s = null;
        int p = 80;

        try 
        {
            s = new Socket(hostname, p);
            System.out.println("A server is running on port " + p + ".");
            s.close();
        } 
        catch (IOException e) 
        {
            System.out.println("No server on port " + p + ".");
        }
        if (s != null) 
        {
            try 
            {
                s.close();
            } 
            catch (IOException ioEx) 
            {
                System.out.println("Last error: " + ioEx);
            }
        }
    }
}
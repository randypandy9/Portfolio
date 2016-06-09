/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Random;

/**
 *
 * @author ysj13kxu
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println("My name is Imran Ali.");
        System.out.println("I don't really like books, sorry...");
        System.out.println("My favourite film is Pulp Fiction.");// TODO code application logic here
        Random ran = new Random();
        int decideletters = ran.nextInt(3);
        System.out.println(decideletters);
    }
}

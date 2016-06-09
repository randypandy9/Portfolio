/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demorgs;

/**
 *
 * @author ysj13kxu
 */
public class Demorgs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int x = 2;
        int a;
        
        switch (x) 
        {
            case 1:  a = 10;
                     break;
            case 2:  a = x*2;
                     break;
            default: a = 33333;
                     break;
        }
        System.out.println(a);
        System.out.println("----");
        
        a = x==1 ? 10:(x==2 ? x*2:33333);
        
        // a =  x==1 ? if : (x==2 ? if : else);
        System.out.println(a);
        
        

          


    }

}

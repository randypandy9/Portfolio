/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package majorityelement;

/**
 *
 * @author ysj13kxu
 */
public class MajorityElement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int [] inputarray = {2,2,3,3,4,4,4,6,7,7,7,7,7,7,7,7,7,7,7,7,7};
        int counter = 0;
        int [] results = new int [inputarray.length];
        int finalcount = 0;
        int address = 0;
        
        for (int i=0; i < inputarray.length; i++)
        {
            for (int a=0; a < inputarray.length; a++)
            {
                if (inputarray[i] == inputarray[a])
                {
                    counter++;
                }
            }
            results[i] = counter;
            counter = 0;
            
        }
        for (int b = 1; b<results.length; b++)
        {
            if (results[b] > results[b-1])
            {
                finalcount = results[b];
                address = inputarray[b];
            }
            
        }
        if(inputarray.length/2 < finalcount)
        {
            System.out.println("Majority element is " + address + ", occuring " + finalcount + " times.");
        }
        else
        {
            System.out.println("-1");
        }
        
    }
}

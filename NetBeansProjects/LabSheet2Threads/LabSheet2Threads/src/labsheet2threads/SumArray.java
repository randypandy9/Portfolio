/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package labsheet2threads;

import java.text.DecimalFormat;

/**
 *
 * @author ajb
 */
public class SumArray extends Thread{

/* Static method to find the sum of an array a from sstart to end positions, 
    i.e.        a[start]+a[start+1]+...a[end]
    */    
    public static int sequentialSumArray(int[] a, int start, int end){
        int sum=a[start];
        for(int i=start+1;i<end;i++)
            sum+=a[i];
        return sum;
    }
/* To thread this operation, we need to use SumArray objects. Each one will
    be given a different start and end point, and will run in its own thread,
    then add its result to the global variable grandSum
    */    
    static int grandSum=0;
    static int[] data;
    public int start;
    public int end;
    
    public SumArray(int s, int e){
        start=s;
        end=e;
    }
    
    public void run(){
        
        for(int i = start; i < end; i++)
        {           
            grandSum = grandSum + data[i];
        }
    }
    
    public static void threadSum(){
        int numThreads=10;
        SumArray[] s=new SumArray[numThreads];
        
        
//HERE: Question 1: Exercise to implement threaded summing of array
//Each thread should sum 1/10th of the array. Assume for simplicity 
//that the length is divisible by 10
     
        
    }
  
}

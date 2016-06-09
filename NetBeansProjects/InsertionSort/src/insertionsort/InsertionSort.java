/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertionsort;

import java.util.Arrays;

/**
 *
 * @author ysj13kxu
 */
public class InsertionSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] input = {5, 4, 3, 2, 1};
        for (int a = 0; a < input.length; a++) {
            System.out.print(input[a] + ", ");
        }
        System.out.println("\n");
        int arraylength = input.length;
        long t1 = System.nanoTime();

        long t2 = System.nanoTime();
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println("\n");
        long timeTaken = t2 - t1;
        System.out.println(timeTaken + " nanosecs.");
        System.out.println("");
        System.out.println("recursive version...");
        int[] finish = InsertionSort.recursivealg(input, 1);
        for (int pr = 0; pr < finish.length; pr++) {
            System.out.println(finish[pr]);
        }

    }

    public static int[] recursivealg(int[] input2, int n) {

        int[] donearray = new int[input2.length];

        if (n == input2.length) {
            donearray = input2.clone();
            return donearray;
        } else {

            for (int x = 1; x <= n; x++) 
            {
                if (x != input2.length) 
                {
                    if (input2[x - 1] > input2[x]) 
                    {
                        int temp = input2[x];
                        input2[x] = input2[x - 1];
                        input2[x - 1] = temp;
                    }
                }
                recursivealg(input2, n+1);
                donearray = input2.clone();
            }
        }

        return donearray;
    }

}

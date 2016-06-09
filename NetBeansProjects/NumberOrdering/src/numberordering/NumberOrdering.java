package numberordering;

import java.util.Arrays;
import java.util.Random;

public class NumberOrdering 
{

    public static void main(String[] args) 
    {
        int diff = 0;
        int prevdiff = 0;
        int counter = 0;
        Random rumber = new Random();
        int gen = rumber.nextInt(9999);
        for (int p = 0; p < 10 || gen != prevdiff; p++) 
        {
            
            System.out.println(gen);
            System.out.println("-----");
            int n1 = gen / 1000 % 100;
            System.out.println(n1);
            int n2 = gen / 100 % 10;
            System.out.println(n2);
            int n3 = gen / 10 % 10;
            System.out.println(n3);
            int n4 = gen % 10;
            System.out.println(n4);

            if (n1 == n2 && n1 == n3 && n1 == n4) 
            {
                NumberOrdering.main(args);
            }

            int[] ints = {n1, n2, n3, n4};
            Arrays.sort(ints);
            System.out.println("---");
            //asc
            String asc = ints[0] + "" + ints[1] + "" + ints[2] + "" + ints[3];
            System.out.println("ASC: " + asc);
            System.out.println("---");
            //desc
            String desc = ints[3] + "" + ints[2] + "" + ints[1] + "" + ints[0];
            System.out.println("DESC: " + desc);
            System.out.println("---");
            int int1 = Integer.parseInt(asc);
            int int2 = Integer.parseInt(desc);
            diff = int2 - int1;
            prevdiff = int2 - int1;
            System.out.println(diff);
            System.out.println("---");
            gen = diff;
            counter = counter + 1;

        }
        System.out.println("NO OF ITERATIONS PERFORMED: "+counter);
    }
}

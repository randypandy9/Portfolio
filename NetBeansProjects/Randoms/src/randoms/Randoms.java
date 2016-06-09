
package randoms;
import java.util.Random;
public class Randoms 
{

    public static void main(String[] args) 
    {
       Random randomGenerator = new Random();
       int n = 2;

       for (int m = 1; m <= 101; m = m + 10)
       {       
           int noH = 0;
           int noT = 0;
           
           for (int i = 0; i < m; i++)
           {    
                int res = randomGenerator.nextInt(n);         
                if (res == 0)
                {
                    noH = noH + 1;
                }
                if (res == 1)
                {
                    noT = noT + 1;
                }
           }
           System.out.println("-----");
           System.out.println("Heads: " + noH);
           System.out.println("Tails: " + noT);
  
        }
    }
}

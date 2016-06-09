package datastructures2;

import java.text.DecimalFormat;
/**
 *
 * @author ysj13kxu
 */
public class Question2 
{
    public static double f(double i, double j)
    {
        if(i==0 && j==0)
        {
            return 0;
        }
        if((i==0 && j>0) || (j==0 && i>0))
        {
            return 1;
        }
        else 
        {
            return (f(i-1,j)+f(i-1,j-1)+f(i,j-1))/3;
        }
    }
    
    public static double [] g(int n){
        double [] g = new double [n];
        for (int i = 0; i < n; i++) 
        {
            //saves all the diagonal values into g[i] to output
            g[i] = f(i, i);
        }
        //returns g[i]
        return g;
    }
    
    public static void main(String[] args)
    {   
        meanAndStandardDeviation(100,1);
        System.out.println("done");
        //increments from 10 to 1000000 by 
        //multiplying by 10 and outputting the answers
        int i = 10;
        while(i<=1000000)
        {
            System.out.println("---"+i+"---");
            improvedmethod(i);
            i*=10;
        }
    }
    
     public static double[] fArray(int n) {
        double[][] f = new double[n][n];
        double[] g = new double[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - 1; j++) {
                //if the first element in the 2d array is 
                //met then make it 0
                if (i == 0 && j == 0) {
                    f[i][j] = 0;
                } 
                //else if its along the edge then make it a 1
                else if ((i == 0 && j > 0) || (j == 0 && i > 0)) {
                    f[i][j] = 1;
                    
                } 
                //else i work out the recursion
                else 
                {
                    f[i][j] = ((f[i - 1][j]) + 
                            (f[i - 1][j - 1]) + (f[i][j - 1])) / 3;
                }
                //if its a diagonal value i save it to an array to output
                if (i == j) {
                    g[i] = f[i][j];
                }
            }
        }
        //return the diagonal array
        return g;
    }
    
    public static void improvedmethod(int n)
    {
        double[] f = new double[n];
        double[] s = new double[n];
        double[] results = new double[n];
        int counter = n;
        f[0] = 0;
        for(int i = 1; i<n; i++)
        {
            f[i] = 1;
        }

        for(int j=0; j<n; j++)
        {
            for(int i=0; i<n-1; i++)
            {
                if(i == 0)
                {
                    s[i] = ((f[i]) + (f[i + 1]) + (f[i + 1])) / 3;
                    results[j] = s[i];
                }
                else
                {
                    s[i] = ((f[i - 1]) + (f[i]) + (f[i + 1])) / 3;
                }
            }
            counter--;
            System.arraycopy(s, 0, f, 0, s.length-counter);
        }
        System.out.println(results[n-1]);
        
    }
    
    public static void meanAndStandardDeviation(int n, int reps){
       // Record mean and std deviation of performing an operation
        // reps times
        double sum=0,s=0;
        double sumSquared=0;
        for(int i=0;i<reps;i++)
        {
        long t1=System.nanoTime();
        g(n);
        long t2=System.nanoTime()-t1;
        //Recording it in milli seconds to make it more interprettable
        sum+=(double)t2/1000000.0;
        sumSquared+=(t2/1000000.0)*(t2/1000000.0);
        }
        double mean=sum/reps;
        double variance=sumSquared/reps-(mean*mean);
        double stdDev=Math.sqrt(variance); 
        System.out.println("\n");
        DecimalFormat df = new DecimalFormat("###.#####");
        System.out.print("n: "+n+" mean: "+df.format(mean)
                +" stdDev: "+df.format(stdDev));
    }
}

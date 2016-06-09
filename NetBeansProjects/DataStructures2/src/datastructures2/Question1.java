package datastructures2;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author ysj13kxu
 */
public class Question1 {
    /**
     * @param args the command line arguments
     */
    public static final int reps = 500;
    public static final int range = 2000;
    
    public static void main(String[] args) 
    {
        
        int A[][] = new int[][]
        {
            {  1,  3,  7,  8,  8,  9, 12},
            {  2,  4,  8,  9, 10, 30, 38},
            {  4,  5, 10, 20, 29, 50, 60},
            {  8, 10, 11, 30, 50, 60, 61},
            { 11, 12, 40, 80, 90,100,111},
            { 13, 15, 50,100,110,112,120},
            { 22, 27, 61,112,119,138,153},          
        };
        int test = -1;
        int testArray[] = new int[]{4,12,110,5,6,111};
        int nSizes[] = new int[]
            {10,20,30,40,50,60,70,80,90,100,
            200,300,400,500,600,700,800,900,1000,
            2000,3000,4000};
        int [][] d;
        System.out.println("D");
        for (int e = 0; e < nSizes.length; e++)
        {
            System.out.println("Size: " + nSizes[e] + "x" + nSizes[e]);
            for(int i = 0; i < testArray.length; i++)
            {
                d = generateMatrixForD(nSizes[e]);    
                System.out.println("Found element "+ testArray[i] + ": "
                        +FindElement_D(d, d.length, testArray[i]));
                
            }
            System.out.println("---------------------");
        }
        
        
        System.out.println("D1");
        for (int e = 0; e < nSizes.length; e++)
        {
            System.out.println("Size: " + nSizes[e] + "x" + nSizes[e]);
            for(int i = 0; i < testArray.length; i++)
            {
                d = generateMatrixForD1(nSizes[e]);    
                System.out.println("Found element "+ testArray[i] + ": "
                        +FindElement_D1(d, d.length, testArray[i]));
                
            }
            System.out.println("---------------------");
        }
        
        System.out.println("D2");
        for (int e = 0; e < nSizes.length; e++)
        {
            System.out.println("Size: " + nSizes[e] + "x" + nSizes[e]);
            for(int i = 0; i < testArray.length; i++)
            {
                d = generateMatrixForD2(nSizes[e]);    
                System.out.println("Found element "+ testArray[i] + ": "
                        +FindElement_D2(d, d.length, testArray[i]));
                
            }
            System.out.println("---------------------");
        }
        
        for(int e = 0; e < nSizes.length; e++)
        {
            d = generateMatrixForD(nSizes[e]);
            double sum = 0, s = 0;
            double sumSquared = 0;
            for (int i = 0; i < reps; i++) 
            {
                d[d.length-1][d.length-1] = 10000;
                long t1 = System.nanoTime();
                FindElement_D(d, d.length, 10000);
                long t2 = System.nanoTime() - t1;
                //Recording it in milli seconds to make it 
                //more interprettable
                sum += (double) t2 / 1000000.0;
                sumSquared += (t2 / 1000000.0) * (t2 / 1000000.0);
            } 
            System.out.println("Result: " + 
                    FindElement_D(d, d.length, test));
            double mean = sum / reps;
            double variance = sumSquared / reps - (mean * mean);
            double stdDev = Math.sqrt(variance);
            DecimalFormat df = new DecimalFormat("###.####");
            System.out.println(df.format(mean));
        }
        System.out.println("----------------------------------");
        //--------------------------------------------------
        int [][] d1;
        for(int e = 0; e < nSizes.length; e++)
        {
            d1 = generateMatrixForD1(nSizes[e]);
            double sum = 0, s = 0;
            double sumSquared = 0;
            for (int i = 0; i < reps; i++) 
            {
                long t1 = System.nanoTime();
                FindElement_D1(d1, d1.length, test);
                long t2 = System.nanoTime() - t1;
                //Recording it in milli seconds to make 
                //it more interprettable
                sum += (double) t2 / 1000000.0;
                sumSquared += (t2 / 1000000.0) * (t2 / 1000000.0);
            }
            System.out.println("Result: " + 
                    FindElement_D1(d1, d1.length, test));
            double mean = sum / reps;
            double variance = sumSquared / reps - (mean * mean);
            double stdDev = Math.sqrt(variance);
            DecimalFormat df = new DecimalFormat("###.####");
            System.out.println(df.format(mean));
        }
        System.out.println("----------------------------------");
        //---------------------------------------------------
        int [][] d2;
        for(int e = 0; e < nSizes.length; e++)
        {
            d2 = generateMatrixForD2(nSizes[e]);
            double sum = 0, s = 0;
            double sumSquared = 0;
            d2[d2.length-1][0] = 10000;
            for (int i = 0; i < reps; i++) 
            {
                long t1 = System.nanoTime();
                FindElement_D2(A, A.length, 22);
                long t2 = System.nanoTime() - t1;
                //Recording it in milli seconds to 
                //make it more interprettable
                sum += (double) t2 / 1000000.0;
                sumSquared += (t2 / 1000000.0) * (t2 / 1000000.0);
            }
            System.out.println("Result: " + 
                    FindElement_D2(d2, d2.length, test));
            double mean = sum / reps;
            double variance = sumSquared / reps - (mean * mean);
            double stdDev = Math.sqrt(variance);
            DecimalFormat df = new DecimalFormat("###.####");
            System.out.println(df.format(mean));
        }
        
    }
    
    public static boolean FindElement_D(int[][] A, int n, int p)
    {
        //iterate through whole 2d array
        for(int a = 0; a < n; a++)
        {
            for(int d = 0; d < n; d++)
            {
                //if current matches then return true
                if(A[a][d] == p)
                {
                    return true;
                }
            }
        }
        //if its not found then return false
        return false;
    }
    
    public static boolean FindElement_D1(int[][] A, int n, int p) 
    {
        //simply find a number in A given each row is 
        //in increasing order
        boolean result = false;
        for (int a = 0; a < n; a++) 
        {
            int min = 0, max = n - 1;
            while (min <= max) 
            {
                int mid = (max + min) / 2;
                if(p == A[a][mid])
                {
                    return true;
                }
                else if (p < A[a][mid]) 
                {
                    max = mid - 1;
                } 
                else if (p > A[a][mid]) 
                {
                    min = mid + 1;
                } 
            }
        }
    return result;
    }
    
    public static boolean FindElement_D2(int[][] A, int n, int p)
    {
        boolean found = false,end = false;
        int i = 0, j = n-1;
        while(!end)
        {
            if(A[i][j] == p)
            {
                return true;
            }
            else if(A[i][j] > p)
            {
                j--;
            }
            else if(A[i][j] < p)
            {
                i++;
            }
            if(j<0 || i<0 || j>=n || i>=n)
            {
                end = true;
            }
        }
        return found;
    }
    
    public static int[][] generateMatrixForD(int n)
    {
        int [][] newmatrix = new int[n][n];
        for(int a = 0; a < n; a++)
        {
            for(int c = 0; c < n; c++)
            {
                Random rand = new Random();
                int element = rand.nextInt(range)+1;
                newmatrix[a][c] = element;
            }
        }
        return newmatrix;
    }
    
    public static int[][] generateMatrixForD1(int n)
    {
        Random rand = new Random();
        int[][] TwoDMatrix = new int[n][n];
        int[] tempMatrix = new int[n];
        for(int i = 0; i < n; i++)  
        {
            for(int j = 0; j < n; j++) 
            {
                tempMatrix[j] = rand.nextInt(range) + 1;
            }
            Arrays.sort(tempMatrix);
            for(int p = 0; p < tempMatrix.length; p++)
            {
                TwoDMatrix[i][p] = tempMatrix[p];
            }
        }
        return TwoDMatrix;
    }
    
    public static int[][] generateMatrixForD2(int n)
    {
        Random rand = new Random();
        int[][] TwoDMatrix = new int[n][n];

        int[] longMatrix = new int[n * n];
        int[] tempMatrix = new int[n];
        for(int i = 0; i < n * n; i++) 
        {
            longMatrix[i] = rand.nextInt(range) + 1;
        }
        Arrays.sort(longMatrix);

        for(int i = 0, k = 0; i < (n * n); i += n, k++) 
        {
            for (int j = 0; j < n; j++) 
            {
                tempMatrix = Arrays.copyOfRange(longMatrix, i, i + n);
                TwoDMatrix[k][j] = tempMatrix[j];
            }
        }
        return TwoDMatrix;
    } 
}

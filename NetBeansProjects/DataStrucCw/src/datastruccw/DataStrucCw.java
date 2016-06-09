package datastruccw;

import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author ysj13kxu
 */
public class DataStrucCw {

    /**
     * @param mainArray
     * @param subArray
     * @return
     */
    public static double[] Work(double[][] mainArray, double[] subArray) {
        double[] toReturn = new double[3];
        double a = 0;
        double s = 0;
        double currentSmallest = 1000000;

        // root (1-1sqr + 0-2sqr + 3-3sqr)
        //goes through all of seriesT
        for (int i = 0; i < mainArray.length; i++) {
            //goes through chuncks
            for (int j = 0; j <= mainArray[i].length - subArray.length; j++) {
                for (int p = 0; p < subArray.length; p++) {
                    a += (subArray[p] - mainArray[i][p + j]) * (subArray[p] - mainArray[i][p + j]);
                }
                if (s < currentSmallest) {
                    currentSmallest = s;
                    toReturn[0] = i;
                    toReturn[1] = j;
                    toReturn[2] = currentSmallest;

                }
                a = 0;
            }
        }
        return toReturn;

    }

    public static double[] Work2(double[][] mainArray, double[] subArray) {
        //int[] subArray =     {1, 2, 3};
        //int[][] mainArray = {{1, 2, 3, 4, 5, 6}, {3, 4, 6, 7, 8, 9}, {9, 5, 1, 2, 8, 7}};
        double[] toReturn = new double[3];
        double a = 0;
        double currentSmallest = 1000000;

        // root (1-1sqr + 0-2sqr + 3-3sqr)
        //goes through all of seriesT
        for (int i = 0; i < mainArray.length; i++) {
            //goes through chuncks
            for (int j = 0; j <= mainArray[i].length - subArray.length; j++) {
                boolean goNextSummation = false;
                int p = 0;
                while (goNextSummation == false && p < subArray.length) {
                    a += (subArray[p] - mainArray[i][p + j]) * (subArray[p] - mainArray[i][p + j]);
                    if (a > (currentSmallest * currentSmallest)) {
                        goNextSummation = true;
                    }
                    p++;
                }
                /*for (int p = 0; p < subArray.length; p++) {
                 a += (subArray[p] - mainArray[i][p + j]) * (subArray[p] - mainArray[i][p + j]);
                 }*/

                if (a < currentSmallest) {
                    currentSmallest = a;
                    toReturn[0] = i;
                    toReturn[1] = j;
                    toReturn[2] = currentSmallest;
                }

                a = 0;
            }
        }
        return toReturn;
    }

    public static double[] generateQuery(int s) {
        double[] q = new double[s];
        Random r = new Random();
        for (int i = 0; i < s; i++) {
            q[i] = r.nextDouble();
        }
        return q;
    }

    public static double[][] generateDataSet(int n) {
        double[][] data = new double[n][n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = r.nextDouble();
            }
        }

        return data;
    }

    public static void meanAndStandardDeviation(int n, int reps) {
        double sum = 0, s = 0;
        double[][] d = generateDataSet(n);
        double[] gq = generateQuery(7);
        //double[] S;
        double sumSquared = 0;
        for (int i = 0; i < reps; i++) {
            long t1 = System.nanoTime();
            Work2(d, gq);
            long t2 = System.nanoTime() - t1;
//Recording it in milli seconds to make it more interprettable
            sum += (double) t2 / 1000000.0;
            sumSquared += (t2 / 1000000.0) * (t2 / 1000000.0);
            //System.out.println(t2);
        }
        double mean = sum / reps;
        double variance = sumSquared / reps - (mean * mean);
        double stdDev = Math.sqrt(variance);
        DecimalFormat df = new DecimalFormat("###.####");
        System.out.println("n=" + n + " Mean =" + df.format(mean) + " stdDev=" + df.format(stdDev));

    }

    public static void main(String[] args) {

        /*double[] res = new double[2];
         double[] res1 = new double[2];
         double[] res2 = new double[2];

         double[] setset = generateQuery(3);
         double[][] setsetset = generateDataSet(10);

         long startTime = System.nanoTime();
         res = Work2(setsetset, setset);
         long endTime = System.nanoTime();
         long result = endTime - startTime;
         System.out.println("Raw attempt to get baseline efficiency: " + result + "ns ... Large Array index: " + res[0] + "... Starting point: " + res[1]);
         System.out.println("-------------------------------");
         long startTime1 = System.nanoTime();
         res1 = Work1(setsetset, setset);
         long endTime1 = System.nanoTime();
         long result1 = endTime1 - startTime1;
         System.out.println("1st Attempt for improved efficiency : " + result1 + "ns ... Large Array index: " + res1[0] + "... Starting point: " + res1[1]);
         System.out.println("-------------------------------");
         long startTime2 = System.nanoTime();
         res2 = Work2(setsetset, setset);
         long endTime2 = System.nanoTime();
         long result2 = endTime2 - startTime2;
         System.out.println("2nd Attempt for improved efficiency : " + result2 + "ns ... Large Array index: " + res2[0] + "... Starting point: " + res2[1]);
         System.out.println("-------------------------------");
         */
        for (int n = 50; n <= 1000; n += 50) {
            meanAndStandardDeviation(n, 100);
        }

    }
}

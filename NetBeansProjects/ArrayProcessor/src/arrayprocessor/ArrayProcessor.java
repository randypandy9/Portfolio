package arrayprocessor;
import java.util.Scanner;
public class ArrayProcessor 
{

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Array size:");
        int i = scan.nextInt();
        double[] marks;
        marks = new double[i];
        
        for (int index = 0; index < i; index++)
        {
           System.out.println("Enter the next value for position " + index + " in marks");
           marks[index] = scan.nextDouble(); 
        }
        
        System.out.println("The average value in the array is: " + ArrayProcessor.averageValue(marks));
        
        double[] range;
        range = ArrayProcessor.rangeOfValues(marks);
        
        System.out.println("Max is " + range[0]);
        System.out.println("Min is " + range[1]);
        
        System.out.println("The number of marks less than 40 are: " + ArrayProcessor.numberLessThan(marks, i));
    }
    
    
    public static double [] rangeOfValues(double [] data)
    {
       int i = data.length;
       double currentMax = data[0];
       double currentMin = data[0];
              
       double[] minmax;
       minmax = new double[2];
       
       
       for (int index = 0; index < i; index++)
       {
           if ( data[index] > currentMax)
           {
                currentMax = data[index];   
           }
           if ( data[index] < currentMin)
           {
                currentMin = data[index];
           }
           
       }
       minmax[0] = currentMax;
       minmax[1] = currentMin;
       return minmax;
    }
                   
    
    public static double averageValue(double [] data)
    {    
        int i = data.length;
        int total = 0;
        for (int index = 0; index < i; index++)
        {
            total += data[index];
        }
        double end = (double) total/i;
        return end;
    }
    public static int numberLessThan(double [] data, double value )
    {
       int i = data.length;
       double set = 40;
       int failCount = 0;
       
       for (int index = 0; index < i; index++)
       {           
           if ( data[index] < set)
           {
                failCount = failCount + 1;
           }    
       }
       return failCount;
    }
}

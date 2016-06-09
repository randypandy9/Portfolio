
package javaapplication3;
import java.util.Scanner;

public class JavaApplication3 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter value to be converted from 'lbs' to 'Kg':");
        double toBeConverted = scan.nextDouble();
        double newnumber = toBeConverted * 0.454;
        System.out.println(toBeConverted + " lbs is equal to " + newnumber + " Kg.");
    }
}

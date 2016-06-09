package wk3worksheet;
import java.util.Scanner;
public class Wk3worksheet 
{

  
    public static void main(String[] args) 
    {
       Scanner scan = new Scanner(System.in);
       System.out.println("Enter 1st value:");
       int firstValue = scan.nextInt();
       System.out.println("Enter 2nd value:");
       int secondValue = scan.nextInt();
       System.out.println("Enter 3rd value:");
       int thirdValue = scan.nextInt();
       System.out.println("Your values added up make: " + (firstValue + secondValue + thirdValue));
    }
}
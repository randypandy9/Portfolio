package simplesums;
import java.util.Scanner;

public class SimpleSums 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 1st value!"); //Enter the 1st value here
        float number = scan.nextFloat(); //assignment happens here (1st)
        System.out.println("Enter 2nd value!"); //Enter the 2nd value here     
        float number2 = scan.nextFloat(); //assignment happens here (2nd)
        System.out.println("The sum of your numbers are: " + (number + number2)); //sum 
        System.out.println("The difference of your numbers are: " + (number - number2)); //difference
        System.out.println("The product of your numbers are: " + (number * number2)); //Multiplication
    }
}

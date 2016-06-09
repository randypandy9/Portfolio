
package temperatureconverter;
import java.util.Scanner;
public class TemperatureConverter 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a value in Degrees (C) to be converted into Fahrenheit (F):");
        double cTOf = scan.nextDouble();
        System.out.println((cTOf*(9/5))+32);
    }
}


package lessthanonepound;
import java.util.Scanner;
public class Lessthanonepound 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a value in pence that's 100 or less:");
        int pence = scan.nextInt();
        if (pence > 100)
        {
            System.out.println("Error, enter a value of 100 or less!");
        }
        else 
        System.out.println(pence / 100 + " x £1 coin(s)");
        pence = pence % 100;
        System.out.println(pence / 50 + " x 50p coin(s)");
        pence = pence % 50;
        System.out.println(pence / 20 + " x 20p coin(s)");
        pence = pence % 20;
        System.out.println(pence / 10 + " x 10p coin(s)");
        pence = pence % 10;
        System.out.println(pence / 5 + " x 5p coin(s)");
        pence = pence % 5;
        System.out.println(pence / 2 + " x 2p coin(s)");
        pence = pence % 2;
        System.out.println(pence / 1 + " x 1p coin(s)");
        pence = pence % 1;
    }
}

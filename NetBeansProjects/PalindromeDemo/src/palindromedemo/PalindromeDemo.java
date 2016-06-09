package palindromedemo;

import java.util.Scanner;

public class PalindromeDemo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Type to check:");
        String i = scan.nextLine();
        String testStr = null;
        String testStralmost = i.toLowerCase();
        testStr = testStralmost.replace(" ", "");

        if (isPalindromic(testStr) == true)
        {
            System.out.println("It's a palindrome!");
        }
        else 
        {
            System.out.println("It's not a palindrome!");
        }
    }

    public static boolean isPalindromic(String testStr) {
           
        if (testStr.length() == 0 || testStr.length() == 1) {
            return true;
        }
        
        int left = 0;
        int right = testStr.length() - 1;
        
        while (testStr.charAt(left) == testStr.charAt(right) && left < right) 
        {
            left = left + 1;
            right = right - 1;
        }

        if (left >= right) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }
}

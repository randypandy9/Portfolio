package seasonclassification;

import java.util.Scanner;

public class SeasonClassification 
{

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter month");
        int month = scan.nextInt();
        System.out.println("Enter day");
        int day = scan.nextInt();
        boolean valid = SeasonClassification.isValidDate(month, day);
        System.out.println(valid);
        String season = SeasonClassification.findSeason(month, day);
        System.out.println(season);
    }
    public static boolean isValidDate(int month, int day) 
    {
        if (month >= 1 && month <= 12) 
        {
            switch (day) 
            {
                case 1:
                    if (day <= 31) 
                    {
                        return true;
                    }
                case 2:
                    if (day <= 28) 
                    {
                        return true;
                    }
                case 3:
                    if (day <= 31) 
                    {
                        return true;
                    }
                case 4:
                    if (day <= 30) 
                    {
                        return true;
                    }
                case 5:
                    if (day <= 31) 
                    {
                        return true;
                    }
                case 6:
                    if (day <= 30) 
                    {
                        return true;
                    }
                case 7:
                    if (day <= 31) 
                    {
                        return true;
                    }
                case 8:
                    if (day <= 31) 
                    {
                        return true;
                    }
                case 9:
                    if (day <= 30) 
                    {
                        return true;
                    }
                case 10:
                    if (day <= 31) 
                    {
                        return true;
                    }
                case 11:
                    if (day <= 30) 
                    {
                        return true;
                    }
                case 12:
                    if (day <= 31) 
                    {
                        return true;
                    }
                default:
                    return false;
            }
        } else 
        {
            return false;
        }
    }

    public static String findSeason(int month, int day)
    {
        if (month == 12 && day >= 21)
            {
                return "Winter";
            }
        else if (month == 1 || month == 2)
            {
                return "Winter";
            }
        else if (month == 3 && day <= 20)
            {
                return "Winter";
            }
        
        
        
        
        
        else if (month == 3 && day >= 21)
            {
                return "Spring";
            }
        else if (month == 4 || month == 5)
            {
                return "Spring";
            }
        else if (month == 6 && day <= 20)
            {
                return "Spring";
            }
        
        
        
        
        
        else if (month == 6 && day >= 21)
            {
                return "Summer";
            }
        else if (month == 7 || month == 8)
            {
                return "Summer";
            }
        else if (month == 9 && day <= 20)
            {
                return "Summer";
            }
        
        
        
        else if (month == 9 && day >= 21)
            {
                return "Autumn";
            }
        else if (month == 10 || month == 11)
            {
                return "Autumn";
            }
        else if (month == 12 && day <= 20)
            {
                return "Autumn";
            }
        
        else 
        {
            return "lol no idea";
        }
    }
}

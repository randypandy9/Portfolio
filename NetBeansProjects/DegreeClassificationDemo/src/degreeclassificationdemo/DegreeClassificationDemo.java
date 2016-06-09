package degreeclassificationdemo;
import java.util.Scanner;
enum Classification {FAIL, III, II2, II1, I};
public class DegreeClassificationDemo 
{

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in); //input
        System.out.println("Enter mark:"); //enter a mark value
        int mark = scan.nextInt();  //sets inputted value to variable mark
        Classification clf = findClassification(mark); 
        //find appropriate classification
        System.out.println("Classification: " + clf); 
        //output of classification
        int [] newrange; //create new array
        newrange = markRange(clf); 
        //new array sets values from array in markRange
        System.out.println("Boundries: " + newrange[0] + " - " 
                + newrange[1]); //output array
    }
    public static Classification findClassification(int mark)
    {
        if( mark < 40 )
        {
            return Classification.FAIL; 
            //values of which will become a FAIL
        }
        if( mark >= 40 && mark <= 49 )
        {
            return Classification.III; 
            //values of which will become a III
        }
        if ( mark >= 50 && mark <= 59 )
        {
            return Classification.II2; 
            //values of which will become a II2
        }
        if ( mark >= 60 && mark <= 69 )
        {
            return Classification.II1; 
            //values of which will become a II1
        }
        if ( mark >= 70 && mark <= 100 )
        {
            return Classification.I; 
            //values of which will become a I
        }
        else
        {
            return null; //invalid mark handling
        }
        
    }
    public static int [] markRange(Classification degreeClass)
    {
       
       int[] range; //creating an array to hold classification values
       range = new int[2]; //array size to hold 2 values(min and max)
       range[0] = 0;
       range[1] = 0;
       //initially setting both to 0

       if(degreeClass == Classification.FAIL)
       {
           range[0] = 0;
           range[1] = 39;
           //setting range values according to the classification of FAIL
       }
       if(degreeClass == Classification.III)
       {
           range[0] = 40;
           range[1] = 49;
           //setting range values according to the classification of III
       }
       if(degreeClass == Classification.II2)
       {
           range[0] = 50;
           range[1] = 59;
           //setting range values according to the classification of II2
       }
       if(degreeClass == Classification.II1)
       {
           range[0] = 60;
           range[1] = 69;
           //setting range values according to the classification of II1
       }
       if(degreeClass == Classification.I)
       {
           range[0] = 70;
           range[1] = 100;
           //setting range values according to the classification of I
       }
       return range; 
       //return range according to classification for when its called
    }
}

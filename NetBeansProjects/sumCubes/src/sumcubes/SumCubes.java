
package sumcubes;

public class SumCubes 
{
    public static void main(String[] args) 
    {
        int start = 100;
        while (start != 501)
        {
            int fint = start / 100;     //splitting input
            //System.out.println(fint);
            int sint = (start /10 ) %10;  
            //System.out.println(sint);
            int tint = start % 10;   
            //System.out.println(tint);
            //System.out.println(fint + " and " + sint + " and " + tint);
         
            
            int cubes = ((fint*fint*fint)+(sint*sint*sint)+(tint*tint*tint));
            //System.out.println("    " + cubes);   //cubing split numbers
            
            
            int fint2 = cubes / 100;                //splitting cubed answer
            //System.out.println("         "+fint2);
            int sint2 = (cubes / 10 ) %10;  
            //System.out.println("         "+sint2);
            int tint2 = cubes % 10;
            //System.out.println("         "+tint2);
            //System.out.println(fint2 + " and " + sint2 + " and " + tint2);
            //System.out.println(" ");
            
            
            if (fint == fint2 && sint == sint2 && tint == tint2) //comparing I/O
            {
                System.out.println("found one! " + fint + " cubed + " + sint + " cubed + " + tint + " cubes = " + cubes);
                start = start + 1;
            }
            start = start + 1;
        }
        System.out.println("Done!");
    }
}

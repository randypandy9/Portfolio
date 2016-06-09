
package labsheet2threads;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import static labsheet2threads.WebsiteChecker.urlNames;

/**
 *
 * @author ajb
 */
public class LabSheet2_Threads {

    /**
     * @param args the command line arguments
     */
    
    public static void question1ArraySum(){
            DecimalFormat df= new DecimalFormat("###.####");
            Random rf= new Random();
            System.out.println("n, sequential, concurrent (10 threads)");
            for(int size=100;size<50000;size+=100){
                SumArray.grandSum=0;
                SumArray.data=new int[size];
                for(int i=0;i<size;i++)
                    SumArray.data[i]=rf.nextInt(100);
                long t1=System.nanoTime();
                int x=SumArray.sequentialSumArray(SumArray.data,0,SumArray.data.length);
                long t2=System.nanoTime();
                System.out.print(size+","+df.format((t2-t1)/1000.0)+","+x);
                t1=System.nanoTime();
                SumArray.threadSum();
                t2=System.nanoTime();
                System.out.println(","+df.format((t2-t1)/1000.0)+","+SumArray.grandSum);       
       }
    }
    
    public static void question2Sequential(){
        boolean updated=false;
        WebsiteChecker[] web=new WebsiteChecker[urlNames.length];
        for(int i=0;i<web.length;i++){
            try{
                web[i] = new WebsiteChecker(urlNames[i]);
            }catch(IOException e){
                System.out.println("ERROR loading the websites, quit program ");
                System.exit(0);
            }
        }
        int checkCount=0;
        
        while(!updated){
            int i;
            for(i=0;i<web.length && !updated; i++){
                 try{
                     updated=web[i].checkForChanges();
               }catch(IOException e){
                    System.out.println("Unable to load website  "+web[i].website);
               }
            }
            if(updated)
                    System.out.println("First page to update ="+web[i].website);
            checkCount++;
            System.out.println("Checked "+checkCount+" times");
            
            
            
        }
        
    }
    
    public static void main(String[] args) {
        question1ArraySum();
    }
    
}

package albumcol;


public class TimeDisplay 
{
    private int seconds;
    
    public TimeDisplay(int secs) 
    {
        this.seconds = secs;       
    }
            
    public static void main(String[] args)
    {
        TimeDisplay time = new TimeDisplay(3661);
        System.out.println(time.displayHrsMinsSecs());
    }
    public String displayHrsMinsSecs()
    {
        int secs = this.seconds;
        int mins;
        int hours;
        
        
        hours = secs / 3600;
        int leftoverHours = secs % 3600;
        mins = leftoverHours / 60;
        secs = leftoverHours % 60;
        String zeromin = ""+mins;
        String zerosec = ""+secs;
        
        if (mins < 10)
        {
            zeromin = "0"+mins;
        }
        if (secs < 10)
        {
            zerosec = "0"+secs;
        }
        
        return hours + " : " + zeromin + " : " + zerosec;
    }
    
}

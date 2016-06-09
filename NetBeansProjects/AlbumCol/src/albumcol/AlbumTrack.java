/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package albumcol;

/**
 *
 * @author ysj13kxu
 */
public class AlbumTrack 
{
    private String track;
    private String duration;
    
    public AlbumTrack(String track, String duration)
    {
        this.duration = duration;
        this.track = track;
    }
    
    public String getDuration()
    {
        return duration;
    }
    
    public String getTrack()
    {
        return track;
    }
    
    public int intoSeconds()
    {       
        String tosort = duration;
        
        String[] split = tosort.split(":");
        String firstSubString = split[0];
        String secondSubString = split[1];

        int first = Integer.parseInt(firstSubString);
        int second = Integer.parseInt(secondSubString);
        int totalsecs;
        totalsecs = second + (first * 60);
        
        return totalsecs;
            
    }
    
    public static void main(String[] args)
    {
        AlbumTrack at = new AlbumTrack("track", "3:43");
        System.out.println(at.intoSeconds());
    }
    
    public String toString()
    {
       StringBuilder sb = new StringBuilder();
       sb.append(track).append(duration).append("\n");
       return sb.toString();
    }
}

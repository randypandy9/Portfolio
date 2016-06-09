
package albumcol;
import java.util.ArrayList;
public class AlbumTrackList 
{
    
    private ArrayList<AlbumTrack> trackList;
    
    public AlbumTrackList()
    {
        trackList = new ArrayList<AlbumTrack>();
    }
    public static void main(String[] args)
    {
        AlbumTrackList list = new AlbumTrackList();
        AlbumTrack a = new AlbumTrack("Imran", "32:34");
        AlbumTrack b = new AlbumTrack("Imransweaw", "2:34");
        AlbumTrack c = new AlbumTrack("an", "2:22");
        list.addTrack(a);
        list.addTrack(b);
        list.addTrack(c);
        System.out.println(list.findTrack(1));
        System.out.println(list.toString());
    }
    public void addTrack(AlbumTrack newtrack)
    {
        trackList.add(newtrack);
    }
    
    public int numberOfTracks()
    {
        int numTracks = trackList.size();
        return numTracks;
    }
    
    public AlbumTrack findTrack(int i) throws IllegalArgumentException
    {
        if (i<1 || i>trackList.size())
        {
            throw new IllegalArgumentException("It's an Illegal Argument Exception!");
        }
        return trackList.get(i-1);    
    }
    
    public String getPlayingTime()
    {
        int totaltime = 0;
        for (AlbumTrack nextTrack : trackList)
        {
            totaltime += nextTrack.intoSeconds();
                  
        }
        TimeDisplay time = new TimeDisplay(totaltime);
        return time.displayHrsMinsSecs();
        
        
    }
    
    public String toString()
    {
       StringBuilder sb = new StringBuilder();
       for (AlbumTrack nextTrack : trackList)
       {
            sb.append(nextTrack).append("\n");      
       }
       return sb.toString();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package albumcol;

/**
 *
 * @author ysj13kxu
 */
public class Album 
{
    private String artist;
    private String albumtitle;
    
    public Album(String artist, String albumtitle)
    {
        this.artist = artist;
        this.albumtitle = albumtitle;
    }
    public static void main(String[] args)
    {
        Album test2 = new Album("Bob Lee Swagger","Sweg");
        System.out.println(test2.getArtist()+" - "+test2.getAlbum());
        System.out.println(test2.toString());
    }
    
    public String getArtist()
    {
        return artist;
    }
    
    public String getAlbum()
    {
        return albumtitle;
    }
    
   public String toString()
   {
       StringBuilder sb = new StringBuilder();
       sb.append(artist).append(albumtitle).append("\n");
       return sb.toString();
   }
}

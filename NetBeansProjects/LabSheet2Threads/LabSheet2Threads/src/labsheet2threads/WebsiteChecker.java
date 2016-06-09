/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package labsheet2threads;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajb
 */
public class WebsiteChecker extends Thread{
    public static String[] urlNames={"http://www.bbc.co.uk/","http://www.thewhiskytastingclub.co.uk/",
        "http://www.theguardian.com/","http://www.telegraph.co.uk/","http://weka.sourceforge.net/doc.dev/",
        "http://www.dailymail.co.uk/home/index.html"};
    int nosLines;
    String website;
    URL myURL;
    boolean updated;
    
    public WebsiteChecker(String htpp) throws IOException{
        updated=false;
        this.website=htpp;
        myURL = new URL(website);
        HttpURLConnection huc =  (HttpURLConnection)  myURL.openConnection(); 
        InputStream in=huc.getInputStream(); 
        int http_status = huc.getResponseCode();
        BufferedReader buff;
        buff = new BufferedReader(new InputStreamReader(in));
        nosLines=countLines(buff);
  
    }
    
    public final boolean checkForChanges() throws IOException{
        myURL = new URL(website);
        HttpURLConnection huc =  (HttpURLConnection)  myURL.openConnection(); 
        InputStream in=huc.getInputStream(); 
        int http_status = huc.getResponseCode();
//        System.out.print("Website status ="+http_status);
 //       System.out.print("Input stream ="+in);
        BufferedReader buff;
        buff = new BufferedReader(new InputStreamReader(in));
        int c=countLines(buff);
        if (c==nosLines)
            return false;
        nosLines=c;
        return true;
            
    }
    public final int countLines(BufferedReader b) throws IOException{
        int c=0;
        String inputLine;
        while ((inputLine = b.readLine()) != null)
            c++;
        return c;
   }
    

 
}

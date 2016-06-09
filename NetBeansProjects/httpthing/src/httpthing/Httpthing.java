package httpthing;

import java.io.*;
import java.net.*;

public class Httpthing {

    public static void main(String[] args) throws Exception {
        //set parameters (this is a test page set up for the purposes 
        //of testing this client)
        String hostname = "www.uea.ac.uk";
        String resource = "/~m014436/test_page.html";

        //create socket
        InetAddress netAddress = InetAddress.getByName(hostname);
        Socket socket = new Socket(netAddress, 80);

        //set up writer
        OutputStream ostream = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(ostream, "US-ASCII");
        PrintWriter out = new PrintWriter(osw);

        //set up reader
        InputStream instream = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(instream, "US-ASCII");
        BufferedReader in = new BufferedReader(isr);

        
        //print a get request to the socket
        out.printf("GET %s HTTP/1.1 \r\n", resource);
        out.printf("Host: %s \r\n", hostname);
        out.print("Accept-Charset: utf-8\r\n");
        out.print("\r\n");
        
        
        out.flush();
        socket.shutdownOutput();

        // receive reply and output line by line
        String s = in.readLine();
        while (s != null) {
            System.out.println(s);
            s = in.readLine();
        }
    }
}

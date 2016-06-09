
package turtleclient;

import java.io.*;
import java.net.*;
public class TurtleClient 
{

  
    public static void main(String[] args) throws Exception
    {
        String serverName = "localhost"; //location of server
        InetAddress inetAddress = InetAddress.getByName(serverName);
        int serverPort = 55555; //the port we want to send to
        // create a new client socket
        Socket socket = new Socket(inetAddress, serverPort);
        OutputStream outstream = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(outstream, "US-ASCII");
        PrintWriter out = new PrintWriter(osw);
        //Draw triangle
        out.println("red"); 
        out.println("50 50");
        out.println("50 200");
        out.println("green");
        out.println("200 200");
        out.println("blue");
        out.println("50 50");
        //finish
        out.flush();
        socket.shutdownOutput();
    }
}

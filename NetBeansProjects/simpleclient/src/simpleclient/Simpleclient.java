/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleclient;

/**
 *
 * @author ysj13kxu
 */
import java.io.*;
import java.net.*;
public class Simpleclient 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception 
    {
        String serverName = "localhost"; //location of server
        String message = "Graeme"; //the message we want to send
        //overide the message if a message is supplied on the command line.
        if (args.length > 0)
        message = args[0];
        if (args.length > 1)
        serverName = args[1];
        //get the IP address of the server from the name
        InetAddress inetAddress = InetAddress.getByName(serverName);
        int serverPort = 55555; //the port we want to send to
        // create a new client socket
        Socket socket = new Socket(inetAddress, serverPort);
        //set up the writer
        OutputStream outstream = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(outstream, "US-ASCII");
        PrintWriter out = new PrintWriter(osw);
        //set up the reader
        InputStream instream = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(instream, "US-ASCII");
        BufferedReader inBuf = new BufferedReader(isr);
        System.out.printf("\n\n Sending message \""+message+ "\" to the server.\n\n");
        out.printf(message); //send the message to the server
        out.flush();
        socket.shutdownOutput();
        System.out.print("from server ");
        //read message from the reader
        String s = inBuf.readLine();
        System.out.println(s);
    }
}

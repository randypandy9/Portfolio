/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleserver;

/**
 *
 * @author ysj13kxu
 */
import java.io.*;
import java.net.*;
public class Simpleserver 
{
    private static void sendResponse(Socket socket) throws IOException, InterruptedException
    {
        // a method to send a response from the server
        // set up the reader
        InputStream instream = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(instream, "US-ASCII");
        BufferedReader inBuf = new BufferedReader(isr);
        //set up the writer
        OutputStream outstream = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(outstream, "US-ASCII");
        PrintWriter out = new PrintWriter(osw);
        //read input from the buffer
        String msg = inBuf.readLine();
        //send response
        out.println("Hello, " + msg);
        System.out.println("\n got message \"" + msg+ "\" from client");
        System.out.println("\n sending message to client");
        osw.close();
    }
    
    public static void main(String[] args) throws IOException, InterruptedException 
    {
        int port = 55555; //set port number to listen on
        //create a server socket
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.printf("\n\n Graeme's server starting, using port " + port);
        while (true)
            {
                // the next line blocks (waits) until a message is received.
                Socket socket = serverSocket.accept();
                System.out.printf("\n Socket accepted: " + socket.toString());
                sendResponse(socket);
            }
    }
}

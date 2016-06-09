package networkslabs;
/*
 * TextSender.java
 *
 * Created on 15 January 2003, 15:29
 */

/**
 *
 * @author  abj
 */
import CMPC3M06.AudioRecorder;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import uk.ac.uea.cmp.voip.*;

public class TextSenderThread implements Runnable{
    
    static DatagramSocket4 sending_socket;
    
    
    public void start(){
        Thread thread = new Thread(this);
	thread.start();
    }
    
    public void run (){
     
	try {
            
            //***************************************************
            //Port to send to
            int PORT = 55555;
            //IP ADDRESS to send to
            InetAddress clientIP = null;
            try {
                clientIP = InetAddress.getByName("139.222.5.193");  //CHANGE localhost to IP or NAME of client machine
            } catch (UnknownHostException e) {
                System.out.println("ERROR: TextSender: Could not find client IP");
                e.printStackTrace();
                System.exit(0);
            }
            //***************************************************
            
            //***************************************************
            //Open a socket to send from
            //We dont need to know its port number as we never send anything to it.
            //We need the try and catch block to make sure no errors occur.
            
            //DatagramSocket sending_socket;
            try{
                sending_socket = new DatagramSocket4();
                sending_socket.setSoTimeout(32);
            } catch (SocketException e){
                System.out.println("ERROR: TextSender: Could not open UDP socket to send from.");
                e.printStackTrace();
                System.exit(0);
            }
            //***************************************************
            
            //***************************************************
            //Get a handle to the Standard Input (console) so we can read user input
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            //***************************************();************
            
            //***************************************************
            //Main loop.
            
            boolean running = true;
            
            AudioRecorder recorder = new AudioRecorder();
            PacketClass p = new PacketClass();
            int id = 0;
            
            long t = System.currentTimeMillis();
            long end = t+1000;
            int sentNo = 0;
            
                
            
            while (running){
                try
                {
                    byte[] block = recorder.getBlock();
                    //Make a DatagramPacket from it, with client address and port number
                    long time = System.currentTimeMillis();
                    p = new PacketClass(id,block);
                    DatagramPacket packet = new DatagramPacket(p.getAsByteArray(), p.getSize(), clientIP, PORT);
                    //Send it
                    sending_socket.send(packet);
                    sentNo++;
                    System.out.println("SENT:     "+p.getID()+" TIME: "+System.currentTimeMillis());
                    id++;
                } 
                catch (IOException e){
                    System.out.println("ERROR: TextSender: Some random IO error occured!");
                    e.printStackTrace();
                }
            }
            System.out.println("Bit rate: "+sentNo*524); //packetclass size
            
            //Close the socket
            sending_socket.close();
            //***************************************************
        } catch (LineUnavailableException ex) {
                Logger.getLogger(TextSenderThread.class.getName()).log(Level.SEVERE, null, ex);
	}
        //***************************************************
    }
} 

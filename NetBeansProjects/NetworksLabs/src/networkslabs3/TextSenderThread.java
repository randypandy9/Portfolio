package networkslabs3;
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
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import uk.ac.uea.cmp.voip.*;

public class TextSenderThread implements Runnable{
    
    public final int D=3;
    public int Dlength = D*D;
    
    static DatagramSocket3 sending_socket;
    
    public void start(){
        Thread thread = new Thread(this);
	thread.start();
    }
    
    @Override
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
                sending_socket = new DatagramSocket3();
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
            int a = 0;
            while (running)
            {
                try
                {
                    
                    ArrayList<PacketClass> originals = new ArrayList<>();
                    ArrayList<PacketClass> interleavedPackets = new ArrayList<>();
//                    System.out.println("RECORDED: "+a+" "+System.currentTimeMillis());
                    a++;
                    for(int i=0;i<Dlength;i++)
                    {
                        
                        byte[] block = recorder.getBlock();
                        p = new PacketClass(id,block,System.currentTimeMillis());
                        originals.add(p);
                        id++;
                    }
                    interleavedPackets = interleavePackets(originals);
                    
                    
                    for(int s=0;s<Dlength;s++)
                    {               

                        DatagramPacket packet = new DatagramPacket(interleavedPackets.get(s).getAsByteArray(), interleavedPackets.get(s).getSize(), clientIP, PORT);

                        sending_socket.send(packet);
                        
                        
                    }
    
                } catch (IOException e){
                    System.out.println("ERROR: TextSender: Some random IO error occured!");
                    e.printStackTrace();
                }
            }
            //Close the socket
            sending_socket.close();
            //***************************************************
        } catch (LineUnavailableException ex) {
                Logger.getLogger(TextSenderThread.class.getName()).log(Level.SEVERE, null, ex);
	}
        //***************************************************
    }

    public ArrayList<PacketClass> interleavePackets(ArrayList<PacketClass> originals) 
    {
        ArrayList<PacketClass> interleaved = new ArrayList<>();
        
        for(int x=0; x < D;x++)
        {
            for(int y=0; y < D; y++)
            {
                int chosen = (y*D)+(D-1-x);
                interleaved.add(originals.get(chosen));
            }
        }
        return interleaved;
    }
} 

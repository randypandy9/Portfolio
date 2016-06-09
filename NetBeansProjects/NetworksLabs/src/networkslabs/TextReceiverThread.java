package networkslabs;
/*
 * TextReceiver.java
 *
 * Created on 15 January 2003, 15:43
 */

/**
 *
 * @author abj
 */

import CMPC3M06.AudioPlayer;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import uk.ac.uea.cmp.voip.*;

public class TextReceiverThread implements Runnable {

    static DatagramSocket4 receiving_socket;
    public final int D=4;
    public int Dlength = D*D;
    public long now;
    
    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public void run() {

        try {
            
            //***************************************************
            //Port to open socket on
            int PORT = 55555;
            //***************************************************
            
            //***************************************************
            //Open a socket to receive from on port PORT
            //DatagramSocket receiving_socket;
            try {
                receiving_socket = new DatagramSocket4(PORT);
                
                
                
                
            } catch (SocketException e) {
                System.out.println("ERROR: TextReceiver: Could not open UDP socket to receive from.");
                e.printStackTrace();
                System.exit(0);
            }
            //***************************************************

            //***************************************************
            //Main loop.
            boolean running = true;
            AudioPlayer player = new AudioPlayer();
            while (running) {

                try {
                    //Receive a DatagramPacket (note that the string cant be more than 80 chars)
                    byte[] buffer = new byte[512];
                    

                    ByteBuffer bbf;

                    bbf = ByteBuffer.allocate(524);
                    DatagramPacket packet = new DatagramPacket(bbf.array(), 0, 524);
                    receiving_socket.receive(packet);
                    

                    PacketClass p = new PacketClass();
                    p.decode(bbf);

                    now = System.currentTimeMillis();

                    buffer = p.getBlock();
                    int recievingID = p.getID();
                    System.out.println("RECIEVED: "+recievingID+" TIME: "+System.currentTimeMillis());
                    player.playBlock(buffer);
//                    long timeRecieved = p.getTime();
//                    long timediff = now - timeRecieved;
                    


                } catch (IOException e) {
                    System.out.println("ERROR: TextReceiver: Some random IO error occured!");
                    e.printStackTrace();
                }
            }
            //Close the socket
            receiving_socket.close();
            //***************************************************
        } catch (LineUnavailableException ex) {
            Logger.getLogger(TextReceiverThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        //***************************************************
    }

    public ArrayList<PacketClass> reorderPackets(ArrayList<PacketClass> gottenPacketClasses) 
    {
        Collections.sort(gottenPacketClasses);
        
        
        return gottenPacketClasses;
    }

    private int fillmissing(ArrayList<PacketClass> orderedpackets) 
    {
        int missed = 0;
        for (int i=0; i<orderedpackets.size()-1; i++){
            if(orderedpackets.get(i).getID()+1 != orderedpackets.get(i+1).getID())
            {
                orderedpackets.add(i+1, orderedpackets.get(i));
                i++;
                missed++;
            }
        }   
        return missed;
    }
}

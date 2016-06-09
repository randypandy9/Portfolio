package networkslabs3;
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

    static DatagramSocket3 receiving_socket;
    public final int D=3;
    public int Dlength = D*D;
    public long now;
    public boolean useInterleave;
    public int pc=0;
    ArrayList<PacketClass> overflow = new ArrayList<>();
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
                receiving_socket = new DatagramSocket3(PORT);
                
                
                
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
            int a = 0;
            ArrayList<PacketClass> gottenPacketClasses = new ArrayList<>();
            ArrayList<PacketClass> orderedpackets = new ArrayList<>();
            int lower = 0;
            while (running) {
                
                try {
                    lower = pc;
                    pc = pc + Dlength;
                    
                    //Receive a DatagramPacket (note that the string cant be more than 80 chars)
                    byte[] buffer = new byte[512];

                    int recievingID;
                    
                    ByteBuffer bbf; 
                    int filled=0;
                    
//                    for (int i = 0; i < Dlength; i++) 
//                    {
//                        bbf = ByteBuffer.allocate(524);
//                        DatagramPacket packet = new DatagramPacket(bbf.array(), 0, 524);
//                        receiving_socket.receive(packet);
//                        PacketClass p = new PacketClass();
//                        p.decode(bbf);      
//                        
//                        gottenPacketClasses.add(p);
//                    }
                    gottenPacketClasses.addAll(overflow);
                    overflow.clear();
                    bbf = ByteBuffer.allocate(524);
                    DatagramPacket packet = new DatagramPacket(bbf.array(), 0, 524);
                    while(overflow.size()<3&&gottenPacketClasses.size()<Dlength)
                    {
                        try
                        {
                            receiving_socket.receive(packet);
                            PacketClass p = new PacketClass();
                            p.decode(bbf);
                            //System.out.println("GOT: "+p.getID());
                            if(p.getID() < lower)
                            {
                                
                            }
                            else if(p.getID() < pc)
                            {
                                gottenPacketClasses.add(p);
                            }
                            else if(p.getID() > pc)
                            {
                                overflow.add(p);
                            }
                        }
                        catch(SocketTimeoutException e)
                        {
                            
                        }
                        
                    }
                   
                    orderedpackets = reorderPackets(gottenPacketClasses);
                    Collections.sort(overflow);
                    now = System.currentTimeMillis();
                    filled = fillmissing2(orderedpackets);

                    
//                    System.out.println("PLAYED: "+a+" "+System.currentTimeMillis());
//                    a++;
                    
                    for (int p = 0; p < orderedpackets.size(); p++) 
                    {
                        buffer = orderedpackets.get(p).getBlock();
                        recievingID = orderedpackets.get(p).getID();
                        //System.out.println("PLAYING PACKET: "+recievingID);
                        player.playBlock(buffer);
                        //long timeRecieved = orderedpackets.get(p).getTime();
                        //long timediff = now - timeRecieved;                    
                    }
                   orderedpackets.clear();
//                    orderedpackets = overflow;
//                    System.out.println("overflow size: "+overflow.size());
//                    overflow.clear();
                    //System.out.println("-----");
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
    
    private int fillmissing2(ArrayList<PacketClass> orderedpackets) 
    {
        int missed = 0;
        int i = 0;
        boolean soothing = false;
        boolean repeated = true;

        while (repeated == true) 
        {
            repeated = false;
            
            while (orderedpackets.size() < Dlength)
            {
                
                if(i>=orderedpackets.size()-1)
                {
                    i=0;
                }
                else
                {
                    i++;
                }
                if(i < orderedpackets.size()-1)
                {
                    
                
                if ((orderedpackets.get(i).getID() + 1 != orderedpackets.get(i + 1).getID()
                        && orderedpackets.get(i).getID() != orderedpackets.get(i + 1).getID())
                    || soothing == true)
                {
                    orderedpackets.add(i + 1, orderedpackets.get(i));
                    if (orderedpackets.size() > Dlength) 
                    {
                        //System.out.println("a");
                        overflow.add(orderedpackets.get(orderedpackets.size() - 1));
                        orderedpackets.remove(orderedpackets.size() - 1);
                        
                    }
                    repeated=true;
                    i++;

                } 
                }
                else 
                {
                    if(repeated==false)
                    {
                        //System.out.println("overflow size: "+overflow.size());
                        if(orderedpackets.size() > overflow.size())
                        {
                            soothing = true;
                        }
                        else
                        {
                            pc = pc + Dlength;
                            if(overflow.size()!=0)
                            {
                                for(int p = 0;p<overflow.size();p++)
                                {
                                    if(overflow.get(p).getID()<pc)
                                    {
                                        orderedpackets.add(overflow.get(p));
                                    }
                                        
                                }
                            }
                        }
                    }
                }
            }
        }
        return missed;
    }
}

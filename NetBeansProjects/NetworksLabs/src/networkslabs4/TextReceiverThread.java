package networkslabs4;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import uk.ac.uea.cmp.voip.*;

public class TextReceiverThread implements Runnable {

    static DatagramSocket4 receiving_socket;
    public final int D = 3;
    public int pc=0;
    public int Dlength = D * D;
    ArrayList<PacketClass> overflow = new ArrayList<>();
    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        try {

            //***************************************************
            //Port to open socket on
            int PORT = 8000;
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
            int currupt = 0;
            AudioPlayer player = new AudioPlayer();

            while (running) {

                try {
                    ArrayList<PacketClass> gottenPacketClasses = new ArrayList<>();
                    ArrayList<PacketClass> orderedpackets = new ArrayList<>();
                    //Receive a DatagramPacket (note that the string cant be more than 80 chars)
                    byte[] buffer = new byte[512];
                    int recievingID;
                    ByteBuffer bbf;

                    for (int i = 0; i < Dlength; i++) {
                        bbf = ByteBuffer.allocate(532);
                        DatagramPacket packet = new DatagramPacket(bbf.array(), 0, 532);
                        receiving_socket.receive(packet);

                        PacketClass p = new PacketClass();
                        p.decode(bbf);
                        if(p.checkIntegrity())
                        {
                            gottenPacketClasses.add(p);
                        }
                        else
                        {
                            currupt++;
                        }
                    }
                    orderedpackets = reorderPackets(gottenPacketClasses);

//                    int errors = correctErrors(orderedpackets);
                    fillmissing2(orderedpackets);
                    for (int p = 0; p < orderedpackets.size(); p++) {
                        buffer = orderedpackets.get(p).getBlock();
                        recievingID = orderedpackets.get(p).getID();
                        System.out.println("RECIEVED PACKET: " + recievingID);
                        player.playBlock(buffer);
                    }
                    //System.out.println("error packets: " + errors + " per " + 15 + " packets");
                    //System.out.println("Corrupt packets: "+currupt);

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

    public ArrayList<PacketClass> reorderPackets(ArrayList<PacketClass> gottenPacketClasses) {
        Collections.sort(gottenPacketClasses);

        return gottenPacketClasses;
    }

    
    private int fillmissing(ArrayList<PacketClass> orderedpackets) {
        int missed = 0;
        for (int i = 0; i < orderedpackets.size() - 1; i++) {
            if (orderedpackets.get(i + 1).getID() != orderedpackets.get(i).getID() + 1) {
                orderedpackets.add(i + 1, orderedpackets.get(i));
                i++;
                missed++;
            }
        }
        return missed;
    }

    private int correctErrors(ArrayList<PacketClass> orderedpackets) {
        int errors = 0;
        int count = 0;
        int x = orderedpackets.get(count).getID();

        while (x < 0) {
            orderedpackets.remove(count);
//            count++;
            x = orderedpackets.get(count).getID();
        }

        for (int i = 0; i < orderedpackets.size(); i++) {
            if (orderedpackets.get(i).getID() != x) {
                if (orderedpackets.get(i).getID() > x + 1) {
                    orderedpackets.remove(i);
                    errors++;
                }
            }
            x++;
        }
        x = orderedpackets.get(orderedpackets.size() - 2).getID();
        if (orderedpackets.get(orderedpackets.size() - 1).getID() > x + 10) {
            orderedpackets.remove(orderedpackets.size() - 1);
            errors++;
        }
        return errors;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package networkslabs2;

import java.net.DatagramPacket;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 *
 * @author ysj13kxu
 */
public class PacketClass implements Comparable
{
    ByteBuffer bf = ByteBuffer.allocate(524);
    int id;
//    int nextid;
    byte[] block;
    long time;
    final int divisor = 8;
    int remainder;

    public PacketClass(){}
    
    public PacketClass(int id, byte[] block)
    {
        this.id = id;
        this.block = block;
        bf.putInt(id);
        bf.put(block);
    }
    
    public PacketClass(int id, byte[] block, long time)
    {
        this.id = id;
        this.block = block;
        this.time = time;
        bf.putInt(id);
        bf.put(block);
        bf.putLong(time);
    }
    
    public void decode(ByteBuffer bytebuffer)
    {
        //[id(4)-long(8)-voicedata(512)] < packet layout
        bytebuffer.position(0);
        id = bytebuffer.getInt();
        int re = bytebuffer.remaining();
        byte[] gottenBlock = new byte[512];
        bytebuffer.get(gottenBlock, 0, 512);
        block = gottenBlock;
        re = bytebuffer.remaining();
        time = ByteBuffer.wrap(bytebuffer.array()).getLong();
        re = bytebuffer.remaining();
    }
 
    public int getID()
    {
        return this.id;
    }
    
        public void addChecksum()
    {
        byte[] main = bf.array();
        int total = 0;
        for(int i=0; i<main.length; i++)
        {
            total = total+main[i];
        }
        remainder = total%divisor;
        
        byte[] tosend = Arrays.copyOf(main, main.length+1);
        tosend[tosend.length-1] = (byte) remainder;
        
        bf = ByteBuffer.wrap(tosend);
        
    }
        
//    public void setnextID(int nextid)
//    {
//        this.nextid = nextid;
//    }
//        
//    public int getnextID()
//    {
//        return nextid;
//    }
    
    public int setID(int id)
    {
        return this.id = id;
    }
    
    public long getTime()    
    {
        return this.time;
    }
    
    public void setTime(long time)
    {
        this.time = time;
    }
    
    public int getSize()
    {
         return bf.array().length;
    }
    
    public byte[] getAsByteArray()
    {
        return bf.array();
    }
    
    public byte[] getBlock()
    {
        return block;
    }

    @Override
    public int compareTo(Object t) {
        PacketClass p = (PacketClass) t;
        if(this.id < p.id)
        {
            return -1;
        }
        else if(this.id > p.id)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}

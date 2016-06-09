/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkslabs4;

import java.net.DatagramPacket;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

/**
 *
 * @author ysj13kxu
 */
public class PacketClass implements Comparable {

    ByteBuffer bf = ByteBuffer.allocate(532);
    int id;
    byte[] block;
    long time;
    final int divisor = 16;
    int remainder;
    long crcvalue;

    public PacketClass() {
    }

    public PacketClass(int id, byte[] block) {
        this.id = id;
        this.block = block;
        bf.putInt(id);
        bf.put(block);
    }

    public PacketClass(int id, byte[] block, long time) {
        this.id = id;
        this.block = block;
        this.time = time;
        bf.putInt(id);
        bf.put(block);
        bf.putLong(time);

    }

    
    public void decode(ByteBuffer bytebuffer) {
        //[id(4)-voicedata(512)-long(8)-crc(8)] < packet layout
        
        bf = bytebuffer;
        id = bytebuffer.getInt();
        int re = bytebuffer.remaining();
        byte[] gottenBlock = new byte[512];
        bytebuffer.get(gottenBlock, 0, 512);
        block = gottenBlock;
        re = bytebuffer.remaining();
        time = bytebuffer.getLong();
        re = bytebuffer.remaining();
        crcvalue = bytebuffer.getLong();
        re = bytebuffer.remaining();
        
    }

    public boolean checkIntegrity() {
        byte[] packet = Arrays.copyOfRange(bf.array(), 0, bf.array().length-8);
        Checksum checksum = new CRC32();
        checksum.update(packet, 0, packet.length);
        long init = checksum.getValue();

        return crcvalue == init;
    }

    public int getID() {
        return this.id;
    }

    public void addChecksum() {
        byte[] main = bf.array();

        Checksum checksum = new CRC32();
        checksum.update(main, 0, main.length-8);
        long init = checksum.getValue();
        crcvalue = init;
        ByteBuffer temp = ByteBuffer.allocate(8);
        
        temp.putLong(init);

        byte[] tosend = new byte[main.length + temp.array().length];

        tosend = main;
        for (int i=tosend.length-temp.array().length; i<tosend.length; i++){
            tosend[i] = temp.get(i-(tosend.length-temp.array().length));
        }

        bf = ByteBuffer.wrap(tosend);

    }

    public int setID(int id) {
        return this.id = id;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getSize() {
        return bf.array().length;
    }

    public byte[] getAsByteArray() {
        return bf.array();
    }

    public byte[] getBlock() {
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

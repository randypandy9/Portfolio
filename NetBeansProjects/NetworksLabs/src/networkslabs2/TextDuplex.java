package networkslabs2;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/*
 * TextDuplex.java
 *
 * Created on 15 January 2003, 17:11
 */
/**
 *
 * @author abj
 */
public class TextDuplex {

    public static void main(String[] args) throws InterruptedException {


        TextReceiverThread receiver = new TextReceiverThread();
        TextSenderThread sender = new TextSenderThread();
        
        receiver.start();
        sender.start();
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlumniPackage;

/**
 *
 * @author ysj13kxu
 */
public class Message 
{
    private int msgid;
    private String sender;
    private String reciever;
    private String msg;
    private String status;
    
    public Message(int msgid, String sender, String reciever, String msg, String status)
    {
        this.msgid = msgid;
        this.sender = sender;
        this.reciever = reciever;
        this.msg = msg;
        this.status = status;
    }

    public int getMessageeID() {
        return msgid;
    }
    
    public String getSender() {
        return sender;
    }

    public String getReciever() {
        return reciever;
    }

    public String getMsg() {
        return msg;
    }

    public String getStatus() {
        return status;
    }
    
    public void setSender(String sender) {
        this.sender = sender;
    }
    
    public void setMessageeID(int id) {
        this.msgid = id;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}

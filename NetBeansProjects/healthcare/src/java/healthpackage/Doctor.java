/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthpackage;

/**
 *
 * @author ysj13kxu
 */
public class Doctor 
{
    private String doctorName;
    private int doctorRoomNumber;

    public Doctor() 
    {
        
    }

    public Doctor(String externName, int externRoomNumber) 
    {
        this.doctorName = externName;
        this.doctorRoomNumber = externRoomNumber;
    }

    public String getDoctorName() 
    {
        return this.doctorName;
    }

    public void setDoctorName(String externActor) 
    {
        this.doctorName = externActor;
    }

    public int getDoctorRoomNumber() 
    {
        return this.doctorRoomNumber;
    }
    
    public void setDoctorName(int externRoomNumber) 
    {
        this.doctorRoomNumber = externRoomNumber;
    }
}

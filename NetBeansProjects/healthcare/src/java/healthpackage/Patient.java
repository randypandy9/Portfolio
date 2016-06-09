/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthpackage;

/**
 *
 * @author ysj13kxu
 */
public class Patient 
{
    private String name;
    private String address;
    
    
    public Patient() 
    {
        
    }
    
    public Patient(String name, String address) 
    {
        this.name = name;
        this.address = address;
        
    }
    
    public String getName()
    {
        return this.name;      
    }
    
    public String getAddress()
    {
        return this.address;      
    }
    
  
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    

    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthpackage;

/**
 *
 * @author ysj13kxu
 */
public class Test 
{
    
    private String test;
    private String technician;
    private String outcome;
    private String date;
    
    public Test()
    {
                
    }
    
    public Test( String test, String technician, String outcome, String date) 
    {
        
        this.test = test;
        this.technician = technician;
        this.outcome = outcome;
        this.date = date;
    }
    
    
    
    public String getTest()
    {
        return this.test;
    }
    
    public String getTechnician()
    {
        return this.technician;
    }
    
    public String getOutcome()
    {
        return this.outcome;
    }
    
    public String getDate()
    {
        return this.date;
    }
    
  
    
    public String setTest(String test)
    {
        return this.test = test;
    }
    
    public String setTechnician(String technician)
    {
        return this.technician = technician;
    }
    
    public String setOutcome(String outcome)
    {
        return this.outcome = outcome;
    }
    
    public String setDate(String date)
    {
        return this.date = date;
    }  
}

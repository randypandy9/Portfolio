/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package street;

import java.util.ArrayList;

/**
 *
 * @author ysj13kxu
 */
public class Street {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
    }
    
    private ArrayList<House> houses;
    private String Name;
    private String City; 
    private double totalValue;
    
    public Street()
    {
        
    }
    public Street(ArrayList houses)
    {
        
    }
    public String setName(String name)
    {
        return "ABC Street";
    }
    public String setCity(String name)
    {
        return "Norwich";
    }
    public void findTotalValue()
    {
       double total = 0; 
       for (House nextHouse : houses)
       {
           double pre = nextHouse.getPrice();
           total = total + pre;
       }
       totalValue = total;
    }
    public double getTotalValue()
    {
        return totalValue;
    }
    public String toString()
   {
       StringBuilder sb = new StringBuilder();
       for (House nextHouse : houses)
       {
            sb.append(nextHouse);      
       }
       sb.append("Name: ").append(Name).append("City: ").append(City).append("Total Value: ").append(totalValue).append("\n");
       return sb.toString();
   }
}

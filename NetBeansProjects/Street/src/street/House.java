/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package street;
import java.util.Random;
/**
 *
 * @author ysj13kxu
 */
public class House 
{
    private int numBedrooms;
    private int numBathrooms;
    private double price;
    private String postcode;
    public static int MAXNUMBEDS = 10;
    public static int MAXNUMBATHS = 10;

    public static void main(String[] args) 
    {
        House test = new House(2,2,2.33,"hello");
        System.out.println("price: "+test.getPrice());
        System.out.println("rooms: "+test.getNumBedrooms());
        System.out.println("Sring: "+test.toString());
    }
    public House()
    {
        
    }
    public House(int a)
    {
        //this.numBedrooms = a;
    }
    public House(int a, int b)
    {
        //this.numBedrooms = a;
        //this.numBathrooms = b;
    }
    public House(int a, int b, double price, String postcode)
    {
        this.numBedrooms = a;
        this.numBathrooms = b;
        this.price = price;
        this.postcode = postcode;
    }
    public void setNumBedrooms()
    {    
        Random r = new Random();
        int ran = r.nextInt(9)+1;
        numBedrooms = ran;
    }
    public int getNumBedrooms()
    {
       return numBedrooms;
    }
    public String toString()
    {
       StringBuilder sb = new StringBuilder();
       sb.append("Bedrooms: ").append(numBedrooms).append("Bathrooms: ").append(numBathrooms).append("Price: ").append(price).append("Postcode: ").append(postcode).append("\n");
       return sb.toString();
    }
    public static void setMaxNumBedrooms(int numBedrooms)
    {
        numBedrooms = MAXNUMBEDS;
    }
    public double getPrice()
    {
        return price;
    }
}

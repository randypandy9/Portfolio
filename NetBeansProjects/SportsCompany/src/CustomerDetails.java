/**
 *
 * @author ysj13kxu
 */
import java.util.regex.Pattern; //import
public abstract class CustomerDetails
{    
    protected String customerID; //customer ID field
    Address address; //address field of type address
    protected String region; //region field
    protected double fullprice; //full price field
    
    public CustomerDetails(String customerID, Address address, 
            String region, double fullprice) 
            throws IllegalCustomerIDException
    {   
        this.customerID = customerID; 
        //sets customer ID after checking it
        this.address = address; 
        //sets address to a customer details type
        this.region = region; 
        //sets region to a customer details type
        this.fullprice = fullprice; 
        //sets the full price to a customer details type
    }
    public String getCustomerID()
    {
        return customerID; //returns the customer ID
    }
    public Address getAddress()
    {
        return address; //returns the address;
    }
    public String getRegion()
    {
        return region; //returns the region
    }
    public double getFullprice()
    {
        return fullprice; //returns the full price
    }
    public final void setCustomerID(String customerID) 
            throws IllegalCustomerIDException
    {
        if(Pattern.matches("[A-Z]{3}-[0-9]{4}", customerID) == true)
        //checks if the format is 3 capital letters followed 
            //by a '-', then 4 integers
        {
            String reg = customerID.substring(1,3);
            //sets the relative part if the ID to check 
            //if it matches an area code
            String[] regArray = {"SC","WA","NI","NE","NW","MI","EA",
                "SE","SW","GL"};
            //array of valid area codea comprising of 2 capital letters
            for(int i = 0; i < regArray.length-1; i++) 
            //iterate through valid area codes
            {
                if(reg.matches(regArray[i])) //if match is found
                {
                    if((customerID.startsWith("P") || 
                            customerID.startsWith("C")))
                    //check if it starts with a P or a C, 
                    //because then we can 
                    //determine if it's a private or company customer ID
                    {
                        this.customerID = customerID; 
                        //setting the customer ID as a 
                        //customer details type
                    }
                    else
                    {
                        throw new IllegalCustomerIDException
                                ("ERROR - customer ID is incorrect!");
                        //otherwise throw error
                    }
                }
            }
        }
        else
        {
            throw new IllegalCustomerIDException
                    ("ERROR - customer ID is incorrect!");
            //otherwise throw error
        }
        
    }
    public void setAddress(Address address)
    {
        this.address = address; //sets a new address
    }
    public void setRegion(String region)
    {
        this.region = region; //sets a new region
    }
    public void setFullPrice(double fullprice)
    {
        this.fullprice = fullprice; //sets a new full price value
    }
    public abstract int getDiscount(); 
    //abstract method that must be included
    //in all child classes of this one (CustomerDetails class )
    
    public String toString()
    {
       StringBuilder sb = new StringBuilder(); //new String biulder 
       sb.append("/").append(customerID).append("/").append(address)
         .append("/").append(region).append("/").append(fullprice);
       //create toString
       return sb.toString(); //return the string
    }
}

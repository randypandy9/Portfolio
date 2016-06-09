/**
 *
 * @author ysj13kxu
 */
public class PrivateCustomerDetails extends CustomerDetails {

    private Name name; //new name field
    private static final int specVal = 500; 
    //sports suppliers specified value 
    //for project I assume it's 500

    public PrivateCustomerDetails(String customerID, Address address, 
            String region, double fullprice, Name name) 
            throws IllegalCustomerIDException {
        super(customerID, address, region, fullprice);
        //get fields from parent class
        this.name = name;
        //set given name to name type in private customer details
    }

    public Name getName() {
        return name; //return name
    }

    public void setname(Name name) {
        this.name = name; //set new name
    }

    @Override
    public int getDiscount() //abstract method to calculate discount
    {
        if (fullprice >= specVal) //if the price paid is more than the
        //sports suppliers specified value
        {
            return 15; //if they paid more, discount is 15
        } else {
            return ((int) (15 * (fullprice / specVal)));
            //else calculate how much discount they get
            //depending on how much they spent
        }

    }

    public String toString() {
        StringBuilder sb = new StringBuilder(); //new String biulder
        sb.append("/").append(name).append("/").append(customerID)
        .append("/").append(address).append("/").append(region)
        .append("/").append(fullprice);
        //create toString
        return sb.toString(); //return the string
    }
}

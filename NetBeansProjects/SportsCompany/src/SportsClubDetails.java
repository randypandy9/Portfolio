
/**
 *
 * @author ysj13kxu
 */
public class SportsClubDetails extends CustomerDetails {
    private String clubName; //club name field
    private int clubDiscount; //club discount field

    public SportsClubDetails(String customerID, Address address, 
            String region, double fullprice, String clubName, 
            int clubDiscount) throws IllegalCustomerIDException {
        super(customerID, address, region, fullprice);
        //get fields from parent class
        this.clubName = clubName;
        //set given club name to club name field in sports club details
        this.clubDiscount = clubDiscount;
        //set given club discount to club discount field 
        //in sports club details
    }

    @Override
    public int getDiscount() {
        return clubDiscount; //return the discount for sports customers
    }

    public String getClubName() {
        return clubName; //return the club name
    }

    public void setClubName(String clubName) {
        this.clubName = clubName; //set new club name with given name
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(); //new String biulder 
        sb.append("/").append(clubName).append("/").append(clubDiscount)
        .append("/").append(customerID).append("/").append(address)
        .append("/").append(region).append("/").append(fullprice)
        .append("/").append(clubDiscount);
        //create toString
        return sb.toString(); //return the string
    }
}

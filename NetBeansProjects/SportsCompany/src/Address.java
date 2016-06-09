/**
 *
 * @author ysj13kxu
 */
public class Address {

    private String streetName; //street name field
    private String townCity; //town or city field
    private String postCode; //postcode field

    public Address(String streetName, String townCity, String postCode){
        this.streetName = streetName; 
        //setting street name as part of a address type
        this.townCity = townCity; 
        //setting street name as part of a address type
        this.postCode = postCode; 
        //setting postcode as part of a address type
    }

    public String getStreetName() {
        return streetName; //return street name
    }

    public String getTownCity() {
        return townCity; //return town or city
    }

    public String getPostCode() {
        return postCode; //return post code
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName; //sets a new street name
    }

    public void setTownCity(String townCity) {
        this.townCity = townCity; //sets a new town or city
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode; //sets a new post code
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(); //new String biulder 
        sb.append("/").append(streetName).append("/")
        .append(townCity).append("/").append(postCode);
        //create toString
        return sb.toString(); //return the string
    }
}

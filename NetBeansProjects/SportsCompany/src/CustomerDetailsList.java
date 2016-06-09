import java.util.ArrayList; //imports
/**
*
* @param givenID the ID of a customer
* @return the customer's details if found, exception thrown
* otherwise.
*/
class CustomerDetailsList 
{
    private ArrayList<CustomerDetails> customers = new ArrayList<>();
    // create a customer details arraylist to hold all customer details
    
    public void addCustomerToList(CustomerDetails cust)
    {
        customers.add(cust); 
        //adds a customer details type to the customer 
        //details arraylist 
    }
    public CustomerDetails findCustomer(String givenID) 
            throws CustomerNotFoundException
    {
        for (int i = 0; i < customers.size(); i++)
            //iterate through the arraylist
        {
            if (givenID.equals(customers.get(i).getCustomerID())) 
                //for each 
                //found customerdetails type check to see if it's 
                //customer ID matches the one given 
            {
                return customers.get(i);
                //if found return that customer details
            }                     
        }
        throw new CustomerNotFoundException("Customer not found!");
        //if not found then throw a new error
        
    }
    public String toString()
    {
       StringBuilder sb = new StringBuilder(); //new String biulder 
        for(CustomerDetails eachCustomer : customers)
       //interate through arraylist
       {
            sb.append("/").append(eachCustomer);
            //create toString
       }
       return sb.toString(); //return the string
    }
}

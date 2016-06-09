/**
 *
 * @author ysj13kxu
 */
/**
 * Generates a new purchase order record for the 
 *current month and updates
 * record of purchasing customer
 *
 * @param date a String with format "dd/mm/yy"
 * @param customerID must be the ID of a customer 
 *in the the company's customer
 * records
 * @param p must be in the company's current product range
 * @param qty the number of items required of the product
 * @throws IncorrectPurchaseOrderException
 */
/**
 * increments the index of the current month. 12 
 *(December) is followed by 1
 * (January). Updates this supplier's records as appropriate.
 */
public class SportsEquiptmentSupplier {

    private PurchaseOrderList orderList = new PurchaseOrderList(); 
    //purchase order list type field
    private CustomerDetailsList customerDetailsList; 
    //customer details list type
    private Product[] productList; //arraylist of product types
    int month; //integer month field 
    int year; //integer year field
    
    public SportsEquiptmentSupplier(Product[] purchases, 
            CustomerDetailsList customerDetailsList, int month, int year){
        this.customerDetailsList = customerDetailsList; //sets the customer
        //details list to part of a Sports equiptment type
        this.productList = purchases;
        //sets purchases to a purchase order list typw
        //sets and initialises the new arraylist to a product arraylist
        this.month = month; //month
        this.year = year;
    }

    public void addNewPurchaseOrder(String dateStr, String customerID, 
            String productCode, int qty) throws 
            IncorrectPurchaseOrderException, CustomerNotFoundException, 
            IllegalDateFormatException {

        OrderDate date = new OrderDate(dateStr);
        int disc = customerDetailsList.findCustomer
                (customerID).getDiscount();
        //sets disc as the discount from the realtive customer 
        //ID if it exists         
        Product productResult = null; //results of type product
        

        //initialises a new product type variable
        for (Product nextProd : productList) 
        //search through product list
        {
            if (nextProd.getProductCode().equals(productCode)) 
                //check if the product code matches the given one
            {
                productResult = nextProd; // if it does then set the 
                //product as productResult
            }
        }
        CustomerDetails custgo = customerDetailsList.findCustomer
                (customerID);
        PurchaseOrder po = new PurchaseOrder(date, custgo, 
                productResult, disc, qty, 
                productResult.getPricePerUnit());

        orderList.addToPOL(po);
        //add the created purchase order to the purchase order list
    }

    public void UpdateMonth() {
        if (month >= 12 || month < 0) //if month is not between 1 and 12
        {
            month = 1; //set month to 1;
        } else {
            month = month + 1; //else increment month by 1;
        }
    }
}

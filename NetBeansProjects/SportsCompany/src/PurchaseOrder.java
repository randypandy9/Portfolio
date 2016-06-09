
/**
 *
 * @author ysj13kxu
 */
public class PurchaseOrder {

    private OrderDate date; //date field
    private CustomerDetails customer; //customer field
    private Product product; //product type field
    private int discount; //discount field
    private int quantity; //quantity field
    private double ppu; // price per unit field

    public PurchaseOrder(OrderDate date, CustomerDetails customer, 
        Product product, int discount, int quantity, double ppu) {
        this.date = date; //sets date to a purchase order type
        this.customer = customer; 
        //sets the customerID to a purchase 
        //order type after checking its format
        this.product = product; 
        //sets product to a purchase order type
        this.quantity = quantity; 
        //sets the quantity to a purchase order type 
        this.ppu = ppu;
        //sets price per unit as a part of a purchase order type
        this.discount = discount;
        //sets incoming discount as part of a PurchaseOrder type
    }

    public double getFullPriceValue() {
        return ((double) this.quantity * this.ppu);
        //gets the full price of order in a purchase order type
    }

    public double getInvoice() {
        double dis;
        dis = this.discount;
        return ((this.ppu*this.quantity)*((100-dis)/100));
        //gets the final price with discount taken off
    }

    public int getQuantity() {
        return quantity; //return quantity
    }

    public CustomerDetails getCustomer() {
        return customer; //return customerID
    }

    public Product getProduct() {
        return product; //return product
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity; //sets quantity to a new value
    }

    public OrderDate getDate() {
        return date; //gets the date
    }

    public void setDate(OrderDate date) {
        this.date = date; //sets a new date
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(); //new String biulder 
        sb.append("/").append(date).append("/").append(customer)
                .append("/").append(product).append("/").append(discount)
                .append("/").append(quantity).append("/").append(ppu);
        //create toString
        return sb.toString(); //return the string
    }
}

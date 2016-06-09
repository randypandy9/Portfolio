
/**
 *
 * @author ysj13kxu
 */
/**
 * @return an array containing all the purchase orders in this 
 *list, if this
 * list is not empty, otherwise null.
 */
import java.util.ArrayList; //import
public class PurchaseOrderList {

    private ArrayList<PurchaseOrder> purchases;
    //new arraylist of type PurchaseOrder

    public PurchaseOrderList() {
        purchases = new ArrayList<>();
        //initialise the arraylist
    }

    public PurchaseOrder[] getPurchaseOrders() {
        PurchaseOrder[] myArray = null;
        //create array of type PurchaseOrder
        myArray = purchases.toArray(myArray);
        //convert the arraylist to an array
        return myArray; //return the array
    }

    public void clearPurchaseOrder() {
        purchases.clear(); //erase the arraylist
    }

    public void addToPOL(PurchaseOrder order) {
        purchases.add(order);
        //add the given purchase order tot he arraylist
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(); //new String biulder 

        for (PurchaseOrder eachOrder : purchases) 
        //interate through arraylist
        {
            sb.append("/").append(eachOrder);
            //create toString
        }
        return sb.toString(); //return the string
    }
}

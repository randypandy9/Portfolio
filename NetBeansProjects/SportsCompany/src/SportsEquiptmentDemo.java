import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ysj13kxu
 */
public class SportsEquiptmentDemo {

    public static void main(String[] args) 
                throws IllegalDateFormatException, 
            IllegalCustomerIDException, FileNotFoundException, 
            IncorrectPurchaseOrderException, CustomerNotFoundException {
        Product[] prods = InputFileData.getProductsFromTxt();
        CustomerDetailsList clist = InputFileData.getCustomersFromTxt();
        //assuming month starts at 1 or January
        SportsEquiptmentSupplier supplier = new SportsEquiptmentSupplier
                (prods, clist, 1, 2013);

        Scanner fileScan, monthScan, lineScan; //3 scanners
        String months, results; //string to keep results
        String date;
        String id;
        String code;
        int qty;

        //class types to keep purchase order data in

        fileScan = new Scanner(new File("PurchaseOrderData.txt"));

        final String monthSplitter = "@";
        //spilt into months
        final String lineSplitter = "#";
        //split each line
        fileScan.useDelimiter(monthSplitter);

        while (fileScan.hasNext()) {
            months = fileScan.next();
            //scan what's in the file
            monthScan = new Scanner(months);
            //scan the file and split into months

            while (monthScan.hasNext()) {
                results = monthScan.nextLine();
                lineScan = new Scanner(results);
                //scan each month line by line
                lineScan.useDelimiter(lineSplitter);
                //split into lines
                while (lineScan.hasNext()) //for each line
                {
                    date = lineScan.next();
                    id = lineScan.next();
                    code = lineScan.next();
                    qty = Integer.parseInt(lineScan.next().trim());
                    if (id.startsWith("P")) {
                        double fdis = clist.findCustomer(id).getDiscount();  
                        System.out.println("ID: " + id + " Discount: "
                                + fdis); 
                    }
                    supplier.addNewPurchaseOrder(date, id, code, qty);
                    //adds the line as a new purchase order
                }
            }
            supplier.UpdateMonth();
            //updates month(from 1) and increments to do other months
        }
    }
}

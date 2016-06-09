
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//imports

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ysj13kxu
 */
public class InputFileData {

    public static Product[] getProductsFromTxt() 
    throws FileNotFoundException //get product list from text
    {
        Scanner fileScan; //scan text file
        String dataSetCodes; //string for the second line
        String dataSetPrices; //double for third line
        int noOfProducts; //number for the first line
        Product[] prodArray; //array of products

        fileScan = new Scanner(new File("ProductData.txt"));
        //scanning the file

        noOfProducts = Integer.parseInt(fileScan.next());
        //first line string to an integer
        dataSetCodes = fileScan.next();
        //secong line into string type
        dataSetPrices = fileScan.next();
        //third line parsed into a double

        String[] productCodes = dataSetCodes.split("#");
        //split second line every time a # is encountered into an array
        String[] productPrices = dataSetPrices.split("#");
        //split third line every time a # is encountered into an array
        double[] modProductPrices = new double[noOfProducts];
        //new array of type double to store price per units

        for (int i = 0; i < noOfProducts; i++) 
            //iterate through the number of products
        {
            modProductPrices[i] = Double.parseDouble(productPrices[i]);
            //double array now contains parsed elements from string of
            //third line
        }
        prodArray = new Product[noOfProducts];
        //array to hold second and third line combinations
        for (int i = 0; i < noOfProducts; i++) {
            Product pr = new Product(productCodes[i],
                    modProductPrices[i]);
            //create a product type from both lines of text
            prodArray[i] = pr;
            //insert that product type into a product array
        }
        return prodArray;
        //return the product array
    }

    public static CustomerDetailsList getCustomersFromTxt() 
        throws FileNotFoundException, IllegalCustomerIDException {
        Scanner fileScan; //scan the text file
        String line; //string to save lines

        String PID, Ptitle, Pinit, Psurname, Pstreet, Ptown, Ppostcode;
        //strings to save private customers details
        String CID, Ccompany, Cstreet, Ctown, Cpostcode;
        //strings to save company customer details
        CustomerDetailsList customerlist = new CustomerDetailsList();
        //customer details arraylist

        fileScan = new Scanner(new File("Customer.txt"));
        fileScan.useDelimiter("\n");
        //scan the text file
        while (fileScan.hasNext()) {
            //scan next
            line = fileScan.next();
            if (line.startsWith("P")) // if it starts a 'P'
            {
                //split accoringly
                String[] PrivateStrArray = line.split("/");
                System.out.println(line);
                //split at each '/'
                PID = PrivateStrArray[0];
                Ptitle = PrivateStrArray[1];
                Pinit = PrivateStrArray[2];
                Psurname = PrivateStrArray[3];
                Pstreet = PrivateStrArray[4];
                Ptown = PrivateStrArray[5];
                Ppostcode = PrivateStrArray[6];

                //parse house number as an int
                String Pregion = PID.substring(1, 3);
                //get reagion
                double setfullprice = 0.0;

                Name pName = new Name(Ptitle, Pinit, Psurname);
                //create new name type
                Address forPCD = new Address(Pstreet, Ptown, Ppostcode);
                //create new address type
                PrivateCustomerDetails privatecustdetails = 
                    new PrivateCustomerDetails(PID, forPCD, Pregion, 
                        setfullprice, pName);
                //create new private customer details type
                customerlist.addCustomerToList(privatecustdetails);
                //add it to the arraylist of type customer details
            }
            if (line.startsWith("C")) {
                //split accoringly
                String[] companyStrArray = line.split("/");
                //split at each '/'
                CID = companyStrArray[0];
                Ccompany = companyStrArray[1];
                Cstreet = companyStrArray[2];
                Ctown = companyStrArray[3];
                Cpostcode = companyStrArray[4];
                String Cregion = CID.substring(1, 3);
                //get the region
                double setfullprice = 0.0;
                int clubDis = Integer.parseInt(companyStrArray[5]
                        .trim());
                //parse the club discount as an int
                Address forSCD = new Address(Cstreet, Ctown, 
                        Cpostcode);
                //create new address type
                SportsClubDetails newsportsclub = new SportsClubDetails
                    (CID, forSCD, Cregion, setfullprice, Ccompany, 
                        clubDis);
                //create sports club type
                customerlist.addCustomerToList(newsportsclub);
                //add it to the arraylist of type customer details
            }
        }
        //turn the customer details arraylist to a customer details array
        return customerlist;
        //return the array
    }

    public static void getPurchaseOrderData() 
            throws FileNotFoundException {
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
                    qty = Integer.parseInt(lineScan.next());
                }

            }

        }
    }
}

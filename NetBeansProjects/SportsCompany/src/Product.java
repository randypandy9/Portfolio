import java.util.regex.Pattern; //import
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ysj13kxu
 */
public class Product {

    private String productCode; //product code field
    private double pricePerUnit; //price per unit field

    public Product(String productCode, double pricePerUnit) {
        this.productCode = productCode;
        //set product code as part of a product type
        this.pricePerUnit = pricePerUnit;
        //set price per unit as part of a product type
    }

    public String getProductCode() {
        return productCode; //return product code
    }

    public double getPricePerUnit() {
        return pricePerUnit; //return price per unit
    }

    public void setProductCode(String productCode) 
            throws InvalidProductCodeException {
        if (Pattern.matches("[A-Z]{2}/[0-9]{3}", productCode) == true) 
        //check if the new product code trying to be changed is of the
        //correct format
        {
            this.productCode = productCode;
            //if it matches, set it
        } else {
            throw new InvalidProductCodeException("Invalid Product Code!");
            //else throw new exception error
        }
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
        //set price per unit to a new value
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(); //new String biulder 
        sb.append(productCode).append(" ").append(pricePerUnit);
        //create toString
        return sb.toString(); //return the string
    }
}

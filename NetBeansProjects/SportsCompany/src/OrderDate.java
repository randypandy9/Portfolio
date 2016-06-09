import java.text.ParseException; //imports
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author ysj13kxu
 */
/**
 * Creates a new OrderDate
 *
 * @param date must have the format "dd/mm/yy" otherwise
 * @throws IllegalDateFormatException
 */
public class OrderDate {

    private String date;

    public String getDate() {
        return date; //return date
    }

    public void setDate(String date) {
        this.date = date; //set given date as new date
    }

    public OrderDate(String date) throws IllegalDateFormatException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy");
        //new simple date format initialisation 
        try {
            Date dt = sdf.parse(date);
            String format = dt.toString();
            String formatted = format.substring(8, 10) + "/" + 
                    format.substring(14, 16) + "/" + 
                    format.substring(26, 28);
            this.date = formatted;
            //try to parse the given date
            //into the type specified in the simple date format
        } catch (ParseException e) {
            throw new IllegalDateFormatException
                    ("ERROR - date format is incorrect!");
            //otherwise throw a new error
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(); //new String biulder 
        sb.append("/").append(date);
        //create toString
        return sb.toString(); //return the string
    }
}

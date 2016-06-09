/**
 *
 * @author ysj13kxu
 */
public class Name 
{
    private String title; //title field
    private String initial; //initial field
    private String surname; //surname field
    
    public Name (String title, String initial, String surname)
    {
        this.title = title; //setting title to class type Name
        this.initial = initial; //setting initial to class type Name
        this.surname = surname; //setting surname to class type Name
    }
    public String getTitle()
    {
        return title; //returns name;
    }
    public String getInitial()
    {
        return initial; //returns initial
    }
    public String getSurname()
    {
        return surname; //return surname
    }
    public void setTitle(String name)
    {
        this.title = name; //sets name to a new name
    }
    public void setInitial(String initial)
    {
        this.title = initial; //sets initial to a new name
    }
    public void setSurname(String surname)
    {
        this.title = surname;
    }
    public String toString()
    {
       StringBuilder sb = new StringBuilder(); //new String biulder 
       sb.append("/").append(title).append("/").append(initial)
         .append("/").append(surname);
       //create toString
       return sb.toString(); //return the string
    }
    
}

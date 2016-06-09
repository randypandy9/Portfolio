/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlumniPackage;

/**
 *
 * @author ysj13kxu
 */
public class Account 
{
    private String name;
    private String username;
    private String password;
    private String email;
    private int id;
    
    public Account(int id, String username, String password)
    {
        this.username = username;
        this.password = password;
        this.id = id;
    }
    public Account(String name, String username, String password, String email)
    {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public int getID()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
    public String getEmail()
    {
        return email;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
}

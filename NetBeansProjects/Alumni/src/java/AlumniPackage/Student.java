/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlumniPackage;

/**
 *
 * @author ysj13kxu
 */
public class Student 
{
    private int studentID;
    private String name;
    private String email;
    private String info;
    private String school;
    
    public Student(int id, String name, String email, String info, String school)
    {
        this.studentID = id;
        this.name = name; 
        this.email = email;
        this.info = info;
        this.school = school;
    }
    
    public int getStudentID()
    {
        return studentID;
    }
    public String getName()
    {
        return name;
    }
    public String getSchool()
    {
        return school;
    }
    public String getEmail()
    {
        return email;
    }
    public String getInfo()
    {
        return info;
    }
    public void setName(String newName)
    {
        this.name = newName;
    }
    public void setSchool(String newSchool)
    {
        this.school = newSchool;
    }
    public void setEmail(String newEmail)
    {
        this.email = newEmail;
    }
    public void setInfo(String newInfo)
    {
        this.info = newInfo;
    }
    
    
}

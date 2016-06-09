/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_package;

import javax.servlet.ServletException;
import java.sql.*;
import java.util.Random;

/**
 *
 * @author HTA13NAU
 */
public class School {

    public String school;
    public String schoolId;
    public String website;
    public String schoolInfo;
    

    public School(String school, String schoolId, String website, String schoolInfo) {
        this.school = school;
        this.schoolId = schoolId;
        this.website= website;
        this.schoolInfo=schoolInfo;
    }

    public String getSchool() {
        return this.school;
    }
    public String getSchoolId(){
        return  this.schoolId;
    }
    public String getWebsite(){
        return this.website;
    }
    public String getSchoolInfo(){
        return this.schoolInfo;
    }
    public void addSchool() throws ServletException {

        try {
            if (!school.equals("")) {
                Connection con = AdminDB.getConnection();
                PreparedStatement insertQuery = con.prepareStatement("INSERT INTO school VALUES(?,?,?,?)");
                Random rand = new Random();
                int rnd = rand.nextInt(900) + 100;
                String schoolID = "S-" + rnd;
                this.schoolId= schoolID;
                
                insertQuery.setString(1, school);
                insertQuery.setString(2, schoolId);
                insertQuery.setString(3, website);
                insertQuery.setString(4, schoolInfo);
                
                insertQuery.executeUpdate();
            } else {
                throw new ServletException("enter a valid schoolName");
            }
        } catch (Exception e) {
            throw new ServletException("update error", e);
        }
    }
    /**
     *
     * @return @throws ServletException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    /*public static int returnNum(Connection connection) throws ClassNotFoundException, SQLException
     {
     connection = AdminDB.getConnection();
     PreparedStatement ps1= connection.prepareStatement("SELECT COUNT('username') FROM login");
     ResultSet rs1 = ps1.executeQuery();
     //num =rs1.getInt()
     while(rs1.next()){
     String result=rs1.getString(1);
     }
     return result;
     **/
}

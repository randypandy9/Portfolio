/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;

/**
 *
 * @author hta13nau
 */
public class SchoolList {
    
    public String school;
    public String schoolId;

    
    public SchoolList(ResultSet rs) throws SQLException {
        try {

            this.school = rs.getString("schoolName");
            this.schoolId=rs.getString("schoolId");
            // this.numSchool=rs1.getString("count");

        } catch (Exception e) {
            throw new SQLException("ResultSet failed", e);
        }
    }
    public String getSchool() {
        return school;
    }
    public static ArrayList returnSchool() throws ServletException, ClassNotFoundException, SQLException {

        ArrayList schoolList = new ArrayList();

        try {

            Connection connection = AdminDB.getConnection();
            PreparedStatement schoolquery = connection.prepareStatement("SELECT * FROM school");
            ResultSet rs = schoolquery.executeQuery();
        
            while (rs.next()) {
                SchoolList aSchool = new SchoolList(rs);
                schoolList.add(aSchool);
            }
            schoolquery.close();
            rs.close();
            connection.close();
        } catch (Exception e) {
            throw new ServletException("No return", e);
        }
        return schoolList;
    
    }
}
        
    


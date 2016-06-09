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
public class SchoolCount {

    public String countSchool;
    
    public SchoolCount(ResultSet countResult) throws SQLException {

        this.countSchool = countResult.getString("count");

    }

    public String getCountName(){
        return countSchool;
    }
     public static ArrayList countSchool() throws ClassNotFoundException, SQLException, ServletException{
        ArrayList CountSch = new ArrayList ();
        Connection connect = AdminDB.getConnection();
        
        String sql = "SELECT COUNT(distinct schoolName)from School";

        PreparedStatement countQuery = connect.prepareStatement(sql);
        ResultSet countResult = countQuery.executeQuery();
        
        if (countResult.next()){
            SchoolCount attendanceC = new SchoolCount(countResult);
            CountSch.add(attendanceC);
        }
        return CountSch;
}
}

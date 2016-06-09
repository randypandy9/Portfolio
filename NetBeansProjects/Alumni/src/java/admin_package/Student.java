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

/**
 *
 * @author hta13nau
 */
public class Student {

    public String countName;

    public Student(ResultSet countResult) throws SQLException {

        this.countName = countResult.getString("count");

    }

    public String getCountName() {
        return countName;
    }

    public static ArrayList countUser() throws SQLException, ClassNotFoundException {
        
        ArrayList countList = new ArrayList();
        Connection connect = AdminDB.getConnection();
        String sql1 = "SELECT COUNT(name)from student";

        PreparedStatement countQuery = connect.prepareStatement(sql1);
        ResultSet countResult = countQuery.executeQuery();
        
        //countUser = countResult.getInt("count");
        if (countResult.next()){
            Student student = new Student(countResult);
            countList.add(student);
        }
        return countList;
        

    }
}

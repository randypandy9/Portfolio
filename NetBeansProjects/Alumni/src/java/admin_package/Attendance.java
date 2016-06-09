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
public class Attendance {
    public String school;
    public String name; 
    public int dateStart; 
    public int dateEnd;
    public int countName;
    
    public Attendance(ResultSet rs1)throws SQLException {
        try{
            this.name=rs1.getString("name");
            this.school=rs1.getString("schoolName");
            this.dateStart=rs1.getInt("dateStart");
            this.dateEnd=rs1.getInt("dateEnd");
            
        } catch(Exception e){
            throw new SQLException("ResultSet rs1 failed", e);
        }
       
    }
    public String getSchoolName() {
        return school;
    }
    public int getDateStart(){
        return dateStart;
    }
    public int getDateEnd(){
        return dateEnd;
    }
    public String getName(){
        return name;
    }
    public int getCountName(){
        return countName;
    }
      public static ArrayList returnAttendance() throws ClassNotFoundException, SQLException, ServletException{
        ArrayList arry = new ArrayList (); 
        
        try{
            Connection con = AdminDB.getConnection();
            String sql= "SELECT * FROM attendance";
           
            
            PreparedStatement  attendanceQ =con.prepareStatement(sql);
          
            ResultSet rs1 = attendanceQ.executeQuery();
          
            while(rs1.next()){
                Attendance anAttendance = new Attendance(rs1);
                arry.add(anAttendance);
            }
            attendanceQ.close();
            rs1.close();
            
            con.close();
        }
        catch(Exception e) {
           throw new ServletException("return arry Fail", e);
       }
       return arry; 
     
    }
      
     
}

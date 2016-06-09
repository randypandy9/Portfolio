/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_package;

/**
 *
 * @author hta13nau
 */
public class AdminRequest {
    private String email;
    private String schoolName;
    
    public AdminRequest(String email, String schoolName){
        this.email=email;
        this.schoolName=schoolName;
    }
    
   public String getEmail(){
       return email;
   }
   public String getSchoolName(){
       return schoolName;
   }
}

package AlumniPackage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hta13nau
 */
public class School {
    private String schoolName;
    private String schoolId;
    
    public School(String schoolName, String schoolId){
        this.schoolName=schoolName;
        this.schoolId=schoolId;
    }
    public String getSchoolName(){
        return this.schoolName;
}
    public String getSchoolId(){
        return this.schoolId;
    }
}

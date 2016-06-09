/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Schooldata_package;

/**
 *
 * @author hta13nau
 */
public class SchoolData {
    private String schoolName;
    private String schoolId;
    private String website;
    private String schoolInfo;
    
    public SchoolData(String schoolName, String schoolId, String website, String schoolInfo){
        this.schoolId=schoolId;
        this.schoolName=schoolName;
        this.website=website;
        this.schoolInfo=schoolInfo;
    }
    public String getSchoolName(){
       return this.schoolName;
    }
    public String getSchoolId(){
        return this.schoolId;
    }
    public String getWebsite(){
        return  this.website;
    }
    public String getSchoolInfo(){
        return this.schoolInfo;
    }
}

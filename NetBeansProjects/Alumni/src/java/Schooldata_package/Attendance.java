/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Schooldata_package;

/**
 *
 * @author hta13nau
 */
public class Attendance {
    private String name;
    private String schoolName;
    private String dateStart;
    private String dateEnd;
    
    public Attendance(String name, String schoolName, String dateStart, String dateEnd){
        this.name=name;
        this.schoolName=schoolName;
        this.dateStart=dateStart;
        this.dateEnd=dateEnd;
    }
    public String getName(){
        return this.name;
    }
    public String getSchoolName(){
        return this.schoolName;
    }
    public String getDateStart(){
        return this.dateStart;
    }
    public String getDateEnd(){
        return this.dateEnd;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setSchoolName(String newschoolName){
        this.schoolName=newschoolName;
    }
    public void setDateStart(String newdateStart){
        this.dateStart=newdateStart;
    }
    public void setDateEnd(String newdateEnd){
        this.dateEnd=newdateEnd;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.slms;

/**
 *
 * @author HP
 */
public class Course {
    private String courseName;
    private String courseCode;
    private int creditHour;
    private String courseSummary;
    private String msTeamsLink;
    
    public String getCourseName(){
        return courseName;
    }
    public void setCourseName(String name){
        courseName = name;
    }
    public String getCourseCode(){
        return courseCode;
    }
    public void setCourseCode(String code){
        courseCode = code;
    }
    public int creditHour(){
        return creditHour;
    }
    public void setCreditHour(int hour){
        creditHour = hour;
    }
    public String getCourseSummary(){
        return courseSummary;
    }
    public void setCourseSummary(String summary){
        courseSummary = summary;
    }
    public String getMsTeamsLink(){
        return msTeamsLink;
    }
    public void setMsTeamsLink(String link){
        msTeamsLink = link;
    }
}

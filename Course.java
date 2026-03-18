public class Course {

    //Course class attributes
    private String courseName;
    private String courseCode;
    private int creditHour;
    private String courseSummary;
    private String msTeamsLink;

    //Getter method to retrieve course name
    public String getCourseName() {
        return courseName;
    }

    //Setter method to set course name
    public void setCourseName(String name) {
        courseName = name;
    }

    //Getter method to retrieve course code
    public String getCourseCode() {
        return courseCode;
    }

    //Setter method to set course code
    public void setCourseCode(String code) {
        courseCode = code;
    }

    //Getter method to retrieve credit hour
    public int creditHour() {
        return creditHour;
    }

    //Setter method to set credit hour
    public void setCreditHour(int hour) {
        creditHour = hour;
    }

    //Getter method to retrieve course summary
    public String getCourseSummary() {
        return courseSummary;
    }

    //Setter method to set course summary
    public void setCourseSummary(String summary) {
        courseSummary = summary;
    }

    //Getter method to retrieve MS teams link
    public String getMsTeamsLink() {
        return msTeamsLink;
    }

    //Setter method to set MS teams link
    public void setMsTeamsLink(String link) {
        msTeamsLink = link;
    }
}

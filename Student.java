public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private String email;
    private String phoneNum;
    
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String name){
        firstName = name;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String name){
        lastName = name;
    }
    public String getStudentId(){
        return studentId;
    }
    public void setStudentId(String id){
        studentId = id;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String studentEmail){
        email = studentEmail;
    }
    public String getPhoneNum(){
        return phoneNum;
    }
    public void setPhoneNum(String phoneNo){
        phoneNum = phoneNo;
    }
}

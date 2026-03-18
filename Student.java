public class Student {
    
    //Student class attributes
    private String firstName;
    private String lastName;
    private String studentId;
    private String email;
    private String phoneNum;
    
    //Getter method to retrieve student's first name
    public String getFirstName(){
        return firstName;
    }
    
    //Setter method to set student's first name
    public void setFirstName(String name){
        firstName = name;
    }
    
    //Getter method to retrieve student's last name
    public String getLastName(){
        return lastName;
    }
    
    //Setter method to set student's last name
    public void setLastName(String name){
        lastName = name;
    }
    
    //Getter method to retrieve student ID
    public String getStudentId(){
        return studentId;
    }
    
    //Setter method to set student ID
    public void setStudentId(String id){
        studentId = id;
    }
    
    //Getter method to retrieve student email
    public String getEmail(){
        return email;
    }
    
    //Setter method to set student email
    public void setEmail(String studentEmail){
        email = studentEmail;
    }
    
    //Getter method to retrieve student's phone number
    public String getPhoneNum(){
        return phoneNum;
    }
    
    //Setter method to set student's phone number
    public void setPhoneNum(String phoneNo){
        phoneNum = phoneNo;
    }
}

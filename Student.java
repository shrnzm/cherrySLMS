import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private String email;
    private String phoneNum;

    private static Student[] studentArray = new Student[100];
    private static int studentCount = 0;

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

    public void addStudent(Scanner sc) {
        if (studentCount >= studentArray.length) {
            System.out.println("\nError: Student database is full.");
            return;
        }

        Student newStudent = new Student();
        
        System.out.print("Enter First Name: ");
        newStudent.setFirstName(sc.nextLine());

        System.out.print("Enter Last Name: ");
        newStudent.setLastName(sc.nextLine());

        System.out.print("Enter Student ID: ");
        newStudent.setStudentId(sc.nextLine());

        System.out.print("Enter Email: ");
        newStudent.setEmail(sc.nextLine());

        System.out.print("Enter Phone Number: ");
        newStudent.setPhoneNum(sc.nextLine());

        studentArray[studentCount] = newStudent;
        studentCount++;
        System.out.println("\nStudent profile added successfully.");
    }
    
    public Student searchStudent(String id, Scanner sc) {
        // If Scanner is provided, ask user for ID
        if (sc != null) {
            System.out.print("\nEnter Student ID to search: ");
            id = sc.nextLine();
        }
    
        for (int i = 0; i < studentCount; i++) {
            if (studentArray[i].getStudentId().equalsIgnoreCase(id)) {
                if (sc != null) {
                    System.out.println("\nStudent found:");
                    displayStudent(studentArray[i]);
                }
                return studentArray[i]; // return the found student
            }
        }
    
        if (sc != null) {
            System.out.println("\nStudent not found.");
        }
    
        return null; // return null if not found
    }

    public void editStudent(String targetId, Scanner sc) {
        Student student = searchStudent(targetId, null);

        if (student == null) {
            System.out.println("\nStudent not found.");
            return;
        }

        System.out.println("\nStudent found. Editing profile for: " + student.getStudentId());

        System.out.print("Enter New First Name: ");
        student.setFirstName(sc.nextLine());

        System.out.print("Enter New Last Name: ");
        student.setLastName(sc.nextLine());

        System.out.print("Enter New Email: ");
        student.setEmail(sc.nextLine());

        System.out.print("Enter New Phone Number: ");
        student.setPhoneNum(sc.nextLine());

        System.out.println("\nChanges saved. Updated Details:");
        displayStudent(student);
    }

    public void displayStudent(Student s) {
        if (s != null) {
            // Display single student
            System.out.println("---------------------------");
            System.out.println("ID:    " + s.getStudentId());
            System.out.println("Name:  " + s.getFirstName() + " " + s.getLastName());
            System.out.println("Email: " + s.getEmail());
            System.out.println("Phone: " + s.getPhoneNum());
            System.out.println("---------------------------");
        } else {
            // Display all students
            if (studentCount == 0) {
                System.out.println("\nNo students in the database.");
                return;
            }
            System.out.println("\nAll Students:");
            for (int i = 0; i < studentCount; i++) {
                displayStudent(studentArray[i]); // reuse same method
            }
        }
    }
}

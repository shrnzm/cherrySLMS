import java.util.*;

class StudentManager {

    //Array to store Student objects
    private Student[] studentArray = new Student[500];
    private int studentCount = 0;

    //Add Student Method
    public void addStudent(Scanner sc) {
        //Check if array is full
        if (studentCount >= studentArray.length) {
            System.out.println("\nStudent list is full. Cannot add new student.");
            return;
        }

        //Create new Student object
        Student newStudent = new Student();

        System.out.print("\nEnter First Name: ");
        newStudent.setFirstName(sc.nextLine());

        System.out.print("Enter Last Name: ");
        newStudent.setLastName(sc.nextLine());

        System.out.print("Enter Student ID: ");
        newStudent.setStudentId(sc.nextLine());

        //Check email for correct format
        while (true) {
            System.out.print("Enter Email: ");
            String emailInput = sc.nextLine();
            if (emailInput.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$")) {
                newStudent.setEmail(emailInput);
                break;
            } else {
                System.out.println("Invalid email format! Please try again.");
            }
        }

        //Check phone number for correct format
        while (true) {
            System.out.print("Enter Phone Number: ");
            String phoneInput = sc.nextLine();
            if (phoneInput.matches("^\\+?[0-9]{8,15}$")) {
                newStudent.setPhoneNum(phoneInput);
                break;
            } else {
                System.out.println("Invalid phone number! Please try again.");
            }
        }

        //Add new student to end of array
        studentArray[studentCount] = newStudent;
        studentCount++;
        System.out.println("\nStudent added successfully.");
    }

    //Search Student Method
    public Student searchStudent(String studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (studentArray[i].getStudentId().equals(studentId)) {
                return studentArray[i];
            }
        }
        return null;
    }

    //Edit Student Method
    public void editStudent(String studentId, Scanner sc) {
        Student student = searchStudent(studentId);

        if (student == null) {
            System.out.println("\nStudent not found.");
            return;
        }

        System.out.println("\nStudent found.\n");

        //Display details of student to edit
        displayStudent(student);

        System.out.print("\nAre you sure you want to edit this student? (Y/N): ");
        String confirm = sc.nextLine();

        //Check for confirmation
        if (confirm.equalsIgnoreCase("N")) {
            System.out.println("Edit cancelled.");
            return;
        }

        //Enter new details of student
        System.out.print("Enter New First Name: ");
        student.setFirstName(sc.nextLine());

        System.out.print("Enter New Last Name: ");
        student.setLastName(sc.nextLine());

        //Check email for correct format
        while (true) {
            System.out.print("Enter New Email: ");
            String emailInput = sc.nextLine();
            if (emailInput.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$")) {
                student.setEmail(emailInput);
                break;
            } else {
                System.out.println("Invalid email format! Please try again.");
            }
        }

        //Check phone number for correct format
        while (true) {
            System.out.print("Enter New Phone Number: ");
            String phoneInput = sc.nextLine();
            if (phoneInput.matches("^\\+?[0-9]{8,15}$")) {
                student.setPhoneNum(phoneInput);
                break;
            } else {
                System.out.println("Invalid phone number! Please try again.");
            }
        }

        System.out.println("\nStudent updated successfully.\nUpdated details:\n");

        //Display edited student details
        displayStudent(student);
    }

    //Delete Student Method
    public void deleteStudent(String studentId, Scanner sc) {
        Student student = searchStudent(studentId);

        if (student == null) {
            System.out.println("\nStudent not found.");
            return;
        }

        System.out.println("\nStudent found.\n");

        //Display details of student to delete
        displayStudent(student);

        System.out.print("\nAre you sure you want to delete this student? (Y/N): ");
        String confirm = sc.nextLine();

        //Check for confirmation
        if (confirm.equalsIgnoreCase("N")) {
            System.out.println("Deletion cancelled.");
            return;
        }

        //Find index of student to delete
        int index = -1;
        for (int i = 0; i < studentCount; i++) {
            if (studentArray[i].getStudentId().equals(studentId)) {
                index = i;
                break;
            }
        }

        //Shift all students after deleted one to the left
        for (int i = index; i < studentCount - 1; i++) {
            studentArray[i] = studentArray[i + 1];
        }

        //Empty the last element in studentArray
        studentArray[studentCount - 1] = null;
        studentCount--;

        System.out.println("\nStudent deleted successfully!\nUpdated student list:");

        //Display all students
        viewAllStudents();
    }

    //Display Student Method
    public void displayStudent(Student student) {
        if (student != null) {
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Phone: " + student.getPhoneNum());
        }
    }

    //View All Students Method
    public void viewAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students available.");
            return;
        }
        for (int i = 0; i < studentCount; i++) {
            displayStudent(studentArray[i]);
            System.out.println("-------------------");
        }
    }
}

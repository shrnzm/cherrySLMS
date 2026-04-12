import java.util.*;

class Enrollment {

    //Enrollment class attributes
    private String[] studentIDs = new String[500];
    private String[] courseCodes = new String[500];
    private int count = 0;

    private CourseManager courseManager;
    private StudentManager studentManager;
    private Scanner sc;
    private SuggestionAPI cacheAPI;

    //Constructor to connect managers
    public Enrollment(CourseManager cm, StudentManager sm, Scanner sc, SuggestionAPI cacheAPI) {
        this.courseManager = cm;
        this.studentManager = sm;
        this.sc = sc;
        this.cacheAPI = cacheAPI;
    }

    //Add a course to a student
    public void addCourse() {
        //Check if array is full
        if (count >= studentIDs.length) {
            System.out.println("\nEnrollment list is full.");
            return;
        }

        //Show student ID suggestions
        cacheAPI.showAllStudents();

        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();

        //Check if student exists
        if (studentManager.searchStudent(studentId) == null) {
            System.out.println("\nError! Student not found.");
            return;
        }

        //Show course code suggestions
        cacheAPI.showAllCourses();

        System.out.print("Enter Course Code: ");
        String courseCode = sc.nextLine();
        
        // Check if course exists
        if (courseManager.searchCourse(courseCode) == null) {
            System.out.println("\nError! Course does not exist.");
            return;
        }

        // Check for duplicate
        for (int i = 0; i < count; i++) {
            if (studentIDs[i].equalsIgnoreCase(studentId) && courseCodes[i].equalsIgnoreCase(courseCode)) {
                System.out.println("\nError! Student is already enrolled in this course.");
                return;
            }
        }

        studentIDs[count] = studentId;
        courseCodes[count] = courseCode;
        count++;
        
        cacheAPI.cacheStudent(studentId);
        cacheAPI.cacheCourse(courseCode);

        System.out.println("\nCourse successfully added to student.");
    }

    //Add a student to a course
    public void addStudent() {
        //Check if array is full
        if (count >= studentIDs.length) {
            System.out.println("\nEnrollment list is full.");
            return;
        }

        //Show course code suggestions
        cacheAPI.showAllCourses();

        System.out.print("Enter Course Code: ");
        String courseCode = sc.nextLine();
        
        // Check if course exists
        if (courseManager.searchCourse(courseCode) == null) {
            System.out.println("\nError! Course does not exist.");
            return;
        }
        
        //Show student ID suggestions
        cacheAPI.showAllStudents();

        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();

        //Check if student exists
        if (studentManager.searchStudent(studentId) == null) {
            System.out.println("\nError! Student not found.");
            return;
        }

        // Check for duplicate
        for (int i = 0; i < count; i++) {
            if (studentIDs[i].equalsIgnoreCase(studentId) && courseCodes[i].equalsIgnoreCase(courseCode)) {
                System.out.println("\nError! Student is already enrolled in this course.");
                return;
            }
        }

        studentIDs[count] = studentId;
        courseCodes[count] = courseCode;
        count++;
        
        cacheAPI.cacheStudent(studentId);
        cacheAPI.cacheCourse(courseCode);

        System.out.println("\nStudent successfully added to course.");
    }

    //Find a student's course based on student ID
    public void findCourse(String studentId) {
        for (int i = 0; i < count; i++) {
            if (studentIDs[i].equalsIgnoreCase(studentId)) {
                System.out.println("Course found: " + courseCodes[i]);
                return;
            }
        }
        System.out.println("\nNo course found for this student.");
    }

    //List all courses enrolled by a student
    public void listCourses(String studentId) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (studentIDs[i].equalsIgnoreCase(studentId)) {
                System.out.println("Course: " + courseCodes[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("\nThis student has no enrolled courses.");
        }
    }

    //Find a student in a course based on course code
    public void findStudent(String courseCode) {
        for (int i = 0; i < count; i++) {
            if (courseCodes[i].equalsIgnoreCase(courseCode)) {
                System.out.println("Student found: " + studentIDs[i]);
                return;
            }
        }
        System.out.println("\nNo student found in this course.");
    }

    //List all students enrolled in a course
    public void listStudents(String courseCode) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (courseCodes[i].equalsIgnoreCase(courseCode)) {
                System.out.println("Student ID: " + studentIDs[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("\nThis course has no students.");
        }
    }
}

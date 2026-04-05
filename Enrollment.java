class Enrollment {

    //Enrollment class attributes
    private String[] studentIDs = new String[500];
    private String[] courseCodes = new String[500];
    private int count = 0;

    private CourseManager courseManager;
    private StudentManager studentManager;

    //Constructor to connect managers
    public Enrollment(CourseManager cm, StudentManager sm) {
        this.courseManager = cm;
        this.studentManager = sm;
    }

    //Add a course to a student
    public void addCourse(String studentId, String courseCode) {
        //Check if array is full
        if (count >= studentIDs.length) {
            System.out.println("\nEnrollment list is full.");
            return;
        }
        
        //Check if student exists
        if (studentManager.searchStudent(studentId) == null) {
            System.out.println("Error! Student not found.");
            return;
        }

        // Check if course exists
        if (courseManager.searchCourse(courseCode) == null) {
            System.out.println("Error! Course does not exist.");
            return;
        }

        // Check for duplicate
        for (int i = 0; i < count; i++) {
            if (studentIDs[i].equalsIgnoreCase(studentId) && courseCodes[i].equalsIgnoreCase(courseCode)) {
                System.out.println("Error! Student is already enrolled in this course.");
                return;
            }
        }

        studentIDs[count] = studentId;
        courseCodes[count] = courseCode;
        count++;

        System.out.println("Course successfully added to student.");
    }

    //Add a student to a course
    public void addStudent(String courseCode, String studentId) {
        addCourse(studentId, courseCode);
    }

    //Find a student's course based on student ID
    public void findCourse(String studentId) {
        for (int i = 0; i < count; i++) {
            if (studentIDs[i].equalsIgnoreCase(studentId)) {
                System.out.println("Course found: " + courseCodes[i]);
                return;
            }
        }
        System.out.println("No course found for this student.");
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
            System.out.println("This student has no enrolled courses.");
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
        System.out.println("No student found in this course.");
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
            System.out.println("This course has no students.");
        }
    }
}

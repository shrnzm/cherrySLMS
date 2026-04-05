import java.util.*;

class SLMS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Create course manager object to manage courses 
        CourseManager courseManager = new CourseManager();

        //Create student manager object to manage students
        StudentManager studentManager = new StudentManager();

        final int MAX_COURSES = 100;
        final int MAX_STUDENTS = 500;

        Course[] courses = new Course[MAX_COURSES];
        Student[] students = new Student[MAX_STUDENTS];

        boolean[][] enrollment = new boolean[MAX_COURSES][MAX_STUDENTS];

        //Main menu for SLMS
        while (true) {
            System.out.println("\n===== Welcome to cherrySLMS! =====\n");
            System.out.println("1. Manage Courses");
            System.out.println("2. Manage Students");
            System.out.println("3. Exit");

            //Check that choice is an integer and within the range given
            int mainChoice = -1;
            while (true) {
                System.out.print("\nChoose option: ");
                String input = sc.nextLine();
                try {
                    mainChoice = Integer.parseInt(input);
                    if (mainChoice < 1 || mainChoice > 3) {
                        System.out.println("Please enter a number between 1 and 3.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter an integer.");
                }
            }

            switch (mainChoice) {
                case 1:
                    //Go to course management menu if choice is 1
                    manageCourses(sc, courseManager);
                    break;
                    
                case 2:
                    //Go to student management menu if choice is 2
                    manageStudents(sc, studentManager);
                    break;
                    
                case 3:
                    //Exit system if choice is 3
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    //Error Handling
    public static void manageEnrollments(Scanner sc, CourseManager cManager, StudentManager sManager, boolean[][] enrollment) {
        while (true) {
            System.out.println("\n=== Enrollment & Relationship Management ===\n");
            System.out.println("1. Add Student to Course (Enroll)");
            System.out.println("2. List all Courses for a Student");
            System.out.println("3. List all Students in a Course");
            System.out.println("4. Back to Main Menu");

            System.out.print("\nChoose option: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                enrollProcess(sc, cManager, sManager, enrollment);
            } else if (choice.equals("2")) {
                viewStudentEnrollments(sc, sManager, cManager, enrollment);
            } else if (choice.equals("3")) {
                viewCourseEnrollments(sc, cManager, sManager, enrollment);
            } else if (choice.equals("4")) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static void enrollProcess(Scanner sc, CourseManager cManager, StudentManager sManager, boolean[][] enrollment) {
        System.out.print("Enter Student ID: ");
        String sId = sc.nextLine();
        System.out.print("Enter Course Code: ");
        String cCode = sc.nextLine();

        int sIndex = -1, cIndex = -1;

        // 3a. Error Handling: Find indices and check if they exist
        for (int i = 0; i < 500; i++) {
            Student s = sManager.getStudentByIndex(i);
            if (s != null && s.getStudentId().equalsIgnoreCase(sId)) { sIndex = i; break; }
        }
        for (int i = 0; i < 100; i++) {
            Course c = cManager.getCourseByIndex(i);
            if (c != null && c.getCourseCode().equalsIgnoreCase(cCode)) { cIndex = i; break; }
        }

        if (sIndex == -1 || cIndex == -1) {
            System.out.println("\n[ERROR] Student or course not found in the system.");
            return;
        }

        // 3a. Error Handling: Attempting to assign same student to course
        if (enrollment[cIndex][sIndex]) {
            System.out.println("\n[ERROR] This student is already enrolled in this course.");
        } else {
            enrollment[cIndex][sIndex] = true;
            System.out.println("\n[SUCCESS] Enrollment completed successfully.");
        }
    }

    private static void viewStudentEnrollments(Scanner sc, StudentManager sManager, CourseManager cManager, boolean[][] enrollment) {
        System.out.print("Enter Student ID: ");
        String sId = sc.nextLine();
        int sIndex = -1;

        for (int i = 0; i < 500; i++) {
            Student s = sManager.getStudentByIndex(i);
            if (s != null && s.getStudentId().equalsIgnoreCase(sId)) { sIndex = i; break; }
        }

        if (sIndex == -1) {
            System.out.println("\n[ERROR] Student not found.");
            return;
        }

        boolean found = false;
        System.out.println("\nEnrolled Courses for " + sId + ":");
        for (int i = 0; i < 100; i++) {
            if (enrollment[i][sIndex]) {
                Course c = cManager.getCourseByIndex(i);
                System.out.println("- " + c.getCourseCode() + ": " + c.getCourseName());
                found = true;
            }
        }
        // 3a. Error Handling: Student without an assigned course
        if (!found) System.out.println("[ERROR] This student is not assigned to any courses.");
    }

    private static void viewCourseEnrollments(Scanner sc, CourseManager cManager, StudentManager sManager, boolean[][] enrollment) {
        System.out.print("Enter Course Code: ");
        String cCode = sc.nextLine();
        int cIndex = -1;

        for (int i = 0; i < 100; i++) {
            Course c = cManager.getCourseByIndex(i);
            if (c != null && c.getCourseCode().equalsIgnoreCase(cCode)) { cIndex = i; break; }
        }

        if (cIndex == -1) {
            System.out.println("\n[ERROR] Course not found.");
            return;
        }

        boolean found = false;
        System.out.println("\nStudents enrolled in " + cCode + ":");
        for (int i = 0; i < 500; i++) {
            if (enrollment[cIndex][i]) {
                Student s = sManager.getStudentByIndex(i);
                System.out.println("- " + s.getStudentId() + ": " + s.getFirstName() + " " + s.getLastName());
                found = true;
            }
        }
        // 3a. Error Handling: Course without an assigned student
        if (!found) System.out.println("[ERROR] No students are assigned to this course.");
    }

    //Course Management Menu
    public static void manageCourses(Scanner sc, CourseManager manager) {
        while (true) {
            System.out.println("\n=== Course Management Menu ===\n");
            System.out.println("1. Add Course");
            System.out.println("2. Search Course");
            System.out.println("3. Edit Course");
            System.out.println("4. Delete Course");
            System.out.println("5. View All Courses");
            System.out.println("6. Back");

            //Check that choice is an integer and within the range given
            int choice = -1;
            while (true) {
                System.out.print("\nChoose option: ");
                String input = sc.nextLine();
                try {
                    choice = Integer.parseInt(input);
                    if (choice < 1 || choice > 6) {
                        System.out.println("Please enter a number between 1 and 6.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter an integer.");
                }
            }

            switch (choice) {
                case 1:
                    //Call Add Course Method
                    manager.addCourse(sc);
                    break;
                    
                case 2:
                    System.out.print("Enter course code to search: ");
                    //Call Search Course Method
                    Course foundCourse = manager.searchCourse(sc.nextLine());
                    
                    //Check if course is found
                    if (foundCourse != null) {
                        System.out.println("\nCourse found:\n");
                        //Display details of found course
                        manager.displayCourse(foundCourse);
                    } else {
                        System.out.println("\nCourse not found.");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter course code to edit: ");
                    //Call Edit Course Method
                    manager.editCourse(sc.nextLine(), sc);
                    break;
                    
                case 4:
                    System.out.print("Enter course code to delete: ");
                    //Call Delete Course Method
                    manager.deleteCourse(sc.nextLine(), sc);
                    break;
                    
                case 5:
                    System.out.println("\n=== All Courses ===\n");
                    //Call View All Courses Method
                    manager.viewAllCourses();
                    break;
                    
                case 6:
                    return;
                    
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    //Student Management Menu
    public static void manageStudents(Scanner sc, StudentManager manager) {
        while (true) {
            System.out.println("\n=== Student Management Menu ===\n");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Edit Student");
            System.out.println("4. Delete Student");
            System.out.println("5. View All Students");
            System.out.println("6. Back");

            //Check that choice is an integer and within the range given
            int choice = -1;
            while (true) {
                System.out.print("\nChoose option: ");
                String input = sc.nextLine();
                try {
                    choice = Integer.parseInt(input);
                    if (choice < 1 || choice > 6) {
                        System.out.println("Please enter a number between 1 and 6.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter an integer.");
                }
            }

            switch (choice) {
                case 1:
                    //Call Add Student Method
                    manager.addStudent(sc);
                    break;
                    
                case 2:
                    System.out.print("Enter student ID to search: ");
                    //Call Search Student Method
                    Student foundStudent = manager.searchStudent(sc.nextLine());
                    
                    //Check if student is found
                    if (foundStudent != null) {
                        System.out.println("\nStudent found:\n");
                        //Display details of found student
                        manager.displayStudent(foundStudent);
                    } else {
                        System.out.println("\nStudent not found.");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter student ID to edit: ");
                    //Call Edit Student Method
                    manager.editStudent(sc.nextLine(), sc);
                    break;
                    
                case 4:
                    System.out.print("Enter student ID to delete: ");
                    //Call Delete Student Method
                    manager.deleteStudent(sc.nextLine(), sc);
                    break;
                    
                case 5:
                    System.out.println("\n=== All Students ===\n");
                    //Call View All Students Method
                    manager.viewAllStudents();
                    break;
                    
                case 6:
                    return;
                    
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}

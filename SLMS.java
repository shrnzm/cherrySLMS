import java.util.*;

class SLMS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Create course manager object to manage courses 
        CourseManager courseManager = new CourseManager();

        //Create student manager object to manage students
        StudentManager studentManager = new StudentManager();

        //Create enrollment object to handle enrollment
        Enrollment enrollment = new Enrollment(courseManager, studentManager);

        //Main menu for SLMS
        while (true) {
            System.out.println("\n===== Welcome to cherrySLMS! =====\n");
            System.out.println("1. Manage Courses");
            System.out.println("2. Manage Students");
            System.out.println("3. Manage Enrollments");
            System.out.println("4. Exit");

            //Check that choice is an integer and within the range given
            int mainChoice = -1;
            while (true) {
                System.out.print("\nChoose option: ");
                String input = sc.nextLine();
                try {
                    mainChoice = Integer.parseInt(input);
                    if (mainChoice < 1 || mainChoice > 4) {
                        System.out.println("Please enter a number between 1 and 4.");
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
                    //Go to enrollment management menu if choice is 3
                    manageEnrollments(sc, enrollment);
                    break;

                case 4:
                    //Exit system if choice is 4
                    System.exit(0);

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
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

    public static void manageEnrollments(Scanner sc, Enrollment em) {
        while (true) {
            System.out.println("\n=== Enrollment Menu ===\n");
            System.out.println("1. Add a course to a student");
            System.out.println("2. Add a student to a course");
            System.out.println("3. Find a student's course by student ID");
            System.out.println("4. List all courses enrolled by a student");
            System.out.println("5. Find a student in a course by course code");
            System.out.println("6. List all students enrolled in a course");
            System.out.println("7. Back");

            //Check that choice is an integer and within the range given
            int choice = -1;
            while (true) {
                System.out.print("\nChoose option: ");
                String input = sc.nextLine();
                try {
                    choice = Integer.parseInt(input);
                    if (choice < 1 || choice > 7) {
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
                    //Enter Student ID of student to add course to
                    System.out.print("Enter Student ID: ");
                    String studentID = sc.nextLine();
                    
                    //Enter Course Code of course to add
                    System.out.print("Enter Course Code: ");
                    String courseCode = sc.nextLine();
                    
                    //Call addCourse method
                    em.addCourse(studentID, courseCode);
                    break;

                case 2:
                    //Enter Course Code of course to add student to
                    System.out.print("Enter Course Code: ");
                    String course_Code = sc.nextLine();
                    
                    //Enter Student ID of student to add to course
                    System.out.print("Enter Student ID: ");
                    String student_ID = sc.nextLine();
                    
                    //Call addStudent method
                    em.addStudent(course_Code, student_ID);
                    break;

                case 3:
                    //Enter Student ID of student to find student's course
                    System.out.print("Enter Student ID: ");
                    
                    //Call findCourse method
                    em.findCourse(sc.nextLine());
                    break;

                case 4:
                    //Enter Student ID of student to view all courses the selected student is enrolled in
                    System.out.print("Enter Student ID: ");
                    
                    //Call listCourses method
                    em.listCourses(sc.nextLine());
                    break;

                case 5:
                    //Enter Course Code of course to find student
                    System.out.print("Enter Course Code: ");
                    
                    //Call findStudent method
                    em.findStudent(sc.nextLine());
                    break;

                case 6:
                    //Enter Course Code to view all students enrolled in the selected course
                    System.out.print("Enter Course Code: ");
                    
                    //Call listStudents method
                    em.listStudents(sc.nextLine());
                    break;

                case 7:
                    return;
                    
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}

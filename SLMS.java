import java.util.*;

class SLMS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Create course manager object to manage courses 
        CourseManager courseManager = new CourseManager();

        //Create student manager object to manage students
        StudentManager studentManager = new StudentManager();

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

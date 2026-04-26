package com.mycompany.slms;

import java.util.*;

class SLMS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create API object to manage cache API operations
        SuggestionAPI api = new SuggestionAPI();

        // Create course manager object to manage courses
        CourseManager courseManager = new CourseManager(api);

        // Create student manager object to manage students
        StudentManager studentManager = new StudentManager(api);

        // Create enrollment object to manage enrollments
        Enrollment enrollment = new Enrollment(courseManager, studentManager, sc, api);

        // System Main Menu
        while (true) {
            System.out.println("\n===== Welcome to cherrySLMS! =====\n");
            System.out.println("1. Manage Courses");
            System.out.println("2. Manage Students");
            System.out.println("3. Manage Enrollments");
            System.out.println("4. Exit");

            // Check choice if it is an integer and within range of 1 - 4
            int mainChoice = getValidatedChoice(sc, 1, 4);

            switch (mainChoice) {
                case 1:
                    // Go to Course Management Menu
                    manageCourses(sc, courseManager, api);
                    break;
                case 2:
                    // Go to Student Management Menu
                    manageStudents(sc, studentManager, api);
                    break;
                case 3:
                    // Go to Enrollment Management Menu
                    manageEnrollments(sc, enrollment, api);
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    System.exit(0);
            }
        }
    }

    // Method to check input for valid integer range
    public static int getValidatedChoice(Scanner sc, int min, int max) {
        int choice;

        while (true) {
            System.out.print("\nChoose option: ");
            String input = sc.nextLine();

            try {
                choice = Integer.parseInt(input);
                
                // Check if input entered is within accepted range
                if (choice < min || choice > max) {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                } else {
                    return choice;
                }

                // Error message if input entered is not an integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer.");
            }
        }
    }

    // Course Management Menu
    public static void manageCourses(Scanner sc, CourseManager manager, SuggestionAPI api) {
        while (true) {
            System.out.println("\n=== Course Management Menu ===\n");
            System.out.println("1. Add Course");
            System.out.println("2. Search Course");
            System.out.println("3. Edit Course");
            System.out.println("4. Delete Course");
            System.out.println("5. View All Courses");
            System.out.println("6. Back");

            // Check choice if it is an integer and within range of 1 - 6
            int choice = getValidatedChoice(sc, 1, 6);

            switch (choice) {
                case 1:
                    // Call Add Course Method
                    manager.addCourse(sc);
                    break;
                case 2:
                    // Show recent searches (if any)
                    api.showRecentCourseSearches();

                    System.out.print("Enter course code: ");
                    String tempCode = sc.nextLine();

                    // Suggest course codes based on input before finalization
                    api.suggestCourseList(tempCode);

                    // Ask for final course code to search
                    System.out.print("Confirm course code: ");
                    String searchCourseCode = sc.nextLine();

                    // Add entered course code to recent searches cache
                    api.addRecentCourseSearch(searchCourseCode);

                    // Call Search Course Method
                    Course foundCourse = manager.searchCourse(searchCourseCode);

                    // Check if course is found
                    if (foundCourse != null) {
                        System.out.println("\nCourse found:\n");
                        // Display details of found course
                        manager.displayCourse(foundCourse);
                    } else {
                        System.out.println("\nCourse not found.");
                    }
                    break;
                case 3:
                    // Show recent searches (if any)
                    api.showRecentCourseSearches();

                    System.out.print("Enter course code to edit: ");
                    String editCode = sc.nextLine();
                    
                    // Add course code to recent searches cache
                    api.addRecentCourseSearch(editCode);

                    // Call Edit Course Method
                    manager.editCourse(editCode, sc);
                    break;
                case 4:
                    // Show recent searches (if any)
                    api.showRecentCourseSearches();

                    System.out.print("Enter course code to delete: ");
                    String deleteCode = sc.nextLine();
                    
                    // Add course code to recent searches cache
                    api.addRecentCourseSearch(deleteCode);

                    // Call Delete Course Method
                    manager.deleteCourse(deleteCode, sc);
                    break;
                case 5:
                    System.out.println("\n=== All Courses ===\n");
                    // Call View All Courses Method
                    manager.viewAllCourses();
                    break;
                case 6:
                    return;
            }
        }
    }

    // Student Management Menu
    public static void manageStudents(Scanner sc, StudentManager manager, SuggestionAPI api) {
        while (true) {
            System.out.println("\n=== Student Management Menu ===\n");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Edit Student");
            System.out.println("4. Delete Student");
            System.out.println("5. View All Students");
            System.out.println("6. Back");

            // Check choice if it is an integer and within range of 1 - 6
            int choice = getValidatedChoice(sc, 1, 6);

            switch (choice) {
                case 1:
                    // Call Add Student Method
                    manager.addStudent(sc);
                    break;
                case 2:
                    // Show recent searches (if any)
                    api.showRecentStudentSearches();

                    System.out.print("Enter student ID: ");
                    String tempId = sc.nextLine();

                    // Suggest student IDs based on input before finalization
                    api.suggestStudentList(tempId);

                    // Ask for final student ID to search
                    System.out.print("Confirm student ID: ");
                    String searchStudentId = sc.nextLine();

                    // Add student ID to recent searches cache
                    api.addRecentStudentSearch(searchStudentId);

                    // Call Search Student Method
                    Student foundStudent = manager.searchStudent(searchStudentId);

                    // Check if student is found
                    if (foundStudent != null) {
                        System.out.println("\nStudent found:\n");
                        // Display details of found student
                        manager.displayStudent(foundStudent);
                    } else {
                        System.out.println("\nStudent not found.");
                    }
                    break;
                case 3:
                    // Show recent searches (if any)
                    api.showRecentStudentSearches();

                    System.out.print("Enter student ID to edit: ");
                    String editId = sc.nextLine();
                    
                    // Add student ID to recent searches cache
                    api.addRecentStudentSearch(editId);

                    // Call Edit Student Method
                    manager.editStudent(editId, sc);
                    break;
                case 4:
                    // Show recent searches (if any)
                    api.showRecentStudentSearches();

                    System.out.print("Enter student ID to delete: ");
                    String deleteId = sc.nextLine();
                    
                    // Add student ID to recent searches cache
                    api.addRecentStudentSearch(deleteId);

                    // Call Delete Student Method
                    manager.deleteStudent(deleteId, sc);
                    break;
                case 5:
                    System.out.println("\n=== All Students ===\n");
                    // Call View All Students Method
                    manager.viewAllStudents();
                    break;
                case 6:
                    return;
            }
        }
    }

    // Enrollment Management Menu
    public static void manageEnrollments(Scanner sc, Enrollment em, SuggestionAPI api) {
        while (true) {
            System.out.println("\n=== Enrollment Management Menu ===\n");
            System.out.println("1. Add a course to a student");
            System.out.println("2. Add a student to a course");
            System.out.println("3. Find a student's course by student ID");
            System.out.println("4. List all courses enrolled by a student");
            System.out.println("5. Find a student in a course by course code");
            System.out.println("6. List all students enrolled in a course");
            System.out.println("7. Back");

            // Check choice if it is an integer and within range of 1 - 7
            int choice = getValidatedChoice(sc, 1, 7);

            switch (choice) {
                case 1:
                    // Call addCourse Method
                    em.addCourse();
                    break;
                case 2:
                    // Call addStudent Method
                    em.addStudent();
                    break;
                case 3:
                    // Show recent searches (if any)
                    api.showRecentStudentSearches();

                    System.out.print("Enter student ID: ");
                    String tempSearchId = sc.nextLine();

                    // Suggest student IDs based on input before finalization
                    api.suggestStudentList(tempSearchId);
                    
                    // Ask for final student ID to search
                    System.out.print("Confirm student ID: ");
                    String searchId = sc.nextLine();
                    
                    // Add student ID to recent searches cache
                    api.addRecentStudentSearch(searchId);

                    // Call findCourse Method
                    em.findCourse(searchId);
                    break;
                case 4:
                    // Show recent searches (if any)
                    api.showRecentStudentSearches();

                    System.out.print("Enter student ID: ");
                    String studentIdList = sc.nextLine();
                    
                    // Add student ID to recent searches cache
                    api.addRecentStudentSearch(studentIdList);

                    // Call listCourses Method
                    em.listCourses(studentIdList);
                    break;
                case 5:
                    // Show recent searches (if any)
                    api.showRecentCourseSearches();

                    System.out.print("Enter course code: ");
                    String tempSearchCode = sc.nextLine();

                    // Suggest course codes based on input before finalization
                    api.suggestCourseList(tempSearchCode);
                    
                    // Ask for final course code to search
                    System.out.print("Confirm course code: ");
                    String searchCode = sc.nextLine();
                    
                    // Add course code to recent searches cache
                    api.addRecentCourseSearch(searchCode);

                    // Call findStudent Method
                    em.findStudent(searchCode);
                    break;
                case 6:
                    // Show recent searches (if any)
                    api.showRecentCourseSearches();

                    System.out.print("Enter course code: ");
                    String courseCodeList = sc.nextLine();
                    
                    // Add course code to recent searches cache
                    api.addRecentCourseSearch(courseCodeList);

                    // Call listStudents Method
                    em.listStudents(courseCodeList);
                    break;
                case 7:
                    return;
            }
        }
    }
}

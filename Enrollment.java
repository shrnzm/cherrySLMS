package com.mycompany.slms;

import java.util.*;

class Enrollment {

    // Enrollment class attributes
    private String[] studentIDs = new String[500];
    private String[] courseCodes = new String[500];
    private int count = 0;
    private CourseManager courseManager;
    private StudentManager studentManager;
    private Scanner sc;
    private SuggestionAPI cacheAPI;

    // Constructor to connect managers and API
    public Enrollment(CourseManager cm, StudentManager sm, Scanner sc, SuggestionAPI cacheAPI) {
        this.courseManager = cm;
        this.studentManager = sm;
        this.sc = sc;
        this.cacheAPI = cacheAPI;
    }

    // Add a course to a student
    public void addCourse() {
        // Check if array is full
        if (count >= studentIDs.length) {
            System.out.println("\nEnrollment list is full.");
            return;
        }
        
        System.out.println();
        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();

        // Check if student exists
        if (studentManager.searchStudent(studentId) == null) {
            System.out.println("\nStudent not found.");
            return;
        }

        System.out.print("Enter Course Code: ");
        String courseCode = sc.nextLine();

        // Check if course exists
        if (courseManager.searchCourse(courseCode) == null) {
            System.out.println("\nCourse not found.");
            return;
        }

        // Check for duplicate
        for (int i = 0; i < count; i++) {
            if (studentIDs[i].equalsIgnoreCase(studentId) && courseCodes[i].equalsIgnoreCase(courseCode)) {
                System.out.println("\nStudent is already enrolled in this course.");
                return;
            }
        }

        studentIDs[count] = studentId.toUpperCase();
        courseCodes[count] = courseCode.toUpperCase();
        count++;

        cacheAPI.cacheStudent(studentId);
        cacheAPI.cacheCourse(courseCode);

        System.out.println("\nCourse successfully added to student.");
    }

    // Add a student to a course
    public void addStudent() {
        // Check if array is full
        if (count >= studentIDs.length) {
            System.out.println("\nEnrollment list is full.");
            return;
        }

        System.out.println();

        System.out.print("Enter Course Code: ");
        String courseCode = sc.nextLine();

        // Check if course exists
        if (courseManager.searchCourse(courseCode) == null) {
            System.out.println("\nCourse not found.");
            return;
        }

        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();

        // Check if student exists
        if (studentManager.searchStudent(studentId) == null) {
            System.out.println("\nStudent not found.");
            return;
        }

        // Check for duplicate
        for (int i = 0; i < count; i++) {
            if (studentIDs[i].equalsIgnoreCase(studentId) && courseCodes[i].equalsIgnoreCase(courseCode)) {
                System.out.println("\nStudent is already enrolled in this course.");
                return;
            }
        }

        studentIDs[count] = studentId.toUpperCase();
        courseCodes[count] = courseCode.toUpperCase();
        count++;

        cacheAPI.cacheStudent(studentId);
        cacheAPI.cacheCourse(courseCode);

        System.out.println("\nStudent successfully added to course.");
    }

    // Find a student's course based on student ID
    public void findCourse(String studentId) {
        for (int i = 0; i < count; i++) {
            if (studentIDs[i] != null && studentIDs[i].equalsIgnoreCase(studentId)) {
                System.out.println("\nCourse found: " + courseCodes[i]);
                return;
            }
        }
        System.out.println("\nNo course found for this student.");
    }

    // List all courses enrolled by a student
    public void listCourses(String studentId) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (studentIDs[i] != null && studentIDs[i].equalsIgnoreCase(studentId)) {
                if (!found) {
                    System.out.println("\nAll courses enrolled by student " + studentId + ":");
                    found = true;
                }
                System.out.println(" > " + courseCodes[i]);
            }
        }
        if (!found) {
            System.out.println("\nThis student has no enrolled courses.");
        }
    }

    // Find a student in a course based on course code
    public void findStudent(String courseCode) {
        for (int i = 0; i < count; i++) {
            if (courseCodes[i] != null && courseCodes[i].equalsIgnoreCase(courseCode)) {
                System.out.println("\nStudent found: " + studentIDs[i]);
                return;
            }
        }
        System.out.println("\nNo student found in this course.");
    }

    // List all students enrolled in a course
    public void listStudents(String courseCode) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (courseCodes[i] != null && courseCodes[i].equalsIgnoreCase(courseCode)) {
                if (!found) {
                    System.out.println("\nAll students enrolled in course " + courseCode + ":");
                    found = true;
                }
                System.out.println(" > " + studentIDs[i]);
            }
        }
        if (!found) {
            System.out.println("\nThis course has no students.");
        }
    }
}

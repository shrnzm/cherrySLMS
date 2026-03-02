/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.slms;

/**
 *
 * @author HP
 */
public class Course {

    private String courseName;
    private String courseCode;
    private int creditHour;
    private String courseSummary;
    private String msTeamsLink;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String name) {
        courseName = name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String code) {
        courseCode = code;
    }

    public int creditHour() {
        return creditHour;
    }

    public void setCreditHour(int hour) {
        creditHour = hour;
    }

    public String getCourseSummary() {
        return courseSummary;
    }

    public void setCourseSummary(String summary) {
        courseSummary = summary;
    }

    public String getMsTeamsLink() {
        return msTeamsLink;
    }

    public void setMsTeamsLink(String link) {
        msTeamsLink = link;
    }
}

class CourseManager {

    private Course[] courseArray = new Course[100];
    private int courseCount = 0;

    public void addCourse(Course course) {
        if (courseCount < courseArray.length) {
            courseArray[courseCount] = course;
            courseCount++;
            System.out.println("Course added successfully.");
        } else {
            System.out.println("Course list is full.");
        }
    }

    public Course searchCourse(String courseCode) {
        for (int i = 0; i < courseCount; i++) {
            if (courseArray[i].getCourseCode().equals(courseCode)) {
                return courseArray[i];
            }
        }
        return null;
    }

    public void editCourse(String courseCode, Scanner sc) {
        Course course = searchCourse(courseCode);

        if (course != null) {
            System.out.print("Enter new course name: ");
            course.setCourseName(sc.nextLine());

            System.out.print("Enter new credit hour: ");
            course.setCreditHour(Integer.parseInt(sc.nextLine()));

            System.out.print("Enter new summary: ");
            course.setCourseSummary(sc.nextLine());

            System.out.print("Enter new MS Teams link: ");
            course.setMsTeamsLink(sc.nextLine());

            System.out.println("Course updated successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    public void displayCourse(Course course) {
        if (course != null) {
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Credit Hour: " + course.creditHour());
            System.out.println("Summary: " + course.getCourseSummary());
            System.out.println("MS Teams Link: " + course.getMsTeamsLink());
        } else {
            System.out.println("Course not found.");
        }
    }
}

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CourseManager manager = new CourseManager();

        while (true) {

            System.out.println("\n1. Add Course");
            System.out.println("2. Search Course");
            System.out.println("3. Edit Course");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    Course newCourse = new Course();

                    System.out.print("Course Name: ");
                    newCourse.setCourseName(sc.nextLine());

                    System.out.print("Course Code: ");
                    newCourse.setCourseCode(sc.nextLine());

                    System.out.print("Credit Hour: ");
                    newCourse.setCreditHour(Integer.parseInt(sc.nextLine()));

                    System.out.print("Course Summary: ");
                    newCourse.setCourseSummary(sc.nextLine());

                    System.out.print("MS Teams Link: ");
                    newCourse.setMsTeamsLink(sc.nextLine());

                    manager.addCourse(newCourse);
                    break;

                case 2:
                    System.out.print("Enter Course Code to Search: ");
                    Course found = manager.searchCourse(sc.nextLine());
                    manager.displayCourse(found);
                    break;

                case 3:
                    System.out.print("Enter Course Code to Edit: ");
                    manager.editCourse(sc.nextLine(), sc);
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}

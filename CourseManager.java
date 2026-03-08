import java.util.*;

class CourseManager {
    private Course[] courseArray = new Course[100];
    private int courseCount = 0;

    public void addCourse(Scanner sc) {
        if (courseCount >= courseArray.length) {
            System.out.println("\nCourse list is full. Cannot add new course.");
            return;
        }
        Course newCourse = new Course();
        
        System.out.print("\nEnter Course Code: ");
        newCourse.setCourseCode(sc.nextLine());

        System.out.print("Enter Course Name: ");
        newCourse.setCourseName(sc.nextLine());

        int creditHour = -1;
        while (true) {
            System.out.print("Enter Credit Hour: ");
            String input = sc.nextLine();
            try {
                creditHour = Integer.parseInt(input);
                if (creditHour <= 0) {
                    System.out.println("Credit hour must be a positive integer.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer.");
            }
        }
        newCourse.setCreditHour(creditHour);

        System.out.print("Enter Course Summary: ");
        newCourse.setCourseSummary(sc.nextLine());

        System.out.print("Enter MS Teams Link: ");
        newCourse.setMsTeamsLink(sc.nextLine());

        courseArray[courseCount] = newCourse;
        courseCount++;
        System.out.println("\nCourse added successfully.");
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
            System.out.print("Enter New Course Name: ");
            course.setCourseName(sc.nextLine());

            int creditHour = -1;
            while (true) {
                System.out.print("Enter New Credit Hour (integer only): ");
                String input = sc.nextLine();
                try {
                    creditHour = Integer.parseInt(input);
                    if (creditHour <= 0) {
                        System.out.println("Credit hour must be a positive integer.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter an integer.");
                }
            }
            course.setCreditHour(creditHour);

            System.out.print("Enter New Summary: ");
            course.setCourseSummary(sc.nextLine());

            System.out.print("Enter New MS Teams link: ");
            course.setMsTeamsLink(sc.nextLine());

            System.out.println("\nCourse updated successfully.\nUpdated details:\n");
            displayCourse(course);
        } else {
            System.out.println("\nCourse not found.");
        }
    }
    
    public void deleteCourse(String courseCode, Scanner sc) {
        Course course = searchCourse(courseCode);

        if (course == null) {
            System.out.println("\nCourse not found.");
            return;
        }

        System.out.println("\nCourse found.\n");
        displayCourse(course);
        
        System.out.print("\nAre you sure you want to delete this course? (Y/N): ");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("N")) {
            System.out.println("Deletion cancelled.");
            return;
        }

        int index = -1;
        for (int i = 0; i < courseCount; i++) {
            if (courseArray[i].getCourseCode().equals(courseCode)) {
                index = i;
                break;
            }
        }
        
        for (int i = index; i < courseCount - 1; i++) {
            courseArray[i] = courseArray[i + 1];
        }

        courseArray[courseCount - 1] = null;
        courseCount--;
        System.out.println("\nCourse deleted successfully!\nUpdated course list:");
        viewAllCourses();
    }
    
    public void displayCourse(Course course) {
        if (course != null) {
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Credit Hour: " + course.creditHour());
            System.out.println("Summary: " + course.getCourseSummary());
            System.out.println("MS Teams Link: " + course.getMsTeamsLink());
        }
    }
    
    public void viewAllCourses() {
        if (courseCount == 0) {
            System.out.println("No courses available.");
            return;
        }
        for (int i = 0; i < courseCount; i++) {
            displayCourse(courseArray[i]);
            System.out.println("-------------------");
        }
    }
}

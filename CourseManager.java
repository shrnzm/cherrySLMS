import java.util.*;

class CourseManager {
    //Array to store Course objects
    private Course[] courseArray = new Course[100];
    private int courseCount = 0;

    //Add Course Method
    public void addCourse(Scanner sc) {
        //Check if array is full
        if (courseCount >= courseArray.length) {
            System.out.println("\nCourse list is full. Cannot add new course.");
            return;
        }
        
        //Create new Course object
        Course newCourse = new Course();
        
        System.out.print("\nEnter Course Code: ");
        newCourse.setCourseCode(sc.nextLine());

        System.out.print("Enter Course Name: ");
        newCourse.setCourseName(sc.nextLine());

        //Check that credit hour is an integer
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
        
        //Add new course to end of array
        courseArray[courseCount] = newCourse;
        courseCount++;
        System.out.println("\nCourse added successfully.");
    }
    
    //Search Course Method
    public Course searchCourse(String courseCode) {
            for (int i = 0; i < courseCount; i++) {
                if (courseArray[i].getCourseCode().equals(courseCode)) {
                    return courseArray[i];
                }
            }
            return null;
    }
    
    //Edit Course Method
    public void editCourse(String courseCode, Scanner sc) {
        Course course = searchCourse(courseCode);

        if (course == null) {
            System.out.println("\nCourse not found.");
            return;
        }

        System.out.println("\nCourse found.\n");
        
        //Display details of course to edit
        displayCourse(course);

        System.out.print("\nAre you sure you want to edit this course? (Y/N): ");
        String confirm = sc.nextLine();

        //Check for confirmation
        if (confirm.equalsIgnoreCase("N")) {
            System.out.println("Edit cancelled.");
            return;
        }
        
        //Enter new details of course
        System.out.print("Enter New Course Name: ");
        course.setCourseName(sc.nextLine());

        //Check that credit hour is an integer
        int creditHour = -1;
        while (true) {
            System.out.print("Enter New Credit Hour: ");
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

        System.out.print("Enter New MS Teams Link: ");
        course.setMsTeamsLink(sc.nextLine());

        System.out.println("\nCourse updated successfully.\nUpdated details:\n");

        //Display edited course details
        displayCourse(course);
    }
    
    //Delete Course Method
    public void deleteCourse(String courseCode, Scanner sc) {
        Course course = searchCourse(courseCode);

        if (course == null) {
            System.out.println("\nCourse not found.");
            return;
        }

        System.out.println("\nCourse found.\n");
        
        //Display details of course to delete
        displayCourse(course);
        
        System.out.print("\nAre you sure you want to delete this course? (Y/N): ");
        String confirm = sc.nextLine();
        
        //Check for confirmation
        if (confirm.equalsIgnoreCase("N")) {
            System.out.println("Deletion cancelled.");
            return;
        }
        
        //Find index of course to delete
        int index = -1;
        for (int i = 0; i < courseCount; i++) {
            if (courseArray[i].getCourseCode().equals(courseCode)) {
                index = i;
                break;
            }
        }
        
        //Shift all courses after deleted one to the left
        for (int i = index; i < courseCount - 1; i++) {
            courseArray[i] = courseArray[i + 1];
        }
        
        //Empty the last element in courseArray
        courseArray[courseCount - 1] = null;
        courseCount--;
        
        System.out.println("\nCourse deleted successfully!\nUpdated course list:");
        
        //Display all courses
        viewAllCourses();
    }
    
    //Display Course Method
    public void displayCourse(Course course) {
        if (course != null) {
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Credit Hour: " + course.creditHour());
            System.out.println("Summary: " + course.getCourseSummary());
            System.out.println("MS Teams Link: " + course.getMsTeamsLink());
        }
    }
    
    //View All Courses Method
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

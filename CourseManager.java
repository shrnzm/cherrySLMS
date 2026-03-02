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

class SLMS {

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

import java.util.*;

class SLMS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //Create manager object to manage courses 
        CourseManager manager = new CourseManager();
        
        //System menu
        while (true) {
            System.out.println("\n1. Add Course");
            System.out.println("2. Search Course");
            System.out.println("3. Edit Course");
            System.out.println("4. Delete Course");
            System.out.println("5. View All Courses");
            System.out.println("6. Exit");
            System.out.println();
            
            //Check that option is integer
            int choice = -1;
            while (true) {
                System.out.print("Choose option: ");
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
                    manager.addCourse(sc);
                    break;

                case 2:
                    System.out.print("Enter course code to search: ");
                    Course found = manager.searchCourse(sc.nextLine());
                    
                    //Check if course is found
                    if (found != null) {
                        System.out.println("\nCourse found.\n");
                        manager.displayCourse(found);
                    } else {
                        System.out.println("\nCourse not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter course code to edit: ");
                    manager.editCourse(sc.nextLine(), sc);
                    break;
                
                case 4:
                    System.out.print("Enter course code to delete: ");
                    manager.deleteCourse(sc.nextLine(), sc);
                    break;
                    
                case 5:
                    System.out.println("\n=== All Courses ===\n");
                    manager.viewAllCourses();
                    break;

                case 6:
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

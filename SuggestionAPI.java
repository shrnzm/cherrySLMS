import java.util.*;

public class SuggestionAPI {
    
    //List-based cache arrays to store student ID and course code
    private ArrayList<String> studentCache = new ArrayList<>();
    private ArrayList<String> courseCache = new ArrayList<>();

    //Store student ID
    public void cacheStudent(String id) {
        if (id != null && !id.isEmpty() && !studentCache.contains(id)) {
            studentCache.add(id);
        }
    }

    //Store course code
    public void cacheCourse(String code) {
        if (code != null && !code.isEmpty() && !courseCache.contains(code)) {
            courseCache.add(code);
        }
    }

    //Show all student suggestions (before input)
    public void showAllStudents() {
        if (studentCache.isEmpty()) {
            System.out.println("\n > No student suggestions available.");
            return;
        }

        System.out.println("\n--- Student Suggestions ---");
        for (String id : studentCache) {
            System.out.println(" > " + id);
        }
        System.out.println("---------------------------\n");
    }

    //Show all course suggestions (before input)
    public void showAllCourses() {
        if (courseCache.isEmpty()) {
            System.out.println("\n > No course suggestions available.");
            return;
        }

        System.out.println("\n--- Course Suggestions ---");
        for (String code : courseCache) {
            System.out.println(" > " + code);
        }
        System.out.println("--------------------------\n");
    }
}

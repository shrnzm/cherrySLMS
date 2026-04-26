package com.mycompany.slms;

class SuggestionAPI {
    // Cache arrays for student IDs and course codes
    private String[] cachedCourses = new String[100];
    private String[] cachedStudents = new String[100];

    private int courseCache = 0;
    private int studentCache = 0;

    // Define maximum number of items in recent search cache
    private static final int MAX_RECENT = 5;

    // Recent search arrays for student IDs and course codes
    private String[] recentCourseSearches = new String[100];
    private String[] recentStudentSearches = new String[100];

    private int recentCourse = 0;
    private int recentStudent = 0;

    // Add course code to cache
    public void cacheCourse(String code) {
        if (code == null) {
            return;
        }

        code = code.toUpperCase();

        if (isCourseCached(code)) {
            return;
        }

        if (!isCourseCached(code) && courseCache < cachedCourses.length) {
            cachedCourses[courseCache++] = code;
        }
    }

    // Check if course code is already in cache
    public boolean isCourseCached(String code) {
        for (int i = 0; i < courseCache; i++) {
            if (cachedCourses[i].equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    // Remove course from cache
    public void removeCourse(String courseCode) {
        for (int i = 0; i < courseCache; i++) {
            if (cachedCourses[i].equalsIgnoreCase(courseCode)) {

                // Shift array to the left
                for (int j = i; j < courseCache - 1; j++) {
                    cachedCourses[j] = cachedCourses[j + 1];
                }
                cachedCourses[courseCache - 1] = null;
                courseCache--;
                return;
            }
        }
    }

    // Suggest course codes based on input
    public void suggestCourseList(String code) {
        if (code == null) {
            return;
        }
        code = code.toUpperCase();

        System.out.println("\nDid you mean:");
        boolean found = false;

        for (int i = 0; i < courseCache; i++) {
            String c = cachedCourses[i];

            if (c != null && c.startsWith(code)) {
                System.out.println(" - " + c);
                found = true;
            }
        }

        if (!found) {
            System.out.println(" - No matches found.");
        }
    }

    // Show all course codes in cache
    public void showAllCourses() {
        System.out.println("\n--- Course Suggestions ---");
        if (courseCache == 0) {
            System.out.println(" > No course suggestions available.");
            return;
        }

        for (String c : cachedCourses) {
            System.out.println(" > " + c);
        }
    }

    // Add student ID to cache
    public void cacheStudent(String id) {
        if (id == null) {
            return;
        }

        id = id.toUpperCase();

        if (isStudentCached(id)) {
            return;
        }

        if (!isStudentCached(id) && studentCache < cachedStudents.length) {
            cachedStudents[studentCache++] = id;
        }
    }

    // Check if student ID is already in cache
    public boolean isStudentCached(String id) {
        for (int i = 0; i < studentCache; i++) {
            if (cachedStudents[i].equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    // Remove student from cache
    public void removeStudent(String studentId) {
        for (int i = 0; i < studentCache; i++) {
            if (cachedStudents[i].equalsIgnoreCase(studentId)) {

                // Shift array to the left
                for (int j = i; j < studentCache - 1; j++) {
                    cachedStudents[j] = cachedStudents[j + 1];
                }
                cachedStudents[studentCache - 1] = null;
                studentCache--;
                return;
            }
        }
    }

    // Suggest student IDs based on input
    public void suggestStudentList(String id) {
        if (id == null) {
            return;
        }
        id = id.toUpperCase();

        System.out.println("\nDid you mean:");
        boolean found = false;

        for (int i = 0; i < studentCache; i++) {
            String s = cachedStudents[i];

            if (s != null && s.startsWith(id)) {
                System.out.println(" - " + s);
                found = true;
            }
        }

        if (!found) {
            System.out.println(" - No matches found.");
        }
    }

    // Show all student IDs in cache
    public void showAllStudents() {
        System.out.println("\n--- Student Suggestions ---");
        if (studentCache == 0) {
            System.out.println(" > No student suggestions available.");
            return;
        }

        for (String s : cachedStudents) {
            System.out.println(" > " + s);
        }
    }

    // Add student ID to recent searches
    public void addRecentStudentSearch(String id) {
        if (id == null) {
            return;
        }

        id = id.toUpperCase();

        // Remove if already exists
        for (int i = 0; i < recentStudent; i++) {
            if (recentStudentSearches[i].equals(id)) {
                // Shift array to the left
                for (int j = i; j < recentStudent - 1; j++) {
                    recentStudentSearches[j] = recentStudentSearches[j + 1];
                }
                recentStudentSearches[--recentStudent] = null;
                break;
            }
        }

        if (recentStudent < recentStudentSearches.length) {
            recentStudentSearches[recentStudent++] = id;
        }
    }

    // Show up to 5 items in recent student searches
    public void showRecentStudentSearches() {
        System.out.println("\n--- Recent Searches ---");

        if (recentStudent == 0) {
            System.out.println(" > No recent searches available.");
            return;
        }

        int start = Math.max(0, recentStudent - MAX_RECENT);

        for (int i = recentStudent - 1; i >= start; i--) {
            System.out.println(" > " + recentStudentSearches[i]);
        }
    }

    // Add course code to recent searches
    public void addRecentCourseSearch(String code) {
        if (code == null) {
            return;
        }

        code = code.toUpperCase();

        // Remove if already exists
        for (int i = 0; i < recentCourse; i++) {
            if (recentCourseSearches[i].equals(code)) {
                // Shift array to the left
                for (int j = i; j < recentCourse - 1; j++) {
                    recentCourseSearches[j] = recentCourseSearches[j + 1];
                }
                recentCourseSearches[--recentCourse] = null;
                break;
            }
        }
        if (recentCourse < recentCourseSearches.length) {
            recentCourseSearches[recentCourse++] = code;
        }
    }

    // Show up to 5 items in recent student searches
    public void showRecentCourseSearches() {
        System.out.println("\n--- Recent Searches ---");

        if (recentCourse == 0) {
            System.out.println(" > No recent searches available.");
            return;
        }

        int start = Math.max(0, recentCourse - MAX_RECENT);

        for (int i = recentCourse - 1; i >= start; i--) {
            System.out.println(" > " + recentCourseSearches[i]);
        }
    }
}

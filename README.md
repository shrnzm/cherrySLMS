# Cherry Student Learning Management System (SLMS)

## Project Description
The Student Learning Management System (SLMS) is a modular, web-based system designed to manage students, courses, and course-student relationships. It allows administrators to input, search, edit, and delete course and student profiles, while also managing enrollments and relationships between courses and students. The system is built following pre-set software construction standards, including naming conventions, modularity, and error handling best practices.


---


## Features
### 1. Course Management
- Add, edit, and delete course profiles with attributes:
  - Course name (full)
  - Course code
  - Credit hours
  - Course summary
  - MS Teams link
- Search courses by course code
- Display all courses in a clear, organized format

### 2. Student Management
- Add, edit, and delete student profiles with attributes:
  - Student name (first and last)
  - Student ID
  - Email
  - Phone number
- Search students by student ID
- Display all students in a clear, organized format

### 3. Course–Student Relationship
- Assign students to courses and vice versa
- Find and list courses for a student
- Find and list students for a course
- Prevent duplicate assignments and handle unassigned students/courses

### 4. System Integration
- Integrated course and student modules
- Middleware API for caching and auto-suggesting input fields
- Clear input/output displays for all operations

### 5. Error Handling
- Handles invalid inputs and out-of-bound errors
- Displays informative messages for unsuccessful operations

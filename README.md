# Cherry Student Learning Management System (SLMS)

## Project Description
The Student Learning Management System (SLMS) is a modular, web-based system designed to manage students, courses, and course-student relationships. It allows administrators to input, search, edit, and delete course and student profiles, while also managing enrollments and relationships between courses and students. The system is built following pre-set software construction standards, including naming conventions, modularity, and error handling best practices.

📄 Full Project Report:  
[View the complete SLMS report](https://github.com/shrnzm/cherrySLMS/blob/2f1dee0a983e2909e6a3f1898591d7ef51ad770f/cherrySLMS_report.pdf)

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

---

## System Structure
The SLMS follows a modular, object-oriented design approach:
- Entity classes represent core system data (e.g. students, courses)
- Manager classes handle system operations and logic
- Responsibilities are clearly separated to improve maintainability

Detailed UML diagrams and design explanations are provided in the full report.

---

## Development Standards
This project follows consistent:
- Naming conventions  
- Code formatting rules  
- Modularity and encapsulation principles  

All standards and justifications are documented in the project report.

---

## Version Control
Version control and collaboration are managed using GitHub.

- Main branch: `main`
- Feature branches are used for development
- Pull requests and peer reviews are required before merging

---

## Getting Started
1. Clone the repository  
2. Open the project in your preferred IDE  
3. Refer to the full report for system design and implementation details

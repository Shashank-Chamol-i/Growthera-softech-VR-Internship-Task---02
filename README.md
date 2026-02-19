Student Management System
Overview
The Student Management System is a simple Java console application that allows users to manage student information. Users can add, view, update, and delete students. Each student has a unique ID, a name, and marks for five subjects.

This project demonstrates basic object-oriented programming (OOP) concepts, use of ArrayList, and user input handling in Java.

Features
Add Student
Input student name
Input marks for 5 subjects
Automatically assigns a unique ID
View Students
Display all students with ID, name, and subject marks
Update Student
Update a student by ID

Options to update:

Name only
Marks only
Both Name and Marks
Delete Student
Delete a student by ID
Automatically adjusts IDs of remaining students
Exit
Safely exits the application
Technologies Used
Java SE (Standard Edition)
Collections Framework (ArrayList)
Scanner class for input
Class Design
Student Class
Fields:

id: Unique student ID

name: Student name

marks[5]: Marks for 5 subjects

Methods:

addStudent(): Adds a new student

viewStudents(): Displays all students

updateStudent(int id): Menu to update a student

updateName(Student s): Updates name

updateMarks(Student s): Updates marks

deleteStudent(): Deletes a student

welcomePanel(): Main menu loop

How to Run
Ensure you have Java JDK installed.
Save the Student.java file in a folder structure matching the package: com/Student/.
Create a Main.java class to run the system:
package com.Student;

public class Main {
    public static void main(String[] args) {
        Student studentSystem = new Student();
        studentSystem.welcomePanel();
    }
}
Compile and run:
javac com/Student/Student.java com/Student/Main.java
java com.Student.Main
Example Usage
Welcome to the Student Management System....
Choose the options Given Below..
1 Add Students
2 View Students
3 Update Student
4 Delete Student
5 EXIT
Add a student by selecting 1
View all students with 2
Update student info by 3 and entering the student ID
Delete a student with 4
Exit with 5
Notes
Each student maintains a unique marks array, preventing data overwrite issues.
IDs are automatically updated after deletion.
The system uses console input for simplicity but can be extended with file storage or GUI.
Author
Created by: [Shashank Chamoli]
Date:19 February 2026

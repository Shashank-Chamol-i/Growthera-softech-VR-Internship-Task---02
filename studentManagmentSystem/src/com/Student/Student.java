package com.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private float[] marks;

    public Student(int id) {
        this.id = id;
        this.marks = new float[5];
    }

    public Student() {
        this.marks = new float[5];
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public float[] getMarks() { return marks; }
    public void setMarks(float[] marks) { this.marks = marks; }

    static Scanner sc = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();

    // Main Menu
    public void welcomePanel() {
        System.out.println("Welcome to the Student Management System....");
        boolean flag = true;
        while (flag) {
            System.out.println("\nChoose the options Given Below..");
            System.out.println("1 Add Students\n2 View Students\n3 Update Student\n4 Delete Student\n5 EXIT");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    System.out.println("Enter student Id : ");
                    int id = sc.nextInt();
                    updateStudent(id);
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select the Valid Option");
            }
        }
    }

    // Add Student
    private void addStudent() {
        Student s = new Student();
        System.out.println("Enter the Name of the Student:");
        String name = sc.next();
        s.setName(name);

        float[] marks = new float[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter the marks of subject " + (i + 1) + ":");
            marks[i] = sc.nextFloat();
        }
        s.setMarks(marks);

        s.setId(students.size() + 1);
        students.add(s);

        System.out.println("Student added Successfully..");
    }

    // View Students
    private void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No Students Available.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            System.out.println("ID: " + s.getId());
            System.out.println("Name: " + s.getName());
            float[] marks = s.getMarks();
            for (int i = 0; i < marks.length; i++) {
                System.out.print("Sub" + (i + 1) + ": " + marks[i] + "  ");
            }
            System.out.println("\n------------------");
        }
    }

    // Update Student Menu
    private void updateStudent(int id) {
        if (id <= 0 || id > students.size()) {
            System.out.println("Invalid Student Id.");
            return;
        }

        Student s = students.get(id - 1);

        while (true) {
            System.out.println("\nChoose the option to update:");
            System.out.println("1 Update Name");
            System.out.println("2 Update Marks");
            System.out.println("3 Update Name and Marks Both");
            System.out.println("4 Exit Update");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    updateName(s);
                    break;
                case 2:
                    updateMarks(s);
                    break;
                case 3:
                    updateName(s);
                    updateMarks(s);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Select valid Operation.");
            }
        }
    }

    // Update Name
    private void updateName(Student s) {
        System.out.println("Enter new name:");
        String newName = sc.next();
        s.setName(newName);
        System.out.println("Name updated Successfully.");
    }

    // Update Marks
    private void updateMarks(Student s) {
        System.out.println("Choose the Subject (1-5):");
        int subject = sc.nextInt();
        if (subject < 1 || subject > 5) {
            System.out.println("Invalid subject number!");
            return;
        }
        System.out.println("Enter the new marks:");
        float newMark = sc.nextFloat();
        float[] marks = s.getMarks();
        marks[subject - 1] = newMark;
        s.setMarks(marks);
        System.out.println("Marks updated Successfully.");
    }

    // Delete Student
    private void deleteStudent() {
        if (students.isEmpty()) {
            System.out.println("No students to delete.");
            return;
        }
        System.out.println("Enter Student ID to delete:");
        int id = sc.nextInt();
        if (id <= 0 || id > students.size()) {
            System.out.println("Invalid Student ID.");
            return;
        }
        students.remove(id - 1);

        // Adjust IDs after deletion
        for (int i = 0; i < students.size(); i++) {
            students.get(i).setId(i + 1);
        }
        System.out.println("Student deleted successfully.");
    }
}

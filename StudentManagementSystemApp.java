import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    char grade;

    // Constructor
    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
}

class StudentManagementSystem {
    ArrayList<Student> students;

    // Constructor
    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    // Add a student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Remove a student
    public void removeStudent(int rollNumber) {
        for (Student student : students) {
            if (student.rollNumber == rollNumber) {
                students.remove(student);
                System.out.println("Student removed successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Search for a student
    public void searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.rollNumber == rollNumber) {
                System.out.println("Student found:");
                System.out.println("Name: " + student.name);
                System.out.println("Roll Number: " + student.rollNumber);
                System.out.println("Grade: " + student.grade);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("List of all students:");
            for (Student student : students) {
                System.out.println("Name: " + student.name + ", Roll Number: " + student.rollNumber + ", Grade: " + student.grade);
            }
        }
    }
}

public class StudentManagementSystemApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            /*So with my little knowlegde of programming, i understand that the user might
            enter a wrong input so, I added a try-catch block to handle the InputMismatchException 
            and added scanner.nextLine() to consume the invalid input. This should help prevent the 
            program from crashing due to invalid input.
             */
            try {
                System.out.println("\nOptions:");
                System.out.println("1. Add a new student");
                System.out.println("2. Remove a student");
                System.out.println("3. Search for a student");
                System.out.println("4. Display all students");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.next();
                        System.out.print("Enter roll number: ");
                        int rollNumber = scanner.nextInt();
                        System.out.print("Enter grade: ");
                        char grade = scanner.next().charAt(0);

                        Student newStudent = new Student(name, rollNumber, grade);
                        system.addStudent(newStudent);
                        break;

                    case 2:
                        System.out.print("Enter roll number to remove: ");
                        int removeRollNumber = scanner.nextInt();
                        system.removeStudent(removeRollNumber);
                        break;

                    case 3:
                        System.out.print("Enter roll number to search: ");
                        int searchRollNumber = scanner.nextInt();
                        system.searchStudent(searchRollNumber);
                        break;

                    case 4:
                        system.displayAllStudents();
                        break;

                    case 5:
                        System.out.println("Exiting the application. Goodbye!");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
}
package stu;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
	static ArrayList<Student> students = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int choice;

        do {

            System.out.println("\n.....STUDENT MANAGEMENT SYSTEM.....");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

    }

    // 1. Add Student
    public static void addStudent() {
    	System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Department: ");
        String department = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        Student s = new Student(id, name, age, department, marks);
        students.add(s);
        System.out.println("Student added successfully!");
    }

    // 2. Display Students
    public static void displayStudents() {

        if (students.isEmpty()) {

            System.out.println("No student records found!");

        } else {

            for (Student s : students) {

                s.display();

            }
        }
    }

    // 3. Search Student
    public static void searchStudent() {
    	System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();
        boolean found = false;
        for (Student s : students) {
        	if (s.getId() == id) {
        		s.display();
        		found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    // 4. Update Student
    public static void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();

        boolean found = false;

        for (Student s : students) {

            if (s.getId() == id) {

                sc.nextLine();

                System.out.print("Enter New Name: ");
                s.setName(sc.nextLine());

                System.out.print("Enter New Age: ");
                s.setAge(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter New Department: ");
                s.setDepartment(sc.nextLine());

                System.out.print("Enter New Marks: ");
                s.setMarks(sc.nextDouble());

                System.out.println("Student updated successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    // 5. Delete Student
    public static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId() == id) {

                students.remove(i);

                System.out.println("Student deleted successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }
}
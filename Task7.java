
package java_projects;

public class Task7 {

    class Person {
        String name;
        int age;

        Person() {
            System.out.println("Person default constructor");
        }

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    class Employee extends Person {
        int empId;
        String department;

        Employee() {
            super();
            System.out.println("Employee default constructor");
        }

        Employee(String name, int age, int empId,
                 String department) {
            super(name, age);
            this.empId = empId;
            this.department = department;
        }

        void display() {
            System.out.println("Employee Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Employee ID: " + empId);
            System.out.println("Department: " + department);
        }
    }

    public static void main(String[] args) {
        Task7 t = new Task7();

        Task7.Employee e1 =
                t.new Employee("Arun", 24, 109, "IT");

        e1.display();
    }
}

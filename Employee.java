package oops;

import java.util.Scanner;

class Emp{
	int empid;
	String empname;
	double basicSalary;
	
	Emp(int id, String name , double salary){
		empid=id;
		empname=name;
		basicSalary=salary;
	}
	double calculateSalary() {
		return basicSalary;
	}
	public void display() {
		System.out.println("Employee ID : " + empid);
		System.out.println("Employee name : "+empname);
		System.out.println("Basic Salary : "+basicSalary);
		System.out.println("Final Salary: " +calculateSalary());
	}
	
	
}
class Manager extends Emp{
	Manager(int id,String name,double salary){
		super(id,name,salary);
	}
	@Override
	double calculateSalary() {
		double hra = basicSalary * 0.20;
        double bonus = basicSalary * 0.15;
        double tax = basicSalary * 0.05;
        return basicSalary + hra + bonus - tax;
	}
}
class Developer extends Emp{
	Developer(int id,String name,double salary){
		super(id,name,salary);
	}
	@Override
	double calculateSalary() {
		double hra = basicSalary * 0.15;
        double bonus = basicSalary * 0.10;
        double tax = basicSalary * 0.05;
        return basicSalary + hra + bonus - tax;
	}
	
}
class Intern extends Emp{
	Intern(int id,String name,double salary){
		super(id,name,salary);
	}
	@Override
	double calculateSalary() {
		double allowance = basicSalary * 0.05;
        double deduction = basicSalary * 0.02;
        return basicSalary + allowance - deduction;

	}
}
public class Employee {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Manager");
		System.out.println("2. Developer");
		System.out.println("3. Intern ");
		System.out.println("4.Exit");
		System.out.println("Choose Employee type : ");
		int choice=sc.nextInt();
		
		System.out.println("Enter Employee Id : ");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Employee Name : ");
		String name=sc.nextLine();
		System.out.print("Enter Basic Salary: ");
        double salary = sc.nextDouble();
        
        Emp emp = null;
        switch(choice) {
        case 1:
        	emp=new Manager(id,name,salary);
        	break;
        case 2:
            emp = new Developer(id, name, salary);
            break;
        case 3:
            emp = new Intern(id, name, salary);
            break;
        case 4:
            System.out.println("Exiting the program...");
            sc.close();
            return;
        default:
            System.out.println("Invalid employee type!");
        }
        System.out.println("....Employee Details....");
        emp.display();
	}
}

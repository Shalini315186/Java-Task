package java_projects;
import java.util.*;

public class task2 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int a=10;
		int b=20;
		int c=10;
		
		System.out.println("...Operators....");
		
		System.out.println("1...Arithmetic Operators..");
		
		System.out.println("Addition of two numbers : " + (a+b));
		System.out.println("Substraction of two numbers : " + (b-a));
		System.out.println("Multiplication of two number : " + (a*b));
		System.out.println("Division of two numbers : " + (b/a));
		System.out.println("Modulus of two numbers : " + (a%b));
		System.out.println("..................................................");
		System.out.println("2.Logical operator");
		System.out.println("...AND operator.. " );
		if ((5 * 2 == 10) && (2 * 5 == 10)) {
		    System.out.println("true");
		} else {
		    System.out.println("false");
		}
		
		System.out.println("...OR Operator...");
		
		if ((5*2==15)||(2*5==10)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		System.out.println("...NOT Operator...");
		if (a!=b) {
			System.out.println("yes a is not equal to b ");
		}else {
			System.out.println("a and b is equal.");
		}
		System.out.println("..................................................");
		System.out.println("3.Ternary Operator ");
		
		System.out.println("Multiplication of 10*20 = " + (a*b==200 ? "200" : "400") );
		System.out.println("..................................................");
		System.out.println("4.Relational Operator");
		
		if(a>b) {
			System.out.println("a is greater than b");
		}else if(a<b) {
			System.out.println(" a is less than b ");
		}else if(a>=b) {
			System.out.println("a is greater than equal to b");
		}else if(a<=b) {
			System.out.println("a is less than equal to b");
		}else if(a==c) {
			System.out.println(" a is equal to c");
		}else if(a!=b) {
			System.out.println(" a is not equal to b ");
		}
		
		System.out.println("..................................................");
		System.out.println("5.Increment and Decrement Operator");
		
		System.out.println("pre Increment  : " + ++a);
		System.out.println("post Increment  : " + a++);
		System.out.println("pre Decrement  : " + --a);
		System.out.println("post Decrement " + a--);
		System.out.println("..................................................");
		System.out.println("6.Assignment Operator");
		
		System.out.println("a += 5 : " + (a += 5));
		System.out.println("a -= 3 : " + ( a -= 3));
		System.out.println("a *= 2 : " +(a *= 2));
		System.out.println("a /= 4 : " +(a /= 4));
		System.out.println("a %= 4 : " +(a %= 4));
		
		
		System.out.println("..................................................");
		System.out.println("swaping of two numbers using temp ");
		
		int i=10;
		int j=20;
		int temp;
		
		temp=i;
		i=j;
		j=temp;
		
		System.out.println("i = " + i);
		System.out.println("j = " + j);
		
		System.out.println("..................................................");
		System.out.println("swaping of two numbers without using temp ");
		
		int r=2;
		int t=3;
		
		r=r+t;
		t=r-t;
		r=r-t;
		
		System.out.println("r = " + r);
		System.out.println("t = " + t);
		
		System.out.println("..................................................");
		System.out.println("Student Details  ");
		System.out.println("........................");
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter the student name : ");
		String name=s.nextLine();
		
		
		System.out.println("Enter your class here:");
	    String className = s.nextLine();
	    
	    System.out.println("Enter the mark1 : ");
	    int mark1=s.nextInt();
	    
	    System.out.println("Enter the mark2 : ");
	    int mark2=s.nextInt();
	    
	    System.out.println("Enter the mark3 : ");
	    int mark3=s.nextInt();
	    
	    int total=mark1+mark2+mark3;
	    System.out.println("Total Marks : " + total);
	    
	    double avg=total/3;
	    System.out.println("Average Marks : " + avg);
	    
	    String grade = null;
	    if(avg>90) {
	    	  grade = "O Grade";
	    }else if(avg>75 && avg<=90) {
	    	grade = "A Grade";
	    }else if(avg>50 && avg<=75) {
	    	grade = "B Grade";
	    }else if(avg>=35) {
	    	grade = "Pass";
	    }else if(avg<35) {
	    	grade = "Fail";
	    }
	  
	    
	    System.out.println(".......................................................................................................................");
	    System.out.printf("%-15s %-10s %-10s %-10s %-10s %-10s %-15s %-10s%n " ,"Name","class","Mark1","Mark2","Mark3","Total","Average","Grade" );
	    System.out.println(".........................................................................................................................");
	    System.out.printf("%-15s %-10s %-10s %-10s %-10s %-10s %-15s  %-10s%n" ,name,className,mark1,mark2,mark3,total,avg,grade);
	    System.out.println(".........................................................................................................................");
	    System.out.println("Name of the Student : " +name );
	    System.out.println("your class is : " + className);
	    System.out.println("your First Mark : " + mark1);
	    System.out.println("your Second Mark : " + mark2);
	    System.out.println("your Third Mark : " + mark3);
	    System.out.println("your Total is :  " + total);
	    System.out.println("your average is : " + avg);
	    System.out.println("Grade: " + grade);
	    
	    
	  
	    System.out.println("..................................................");
		System.out.println("Employee Details  ");
		System.out.println("........................");



		System.out.println("Enter the employee name: ");
		String empname = s.next();
		s.nextLine();
		System.out.println("Enter the employee id: ");
		int empid = s.nextInt();
		s.nextLine();
		
		System.out.println("Enter the employee department: ");
		String empdept = s.nextLine();

		System.out.println("Enter the year of Experiences : ");
		int year=s.nextInt();

		System.out.println("Enter the Employee Designation: ");
		String empdesignation = s.next();

		System.out.println("Enter your Basic Salary: ");
		double basicsalary = s.nextDouble();
		
		double increment = 0;
		double bonus = 0;
		
		if(year>=3 && empdesignation.equalsIgnoreCase("developer")) {
			bonus = basicsalary * 0.05;
			increment=basicsalary*0.05;
		}
		if (year >= 5 && empdept.equalsIgnoreCase("Tester")) {
		    increment = basicsalary * 0.10;
		    bonus = basicsalary * 0.05;
		}

		
		double hra = basicsalary * 0.20;
        double da = basicsalary * 0.10;
        double grosspay = basicsalary + hra + da;
        double pfAmount = basicsalary * 0.12;
        double netPay = grosspay - pfAmount;
        double finalSalary = netPay + increment + bonus;
        
        System.out.println("..................................................");
		System.out.println("Employee Details  ");
		System.out.println("........................");
//        
        System.out.println("your Employee ID is : "+empid);
        System.out.println("your Employee name is :"+empname);
        System.out.println("your Department is : " + empdept);
        System.out.println("your year of experience is  : " +year);
        System.out.println("your designations is : " + empdesignation);
        System.out.println("your basicsalary is : " + basicsalary);
        System.out.println("your grosspay is : " + grosspay);
        System.out.println("your pfAmount is : "+pfAmount);
        System.out.println("your netPay is  :  "+ netPay);
        System.out.println("Increment : " + increment);
        System.out.println("Bonus : " + bonus);
        System.out.println("Final Salary : " + finalSalary);
        System.out.println("..................................................");
        System.out.println("..EbBill...");
        System.out.println("..................................................");
        System.out.println("Enter the consumer id : ");
        int consumerid=s.nextInt();
        
        System.out.println("Enter the Consumer name : ");
        String consumername=s.next();
        
        System.out.println("Enter the type of Building : ");
        String typeofbuilding=s.next();
        
        System.out.println("Enter the previous unit : ");
        double previous_unit=s.nextDouble();
        
        System.out.println("Enter the current unit : ");
        double current_unit=s.nextDouble();
        
        double units = current_unit - previous_unit;
        double rate = 0;
        double billAmount = 0;
        double concession = 0;
        
        if(typeofbuilding.equalsIgnoreCase("home")) {
        	rate=3.0;
        	billAmount=units*rate;
        	concession=billAmount*0.20;
        	billAmount=billAmount-concession;
        }else if(typeofbuilding.equalsIgnoreCase("shop")) {
        	rate=8.0;
        	billAmount=units*rate;
        } else {
            System.out.println("Invalid building type!");
        }
        
        if (typeofbuilding.equalsIgnoreCase("home")
                || typeofbuilding.equalsIgnoreCase("shop")) {

        
        System.out.println("Enter the consumer name : " +consumername);
        System.out.println("Enter the consumer id : "+consumerid);
        System.out.println("Enter the type of Building : " +typeofbuilding);
        System.out.println("Enter the previous unit : " +previous_unit);
        System.out.println("Enter the current unit : "+current_unit);
        System.out.println("Units Consumed : " + units);
        System.out.println("Rate per Unit : " + rate);
        System.out.println("Concession : " + concession);
        System.out.println("EB Bill Amount : " + billAmount);
        }
        
        System.out.println("..................................................");
        
        System.out.println("Login Program...");
        
        System.out.println("..................................................");
        
        System.out.println("Enter the User name : ");
        String user=s.nextLine();
        s.nextLine();
        System.out.println("Enter password:");
        String password = s.nextLine();

        System.out.println("Enter phone number:");
        String phone = s.nextLine();
        
        if (user.equals("abcde")
        		&& password.contains(".*[^a-zA-Z0-9].*")
                && phone.matches("[0-9]{10}")) {

            System.out.println("Login successful");
            System.out.println("You are eligible to login");

        } else {
            System.out.println("Login failed");
            System.out.println("You are not eligible to login");
        }
        
        System.out.println("..................................................");
        
        System.out.println("Loan Program");
        
        System.out.println("..................................................");
        
        
        System.out.println("Enter the name of the loan person : ");
        String customer=s.nextLine();
        
        System.out.println("Are you a salaried person? (yes/no):");
        String salaried = s.nextLine();
        
        System.out.println("Enter your salary : ");
        double salary=s.nextDouble();
        
        System.out.println("Enter your cbil score : ");
        String cibil=s.next();
        
        boolean eligible = true;
        
    	
        if (!salaried.equalsIgnoreCase("yes")) {
            System.out.println("You are not a salaried person.");
            eligible = false;
        }
        
        if (salary <= 30000) {
            System.out.println("Your salary must be greater than 30000.");
            eligible = false;
        }
        
        if (!cibil.equalsIgnoreCase("good")) {
            System.out.println("Your CIBIL score is not good.");
            eligible = false;
        }
        
        if (eligible) {
            System.out.println(customer
                    + ", you are eligible to apply for a loan.");
        } else {
            System.out.println(customer
                    + ", you are not eligible based on these conditions.");
        }
        
        
        
        
        
        
        
        
	    
        
	    
	    
		
		
		
		
	}

	
}

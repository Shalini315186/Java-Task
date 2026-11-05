package java_projects;

import java.util.Iterator;
import java.util.Scanner;
public class Task5_nonstaticMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		1.student details
		

		        Scanner sc = new Scanner(System.in);

		        // Input student & subject count
		        System.out.print("Enter number of students: ");
		        int students = sc.nextInt();

		        System.out.print("Enter number of subjects: ");
		        int subjects = sc.nextInt();

		        int[][] marks = new int[students][subjects];
		        int[] totals = new int[students];
		        double[] averages = new double[students];
		        char[] grades = new char[students];

		        // Input marks with validation
		        for (int i = 0; i < students; i++) {
		            System.out.println("\nEnter marks for Student " + (i + 1));
		            int total = 0;

		            for (int j = 0; j < subjects; j++) {
		                while (true) {
		                    System.out.print("Subject " + (j + 1) + ": ");
		                    int mark = sc.nextInt();

		                    if (mark >= 0 && mark <= 100) 
				{
		                        marks[i][j] = mark;
		                        total += mark;
		                        break;
		                    } else 
				{
		                        System.out.println("Invalid! Enter marks between 0 and 100.");
		                    }
		                }
		            }

		            totals[i] = total;
		            averages[i] = total / (double) subjects;

		            // Grade calculation
		            if (averages[i] >= 90)
		                grades[i] = 'A';
		            else if (averages[i] >= 75)
		                grades[i] = 'B';
		            else if (averages[i] >= 60)
		                grades[i] = 'C';
		            else if (averages[i] >= 50)
		                grades[i] = 'D';
		            else
		                grades[i] = 'F';
		        }

		        // Find topper
		        int topperIndex = 0;
		        for (int i = 1; i < students; i++) {
		            if (totals[i] > totals[topperIndex]) {
		                topperIndex = i;
		            }
		        }

		         int lowerIndex = 0;
		        for (int i = 1; i < students; i++) {
		            if (totals[i] <totals[lowerIndex]) {
		                lowerIndex = i;
		            }
		        }

		        // Final Report
		        System.out.println("\n===== FINAL REPORT =====");
		        System.out.print("Student\t");
		        for (int j = 0; j < subjects; j++) {
		            System.out.print("Sub" + (j + 1) + "\t");
		        }
		        System.out.println("Total\tAvg\tGrade");

		        for (int i = 0; i < students; i++) {
		            System.out.print((i + 1) + "\t");

		            for (int j = 0; j < subjects; j++) {
		                System.out.print(marks[i][j] + "\t");
		            }

		            System.out.println(totals[i] + "\t" + averages[i] + "\t" + grades[i]);
		        }

		        // Display topper
		        System.out.println("\nTopper: Student " + (topperIndex + 1));
		        System.out.println("Total Marks: " + totals[topperIndex]);
		        System.out.println("Average: " + averages[topperIndex]);
		        System.out.println("Grade: " + grades[topperIndex]);
		        
//		        display lower
		        System.out.println("\nLower : Student " + (lowerIndex + 1));
		        System.out.println("Total Marks: " + totals[lowerIndex]);
		        System.out.println("Average: " + averages[lowerIndex]);
		        System.out.println("Grade: " + grades[lowerIndex]);

//		        2.Employee
		        
		        
		       System.out.println("Enter the number of Employees : ");
		       int employees=sc.nextInt();
		       
		       System.out.println("Enter the number of Months :  ");
		       int month=sc.nextInt();
		       
		       sc.nextLine();
		       
		       String[] names=new String[employees];
		       int[][] salary = new int[employees][month];
		       
		       for (int i = 0; i <employees; i++) {
				System.out.println("\n Enter the Employee name : ");
				names[i]=sc.nextLine();
				
				System.out.println("Enter the salary details for : " +names[i]);
				
				for (int j = 0; j < month; j++) {
					System.out.println("Month " + (j+1) + "salary : ");
					salary[i][j]=sc.nextInt();
				}
				sc.nextLine();
			}
		    int highestEmployee=0;
		    int highestMonth=0;
		    
		    for (int i = 0; i < employees; i++) {
				for(int j=0;j<month;j++) {
					if(salary[i][j]>salary[highestEmployee][highestMonth]) {
						highestEmployee=i;
						highestMonth=j;
					}
				}
			}
		    
		    int lowestEmployee=0;
		    int lowestMonth=0;
		    
		    for(int i=0;i<employees;i++) {
		    	for(int j=0;j<month;j++) {
		    		if(salary[i][j]< salary[lowestEmployee][lowestMonth]) {
		    			
		    			lowestEmployee=i;
		    			lowestMonth=j;
		    		}
		    		
		    	}
		    }
		    
		    System.out.println("....Employee Salary Report......");
		    System.out.printf("%-20s" , "Employee name  \t");
		    for(int j=0;j<month;j++) {
		    	System.out.printf("%-15s","Month " +(j+1)+"\t");
		    }
		    System.out.println();
		    


	        for (int i = 0; i < employees; i++) {

	            System.out.printf("%-20s",names[i]);

	            for (int j = 0; j < month; j++) {

	                System.out.printf("%-15d",salary[i][j]);
	            }

	            System.out.println();
	        }
	        
	        System.out.println("....Highest salary....");
	        System.out.println("Employee name : " +names[highestEmployee]);
	        System.out.println("Salary : "+salary[highestEmployee][highestMonth]);
	        System.out.println("Month: " + (highestMonth + 1));
	        
	        System.out.println("\n...Lowest salary...");
	        System.out.println("Employee Name: " + names[lowestEmployee]);
	        System.out.println("Salary: " + salary[lowestEmployee][lowestMonth]);
	        System.out.println("Month: " + (lowestMonth + 1));
	        
//	        3.Temperature Reading for Multiple Patients
	        
	        System.out.println("Enter the number of patients : ");
	        int patients=sc.nextInt();
	        
	        System.out.println("Enter the temperature reading : ");
	        int readings=sc.nextInt();
	        
	        double[][] temperature=new double[patients][readings];
	        double[] avg=new double[patients];
	        
	        for(int i=0;i<patients;i++) {
	        	System.out.println("\n Enter the temperature readings for patients " + (i+1));
	        	double total=0;
	        	
	        	for(int j=0;j<readings;j++) {
	        		System.out.println("Readings " + (j+1) + " : ");
	        		temperature[i][j]=sc.nextDouble();
	        		total=total+temperature[i][j];
	        		
	        	}
	        	avg[i]=total/readings;
	        }
	        
	        System.out.println("\n .....Patient Temperature Report.....");
	        System.out.printf("%-15s","Patients");
	        for(int j=0;j<readings;j++) {
	        	System.out.printf("%-15s","Reading" +(j+1));
	        }
	        System.out.printf("%-15s%-15s%-20s%n","Average", "Condition", "Status");
	        for(int i=0;i<patients;i++) {
	        	System.out.printf("%-15s", "Patient " + (i + 1));
	        	for(int j=0;j<readings;j++) {
	        		System.out.printf("%-15.1f", temperature[i][j]);
	        	}
	        	String condition;
	        	String status;
	        	
	        	if(avg[i]>=38.0) {
	        		condition="Fever";
	        		status="Need review";
	        	}else {
	        		condition="No review";
	        		status = "Review as needed";
	        	}
	        	System.out.printf("%-15.2f%-15s%-20s%n",averages[i], condition, status);
	        }

	}

}

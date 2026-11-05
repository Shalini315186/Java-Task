package java_projects;

import java.util.Scanner;

public class task4_looping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
//		1.print the tables
		
		System.out.println("Enter the n value : ");
		int num=sc.nextInt();
		
		for (int i = 1; i <=10; i++) {
			
			System.out.println(i+" * " + num + " = "+num*i);
		}
		
//		2.pattern program using numbers 
//		1
		
		System.out.println("...Number Program..");

	int n = 5;

	for (int i = 1; i <= n; i++) {

    // Number 1
    for (int j = 1; j <= n; j++) {
        if (j == 3 || (i == 5) || (i == 2 && j == 2)) {
            System.out.print("1 ");
        } else {
            System.out.print("  ");
        }
    }

    System.out.print("     ");
//    2
    for (int j = 1; j <= n; j++) {
        if (i == 1 || i == 5 || j == n - i + 1) {
            System.out.print("2 ");
        } else {
            System.out.print("  ");
        }
    }
    System.out.print("     ");
    
//  3  
    for (int j = 1; j <= n; j++) {
        if (i == 1 || i==n || i==3 || j==n) {
            System.out.print("3 ");
        } else {
            System.out.print("  ");
        }
    }
    System.out.print("     ");
    
//    4
    
    for (int j = 1; j <= n; j++) {
        if (j == n - i || i==n-1 || j==n ) {
            System.out.print("4 ");
        } else {
            System.out.print("  ");
        }
    }
    System.out.print("     ");
//   5 
    
    for (int j = 1; j <= n; j++) {
        if (i==1 || (i<=n/2 && j==1) || i==3 || (j>=n/2 && i==4 &&j==5 )  || i==n) {
            System.out.print("5 ");
        } else {
            System.out.print("  ");
        }
    }
    
    
    System.out.println();
}

	

		
//		3.electricity bill for 6 months and display the total bill
	
	System.out.println("Enter the number of months here : ");
	int month=sc.nextInt();
	double total=0;
	
	for (int i = 1; i <=month; i++) {
		System.out.println("For month " + i + " :");
		double bill=sc.nextDouble();
		total+=bill;
	}
	
	System.out.println("Total electricity bill : " + total);
	
		
//		4.star pattern program
	
	System.out.println("");
	
 System.out.println("star pattern program");
	
//	s
	
	
	
	int nu = 5;

	for (int i = 1; i <= nu; i++) {

    // Number 1
    for (int j = 1; j <= nu; j++) {
        if (i==1 || (i<=nu/2 && j==1) || i==3 || (j>=nu/2 && i==4 &&j==5 )  || i==nu) {
            System.out.print("* ");
        } else {
            System.out.print("  ");
        }
    }
    System.out.print("     ");
    
//    H
    
    for (int j = 1; j <= nu; j++) {
        if (j==1 || j==n || i==nu/2 +1) {
            System.out.print("* ");
        } else {
            System.out.print("  ");
        }
    }
    
    System.out.print("     ");
    
//    A
    for (int j = 1; j <= nu; j++) {
        if (j==1 || i==1 || j==nu ||  i==nu/2 +1) {
            System.out.print("* ");
        } else {
            System.out.print("  ");
        }
    }
    System.out.print("     ");
    
//  L
  for (int j = 1; j <= nu; j++) {
      if (j==1 || i==nu) {
          System.out.print("* ");
      } else {
          System.out.print("  ");
      }
  } 
  System.out.print("     ");
  
//  I
  
  for (int j = 1; j <= nu; j++) {
    if (i==1 || j==nu/2 +1 || i==nu) {
        System.out.print("* ");
    } else {
        System.out.print("  ");
    }
}
  System.out.print("     ");
//  N
  for (int j = 1; j <= nu; j++) {
	    if (j==1 || i==j || j==nu) {
	        System.out.print("* ");
	    } else {
	        System.out.print("  ");
	    }
	}
  System.out.print("     "); 
  
//  I
  for (int j = 1; j <= nu; j++) {
	    if (i==1 || j==nu/2 +1 || i==nu) {
	        System.out.print("* ");
	    } else {
	        System.out.print("  ");
	    }
	}
    
   System.out.println();
	}
    
//    5.check the number is prime or not
	
	System.out.println("Enter your number here : ");
	int number=sc.nextInt();
	
	boolean flag=true;
	
	if(number==1 || number==0) {
		flag=false;}
	else {
		for (int i=2;i< number;i++) {
		
			 if (number % i == 0) {
		            flag = false;
		            break;
		        }
			
		}
		}
	
		System.out.println(flag ? "prime" :"not prime");
		
//  6.check the number is palindrome or not
		
		System.out.println("Enter your number here to check palindrome : ");
		int palindrome=sc.nextInt();
		
		
		int rev=0;
		int temp=palindrome;
		
		while(palindrome>0) {
			rev=(rev*10)+(palindrome%10);
			palindrome=palindrome/10;
		}
		System.out.println(rev==temp ? "The number is palindrome" : "the number is not palindrome");
		
		
//		7.guess the number
		
		int secretNumber = 7;
        int guess;
        boolean correct = false;
        
        for (int i = 1; i <= 3; i++) {
        	System.out.println("Attempt " + i + " of 3");
            System.out.print("Guess the number (1-10): ");
            guess = sc.nextInt();

            if (guess == secretNumber) {
                System.out.println("Correct! You won.");
                correct = true;
                break;
            } else {
                System.out.println("Wrong guess!");
            }
        }  
        if (correct == false) {
            System.out.println("Failed! The correct number was " + secretNumber);
        }
		

	}

}

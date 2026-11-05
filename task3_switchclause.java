package java_projects;

import java.util.Scanner;

public class task3_switchclause {
 public static void main(String[] args) {
	 
	 Scanner sc=new Scanner(System.in);
//	1.calculator program
	 
	 
	 System.out.println("1.Addition");
	 System.out.println("2.Substraction");
	 System.out.println("3.Multiplication");
	 System.out.println("4.Division");
	 System.out.println("Enter your choice : ");
	 int choice = sc.nextInt();
	 
	 System.out.println("Enter the first value : ");
	 double a=sc.nextDouble();
	 
	 System.out.println("Enter the second value : ");
	 double b=sc.nextDouble();
	 switch (choice) {
	case 1:
		System.out.println("Addition : " + (a + b));
		break;
		
	case 2:
        System.out.println("Subtraction : " + (a - b));
        break;

    case 3:
        System.out.println("Multiplication : " + (a * b));
        break;

    case 4:
        if (b != 0) {
            System.out.println("Division : " + (a / b));
        } else {
            System.out.println("Cannot divide by zero");
        }
        break;

	default:
		System.out.println("Invalid choice");
		break;
	}
	 
//	 2.leap year and no of days in month
	 
	 System.out.println("Enter the month number (1-12): ");
     int month = sc.nextInt();

     System.out.println("Enter the year: ");
     int year = sc.nextInt();
     
     switch (month) {
     case 1:
     case 3:
     case 5:
     case 7:
     case 8:
     case 10:
     case 12:
         System.out.println("Number of days: 31");
         break;

     case 4:
     case 6:
     case 9:
     case 11:
         System.out.println("Number of days: 30");
         break;

     case 2:
         if (year % 400 == 0 ||
             (year % 4 == 0 && year % 100 != 0)) {

             System.out.println("It is a leap year");
             System.out.println("Number of days: 29");

         } else {
             System.out.println("It is not a leap year");
             System.out.println("Number of days: 28");
         }
         break;

     default:
         System.out.println("Invalid month number");
         break;
 }
     
//     atm machine
     
     double balance = 5000;
     int choices;

     do {
         System.out.println("\n===== ATM MACHINE =====");
         System.out.println("1. Deposit");
         System.out.println("2. View Balance");
         System.out.println("3. Withdraw");
         System.out.println("4. Transfer Funds");
         System.out.println("5. Exit");

         System.out.println("Enter your choice: ");
         choices = sc.nextInt();

         switch (choices) {

             case 1:
                 System.out.println("Enter deposit amount: ");
                 double deposit = sc.nextDouble();

                 if (deposit > 0) {
                     balance = balance + deposit;
                     System.out.println("Deposit successful!");
                     System.out.println("Current balance: " + balance);
                 } else {
                     System.out.println("Invalid deposit amount");
                 }
                 break;

             case 2:
                 System.out.println("Your balance is: " + balance);
                 break;

             case 3:
                 System.out.println("Enter withdrawal amount: ");
                 double withdraw = sc.nextDouble();

                 if (withdraw > 0 && withdraw <= balance) {
                     balance = balance - withdraw;
                     System.out.println("Withdrawal successful!");
                     System.out.println("Remaining balance: " + balance);
                 } else {
                     System.out.println("Invalid amount or insufficient balance");
                 }
                 break;

             case 4:
                 System.out.println("Enter transfer amount: ");
                 double transfer = sc.nextDouble();

                 if (transfer > 0 && transfer <= balance) {
                     balance = balance - transfer;
                     System.out.println("Fund transferred successfully!");
                     System.out.println("Remaining balance: " + balance);
                 } else {
                     System.out.println("Invalid amount or insufficient balance");
                 }
                 break;

             case 5:
                 System.out.println("Thank you for using the ATM!");
                 break;

             default:
                 System.out.println("Invalid choice. Please try again.");
                 break;
         }
     }while (choices != 5);
         
//         4.Resort Room Booking...
         
         
         System.out.println("===== RESORT ROOM BOOKING =====");
         System.out.println("1. Standard Room - Rs.2000 per day");
         System.out.println("2. Deluxe Room - Rs.3500 per day");
         System.out.println("3. Suite Room - Rs.5000 per day");

         System.out.println("Select your room type:");
         int room = sc.nextInt();

         System.out.println("Select number of days:");
         System.out.println("1. 1 Day");
         System.out.println("2. 2 Days");
         System.out.println("3. 3 Days");
         int days = sc.nextInt();

         int price = 0;
         int total = 0;

         switch (room) {

             case 1:
                 price = 2000;
                 System.out.println("Standard Room Selected");

                 switch (days) {
                     case 1:
                         total = price * 1;
                         break;
                     case 2:
                         total = price * 2;
                         break;
                     case 3:
                         total = price * 3;
                         break;
                     default:
                         System.out.println("Invalid number of days");
                         break;
                 }
                 break;

             case 2:
                 price = 3500;
                 System.out.println("Deluxe Room Selected");

                 switch (days) {
                     case 1:
                         total = price * 1;
                         break;
                     case 2:
                         total = price * 2;
                         break;
                     case 3:
                         total = price * 3;
                         break;
                     default:
                         System.out.println("Invalid number of days");
                         break;
                 }
                 break;

             case 3:
                 price = 5000;
                 System.out.println("Suite Room Selected");

                 switch (days) {
                     case 1:
                         total = price * 1;
                         break;
                     case 2:
                         total = price * 2;
                         break;
                     case 3:
                         total = price * 3;
                         break;
                     default:
                         System.out.println("Invalid number of days");
                         break;
                 }
                 break;

             default:
                 System.out.println("Invalid room type");
                 break;
         }

         if (room >= 1 && room <= 3 && days >= 1 && days <= 3) {
             System.out.println("Number of days: " + days);
             System.out.println("Total booking amount: Rs." + total);
             System.out.println("Room booked successfully!");
         }


     
     
     }
}

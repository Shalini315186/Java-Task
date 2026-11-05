package cab;

import java.util.Scanner;

interface CabBooking
{
 void bookRide();
 void calculateFare();
}


class Customer
{
 String customerName;
 double distance;

 Customer(String customerName, double distance)
 {
     this.customerName = customerName;
     this.distance = distance;
 }
}

// 1. MiniCab 
class MiniCab extends Customer implements CabBooking
{
 MiniCab(String name, double distance)
 {
     super(name, distance);
 }

 public void bookRide()
 {
     System.out.println("Mini Cab Booked Successfully!");
     System.out.println("Customer Name: " + customerName);
     System.out.println("Distance: " + distance + " KM");
 }

 public void calculateFare()
 {
     double fare = distance * 20;
     System.out.println("Mini Cab Fare: Rs." + fare);
 }
}

//2.Auto
class AutoCab extends Customer implements CabBooking
{
 AutoCab(String name, double distance)
 {
     super(name, distance);
 }

 public void bookRide()
 {
     System.out.println("Auto Cab Booked Successfully!");
     System.out.println("Customer Name: " + customerName);
     System.out.println("Distance: " + distance + " KM");
 }

 public void calculateFare()
 {
     double fare = distance * 15;
     System.out.println("Auto Cab Fare: Rs." + fare);
 }
}

// 3. Sedan
class SedanCab extends Customer implements CabBooking
{
 SedanCab(String name, double distance)
 {
     super(name, distance);
 }

 public void bookRide()
 {
     System.out.println("Sedan Cab Booked Successfully!");
     System.out.println("Customer Name: " + customerName);
     System.out.println("Distance: " + distance + " KM");
 }

 public void calculateFare()
 {
     double fare = distance * 25;
     System.out.println("Sedan Cab Fare: Rs." + fare);
 }
}

//Main class
public class CabBookingSystem
{
 public static void main(String[] args)
 {
     Scanner sc = new Scanner(System.in);

     int choice;

     while(true)
     {
         System.out.println("\n.......CAB BOOKING SYSTEM.......");
         System.out.println("1. Mini Cab");
         System.out.println("2. Auto Cab");
         System.out.println("3. Sedan Cab");
         System.out.println("4. Exit");

         System.out.print("Enter your choice: ");
         choice = sc.nextInt();

         if(choice == 4)
         {
             System.out.println("Thank you for using Cab Booking System!");
             break;
         }

         if(choice < 1 || choice > 4)
         {
             System.out.println("Invalid Choice! Try Again.");
             continue;
         }

         sc.nextLine();

         System.out.print("Enter Customer Name: ");
         String name = sc.nextLine();

         System.out.print("Enter Distance in KM: ");
         double distance = sc.nextDouble();

         if(distance <= 0)
         {
             System.out.println("Distance must be greater than zero!");
             continue;
         }

         CabBooking cab;

         switch(choice)
         {
             case 1:
                 cab = new MiniCab(name, distance);
                 break;

             case 2:
                 cab = new AutoCab(name, distance);
                 break;

             case 3:
                 cab = new SedanCab(name, distance);
                 break;

             default:
                 System.out.println("Invalid Choice!");
                 continue;
         }

         cab.bookRide();
         cab.calculateFare();
     }
 }
}

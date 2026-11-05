
package oops;

import java.util.Scanner;

class Car {

    String name;
    long phoneNumber;
    String brand;

    Car(String name, long phoneNumber, String brand) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.brand = brand;
    }

    void display() {
        System.out.println("\n----- CUSTOMER DETAILS -----");
        System.out.println("Customer Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Car Brand: " + brand);
    }

    double calculateAmount() {
        return 0;
    }
}

// Hourly rental
class Hours extends Car {

    int hours;
    double carRate = 200;

    Hours(String name, long phoneNumber, String brand, int hours) {
        super(name, phoneNumber, brand);
        this.hours = hours;
    }

    @Override
    double calculateAmount() {
        return carRate * hours;
    }

    void displayDetails() {
        System.out.println("\nRental Type: Hourly");
        System.out.println("Rental Hours: " + hours);
        System.out.println("Car Rate Per Hour: Rs." + carRate);
        System.out.println("Car Rental Cost: Rs." + calculateAmount());
    }
}

// Daily rental
class Days extends Car {

    int days;
    double carRate = 2000;

    Days(String name, long phoneNumber, String brand, int days) {
        super(name, phoneNumber, brand);
        this.days = days;
    }

    @Override
    double calculateAmount() {
        return carRate * days;
    }

    void displayDetails() {
        System.out.println("\nRental Type: Daily");
        System.out.println("Rental Days: " + days);
        System.out.println("Car Rate Per Day: Rs." + carRate);
        System.out.println("Car Rental Cost: Rs." + calculateAmount());
    }
}

// Driver details and charges
class Driver extends Car {

    boolean driverNeeded;
    double hourlyDriverRate = 500;
    double dailyDriverRate = 1000;

    Driver(String name, long phoneNumber, String brand,
           boolean driverNeeded) {

        super(name, phoneNumber, brand);
        this.driverNeeded = driverNeeded;
    }

    double calculateDriverCharge(int duration, int choice) {

        if (!driverNeeded) {
            return 0;
        }

        if (choice == 1) {
            return hourlyDriverRate * duration;
        } else {
            return dailyDriverRate * duration;
        }
    }

    void displayDriver() {
        System.out.println("Driver Needed: "
                + (driverNeeded ? "Yes" : "No"));
    }
}


public class Car_Rental_program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== CAR RENTAL MENU =====");
            System.out.println("1. Rent by Hours");
            System.out.println("2. Rent by Days");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 3) {
                System.out.println(
                        "Thank you for using our service!");
                sc.close();
                return;
            }

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice! Try again.");
                continue;
            }

            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            System.out.print("Enter phone number: ");
            long phone = sc.nextLong();
            sc.nextLine();

            System.out.print("Enter car brand: ");
            String brand = sc.nextLine();

            System.out.print("Do you need a driver? (yes/no): ");
            String answer = sc.nextLine();

            boolean needed = answer.equalsIgnoreCase("yes");

            int duration;
            double carCost;

            if (choice == 1) {

                System.out.print("Enter rental hours: ");
                duration = sc.nextInt();

                if (duration <= 0) {
                    System.out.println(
                            "Hours must be greater than zero.");
                    continue;
                }

                Hours h = new Hours(
                        name, phone, brand, duration);

                h.display();
                h.displayDetails();

                carCost = h.calculateAmount();

            } else {

                System.out.print("Enter rental days: ");
                duration = sc.nextInt();

                if (duration <= 0) {
                    System.out.println(
                            "Days must be greater than zero.");
                    continue;
                }

                Days d = new Days(
                        name, phone, brand, duration);

                d.display();
                d.displayDetails();

                carCost = d.calculateAmount();
            }

            Driver driver = new Driver(
                    name, phone, brand, needed);

            driver.displayDriver();

            double driverCost =
                    driver.calculateDriverCharge(duration, choice);

            double total = carCost + driverCost;

            System.out.println("Driver Charge: Rs." + driverCost);
            System.out.println("------------------------------");
            System.out.println("TOTAL RENTAL COST: Rs." + total);
            System.out.println("------------------------------");

            System.out.println("Rental completed!");
        }
    }
}

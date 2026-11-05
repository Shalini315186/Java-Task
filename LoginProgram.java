package oops;

import java.util.Scanner;

class Login{
	void login(String username, String password) {
        if (username.equals("admin") && password.equals("1234")) {
            System.out.println("Login successful using Username!");
        } else {
            System.out.println("Invalid username or password!");
        }
    }



	void login(int id, String password) {
    if (id == 101 && password.equals("1234")) {
        System.out.println("Login successful using ID!");
    } else {
        System.out.println("Invalid ID or password!");
    }
}

	void login(long mobileNumber, String password) {
    if (mobileNumber == 9876543210L
            && password.equals("1234")) {
        System.out.println("Login successful using Mobile Number!");
    } else {
        System.out.println("Invalid mobile number or password!");
    }
}
}

public class LoginProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
        Login obj = new Login();
        System.out.println("...Login Program....");
        System.out.println("1. Login using Username");
        System.out.println("2. Login using ID");
        System.out.println("3. Login using Mobile Number");
        System.out.println("4.Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
        case 1:
        	 System.out.print("Enter username: ");
             String username = sc.nextLine();
             System.out.print("Enter password: ");
             String password1 = sc.nextLine();
             obj.login(username, password1);
             break;
        case 2:
        	 System.out.print("Enter ID: ");
             int id = sc.nextInt();
             sc.nextLine();
             System.out.print("Enter password: ");
             String password2 = sc.nextLine();
             obj.login(id, password2);
             break;
             
        case 3:
        	System.out.print("Enter mobile number: ");
            long mobile = sc.nextLong();
            sc.nextLine();
            System.out.print("Enter password: ");
            String password3 = sc.nextLine();
            obj.login(mobile, password3);
            break;
        case 4:
            System.out.println("Thank you! Exiting the login program.");
            sc.close();
            return;
        default:
            System.out.println("Invalid choice!");
        }
		}

	}

}

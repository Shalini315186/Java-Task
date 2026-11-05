package oops;

import java.util.Scanner;

class Bank{
	double balance=1000.0;
	String history="";
	
	void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }
     balance = balance + amount;
     history = history + "Cash Deposit: Rs." + amount + "\n";
     System.out.println("Cash deposit successful!");
     System.out.println("Deposited Amount: Rs." + amount);
     System.out.println("Available Balance: Rs." + balance);
}
	void deposit(double amount, String chequeNumber) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }
        balance = balance + amount;
        history = history + "Cheque Deposit: Rs." + amount+ ", Cheque Number: " + chequeNumber + "\n";
        System.out.println("Cheque deposit successful!");
        System.out.println("Cheque Number: " + chequeNumber);
        System.out.println("Deposited Amount: Rs." + amount);
        System.out.println("Available Balance: Rs." + balance);
	}
	void deposit(double amount, String upiId, String bankName) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }
        balance = balance + amount;
        history = history + "UPI Deposit: Rs." + amount+ ", UPI ID: " + upiId+ ", Bank: " + bankName + "\n";
        System.out.println("UPI deposit successful!");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Bank Name: " + bankName);
        System.out.println("Deposited Amount: Rs." + amount);
        System.out.println("Available Balance: Rs." + balance);
}
	 void withdraw(double amount) {
	        if (amount <= 0) {
	            System.out.println("Enter a valid withdrawal amount!");
	        } else if (amount > balance) {
	            System.out.println("Insufficient balance!");
	        } else {
	            balance = balance - amount;
	            history = history + "Withdrawal: Rs." + amount + "\n";

	            System.out.println("Withdrawal successful!");
	            System.out.println("Withdrawn Amount: Rs." + amount);
	            System.out.println("Available Balance: Rs." + balance);
	        }
	    }
	 void checkBalance() {
	        System.out.println("Available Balance: Rs." + balance);
	    }
	 void showHistory() {
		 System.out.println("...Transaction History....");
		 if (history.isEmpty()) {
	            System.out.println("No transactions yet!");
	        } else {
	            System.out.println(history);
	        }
		 System.out.println("Current Balance: Rs." + balance);
	 }
}
class BankingProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        while (true) {
            System.out.println("\n....SMART BANK....");
            System.out.println("1. Deposit Cash");
            System.out.println("2. Deposit by Cheque");
            System.out.println("3. Deposit by UPI");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: Rs.");
                    double cash = sc.nextDouble();
                    sc.nextLine();

                    bank.deposit(cash);
                    break;

                case 2:
                    System.out.print("Enter amount: Rs.");
                    double chequeAmount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter cheque number: ");
                    String chequeNumber = sc.nextLine();

                    bank.deposit(chequeAmount, chequeNumber);
                    break;

                case 3:
                    System.out.print("Enter amount: Rs.");
                    double upiAmount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter UPI ID: ");
                    String upiId = sc.nextLine();

                    System.out.print("Enter bank name: ");
                    String bankName = sc.nextLine();

                    bank.deposit(upiAmount, upiId, bankName);
                    break;

                case 4:
                    System.out.print("Enter withdrawal amount: Rs.");
                    double withdrawal = sc.nextDouble();
                    sc.nextLine();

                    bank.withdraw(withdrawal);
                    break;

                case 5:
                    bank.checkBalance();
                    break;

                case 6:
                    bank.showHistory();
                    break;

                case 7:
                    System.out.println("Thank you for using Smart Bank!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
	}

}

package Payment;

import java.util.ArrayList;
import java.util.Scanner;

public class PaymentManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static PaymentGateway payment;

    static ArrayList<Transaction> transactions =
            new ArrayList<>();

    static int transactionId = 1001;

    public static void main(String[] args) {

        int choice;

        while (true) {

            System.out.println("\n........................................");
            System.out.println("        PAYMENT SYSTEM");
            System.out.println("............................................");

            System.out.println("1. UPI Payment");
            System.out.println("2. Credit Card Payment");
            System.out.println("3. Debit Card Payment");
            System.out.println("4. Net Banking");
            System.out.println("5. Wallet Payment");
            System.out.println("6. View Payment Details");
            System.out.println("7. Transaction History");
            System.out.println("8. Refund Payment");
            System.out.println("9. Payment Dashboard");
            System.out.println("10. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    upiPayment();
                    break;

                case 2:
                    creditCardPayment();
                    break;

                case 3:
                    debitCardPayment();
                    break;

                case 4:
                    netBankingPayment();
                    break;

                case 5:
                    walletPayment();
                    break;

                case 6:
                    viewPaymentDetails();
                    break;

                case 7:
                    transactionHistory();
                    break;

                case 8:
                    refundPayment();
                    break;

                case 9:
                    paymentDashboard();
                    break;

                case 10:
                    System.out.println("\nThank you for using PaySphere!");
                    sc.close();
                    return;

                default:
                    System.out.println("\nInvalid Choice! Try Again.");
            }
        }
    }

   

    static void upiPayment() {

        System.out.print("\nEnter UPI ID: ");
        String upiId = sc.nextLine();

        if (!upiId.matches("[A-Za-z0-9._-]+@[A-Za-z0-9.-]+")) {
            System.out.println("Invalid UPI ID!");
            return;
        }

        System.out.print("Enter UPI balance: ");
        double balance = sc.nextDouble();

        if (balance < 0) {
            System.out.println("Invalid balance!");
            return;
        }

        payment = new UPIPayment(upiId, balance);

        processPayment("UPI");
    }

    

    static void creditCardPayment() {

        System.out.print("\nEnter Card Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter 16-digit Card Number: ");
        String cardNumber = sc.nextLine();

        if (!cardNumber.matches("[0-9]{16}")) {
            System.out.println("Invalid Card Number!");
            return;
        }

        System.out.print("Enter Credit Limit: ");
        double limit = sc.nextDouble();

        if (limit < 0) {
            System.out.println("Invalid Credit Limit!");
            return;
        }

        payment = new CreditCardPayment(name, cardNumber, limit);

        processPayment("Credit Card");
    }

   

    static void debitCardPayment() {

        System.out.print("\nEnter Card Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter 16-digit Card Number: ");
        String cardNumber = sc.nextLine();

        if (!cardNumber.matches("[0-9]{16}")) {
            System.out.println("Invalid Card Number!");
            return;
        }

        System.out.print("Enter Bank Balance: ");
        double balance = sc.nextDouble();

        if (balance < 0) {
            System.out.println("Invalid balance!");
            return;
        }

        payment = new DebitCardPayment(name, cardNumber, balance);

        processPayment("Debit Card");
    }

  

    static void netBankingPayment() {

        System.out.print("\nEnter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        String accountNumber = sc.nextLine();

        if (accountNumber.isEmpty()) {
            System.out.println("Invalid Account Number!");
            return;
        }

        System.out.print("Enter Bank Balance: ");
        double balance = sc.nextDouble();

        if (balance < 0) {
            System.out.println("Invalid balance!");
            return;
        }

        payment = new NetBankingPayment(
                name, accountNumber, balance);

        processPayment("Net Banking");
    }

   

    static void walletPayment() {

        System.out.print("\nEnter Wallet Name: ");
        String walletName = sc.nextLine();

        System.out.print("Enter Mobile Number: ");
        String mobileNumber = sc.nextLine();

        if (!mobileNumber.matches("[0-9]{10}")) {
            System.out.println("Invalid Mobile Number!");
            return;
        }

        System.out.print("Enter Wallet Balance: ");
        double balance = sc.nextDouble();

        if (balance < 0) {
            System.out.println("Invalid balance!");
            return;
        }

        payment = new WalletPayment(
                walletName, mobileNumber, balance);

        processPayment("Wallet");
    }

    

    static void processPayment(String method) {

        System.out.print("Enter payment amount: ");
        double amount = sc.nextDouble();

        payment.makePayment(amount);

        if (isPaymentSuccessful()) {

            System.out.println("\nWas the payment successful? YES");

            Transaction transaction = new Transaction(
                    transactionId++,
                    method,
                    amount,
                    payment
            );

            transactions.add(transaction);

            System.out.println("Transaction Added Successfully!");
            System.out.println("Transaction ID: "
                    + transaction.getTransactionId());

        } else {

            System.out.println("\nWas the payment successful? NO");
            System.out.println("Transaction Not Added!");
        }
    }

    

    static boolean isPaymentSuccessful() {

        return payment.getLastPaymentStatus();
    }

   

    static void viewPaymentDetails() {

        if (payment == null) {
            System.out.println("\nNo Payment Details Available!");
            return;
        }

        payment.displayPaymentDetails();
    }

   

    static void transactionHistory() {

        System.out.println("\n.........TRANSACTION HISTORY........");

        if (transactions.isEmpty()) {
            System.out.println("No Transactions Found!");
            return;
        }

        for (Transaction t : transactions) {
            t.displayTransaction();
            System.out.println("--------------------------------");
        }
    }

   

    static void refundPayment() {

        if (transactions.isEmpty()) {
            System.out.println("\nNo Transactions Available for Refund!");
            return;
        }

        System.out.println("\n..........REFUND PAYMENT...........");

        Transaction selected = null;

        for (int i = transactions.size() - 1; i >= 0; i--) {

            Transaction t = transactions.get(i);

            if (!t.isRefunded()) {
                selected = t;
                break;
            }
        }

        if (selected == null) {
            System.out.println("No Refundable Transactions Found!");
            return;
        }

        selected.getPayment().refund(selected.getAmount());

        selected.setRefunded(true);

        System.out.println("Refund Completed!");
        System.out.println("Transaction ID: "
                + selected.getTransactionId());
        System.out.println("Refund Amount: Rs."
                + selected.getAmount());
    }

   

    static void paymentDashboard() {

        int totalTransactions = transactions.size();
        int successfulPayments = 0;
        int refundedPayments = 0;
        double totalAmount = 0;

        for (Transaction t : transactions) {

            totalAmount += t.getAmount();

            if (t.isRefunded()) {
                refundedPayments++;
            } else {
                successfulPayments++;
            }
        }

        System.out.println("\n..........PAYMENT DASHBOARD.........");

        System.out.println("Total Transactions: " + totalTransactions);

        System.out.println("Successful Payments: " + successfulPayments);

        System.out.println("Refunded Payments: " + refundedPayments);

        System.out.println("Total Payment Volume: Rs." + totalAmount);
    }
}
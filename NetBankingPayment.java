package Payment;

public class NetBankingPayment implements PaymentGateway {

    private String accountHolderName;
    private String accountNumber;
    private double bankBalance;
    private boolean lastPaymentStatus = false;

    public NetBankingPayment(String accountHolderName, String accountNumber,double bankBalance) {

        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.bankBalance = bankBalance;
    }

    @Override
    public void makePayment(double amount) {

        lastPaymentStatus = false;

        if (amount > 0 && amount <= bankBalance) {

            bankBalance -= amount;
            lastPaymentStatus = true;

            System.out.println("\nNet Banking Payment Successful!");
            System.out.println("Paid Amount: Rs." + amount);

        } else {
            System.out.println("\nInsufficient Bank Balance or Invalid Amount!");
        }
    }

    @Override
    public void refund(double amount) {

        if (amount > 0) {

            bankBalance += amount;
            System.out.println("Net Banking Refund Successful!");

        } else {
            System.out.println("Invalid Refund Amount!");
        }
    }

    @Override
    public void displayPaymentDetails() {

        System.out.println("\nNet Banking Details");
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Bank Balance: Rs." + bankBalance);
    }

    @Override
    public boolean getLastPaymentStatus() {
        return lastPaymentStatus;
    }
}
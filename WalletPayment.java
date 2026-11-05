package Payment;

public class WalletPayment implements PaymentGateway {

    private String walletName;
    private String mobileNumber;
    private double walletBalance;
    private boolean lastPaymentStatus = false;

    public WalletPayment(String walletName, String mobileNumber,double walletBalance) {

        this.walletName = walletName;
        this.mobileNumber = mobileNumber;
        this.walletBalance = walletBalance;
    }

    @Override
    public void makePayment(double amount) {

        lastPaymentStatus = false;

        if (amount > 0 && amount <= walletBalance) {

            walletBalance -= amount;
            lastPaymentStatus = true;

            System.out.println("\nWallet Payment Successful!");
            System.out.println("Paid Amount: Rs." + amount);

        } else {
            System.out.println("\nInsufficient Wallet Balance or Invalid Amount!");
        }
    }

    @Override
    public void refund(double amount) {

        if (amount > 0) {

            walletBalance += amount;
            System.out.println("Wallet Refund Successful!");

        } else {
            System.out.println("Invalid Refund Amount!");
        }
    }

    @Override
    public void displayPaymentDetails() {

        System.out.println("\nWallet Details");
        System.out.println("Wallet Name: " + walletName);
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Wallet Balance: Rs." + walletBalance);
    }

    @Override
    public boolean getLastPaymentStatus() {
        return lastPaymentStatus;
    }
}
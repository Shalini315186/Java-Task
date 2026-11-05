package Payment;


public class UPIPayment implements PaymentGateway {

    private String upiId;
    private double upiBalance;
    private boolean lastPaymentStatus = false;

    public UPIPayment(String upiId, double upiBalance) {
        this.upiId = upiId;
        this.upiBalance = upiBalance;
    }

    @Override
    public void makePayment(double amount) {

        lastPaymentStatus = false;

        if (amount > 0 && amount <= upiBalance) {

            upiBalance -= amount;
            lastPaymentStatus = true;

            System.out.println("\nUPI Payment Successful!");
            System.out.println("Paid Amount: Rs." + amount);

        } else {
            System.out.println("\nInsufficient UPI Balance or Invalid Amount!");
        }
    }

    @Override
    public void refund(double amount) {

        if (amount > 0) {
            upiBalance += amount;
            System.out.println("UPI Refund Successful!");
        } else {
            System.out.println("Invalid Refund Amount!");
        }
    }

    @Override
    public void displayPaymentDetails() {

        System.out.println("\nUPI Payment Details");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Available Balance: Rs." + upiBalance);
    }

    @Override
    public boolean getLastPaymentStatus() {
        return lastPaymentStatus;
    }
}
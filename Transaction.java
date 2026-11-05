package Payment;

public class Transaction {

    private int transactionId;
    private String paymentMethod;
    private double amount;
    private String status;
    private boolean refunded;
    private PaymentGateway payment;

    public Transaction(int transactionId, String paymentMethod,double amount, PaymentGateway payment) {

        this.transactionId = transactionId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.payment = payment;
        this.status = "Successful";
        this.refunded = false;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public boolean isRefunded() {
        return refunded;
    }

    public PaymentGateway getPayment() {
        return payment;
    }

    public void setRefunded(boolean refunded) {
        this.refunded = refunded;

        if (refunded) {
            status = "Refunded";
        }
    }

    public void displayTransaction() {

        System.out.println("\nTransaction ID: " + transactionId);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Amount: Rs." + amount);
        System.out.println("Status: " + status);
    }
}
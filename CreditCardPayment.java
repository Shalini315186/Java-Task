package Payment;

public class CreditCardPayment implements PaymentGateway {

    private String cardHolderName;
    private String cardNumber;
    private double creditLimit;
    private double usedCredit;
    private boolean lastPaymentStatus = false;

    public CreditCardPayment(String cardHolderName, String cardNumber,double creditLimit) {

        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.creditLimit = creditLimit;
        this.usedCredit = 0;
    }

    @Override
    public void makePayment(double amount) {

        lastPaymentStatus = false;

        if (amount > 0 && amount <= (creditLimit - usedCredit)) {

            usedCredit += amount;
            lastPaymentStatus = true;

            System.out.println("\nCredit Card Payment Successful!");
            System.out.println("Paid Amount: Rs." + amount);

        } else {
            System.out.println("\nCredit Limit Exceeded or Invalid Amount!");
        }
    }

    @Override
    public void refund(double amount) {

        if (amount > 0 && amount <= usedCredit) {

            usedCredit -= amount;
            System.out.println("Credit Card Refund Successful!");

        } else {
            System.out.println("Invalid Refund Amount!");
        }
    }

    @Override
    public void displayPaymentDetails() {

        System.out.println("\nCredit Card Details");
        System.out.println("Card Holder: " + cardHolderName);
        System.out.println("Card Number: XXXX-XXXX-XXXX-" +
                cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Credit Limit: Rs." + creditLimit);
        System.out.println("Used Credit: Rs." + usedCredit);
        System.out.println("Available Credit: Rs." +
                (creditLimit - usedCredit));
    }

    @Override
    public boolean getLastPaymentStatus() {
        return lastPaymentStatus;
    }
}
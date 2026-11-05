package Payment;

public class DebitCardPayment implements PaymentGateway {

    private String cardHolderName;
    private String cardNumber;
    private double bankBalance;
    private boolean lastPaymentStatus = false;

    public DebitCardPayment(String cardHolderName, String cardNumber,double bankBalance) {

        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.bankBalance = bankBalance;
    }

    @Override
    public void makePayment(double amount) {

        lastPaymentStatus = false;

        if (amount > 0 && amount <= bankBalance) {

            bankBalance -= amount;
            lastPaymentStatus = true;

            System.out.println("\nDebit Card Payment Successful!");
            System.out.println("Paid Amount: Rs." + amount);

        } else {
            System.out.println("\nInsufficient Bank Balance or Invalid Amount!");
        }
    }

    @Override
    public void refund(double amount) {

        if (amount > 0) {

            bankBalance += amount;
            System.out.println("Debit Card Refund Successful!");

        } else {
            System.out.println("Invalid Refund Amount!");
        }
    }

    @Override
    public void displayPaymentDetails() {

        System.out.println("\nDebit Card Details");
        System.out.println("Card Holder: " + cardHolderName);
        System.out.println("Card Number: XXXX-XXXX-XXXX-" +
                cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Bank Balance: Rs." + bankBalance);
    }

    @Override
    public boolean getLastPaymentStatus() {
        return lastPaymentStatus;
    }
}
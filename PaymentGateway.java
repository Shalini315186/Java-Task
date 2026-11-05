package Payment;

public interface PaymentGateway {
	void makePayment(double amount);
	void refund(double amount);
	void displayPaymentDetails();
	boolean getLastPaymentStatus();

}

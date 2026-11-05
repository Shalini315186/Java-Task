package Hospital;


class Billing {

    private int billId;
    private int patientId;
    private double consultationFee;
    private double roomCharges;
    private double medicineCharges;
    private double totalAmount;
    private double paidAmount;
    private String paymentStatus;

    public Billing(int billId, int patientId,
                   double consultationFee, double roomCharges,
                   double medicineCharges) {

        this.billId = billId;
        this.patientId = patientId;
        setConsultationFee(consultationFee);
        setRoomCharges(roomCharges);
        setMedicineCharges(medicineCharges);
        this.paidAmount = 0;
        calculateTotal();
        this.paymentStatus = "Pending";
    }

    public int getBillId() {
        return billId;
    }

    public int getPatientId() {
        return patientId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setConsultationFee(double fee) {
        if (fee >= 0)
            consultationFee = fee;
    }

    public void setRoomCharges(double charges) {
        if (charges >= 0)
            roomCharges = charges;
    }

    public void setMedicineCharges(double charges) {
        if (charges >= 0)
            medicineCharges = charges;
    }

    private void calculateTotal() {
        totalAmount = consultationFee + roomCharges + medicineCharges;
    }

    public void makePayment(double amount) {

        if (amount <= 0) {
            System.out.println("Enter a valid payment amount!");
        }
        else if (paidAmount + amount > totalAmount) {
            System.out.println("Payment exceeds pending amount!");
        }
        else {
            paidAmount += amount;

            if (paidAmount == totalAmount) {
                paymentStatus = "Paid";
            } else {
                paymentStatus = "Partially Paid";
            }

            System.out.println("Payment successful!");
        }
    }

    public void displayBill() {

        System.out.println("\n========== HOSPITAL BILL ==========");
        System.out.println("Bill ID          : " + billId);
        System.out.println("Patient ID       : " + patientId);
        System.out.println("Consultation Fee : Rs." + consultationFee);
        System.out.println("Room Charges     : Rs." + roomCharges);
        System.out.println("Medicine Charges : Rs." + medicineCharges);
        System.out.println("-----------------------------------");
        System.out.println("Total Amount     : Rs." + totalAmount);
        System.out.println("Paid Amount      : Rs." + paidAmount);
        System.out.println("Pending Amount   : Rs." + (totalAmount - paidAmount));
        System.out.println("Payment Status   : " + paymentStatus);
        System.out.println("===================================");
    }
}


package Hospital;

class Pharmacy {

    private int medicineId;
    private String medicineName;
    private int stock;
    private double price;

    public Pharmacy(int medicineId, String medicineName,
                    int stock, double price) {

        this.medicineId = medicineId;
        setMedicineName(medicineName);
        setStock(stock);
        setPrice(price);
    }

    public int getMedicineId() {
        return medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public void setMedicineName(String medicineName) {
        if (medicineName != null && !medicineName.trim().isEmpty())
            this.medicineName = medicineName;
    }

    public void setStock(int stock) {
        if (stock >= 0)
            this.stock = stock;
        else
            System.out.println("Stock cannot be negative!");
    }

    public void setPrice(double price) {
        if (price >= 0)
            this.price = price;
        else
            System.out.println("Invalid medicine price!");
    }

    public void purchaseMedicine(int quantity) {

        if (quantity <= 0) {
            System.out.println("Invalid quantity!");
        }
        else if (quantity > stock) {
            System.out.println("Insufficient stock!");
        }
        else {
            stock -= quantity;

            double amount = quantity * price;

            System.out.println("Medicine purchased successfully!");
            System.out.println("Medicine Name : " + medicineName);
            System.out.println("Quantity      : " + quantity);
            System.out.println("Total Amount  : Rs." + amount);
            System.out.println("Remaining Stock: " + stock);
        }
    }

    public void addStock(int quantity) {

        if (quantity > 0) {
            stock += quantity;
            System.out.println("Stock updated successfully!");
        } else {
            System.out.println("Invalid stock quantity!");
        }
    }

    public void displayMedicine() {

        System.out.println("\n---------- MEDICINE DETAILS ----------");
        System.out.println("Medicine ID   : " + medicineId);
        System.out.println("Medicine Name : " + medicineName);
        System.out.println("Available Stock: " + stock);
        System.out.println("Price         : Rs." + price);
    }
}


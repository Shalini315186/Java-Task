package Hospital;

import java.util.ArrayList;
import java.util.Scanner;

public class HospitalManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static ArrayList<MedicalRecord> records = new ArrayList<>();
    static ArrayList<Billing> bills = new ArrayList<>();
    static ArrayList<Pharmacy> medicines = new ArrayList<>();

    static int patientCounter = 1001;
    static int doctorCounter = 101;
    static int appointmentCounter = 501;
    static int recordCounter = 701;
    static int billCounter = 901;
    static int medicineCounter = 201;

    // Input methods

    static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    static double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount!");
            }
        }
    }

    static String readString(String message) {
        System.out.print(message);
        return sc.nextLine();
    }

    // Search patient

    static Patient findPatient(int id) {
        for (Patient p : patients) {
            if (p.getPatientId() == id) {
                return p;
            }
        }
        return null;
    }

    // Search doctor

    static Doctor findDoctor(int id) {
        for (Doctor d : doctors) {
            if (d.getDoctorId() == id) {
                return d;
            }
        }
        return null;
    }

    // Search medicine

    static Pharmacy findMedicine(int id) {
        for (Pharmacy m : medicines) {
            if (m.getMedicineId() == id) {
                return m;
            }
        }
        return null;
    }

    // Search bill

    static Billing findBill(int id) {
        for (Billing b : bills) {
            if (b.getBillId() == id) {
                return b;
            }
        }
        return null;
    }

    // MAIN MENU

    public static void main(String[] args) {

        int choice;

        System.out.println("\n==========================================");
        System.out.println("       WELCOME TO SMARTCARE HOSPITAL");
        System.out.println("          YOUR HEALTH, OUR PRIORITY");
        System.out.println("==========================================");

        while (true) {

            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Medical Records");
            System.out.println("5. Billing Management");
            System.out.println("6. Pharmacy Management");
            System.out.println("7. Hospital Dashboard");
            System.out.println("8. Exit");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    patientMenu();
                    break;

                case 2:
                    doctorMenu();
                    break;

                case 3:
                    appointmentMenu();
                    break;

                case 4:
                    medicalMenu();
                    break;

                case 5:
                    billingMenu();
                    break;

                case 6:
                    pharmacyMenu();
                    break;

                case 7:
                    dashboard();
                    break;

                case 8:
                    System.out.println("\nThank you for visiting SmartCare!");
                    System.out.println("Application closed successfully.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // PATIENT MANAGEMENT

    static void patientMenu() {

        while (true) {

            System.out.println("\n========== PATIENT MANAGEMENT ==========");
            System.out.println("1. Register Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Back to Main Menu");

            int choice = readInt("Enter choice: ");

            switch (choice) {

                case 1: {

                    int id = patientCounter++;

                    String name = readString("Enter patient name: ");
                    int age = readInt("Enter age: ");
                    String gender = readString("Enter gender: ");
                    String phone = readString("Enter phone: ");
                    String blood = readString("Enter blood group: ");
                    String disease = readString("Enter disease: ");

                    if (name.trim().isEmpty() || age <= 0 || age > 120 ||
                        gender.trim().isEmpty() ||
                        !phone.matches("[0-9]{10}") ||
                        blood.trim().isEmpty() ||
                        disease.trim().isEmpty()) {

                        System.out.println("Invalid patient details. Registration failed!");
                        break;
                    }

                    boolean duplicate = false;

                    for (Patient p : patients) {
                        if (p.getPhone().equals(phone)) {
                            duplicate = true;
                            break;
                        }
                    }

                    if (duplicate) {
                        System.out.println("Phone number already registered!");
                        break;
                    }

                    Patient p = new Patient(id, name, age,
                            gender, phone, blood, disease);

                    patients.add(p);

                    System.out.println("Patient registered successfully!");
                    System.out.println("Your Patient ID: " + id);
                    break;
                }

                case 2:

                    if (patients.isEmpty()) {
                        System.out.println("No patients registered!");
                    } else {
                        for (Patient p : patients) {
                            p.displayPatient();
                        }
                    }
                    break;

                case 3: {

                    int id = readInt("Enter Patient ID: ");
                    Patient p = findPatient(id);

                    if (p != null)
                        p.displayPatient();
                    else
                        System.out.println("Patient not found!");

                    break;
                }

                case 4: {

                    int id = readInt("Enter Patient ID: ");
                    Patient p = findPatient(id);

                    if (p == null) {
                        System.out.println("Patient not found!");
                        break;
                    }

                    System.out.println("1. Update Name");
                    System.out.println("2. Update Age");
                    System.out.println("3. Update Phone");
                    System.out.println("4. Update Disease");

                    int update = readInt("Choose field: ");

                    switch (update) {

                        case 1:
                            String name = readString("Enter new name: ");
                            if (!name.trim().isEmpty()) {
                                p.setPatientName(name);
                                System.out.println("Name updated!");
                            } else {
                                System.out.println("Invalid name!");
                            }
                            break;

                        case 2:
                            int age = readInt("Enter new age: ");
                            p.setAge(age);
                            break;

                        case 3:
                            String phone = readString("Enter new phone: ");
                            if (phone.matches("[0-9]{10}")) {
                                boolean exists = false;
                                for (Patient other : patients) {
                                    if (other != p && other.getPhone().equals(phone)) {
                                        exists = true;
                                        break;
                                    }
                                }
                                if (!exists) {
                                    p.setPhone(phone);
                                    System.out.println("Phone updated!");
                                } else {
                                    System.out.println("Phone already registered!");
                                }
                            } else {
                                System.out.println("Invalid phone number!");
                            }
                            break;

                        case 4:
                            String disease = readString("Enter new disease: ");
                            p.setDisease(disease);
                            break;

                        default:
                            System.out.println("Invalid choice!");
                    }
                    break;
                }

                case 5: {

                    int id = readInt("Enter Patient ID to delete: ");
                    Patient p = findPatient(id);

                    if (p == null) {
                        System.out.println("Patient not found!");
                        break;
                    }

                    boolean hasHistory = false;

                    for (Appointment a : appointments) {
                        if (a.getPatientId() == id) {
                            hasHistory = true;
                            break;
                        }
                    }

                    for (MedicalRecord r : records) {
                        if (r.getPatientId() == id) {
                            hasHistory = true;
                            break;
                        }
                    }

                    for (Billing b : bills) {
                        if (b.getPatientId() == id) {
                            hasHistory = true;
                            break;
                        }
                    }

                    if (hasHistory) {
                        System.out.println("Cannot delete patient with existing hospital records!");
                    } else {
                        patients.remove(p);
                        System.out.println("Patient deleted successfully!");
                    }
                    break;
                }

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // DOCTOR MANAGEMENT

    static void doctorMenu() {

        while (true) {

            System.out.println("\n========== DOCTOR MANAGEMENT ==========");
            System.out.println("1. Register Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Search Doctor");
            System.out.println("4. Update Availability");
            System.out.println("5. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {

                case 1: {

                    String name = readString("Doctor name: ");
                    String specialization = readString("Specialization: ");
                    String phone = readString("Phone number: ");
                    double fee = readDouble("Consultation fee: ");

                    if (name.trim().isEmpty() ||
                        specialization.trim().isEmpty() ||
                        !phone.matches("[0-9]{10}") || fee < 0) {

                        System.out.println("Invalid doctor details!");
                        break;
                    }

                    boolean duplicate = false;

                    for (Doctor d : doctors) {
                        if (d.getPhone().equals(phone)) {
                            duplicate = true;
                            break;
                        }
                    }

                    if (duplicate) {
                        System.out.println("Doctor phone already registered!");
                        break;
                    }

                    Doctor d = new Doctor(doctorCounter++, name,
                            specialization, phone, fee);

                    doctors.add(d);

                    System.out.println("Doctor registered successfully!");
                    System.out.println("Doctor ID: " + d.getDoctorId());
                    break;
                }

                case 2:

                    if (doctors.isEmpty())
                        System.out.println("No doctors registered!");
                    else
                        for (Doctor d : doctors)
                            d.displayDoctor();

                    break;

                case 3: {

                    int id = readInt("Enter Doctor ID: ");
                    Doctor d = findDoctor(id);

                    if (d != null)
                        d.displayDoctor();
                    else
                        System.out.println("Doctor not found!");

                    break;
                }

                case 4: {

                    int id = readInt("Enter Doctor ID: ");
                    Doctor d = findDoctor(id);

                    if (d == null) {
                        System.out.println("Doctor not found!");
                        break;
                    }

                    d.setAvailable(!d.isAvailable());

                    System.out.println("Doctor availability updated!");
                    d.displayDoctor();
                    break;
                }

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // APPOINTMENT MANAGEMENT

    static void appointmentMenu() {

        while (true) {

            System.out.println("\n========== APPOINTMENT MANAGEMENT ==========");
            System.out.println("1. Book Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Reschedule Appointment");
            System.out.println("5. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {

                case 1: {

                    int patientId = readInt("Enter Patient ID: ");
                    int doctorId = readInt("Enter Doctor ID: ");

                    Patient p = findPatient(patientId);
                    Doctor d = findDoctor(doctorId);

                    if (p == null || d == null) {
                        System.out.println("Invalid patient or doctor ID!");
                        break;
                    }

                    if (!d.isAvailable()) {
                        System.out.println("Doctor is unavailable!");
                        break;
                    }

                    String date = readString("Enter date (YYYY-MM-DD): ");
                    String time = readString("Enter time (HH:MM): ");

                    if (!validDateTime(date, time)) {
                        System.out.println("Invalid date or time format!");
                        break;
                    }

                    boolean booked = false;

                    for (Appointment a : appointments) {
                        if (a.getDoctorId() == doctorId &&
                            a.getAppointmentDate().equals(date) &&
                            a.getAppointmentTime().equals(time) &&
                            a.getStatus().equals("Booked")) {

                            booked = true;
                            break;
                        }
                    }

                    if (booked) {
                        System.out.println("Doctor already has an appointment at this time!");
                        break;
                    }

                    Appointment a = new Appointment(
                            appointmentCounter++, patientId,
                            doctorId, date, time);

                    appointments.add(a);

                    System.out.println("Appointment booked successfully!");
                    System.out.println("Appointment ID: " + a.getAppointmentId());
                    break;
                }

                case 2:

                    if (appointments.isEmpty())
                        System.out.println("No appointments available!");
                    else
                        for (Appointment a : appointments)
                            a.displayAppointment();

                    break;

                case 3: {

                    int id = readInt("Enter Appointment ID: ");
                    Appointment found = null;

                    for (Appointment a : appointments) {
                        if (a.getAppointmentId() == id) {
                            found = a;
                            break;
                        }
                    }

                    if (found != null)
                        found.cancelAppointment();
                    else
                        System.out.println("Appointment not found!");

                    break;
                }

                case 4: {

                    int id = readInt("Enter Appointment ID: ");
                    Appointment found = null;

                    for (Appointment a : appointments) {
                        if (a.getAppointmentId() == id) {
                            found = a;
                            break;
                        }
                    }

                    if (found == null || !found.getStatus().equals("Booked")) {
                        System.out.println("Active appointment not found!");
                        break;
                    }

                    String date = readString("Enter new date (YYYY-MM-DD): ");
                    String time = readString("Enter new time (HH:MM): ");

                    if (!validDateTime(date, time)) {
                        System.out.println("Invalid date or time!");
                        break;
                    }

                    boolean conflict = false;

                    for (Appointment a : appointments) {
                        if (a != found &&
                            a.getDoctorId() == found.getDoctorId() &&
                            a.getAppointmentDate().equals(date) &&
                            a.getAppointmentTime().equals(time) &&
                            a.getStatus().equals("Booked")) {

                            conflict = true;
                            break;
                        }
                    }

                    if (conflict) {
                        System.out.println("Doctor already booked at that time!");
                    } else {
                        found.setAppointmentDate(date);
                        found.setAppointmentTime(time);
                        System.out.println("Appointment rescheduled successfully!");
                    }
                    break;
                }

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Date and time validation

    static boolean validDateTime(String date, String time) {
        try {
            java.time.LocalDate.parse(date);
            java.time.LocalTime.parse(time);
            return true;
        } catch (java.time.format.DateTimeParseException e) {
            return false;
        }
    }

    // MEDICAL RECORD MANAGEMENT

    static void medicalMenu() {

        while (true) {

            System.out.println("\n========== MEDICAL RECORDS ==========");
            System.out.println("1. Add Medical Record");
            System.out.println("2. View Medical Record");
            System.out.println("3. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {

                case 1: {

                    int patientId = readInt("Enter Patient ID: ");

                    if (findPatient(patientId) == null) {
                        System.out.println("Patient not found!");
                        break;
                    }

                    String diagnosis = readString("Diagnosis: ");
                    String prescription = readString("Prescription: ");
                    String allergies = readString("Allergies (enter None if no allergies): ");
                    double temp = readDouble("Temperature: ");
                    int bp = readInt("Systolic blood pressure: ");
                    int heart = readInt("Heart rate: ");

                    if (diagnosis.trim().isEmpty() ||
                        prescription.trim().isEmpty() ||
                        allergies.trim().isEmpty() ||
                        temp <= 0 || temp >= 50 || bp <= 0 || heart <= 0) {

                        System.out.println("Invalid medical record details!");
                        break;
                    }

                    MedicalRecord r = new MedicalRecord(
                            recordCounter++, patientId, diagnosis,
                            prescription, allergies, temp, bp, heart);

                    records.add(r);

                    System.out.println("Medical record added successfully!");
                    System.out.println("Record ID: " + r.getRecordId());
                    break;
                }

                case 2: {

                    int id = readInt("Enter Patient ID: ");
                    boolean found = false;

                    for (MedicalRecord r : records) {
                        if (r.getPatientId() == id) {
                            r.displayRecord();
                            found = true;
                        }
                    }

                    if (!found)
                        System.out.println("No medical records found!");

                    break;
                }

                case 3:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // BILLING MANAGEMENT

    static void billingMenu() {

        while (true) {

            System.out.println("\n========== BILLING MANAGEMENT ==========");
            System.out.println("1. Generate Bill");
            System.out.println("2. View Bill");
            System.out.println("3. Make Payment");
            System.out.println("4. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {

                case 1: {

                    int patientId = readInt("Enter Patient ID: ");

                    Patient p = findPatient(patientId);

                    if (p == null) {
                        System.out.println("Patient not found!");
                        break;
                    }

                    boolean existing = false;

                    for (Billing b : bills) {
                        if (b.getPatientId() == patientId &&
                            !b.getPaymentStatus().equals("Paid")) {
                            existing = true;
                            break;
                        }
                    }

                    if (existing) {
                        System.out.println("An unpaid bill already exists for this patient!");
                        break;
                    }

                    double consultation = readDouble("Consultation fee: ");
                    double room = readDouble("Room charges: ");
                    double medicine = readDouble("Medicine charges: ");

                    if (consultation < 0 || room < 0 || medicine < 0) {
                        System.out.println("Charges cannot be negative!");
                        break;
                    }

                    Billing b = new Billing(
                            billCounter++, patientId,
                            consultation, room, medicine);

                    bills.add(b);

                    System.out.println("Bill generated successfully!");
                    b.displayBill();
                    break;
                }

                case 2: {

                    int id = readInt("Enter Bill ID: ");
                    Billing b = findBill(id);

                    if (b != null)
                        b.displayBill();
                    else
                        System.out.println("Bill not found!");

                    break;
                }

                case 3: {

                    int id = readInt("Enter Bill ID: ");
                    Billing b = findBill(id);

                    if (b == null) {
                        System.out.println("Bill not found!");
                        break;
                    }

                    double pending = b.getTotalAmount() - b.getPaidAmount();

                    if (pending <= 0) {
                        System.out.println("Bill is already fully paid!");
                        break;
                    }

                    System.out.println("Pending Amount: Rs." + pending);

                    double amount = readDouble("Enter payment amount: ");
                    b.makePayment(amount);
                    b.displayBill();
                    break;
                }

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // PHARMACY MANAGEMENT

    static void pharmacyMenu() {

        while (true) {

            System.out.println("\n========== PHARMACY MANAGEMENT ==========");
            System.out.println("1. Add Medicine");
            System.out.println("2. View Medicines");
            System.out.println("3. Purchase Medicine");
            System.out.println("4. Add Stock");
            System.out.println("5. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {

                case 1: {

                    String name = readString("Medicine name: ");
                    int stock = readInt("Initial stock: ");
                    double price = readDouble("Price per unit: ");

                    if (name.trim().isEmpty() || stock < 0 || price < 0) {
                        System.out.println("Invalid medicine details!");
                        break;
                    }

                    Pharmacy m = new Pharmacy(
                            medicineCounter++, name, stock, price);

                    medicines.add(m);

                    System.out.println("Medicine added successfully!");
                    System.out.println("Medicine ID: " + m.getMedicineId());
                    break;
                }

                case 2:

                    if (medicines.isEmpty())
                        System.out.println("No medicines available!");
                    else
                        for (Pharmacy m : medicines)
                            m.displayMedicine();

                    break;

                case 3: {

                    int id = readInt("Enter Medicine ID: ");
                    Pharmacy m = findMedicine(id);

                    if (m == null) {
                        System.out.println("Medicine not found!");
                        break;
                    }

                    int quantity = readInt("Enter quantity: ");
                    m.purchaseMedicine(quantity);
                    break;
                }

                case 4: {

                    int id = readInt("Enter Medicine ID: ");
                    Pharmacy m = findMedicine(id);

                    if (m == null) {
                        System.out.println("Medicine not found!");
                        break;
                    }

                    int quantity = readInt("Enter stock quantity: ");
                    m.addStock(quantity);
                    break;
                }

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // HOSPITAL DASHBOARD

    static void dashboard() {

        System.out.println("\n=========================================");
        System.out.println("          SMARTCARE DASHBOARD");
        System.out.println("=========================================");

        int activeAppointments = 0;
        int completedPayments = 0;
        int lowStock = 0;

        double totalRevenue = 0;
        double pendingRevenue = 0;

        for (Appointment a : appointments) {
            if (a.getStatus().equals("Booked"))
                activeAppointments++;
        }

        for (Billing b : bills) {
            totalRevenue += b.getPaidAmount();

            pendingRevenue += b.getTotalAmount() - b.getPaidAmount();

            if (b.getPaymentStatus().equals("Paid"))
                completedPayments++;
        }

        for (Pharmacy m : medicines) {
            if (m.getStock() <= 10)
                lowStock++;
        }

        System.out.println("Total Patients       : " + patients.size());
        System.out.println("Total Doctors        : " + doctors.size());
        System.out.println("Total Appointments   : " + appointments.size());
        System.out.println("Active Appointments  : " + activeAppointments);
        System.out.println("Medical Records      : " + records.size());
        System.out.println("Total Bills          : " + bills.size());
        System.out.println("Completed Payments   : " + completedPayments);
        System.out.println("Medicine Types       : " + medicines.size());
        System.out.println("Low Stock Medicines  : " + lowStock);

        System.out.println("-----------------------------------------");
        System.out.println("Collected Revenue    : Rs." + totalRevenue);
        System.out.println("Pending Revenue      : Rs." + pendingRevenue);
        System.out.println("=========================================");
    }
}


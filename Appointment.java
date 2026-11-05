package Hospital;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Appointment {

    // Encapsulation: Private variables

    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String appointmentDate;
    private String appointmentTime;
    private String status;

    // Constructor

    public Appointment(int appointmentId, int patientId,
                       int doctorId, String appointmentDate,
                       String appointmentTime) {

        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = "Active";
    }

    // Getters

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    // Setters

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Date Validation

    public static boolean isValidDate(String date) {

        try {

            LocalDate.parse(date);

            return true;

        } catch (DateTimeParseException e) {

            return false;
        }
    }

    // Time Validation

    public static boolean isValidTime(String time) {

        try {

            parseTime(time);

            return true;

        } catch (DateTimeParseException e) {

            return false;
        }
    }

    // Convert different time formats into LocalTime

    public static LocalTime parseTime(String time) {

        String formattedTime = time.trim()
                .toUpperCase()
                .replaceAll("\\s+", "");

        try {

            return LocalTime.parse(
                    formattedTime,
                    DateTimeFormatter.ofPattern("HH:mm")
            );

        } catch (DateTimeParseException e) {

            return LocalTime.parse(
                    formattedTime,
                    DateTimeFormatter.ofPattern("h:mma", Locale.ENGLISH)
            );
        }
    }

    // Check whether appointment date and time are in the future

    public static boolean isFutureAppointment(String date, String time) {

        try {

            LocalDate appointmentDate = LocalDate.parse(date);
            LocalTime appointmentTime = parseTime(time);

            LocalDate today = LocalDate.now();
            LocalTime currentTime = LocalTime.now();

            if (appointmentDate.isAfter(today)) {
                return true;
            }

            if (appointmentDate.isEqual(today)
                    && appointmentTime.isAfter(currentTime)) {
                return true;
            }

            return false;

        } catch (DateTimeParseException e) {

            return false;
        }
    }

    // Cancel Appointment

    public void cancelAppointment() {

        if (status.equals("Active")) {

            status = "Cancelled";

            System.out.println("Appointment cancelled successfully!");

        } else {

            System.out.println("Appointment is already cancelled or completed!");
        }
    }

    // Reschedule Appointment

    public void rescheduleAppointment(String newDate, String newTime) {

        if (!status.equals("Active")) {

            System.out.println("Cannot reschedule cancelled or completed appointment!");
            return;
        }

        if (!isValidDate(newDate)) {

            System.out.println("Invalid date format!");
            return;
        }

        if (!isValidTime(newTime)) {

            System.out.println("Invalid time format!");
            return;
        }

        if (!isFutureAppointment(newDate, newTime)) {

            System.out.println("Appointment date and time must be in the future!");
            return;
        }

        appointmentDate = newDate;
        appointmentTime = newTime;

        System.out.println("Appointment rescheduled successfully!");
    }

    // Complete Appointment

    public void completeAppointment() {

        if (status.equals("Active")) {

            status = "Completed";

            System.out.println("Appointment completed successfully!");

        } else {

            System.out.println("Appointment is not active!");
        }
    }

    // Display Appointment Details

    public void displayAppointment() {

        System.out.println("\n---------- APPOINTMENT DETAILS ----------");

        System.out.println("Appointment ID : " + appointmentId);
        System.out.println("Patient ID     : " + patientId);
        System.out.println("Doctor ID      : " + doctorId);
        System.out.println("Date           : " + appointmentDate);
        System.out.println("Time           : " + appointmentTime);
        System.out.println("Status         : " + status);
    }
}
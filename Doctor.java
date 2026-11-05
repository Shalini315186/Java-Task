package Hospital;


class Doctor {

    private int doctorId;
    private String doctorName;
    private String specialization;
    private String phone;
    private double consultationFee;
    private boolean available;

    public Doctor(int doctorId, String doctorName,
                  String specialization, String phone,
                  double consultationFee) {

        setDoctorId(doctorId);
        setDoctorName(doctorName);
        setSpecialization(specialization);
        setPhone(phone);
        setConsultationFee(consultationFee);
        this.available = true;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        if (doctorId > 0)
            this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        if (doctorName != null && !doctorName.trim().isEmpty())
            this.doctorName = doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        if (specialization != null && !specialization.trim().isEmpty())
            this.specialization = specialization;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone != null && phone.matches("[0-9]{10}"))
            this.phone = phone;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        if (consultationFee >= 0)
            this.consultationFee = consultationFee;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void displayDoctor() {
        System.out.println("\n---------- DOCTOR DETAILS ----------");
        System.out.println("Doctor ID     : " + doctorId);
        System.out.println("Doctor Name   : " + doctorName);
        System.out.println("Specialization: " + specialization);
        System.out.println("Phone         : " + phone);
        System.out.println("Consultation  : Rs." + consultationFee);
        System.out.println("Availability  : " +
                           (available ? "Available" : "Unavailable"));
    }
}


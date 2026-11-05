package Hospital;


class MedicalRecord {

    private int recordId;
    private int patientId;
    private String diagnosis;
    private String prescription;
    private String allergies;
    private double temperature;
    private int bloodPressure;
    private int heartRate;

    public MedicalRecord(int recordId, int patientId,
                         String diagnosis, String prescription,
                         String allergies, double temperature,
                         int bloodPressure, int heartRate) {

        this.recordId = recordId;
        this.patientId = patientId;
        setDiagnosis(diagnosis);
        setPrescription(prescription);
        setAllergies(allergies);
        setTemperature(temperature);
        setBloodPressure(bloodPressure);
        setHeartRate(heartRate);
    }

    public int getRecordId() {
        return recordId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        if (diagnosis != null && !diagnosis.trim().isEmpty())
            this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        if (prescription != null && !prescription.trim().isEmpty())
            this.prescription = prescription;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        if (allergies != null)
            this.allergies = allergies;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        if (temperature > 0 && temperature < 50)
            this.temperature = temperature;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        if (bloodPressure > 0)
            this.bloodPressure = bloodPressure;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        if (heartRate > 0)
            this.heartRate = heartRate;
    }

    public void displayRecord() {
        System.out.println("\n---------- MEDICAL RECORD ----------");
        System.out.println("Record ID     : " + recordId);
        System.out.println("Patient ID    : " + patientId);
        System.out.println("Diagnosis     : " + diagnosis);
        System.out.println("Prescription  : " + prescription);
        System.out.println("Allergies     : " + allergies);
        System.out.println("Temperature   : " + temperature);
        System.out.println("Blood Pressure: " + bloodPressure);
        System.out.println("Heart Rate    : " + heartRate);
    }
}


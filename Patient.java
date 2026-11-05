package Hospital;


class Patient {

    private int patientId;
    private String patientName;
    private int age;
    private String gender;
    private String phone;
    private String bloodGroup;
    private String disease;

    public Patient(int patientId, String patientName, int age,String gender, String phone,String bloodGroup, String disease) {

        setPatientId(patientId);
        setPatientName(patientName);
        setAge(age);
        setGender(gender);
        setPhone(phone);
        setBloodGroup(bloodGroup);
        setDisease(disease);
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        if (patientId > 0)
            this.patientId = patientId;
        else
            System.out.println("Invalid Patient ID!");
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        if (patientName != null && !patientName.trim().isEmpty())
            this.patientName = patientName;
        else
            System.out.println("Invalid Patient Name!");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age <= 120)
            this.age = age;
        else
            System.out.println("Invalid Age!");
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender != null && !gender.trim().isEmpty())
            this.gender = gender;
        else
            System.out.println("Invalid Gender!");
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone != null && phone.matches("[0-9]{10}"))
            this.phone = phone;
        else
            System.out.println("Phone number must contain 10 digits!");
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        if (bloodGroup != null && !bloodGroup.trim().isEmpty())
            this.bloodGroup = bloodGroup;
        else
            System.out.println("Invalid Blood Group!");
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        if (disease != null && !disease.trim().isEmpty())
            this.disease = disease;
        else
            System.out.println("Invalid Disease!");
    }

    public void displayPatient() {
        System.out.println("\n.......PATIENT DETAILS........");
        System.out.println("Patient ID   : " + patientId);
        System.out.println("Name         : " + patientName);
        System.out.println("Age          : " + age);
        System.out.println("Gender       : " + gender);
        System.out.println("Phone        : " + phone);
        System.out.println("Blood Group  : " + bloodGroup);
        System.out.println("Disease      : " + disease);
    }
}


package Patients;

public class Patient {
    private int patientID;
    private String patientName;
    private String email;
    private String address;
    private String phone;
    private int age;

    public Patient() {
    }

    public Patient(int patientID, String patientName, String email, String address, String phone, int age) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.age = age;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

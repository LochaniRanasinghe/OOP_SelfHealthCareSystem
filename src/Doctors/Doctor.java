package Doctors;

import java.sql.Date;
import java.sql.Time;

public class Doctor extends DoctorImplements{
    private int doctorID;
    private String doctorName;
    private String specialization;
    private int specializationID;
    private Time time;
    private Date date;
    private double doctorFee;

    public Doctor() {
    }

    public Doctor(int doctorID, String doctorName, String specialization, int specializationID, Time time,Date date,double doctorFee) {
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.specializationID = specializationID;
        this.time =time;
        this.date = date;
        this.doctorFee = doctorFee;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getSpecializationID() {
        return specializationID;
    }

    public void setSpecializationID(int specializationID) {
        this.specializationID = specializationID;
    }

    public double getDoctorFee() {
        return doctorFee;
    }

    public void setDoctorFee(double doctorFee) {
        this.doctorFee = doctorFee;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID=" + doctorID +
                ", doctorName='" + doctorName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", specializationID=" + specializationID +
                ", time=" + time +
                ", date=" + date +
                ", doctorFee=" + doctorFee +
                '}';
    }
}

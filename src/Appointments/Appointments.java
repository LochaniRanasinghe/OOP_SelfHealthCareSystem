package Appointments;
import java.sql.Date;
import java.sql.Time;

public class Appointments {
        private int appointmentID;
        private int doctorID;
        private String doctorName;
        private String patientName;
        private String email;
        private Date date;
        private Time time;
        private double doctorFee;

        public Appointments(){
        }

        public Appointments(int appointmentID, int doctorID, String doctorName, String patientName, String email, Date date, Time time, double doctorFee) {
            this.appointmentID = appointmentID;
            this.doctorID = doctorID;
            this.doctorName = doctorName;
            this.patientName = patientName;
            this.email = email;
            this.date = date;
            this.time = time;
            this.doctorFee = doctorFee;
        }

        public int getAppointmentID() {
            return appointmentID;
        }

        public void setAppointmentID(int appointmentID) {
            this.appointmentID = appointmentID;
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

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Time getTime() {
            return time;
        }

        public void setTime(Time time) {
            this.time = time;
        }

        public double getDoctorFee() {
            return doctorFee;
        }

        public void setDoctorFee(double doctorFee) {
            this.doctorFee = doctorFee;
        }
}

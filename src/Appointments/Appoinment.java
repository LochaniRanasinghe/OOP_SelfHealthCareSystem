package Appointments;
import Doctors.DBConnection;
import java.sql.*;
import java.util.Date;

public class Appoinment {
    Connection con;

    public void addDoctorPatient(int doctorID, int patientID) {
        con = DBConnection.createDBConnection();
        String query = "INSERT INTO doctorpatient (doctorID, patientID) VALUES (?,?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, doctorID);
            pstmt.setInt(2, patientID);

            int count = pstmt.executeUpdate();
            if(count != 0) {
                System.out.println("Successfully added doctor-patient relationship to the database.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getPatientAndDoctorDetails(int patientID, int doctorID) {
        con = DBConnection.createDBConnection();
        String query = "SELECT p.patientName, p.email, p.address, p.phone, d.doctorName, d.specialization, d.time, d.date, d.doctorFee " +
                "FROM doctorpatient dp " +
                "JOIN patient p ON dp.patientID = p.patientID " +
                "JOIN doctor d ON dp.doctorID = d.doctorID " +
                "WHERE dp.patientID = ? AND dp.doctorID = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, patientID);
            pstmt.setInt(2, doctorID);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String patientName = rs.getString("patientName");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String doctorName = rs.getString("doctorName");
                String specialization = rs.getString("specialization");
                Time time = rs.getTime("time");
                Date date = rs.getDate("date");
                double doctorFee = rs.getDouble("doctorFee");

                System.out.println("------------------------------------------------------------------");
                System.out.println("\t\t\t\t\tAPPOINTMENT DETAILS");
                System.out.println("------------------------------------------------------------------");
                System.out.println("\t\tPATIENT DETAILS");
                System.out.println("\t\t\tPatient Name: " +patientName );
                System.out.println("\t\t\tPatient Email: " +email );
                System.out.println("\t\t\tPatient Address: " +address );
                System.out.println("\t\t\tPatient PhoneNumber: " +phone );
                System.out.println("\t\tDOCTOR DETAILS");
                System.out.println("\t\t\tDoctor Reserved: "+doctorName);
                System.out.println("\t\t\tDoctor Specialization: "+specialization);
                System.out.println("\t\t\tDoctor Consultation Fee: "+doctorFee);
                System.out.println("------------------------------------------------------------------");
                System.out.println("\t\tAPPOINTMENT DETAILS");
                System.out.println("\t\t\tAppointment Time: "+time);
                System.out.println("\t\t\tAppointment Date: "+date);
                System.out.println("------------------------------------------------------------------");
            } else {
                System.out.println("No records found for the given patient and doctor IDs.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

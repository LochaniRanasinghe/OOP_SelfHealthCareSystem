package Billing;
import Doctors.DBConnection;
import java.sql.*;
import java.util.Date;

public class Billing {
    Connection con;

    double doctorFee;
    double hospitalCharges= 3000.00;
    double medicalCharges= 1000.00;
    double totalCharges=0;

    public void getDoctorFee(int doctorID, int patientID) {
        con = DBConnection.createDBConnection();
        String query = "SELECT doctorFee FROM doctor WHERE doctorID = ? AND doctorID IN (SELECT doctorID FROM doctorpatient WHERE patientID = ?)";
        try {
            PreparedStatement ppt = con.prepareStatement(query);
            ppt.setInt(1, doctorID);
            ppt.setInt(2, patientID);
            ResultSet rs = ppt.executeQuery();
            if (rs.next()) {
                doctorFee = rs.getDouble("doctorFee");
                System.out.println("\n\n");
                System.out.println("------------------------------------------------------------------");
                System.out.println("\t\t\tYOUR FINAL BILL");
                System.out.println("------------------------------------------------------------------");
                System.out.println("\t\t\tDoctor Consultation Fee: "+doctorFee);
                System.out.println("\t\t\tHospital Charges: " +hospitalCharges);
                System.out.println("\t\t\tMedical Tests Charges: "+medicalCharges);
                System.out.println("------------------------------------------------------------------");
                totalCharges = doctorFee+hospitalCharges+medicalCharges;
                System.out.println("\t\t\tTotal Charges: "+totalCharges);
                System.out.println("------------------------------------------------------------------\n");

            } else {
                System.out.println("No doctor fee found for the given doctor and patient IDs");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

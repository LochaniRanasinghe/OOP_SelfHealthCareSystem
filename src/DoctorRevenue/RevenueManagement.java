package DoctorRevenue;
import Doctors.DBConnection;
import java.sql.*;


public class RevenueManagement {
    Connection con;
    double totalfee;

    public void displayPatientsAndCount(int doctorID) {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "SELECT p.patientName, d.doctorFee " +
                "FROM patient p " +
                "JOIN doctorpatient dp ON p.patientID = dp.patientID " +
                "JOIN doctor d ON d.doctorID = dp.doctorID " +
                "WHERE dp.doctorID = ?";

        try {
            con = DBConnection.createDBConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, doctorID);
            rs = pstmt.executeQuery();

            // Get doctor fee for the given doctor ID
            String feeQuery = "SELECT doctorFee FROM doctor WHERE doctorID = ?";
            PreparedStatement feeStmt = con.prepareStatement(feeQuery);
            feeStmt.setInt(1, doctorID);
            ResultSet feeRs = feeStmt.executeQuery();
            feeRs.next();
            int doctorFee = feeRs.getInt("doctorFee");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("\t\t\t\t\t\tFinal Revenue Report");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("\t\t\t***** Consultation fee of Doctor per patient: " + doctorFee+" *****\n");

            // Print patient names
            System.out.println("Names of all Patients Consulted: \n");

            int count = 0;
            while (rs.next()) {
                String patientName = rs.getString("patientName");
                System.out.println(patientName);
                count++;
            }
            totalfee=count*doctorFee;
            System.out.println("\n-------------------------------------------------------------------------------------------------");
            System.out.println("\t\t\tTotal Number of Patients Consulted: " + count);
            System.out.println("\t\t\tTotal Revenue of the Doctor: "+totalfee);
            System.out.println("-------------------------------------------------------------------------------------------------\n\n");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}

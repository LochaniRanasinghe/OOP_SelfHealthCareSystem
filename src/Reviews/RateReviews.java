package Reviews;
import Doctors.DBConnection;
import java.sql.*;
import java.util.Date;

public class RateReviews {
    Connection con;

    //Get All the reviews of a single doctor
    public void getDoctorReviews(int doctorID) {
        con = DBConnection.createDBConnection();
        String query = "SELECT * FROM review WHERE doctorID = ?";
        try {
            PreparedStatement ppt = con.prepareStatement(query);
            ppt.setInt(1, doctorID);
            ResultSet rs = ppt.executeQuery();
            if (rs.next()) {
                System.out.println("Reviews for Doctor " + rs.getString("doctorName") + ":");
                do {
                    String review = rs.getString("review");
                    System.out.println("Review: " + review);
                    System.out.println("-----------------------------");
                } while (rs.next());
            } else {
                System.out.println("No reviews found for the given doctor ID");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Add Rate reviews
    public void addReview(int patientID, int doctorID, String review) {
        con = DBConnection.createDBConnection();
        String query = "insert into review(patientID, doctorID,review) values(?,?,?)";

        try {
            PreparedStatement ppt = con.prepareStatement(query);

            ppt.setInt(1, patientID);
            ppt.setInt(2, doctorID);
            ppt.setString(3, review);

            int cnt = ppt.executeUpdate();
            if(cnt!=0) {
                System.out.println("\n");
                System.out.println("Review added successfully!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

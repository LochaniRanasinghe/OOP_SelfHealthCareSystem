package Reviews;
import Doctors.DBConnection;
import java.sql.*;
import java.util.Date;

public class RateReviews {
    Connection con;


    public void displayReviews(int doctorID) {
        try {
            con = DBConnection.createDBConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT review FROM review WHERE doctorID=?");
            pstmt.setInt(1, doctorID);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Reviews for Doctor ID: " + doctorID);
            System.out.println("-----------------------------");

            int count = 0;
            while (rs.next()) {
                count++;
                System.out.println("Review " + count + ": " + rs.getString("review"));
                System.out.println("-------------------------------------------------------------------------------------------------");

            }

            if (count == 0) {
                System.out.println("No reviews found for Doctor ID: " + doctorID);
            }

            con.close();
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
                System.out.println("Review added successfully!\n");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

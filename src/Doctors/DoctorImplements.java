package Doctors;
import java.sql.*;

public class DoctorImplements implements DoctorInterface{
    Connection con;
    @Override
    public void addDoctor(Doctor doctor) {

        con = DBConnection.createDBConnection();
        String query = "insert into doctor values(?,?,?,?,?,?,?)";

        try {
            PreparedStatement ppt = con.prepareStatement(query);

            ppt.setInt(1,doctor.getDoctorID());
            ppt.setString(2,doctor.getDoctorName());
            ppt.setString(3,doctor.getSpecialization());
            ppt.setInt(4,doctor.getSpecializationID());
            ppt.setTime(5,doctor.getTime());
            ppt.setDate(6,doctor.getDate());
            ppt.setDouble(7,doctor.getDoctorFee());

            int cnt = ppt.executeUpdate();
            if(cnt!=0)
                System.out.println("Successfully Added the Doctor");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void showAllDoctors() {
        con = DBConnection.createDBConnection();
        String query = "select * from doctor";

        System.out.println("Available Doctors and Time Schedules");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%-17s%-20s%-20s%-20s%-20s%-20s%-10s%n\n","Doctor ID","Doctor Name", "Specialization","Specialization ID","Available Time","Date","Doctor Charges");
        try{
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%-17s%-20s%-20s%-20s%-20s%-20s%-10s%n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getTime(5),
                        result.getDate(6),
                        result.getDouble(7));
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showDoctorByID(int doctorID) {
        con=DBConnection.createDBConnection();
        String query = "select * from doctor where doctorID="+doctorID;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        try{
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%-17s%-20s%-20s%-20s%-20s%-20s%-10s%n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getTime(5),
                        result.getDate(6),
                        result.getDouble(7));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

    }

    @Override
    public void updateDoctor(int doctorID, String doctorName) {
        con=DBConnection.createDBConnection();
        String query = "update doctor set doctorName=? where doctorID=?";
        try{
            PreparedStatement ppt = con.prepareStatement(query);
            ppt.setString(1,doctorName);
            ppt.setInt(2,doctorID);
            int cnt = ppt.executeUpdate();
            if(cnt!=0)
                System.out.println("Employee Details updated successfully!");
                System.out.println("-------------------------------------------------------------------------------------------------");

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void deleteDoctor(int doctorID) {
        con=DBConnection.createDBConnection();
        String query = "delete from doctor where doctorID=?";
        try{
            PreparedStatement ppt = con.prepareStatement(query);
            ppt.setInt(1,doctorID);
            int count = ppt.executeUpdate();
            if(count!=0)
                System.out.println("Doctor with ID: "+doctorID + " Deleted Successfully!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Return Doctor Name when Doctor ID is entered
    public void printDoctorName(int doctorID) {
        con = DBConnection.createDBConnection();
        String query = "SELECT doctorName FROM doctor WHERE doctorID = ?";

        try {
            PreparedStatement ppt = con.prepareStatement(query);
            ppt.setInt(1, doctorID);
            ResultSet rs = ppt.executeQuery();

            if (rs.next()) {
                String doctorName = rs.getString("doctorName");
                System.out.println("Doctor of the Doctor you choose: " + doctorName);
            } else {
                System.out.println("No doctor found with ID: " + doctorID);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

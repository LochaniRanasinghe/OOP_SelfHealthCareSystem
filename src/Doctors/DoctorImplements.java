package Doctors;
import java.sql.*;

public class DoctorImplements implements DoctorInterface{
    Connection con;
    @Override
    public void addDoctor(Doctor doctor) {

        con = DBConnection.createDBConnection();
        String query = "insert into doctor values(?,?,?,?,?)";

        try {
            PreparedStatement ppt = con.prepareStatement(query);

            ppt.setInt(1,doctor.getDoctorID());
            ppt.setString(2,doctor.getDoctorName());
            ppt.setString(3,doctor.getSpecialization());
            ppt.setInt(4,doctor.getSpecializationID());
            ppt.setDouble(5,doctor.getDoctorFee());

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
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Doctor Details");
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.format("%-17s%-20s%-20s%-20s%-10s%n","Doctor ID","Doctor Name", "Specialization","Specialization ID","Doctor Charges");
        try{
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%-17s%-20s%-20s%-20s%-10s%n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getDouble(5));
            }
            System.out.println("-------------------------------------------------------------------------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showDoctorByID(int doctorID) {
        con=DBConnection.createDBConnection();
        String query = "select * from doctor where doctorID="+doctorID;
        try{
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%-17s%-20s%-20s%-20s%-10s%n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getDouble(5));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
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
}

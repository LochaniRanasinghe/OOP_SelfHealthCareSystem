package Patients;
import Doctors.DBConnection;
import java.sql.*;

public class PatientImplements implements PatientInterface{
    Connection con;

    @Override
    public void addPatient(Patient patient) {
        con = DBConnection.createDBConnection();
        String query = "insert into patient values(?,?,?,?,?,?)";

        try {
            PreparedStatement ppt = con.prepareStatement(query);

            ppt.setInt(1,patient.getPatientID());
            ppt.setString(2,patient.getPatientName());
            ppt.setString(3,patient.getEmail());
            ppt.setString(4,patient.getAddress());
            ppt.setString(5,patient.getPhone());
            ppt.setString(6,patient.getAge());

            int cnt = ppt.executeUpdate();
            if(cnt!=0)
                System.out.println("Successfully Registered the Patient");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void showAllPatients() {
        con = DBConnection.createDBConnection();
        String query = "select * from patient";
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Patient Details");
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.format("%-17s%-20s%-20s%-20s%-10s%-10s%n","Patient ID","Patient Name", "Email","Address","Phone","Age");

        try{
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%-17s%-20s%-20s%-20s%-10s%-10s%n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6));
            }
            System.out.println("-------------------------------------------------------------------------------------------------");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showPatientByID(int patientID) {
        con = DBConnection.createDBConnection();
        String query = "select * from patient where patientID="+patientID;
        try{
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%-17s%-20s%-20s%-20s%-10s%-10s%n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6));
            }
            System.out.println("-------------------------------------------------------------------------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void deletePatientByID(int patientID) {
        con = DBConnection.createDBConnection();
        String query = "delete from patient where patientID="+patientID;
        try{
            Statement stmt = con.createStatement();
            int result = stmt.executeUpdate(query);
            if(result!=0)
                System.out.println("Successfully Deleted the Patient");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    


}

import Doctors.Doctor;
import Doctors.DoctorImplements;
import Doctors.DoctorInterface;
import Doctors.DBConnection;
import Patients.PatientImplements;
import Patients.PatientInterface;
import Patients.Patient;
import java.sql.*;
import  java.util.Scanner;

public class MainMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Object creation on doctor interface
        DoctorInterface doc = new DoctorImplements();
        //Object creation on patient interface
        PatientInterface pat = new PatientImplements();

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("                                         WELCOME TO SELF HEALTH CARE SERVICE\n");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
//    do{
        //calling the show all function implemented  in DoctorImplements
        doc.showAllDoctors();
        System.out.println("\n");
        System.out.print("Enter Doctor ID to view Doctor Details: ");
        int docid = sc.nextInt();
        //calling the show doctor by ID function implemented in DoctorImplements
        doc.showDoctorByID(docid);
        System.out.println("\n");

        System.out.print("Do you want to book an appointment with the above selected doctor? (y/n): ");
        String ch = sc.next();
        if (!ch.equalsIgnoreCase("y")) {
            System.out.println("Appointment booking cancelled.");
        }
        else{
            System.out.println("Enter your details to continue booking...");
            System.out.println("\n");
            System.out.print("Enter Patient ID: ");
            int patientID=sc.nextInt();
            System.out.print("Enter Patient Name: ");
            String patientName=sc.next();
            System.out.print("Enter Patient Age: ");
            int patientAge=sc.nextInt();
            System.out.print("Enter Patient Address: ");
            String patientAddress=sc.next();
            System.out.print("Enter Patient Phone: ");
            String patientPhone=sc.next();
            System.out.print("Enter Patient Email: ");
            String patientEmail=sc.next();

            //Creating an object from Patient class
            Patient patient = new Patient();

            //Setting the input values gain by the user
            patient.setPatientID(patientID);
            patient.setPatientName(patientName);
            patient.setAge(patientAge);
            patient.setAddress(patientAddress);
            patient.setPhone(patientPhone);
            patient.setEmail(patientEmail);
            pat.addPatient(patient);
        }
          System.out.print("Appoinment Details ");

//        System.out.print("Do you want to book an appointment with the above selected doctor? (y/n): ");
//        String ch = sc.next();
//        if (!ch.equalsIgnoreCase("y")) {
//            System.out.println("Appointment booking cancelled.");
//        }
//        else{

//        switch (choice) {
//            case 1:
//                doc.showAllDoctors();
//                break;
//            case 2:
//                System.out.print("Enter Doctor ID to view doctor details: ");
//                int docid = sc.nextInt();
//                doc.showDoctorByID(docid);
//                break;
//
//            default:
//                System.out.println("Invalid input");
//                break;
//        }
//    }while (true);
    }
}
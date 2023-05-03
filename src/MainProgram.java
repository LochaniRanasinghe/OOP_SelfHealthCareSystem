import Doctors.Doctor;
import Doctors.DoctorImplements;
import Doctors.DoctorInterface;
import Doctors.DBConnection;
import Patients.PatientImplements;
import Patients.PatientInterface;
import Patients.Patient;
import java.sql.*;


import  java.util.Scanner;
public class MainProgram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Object creation on doctor interface
        DoctorInterface doc = new DoctorImplements();
        //Object creation on patient interface
        PatientInterface pat = new PatientImplements();

        System.out.println("Welcome to Self Health Care System..");
        do{
            System.out.println("1. Add Doctor");
            System.out.println("2. Show All Doctors");
            System.out.println("3. Show Doctor by ID");
            System.out.println("4. Update Doctor");
            System.out.println("5. Delete Doctor");
            System.out.println("6. Add Patients");
            System.out.println("7. Show All Patients");
            System.out.println("8. Show Patients by ID");
            System.out.println("9. Delete Patients");


            System.out.print("Enter the number of the operation to proceed: ");
            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    System.out.print("Enter Doctor ID: ");
                    int doctorID=sc.nextInt();
                    System.out.print("Enter Doctor Name: ");
                    String doctorName=sc.next();
                    System.out.print("Enter Doctor Specialization: ");
                    String specialization=sc.next();
                    System.out.print("Enter Doctor SpecializationID: ");
                    int specializationID=sc.nextInt();

                    System.out.println("Enter the available time slot (hh:mm:ss):");
                    String timeString = sc.next();
                    Time time = Time.valueOf(timeString);

                    System.out.println("Enter the date (yyyy-mm-dd):");
                    String dateString = sc.next();
                    Date date = Date.valueOf(dateString);

                    System.out.print("Enter Doctor Fee: ");
                    double doctorFee=sc.nextDouble();

                    //Creating an object from Doctor class
                    Doctor doctor = new Doctor();

                    //Setting the input values gain by the user
                    doctor.setDoctorID(doctorID);
                    doctor.setDoctorName(doctorName);
                    doctor.setSpecialization(specialization);
                    doctor.setSpecializationID(specializationID);
                    doctor.setTime(time);
                    doctor.setDate(date);
                    doctor.setDoctorFee(doctorFee);
                    doc.addDoctor(doctor);
                    break;
                case 2:
                    doc.showAllDoctors();
                    break;
                case 3:
                    System.out.print("Enter Doctor ID to view doctor details: ");
                    int docid = sc.nextInt();
                    doc.showDoctorByID(docid);
                    break;
                case 4:
                    System.out.print("Enter Doctor ID you want to update: ");
                    int upid = sc.nextInt();
                    System.out.print("Enter Doctor Name you want to replace with: ");
                    String name = sc.next();
                    doc.updateDoctor(upid,name);
                    break;
                case 5:
                    System.out.print("Enter the ID to delete: ");
                    int delid = sc.nextInt();
                    doc.deleteDoctor(delid);
                    break;
                case 6:
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
                    break;
                case 7:
                    pat.showAllPatients();
                    break;
                case 8:
                    System.out.print("Enter Patient ID to view patient details: ");
                    int patid = sc.nextInt();
                    pat.showPatientByID(patid);
                    break;

                case 9:
                    System.out.print("Enter the ID to delete: ");
                    int delpid = sc.nextInt();
                    pat.deletePatientByID(delpid);
                    break;

                default:
                    System.out.println("Enter a valid number");
                    break;
            }
        }while (true);
    }
}
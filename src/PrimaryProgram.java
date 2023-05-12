import Appointments.Appoinment;
import Billing.Billing;
import DoctorRevenue.RevenueManagement;
import Doctors.Doctor;
import Doctors.DoctorImplements;
import Doctors.DoctorInterface;
import Patients.PatientImplements;
import Patients.PatientInterface;
import Patients.Patient;
import Reviews.RateReviews;
import java.sql.*;
import  java.util.Scanner;

public class PrimaryProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Object creation on doctor interface
        DoctorInterface doc = new DoctorImplements();
        //Object creation on patient interface
        PatientInterface pat = new PatientImplements();
        //Object creation on Appoinment class
        Appoinment app = new Appoinment();
        //Object creation from Billing class
        Billing bill = new Billing();
        //Object creation from RateReviews class
        RateReviews rate = new RateReviews();
        //Object creation from RevenueManagement class
        RevenueManagement rev = new RevenueManagement();
        //Creating an object from Doctor class
        Doctor doctor = new Doctor();

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\t\t\tWelcome to Self Health Care System..");
        System.out.println("-----------------------------------------------------------------------------------");

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("\t1. Patient Portal");
            System.out.println("\t2. Admin Portal");
            System.out.println("\t3. Doctor Portal");
            System.out.println("-----------------------------------------------------------------------------------\n");

            System.out.print("Enter the portal number you want to enter: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    do{
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.println("\t\tWelcome to Patient Portal");
                        System.out.println("-----------------------------------------------------------------------------------\n");
                        System.out.println("\t\t1. Patients Registration");
                        System.out.println("\t\t2. View Profile by ID");
                        System.out.println("\t\t3. Available Doctor List");
                        System.out.println("\t\t4. View Doctor Details and Rates by ID");
                        System.out.println("\t\t5. Rating Doctors");
                        System.out.println("\t\t6. Place an Appointment\n");
                        System.out.print("Enter the number of the operation to perform: ");
                    int ch1 = input.nextInt();
                    switch (ch1){
                        case 1:
                            System.out.println("-----------------------------------------------------------------------------------");
                            System.out.println("\t\tPatient Registration");
                            System.out.println("\t\t**Please provide patient details to proceed the registration...");
                            System.out.println("-----------------------------------------------------------------------------------\n");
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

                        case 2:
                            System.out.println("-----------------------------------------------------------------------------------");
                            System.out.println("\t\tView Patient Profile");
                            System.out.println("-----------------------------------------------------------------------------------\n");
                            System.out.print("Enter Patient ID to view patient details: ");
                            int patid = sc.nextInt();
                            pat.showPatientByID(patid);
                            break;
                        case 3:
                            doctor.showAllDoctors();
                            break;
                        case 4:
                            System.out.println("-----------------------------------------------------------------------------------");
                            System.out.println("\t\tView Doctor Profile");
                            System.out.println("-----------------------------------------------------------------------------------\n");
                            System.out.print("Enter Doctor ID to view Doctor details: ");
                            int docid = sc.nextInt();
                            //view doctor details
                            doctor.showDoctorByID(docid);
                            //view doctor rates
                            rate.displayReviews(docid);
                            break;
                        case 5:
                            System.out.println("-----------------------------------------------------------------------------------");
                            System.out.println("\t\tRate Doctors");
                            System.out.println("-----------------------------------------------------------------------------------\n");
                            System.out.println("You should know Doctor ID before reviewing the doctor");
                            System.out.print("Enter Your ID: ");
                            int pid=sc.nextInt();
                            System.out.print("Enter Doctor ID: ");
                            int did=sc.nextInt();
                            doc.printDoctorName(did);
                            System.out.print("Enter Your Review: ");
                            String review =sc.next();
                            rate.addReview(pid,did,review);
                            break;
                        case 6:
                            System.out.println("-------------------------------------------------------------------------------------------------");
                            System.out.println("\t\t\t\t\t\tAppointment Placement");
                            System.out.println("-------------------------------------------------------------------------------------------------");

                            System.out.print("\tPlease enter your patient ID: ");
                            int apid = sc.nextInt();
                            System.out.print("\tEnter ID of the Doctor you want to consult: ");
                            int adid = sc.nextInt();
                            //display doctor name
                            doc.printDoctorName(adid);
                            //built database relationship
                            app.addDoctorPatient(adid,apid);
                            System.out.print("Do you want to get your appointment receipt? (y/n)");
                            String ans1 = sc.next();
                            if (ans1.equalsIgnoreCase("y")) {
                                //appointment details
                                app.getPatientAndDoctorDetails(apid,adid);
                            } else {
                                System.out.println("Thank you!");
                            }

                            System.out.print("Do you want to view your Final Bill? (y/n)");
                            String ans = sc.next();
                            if (ans.equalsIgnoreCase("y")) {
                                // Call the getDoctorFee() function
                                bill.getDoctorFee(adid, apid);
                            } else {
                                System.out.println("Thank you!");
                            }


                            break;
                        default:
                            System.out.println("Enter a valid number");
                            break;
                    }
                    } while (true);
                case 2:
                    do {
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.println("\t\tWelcome to Admin Portal");
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.println("\t\t1. View All Patients");
                        System.out.println("\t\t2. Delete Patient Profile");
                        System.out.println("\t\t3. View All Doctors");
                        System.out.println("\t\t4. Delete Doctor Profile\n");
                        System.out.print("Enter the number of the operation to perform: ");
                        int ch2 = input.nextInt();
                        switch (ch2){
                            case 1:
                                pat.showAllPatients();
                                break;
                            case 2:
                                System.out.println("-----------------------------------------------------------------------------------");
                                System.out.println("\t\tDelete Patient Profiles");
                                System.out.println("-----------------------------------------------------------------------------------\n");
                                System.out.print("Enter the ID of the patient to delete: ");
                                int delpid = sc.nextInt();
                                pat.deletePatientByID(delpid);
                                break;
                            case 3:
                                doctor.showAllDoctors();
                                break;
                            case 4:
                                System.out.println("-----------------------------------------------------------------------------------");
                                System.out.println("\t\tDelete Doctor Profiles");
                                System.out.println("-----------------------------------------------------------------------------------\n");
                                System.out.print("Enter the ID of the doctor to delete: ");
                                int delid = sc.nextInt();
                                doc.deleteDoctor(delid);
                                break;
                            default:
                                System.out.println("Enter a valid number");
                                break;
                        }
                    }while (true);

                case 3:
                    do {
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.println("\t\tWelcome to Doctor Portal");
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.println("\t1. Doctor Registration");
                        System.out.println("\t2. View Total Revenue\n");
                        System.out.print("Enter the number of the operation to perform: ");
                        int ch3 = input.nextInt();
                        switch (ch3) {
                            case 1:
                                System.out.println("-----------------------------------------------------------------------------------");
                                System.out.println("\t\tDoctor Registration");
                                System.out.println("\t\t**Please provide doctor details to proceed the registration...");
                                System.out.println("-----------------------------------------------------------------------------------\n");
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

                                //Setting the input values gain by the user to the parameterized constructor
                                doctor = new Doctor(doctorID, doctorName, specialization, specializationID, time, date, doctorFee);

                                doc.addDoctor(doctor);
                                break;
                            case 2:
                                System.out.print("Enter Doctor ID: ");
                                int doid=sc.nextInt();
                                rev.displayPatientsAndCount(doid);
                                break;
                            default:
                                System.out.println("Enter a valid number");
                                break;
                        }
                    }while (true);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    break;
            }

        } while (true);

    }
}

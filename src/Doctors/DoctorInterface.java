package Doctors;

public interface DoctorInterface {

    //Add doctor
    public void addDoctor(Doctor doctor);

    //Show all doctors
    public void showAllDoctors();

    //Show doctor by id
    public void showDoctorByID(int doctorID);

    //Update doctor
    public void updateDoctor(int doctorID,String doctorName);

    //Delete doctor
    public void deleteDoctor(int doctorID);

    //Print Doctor name
    void printDoctorName(int did);
}

package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Doctor extends EmployeeClass {
    static File earDoctorPatientList = new File("Ear Doctor Patient's List.txt");
    static File eyeDoctorPatientList = new File("Eye Doctor Patient's List.txt");
    static File heartDoctorPatientList = new File("Heart Doctor Patient's List.txt");
    static File beautyDoctorPatientList = new File("Beauty Doctor Patient's List.txt");
    static File generalDoctorPatientList = new File("General Doctor Patient's List.txt");
    enum doctorType{
        general,
        earSpecialist,
        eyeSpecialist,
        beautySpecialist,
        hearSpecialist;
    }
    File file;
    doctorType dt;
    int patientNum;
    public Doctor(String firstName, String lastName, String nationalID, String personnelID, doctorType dt) {
        super(firstName, lastName, nationalID, personnelID);
        this.dt = dt;
        if(dt.equals(doctorType.general)) this.file = generalDoctorPatientList;
        else if (dt.equals(doctorType.eyeSpecialist)) this.file = eyeDoctorPatientList;
        else if (dt.equals(doctorType.hearSpecialist)) this.file = heartDoctorPatientList;
        else if (dt.equals(doctorType.beautySpecialist)) this.file = beautyDoctorPatientList;
        else if (dt.equals(doctorType.earSpecialist)) this.file = earDoctorPatientList;
        Supervisor.addDoctor(this);
    }
    protected void getList(File file){
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                System.out.println(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public void writePrescription(String prescription, Patient p){
        p.prescription = prescription;
        p.patientState = Patient.PatientState.visited;
        System.out.println("Prescription for "+p.fullName+" : "+prescription);
    }

}

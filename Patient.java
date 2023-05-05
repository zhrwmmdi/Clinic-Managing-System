package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class Patient {
    protected String firstName;
    protected String lastName;
    protected String fullName;
    protected String nationalID;
    private int money;

    enum PatientState {
        visited, inQueue, registered, not_registered;
    }

    enum Illness {
        ear, eye, heart, beauty, general;
    }

    public Doctor doctor;
    PatientState patientState;
    Illness illness;
    String prescription;

    public Patient(String firstName, String lastName, String nationalID, Illness illness, int money) {
        fullName = firstName + " " + lastName;
        this.nationalID = nationalID;
        this.illness = illness;
        this.money = money;
        patientState = PatientState.not_registered;
    }
    public void gotoReceptionist(){
       Main.receptionist.addPatient(this);
       goToCashier();
    }


    protected void goToCashier() {
        try{
            pay();
            patientState = PatientState.inQueue;
            addInQueuePatient();
            Main.cashier.CreateDoctorsList(this);

        }catch(Exception e){
            System.out.println("error in paying");
            System.out.println(e.getMessage());
        }
    }

    protected void pay() throws Exception {
        if( (this.illness == Illness.general) && money<Main.cashier.generalDoctorPrice) throw new Exception("patients money is not enogh");
        if( (this.illness == Illness.ear) && money<Main.cashier.earDoctorPrice) throw new Exception("patients money is not enogh");
        if( (this.illness == Illness.eye) && money<Main.cashier.eyeDoctorPrice) throw new Exception("patients money is not enogh");
        if( (this.illness == Illness.heart) && money<Main.cashier.heartDoctorPrice) throw new Exception("patients money is not enogh");
        if( (this.illness == Illness.beauty) && money<Main.cashier.beautyDoctorPrice) throw new Exception("patients money is not enogh");
    }

    protected PatientState getPatientState() {
        return patientState;
    }


    private String getInQueuePatientData(){
        return "Patient's name: "+fullName+"\t\tPatient's ID: "+nationalID+"\t\tIllness: "+illness+"\t\tDoctor: Dr."+doctor.fullName;

    }
    protected void addInQueuePatient(){
        FileWriter writer = null;
        try {
            writer = new FileWriter(Supervisor.inQueuePatients, true);
            writer.append( getInQueuePatientData()+ "\n");

        } catch (Exception ex) {
            System.out.println("Something went wrong in addInQueuePatient method in Patient class");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("Sth went wrong in closing writer in addInQueuePatient method is Patient class");
                System.out.println(e.getMessage());
            }
        }
    }
    public void getPrescription(){
        System.out.println(this.prescription);
    }
    public void getBill(){
        Main.cashier.giveBill(this);
    }
}
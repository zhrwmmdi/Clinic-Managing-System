package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Cashier extends EmployeeClass {
    final int earDoctorPrice = 120000;
    final int eyeDoctorPrice = 120000;
    final int beautyDoctorPrice = 500000;
    final int heartDoctorPrice = 200000;
    final int generalDoctorPrice = 700000;

    public Cashier(String firstName, String lastName, String nationalID, String personnelID) {
        super(firstName, lastName, nationalID, personnelID);
        Supervisor.addCashier(this);
    }

    protected void giveBill(Patient p){
        if(p.doctor == Supervisor.earDoctor) {
            System.out.println("PAYMENT--> "+p.fullName+" : "+earDoctorPrice+"T");
        }
        if(p.doctor == Supervisor.eyeDoctor) {
            System.out.println("PAYMENT--> "+p.fullName+" : "+eyeDoctorPrice+"T");
        }
        if(p.doctor == Supervisor.beautiDoctor) {
            System.out.println("PAYMENT--> "+p.fullName+" : "+beautyDoctorPrice+"T");
        }
        if(p.doctor == Supervisor.heartDoctor) {
            System.out.println("PAYMENT--> "+p.fullName+" : "+heartDoctorPrice+"T");
        }
        if(p.doctor == Supervisor.generalDoctor){
            System.out.println("PAYMENT--> "+p.fullName+" : "+generalDoctorPrice+"T");
        }
    }

    public void CreateDoctorsList(Patient patient){

            if(patient.doctor == Supervisor.heartDoctor) addToDoctorList(Doctor.heartDoctorPatientList,patient);
            if(patient.doctor == Supervisor.earDoctor) addToDoctorList(Doctor.earDoctorPatientList,patient);
            if(patient.doctor == Supervisor.eyeDoctor) addToDoctorList(Doctor.eyeDoctorPatientList,patient);
            if(patient.doctor == Supervisor.beautiDoctor) addToDoctorList(Doctor.beautyDoctorPatientList,patient);
            if(patient.doctor == Supervisor.generalDoctor) addToDoctorList(Doctor.generalDoctorPatientList,patient);


    }
    protected void addToDoctorList(File file, Patient patient){
        FileWriter writer = null;
        try {
            writer = new FileWriter(file,true);
            writer.append(getPatientData(patient)+"\n");
        } catch (IOException e) {
            System.out.println("Error in addtodoctorlist method in patient");
            System.out.println(e.getMessage());
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("Sth went wrong in closing writer in addToDoctorList method is Patient class");
                System.out.println(e.getMessage());
            }
        }
    }
    public void calculateSalary(EmployeeClass employee){

    }


//    @Override
//    public void printPaymentReceipt() {
//
//    }
}

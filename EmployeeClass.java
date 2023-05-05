package org.example;

public class EmployeeClass {
    protected String firstName;
    protected String lastName;
    protected String fullName;
    protected String nationalID;
    protected String  personnelID;
    public EmployeeClass(String firstName, String lastName, String nationalID, String personnelID){
        fullName = firstName+" "+lastName;
        this.nationalID = nationalID;
        this.personnelID = personnelID;
    }
    public void printPaymentReceipt() {

    }
    public String getPatientData(Patient p){
        return "Patient's name: "+p.fullName+"\t\tPatient's ID: "+p.nationalID+"\t\tIllness: "+p.illness+"\t\tDoctor: Dr."+p.doctor.fullName;
    }
}

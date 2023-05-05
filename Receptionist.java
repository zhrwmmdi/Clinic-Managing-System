package org.example;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Receptionist extends EmployeeClass {
    //static File patientsList = new File("patientsList.txt");



    public Receptionist(String firstName, String lastName, String nationalID, String personnelID) {
        super(firstName, lastName, nationalID, personnelID);
        Supervisor.addReceptionist(this);
    }


    protected void fixDoctor(Patient patient ){
        if(patient.illness == Patient.Illness.ear){
           patient.doctor = Supervisor.earDoctor;
           Supervisor.earDoctor.patientNum ++;

        }if(patient.illness == Patient.Illness.eye){
            patient.doctor = Supervisor.eyeDoctor;
            Supervisor.eyeDoctor.patientNum ++;

        }if(patient.illness == Patient.Illness.heart){
            patient.doctor = Supervisor.heartDoctor;
            Supervisor.heartDoctor.patientNum ++;

        }if(patient.illness == Patient.Illness.beauty){
            patient.doctor = Supervisor.beautiDoctor;
            Supervisor.beautiDoctor.patientNum ++;

        }if (patient.illness == Patient.Illness.general){
            patient.doctor = Supervisor.generalDoctor;
            Supervisor.generalDoctor.patientNum ++;
        }
    }


    protected void addPatient(Patient patient) {
        fixDoctor(patient);
        FileWriter writer = null;
        try {
            writer = new FileWriter(Supervisor.patientsList, true);
            writer.append(getPatientData(patient)+"\n");
        } catch (IOException e) {
            System.out.println("sth went wrong in add patient method.");
            System.out.println(e.getMessage());
        } finally {
            try {
                writer.close();
                patient.patientState = Patient.PatientState.registered;
            } catch (IOException e) {
                System.out.println("Sth went wrong in closing writer in addpatient method is receptionist class");
                System.out.println(e.getMessage());
            }
        }

    }


//    @Override
//    public void printPaymentReceipt() {
//
//    }
}

package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Supervisor extends EmployeeClass {
    static File patientsList = new File("patientsList.txt");
    static  File inQueuePatients = new File("inQueuePatients");

    static private File doctorsList = new File("doctorsList.txt");
    static private File receptionistList = new File("receptionistsList.txt");
    static private File cashiersList = new File("cashiersList.txt");
    static Doctor generalDoctor = new Doctor("Ahamd", "Salehi", "4516277788", "1123", Doctor.doctorType.general);
    static Doctor earDoctor = new Doctor("Maryam", "Sadeghi", "122223659", "4456", Doctor.doctorType.earSpecialist);
    static Doctor eyeDoctor = new Doctor("Sahel", "Rezaee", "45266988777", "6565", Doctor.doctorType.eyeSpecialist);
    static Doctor beautiDoctor = new Doctor("Ziba", "Radanian", "4555666589", "5223", Doctor.doctorType.beautySpecialist);
    static Doctor heartDoctor = new Doctor("Mehdi", "Moradi", "5100000023", "7777", Doctor.doctorType.hearSpecialist);


    public Supervisor(String firstName, String lastName, String nationalID, String personnelID) {
        super(firstName, lastName, nationalID, personnelID);
    }

    private static String getDoctorData(Doctor d) {
        return "Doctor name: " + d.fullName + "\t\tDoctor ID: " + d.personnelID + "\t\tExpertise: " + d.dt;
    }

    protected static void addDoctor(Doctor doctor) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(doctorsList, true);
            writer.append(getDoctorData(doctor) + "\n");
        } catch (Exception ex) {
            System.out.println("Something went wrong in addDoctor method in supervisor class");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("Sth went wrong in closing writer in addDoctor method is Supervisor class");
                System.out.println(e.getMessage());
            }
        }
    }

    private static String getReceptionistData(Receptionist r) {
        return "Receptionist's name: " + r.fullName + "\t\tReceptionist's ID: " + r.personnelID;
    }

    protected static void addReceptionist(Receptionist receptionist) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(receptionistList, true);
            writer.append(getReceptionistData(receptionist) + "\n");
        } catch (Exception ex) {
            System.out.println("Something went wrong in addReceptionist method in supervisor class");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("Sth went wrong in closing writer in addReceptionist method is Supervisor class");
                System.out.println(e.getMessage());
            }
        }
    }

    private static String getCashierData(Cashier c) {
        return "Cashier's name: " + c.fullName + "\t\tCashier's ID: " + c.personnelID;
    }

    protected static void addCashier(Cashier cashier) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(cashiersList, true);
            writer.append(getCashierData(cashier) + "\n");
        } catch (Exception ex) {
            System.out.println("Something went wrong in addCashier method in supervisor class");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("Sth went wrong in closing writer in addCashier method is SuperVisor class");
                System.out.println(e.getMessage());
            }
        }
    }

    protected void getDoctorsList(){
        Scanner reader = null;
        try {
            reader = new Scanner(doctorsList);
            System.out.println("Doctors list:");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        while (reader.hasNextLine()){
            System.out.println(reader.nextLine());
        }
    }

    protected void getPatientsList(){
        Scanner reader = null;
        try {
            reader = new Scanner(patientsList);
            System.out.println("Patient's list:");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        while (reader.hasNextLine()){
            System.out.println(reader.nextLine());
        }
    }

    protected void getCashiersList(){
        Scanner reader = null;
        try {
            reader = new Scanner(cashiersList);
            System.out.println("Cashier's list:");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        while (reader.hasNextLine()){
            System.out.println(reader.nextLine());
        }
    }
    protected void getReceptionistsList(){
        Scanner reader = null;
        try {
            reader = new Scanner(receptionistList);
            System.out.println("Receptionist's list:");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        while (reader.hasNextLine()){
            System.out.println(reader.nextLine());
        }
    }
    protected void getInQueuePatients(){
        Scanner reader = null;
        try {
            reader = new Scanner(inQueuePatients);
            System.out.println("In Queue Patient's list:");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        while (reader.hasNextLine()){
            System.out.println(reader.nextLine());
        }
    }
}
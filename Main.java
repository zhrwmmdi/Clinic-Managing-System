package org.example;
public class Main {
    static Supervisor supervisor = new Supervisor("Sara","Abdi","8479563248","8974");
    static Receptionist receptionist = new Receptionist("Elaheh","Momeni","0200065847","1254");
    static Cashier cashier = new Cashier("Majid", "Taheri","5487962","5684");
    public static void main(String[] args) {
        Patient p1 = new Patient("Zahra","Mohammadi","0200098543", Patient.Illness.ear,100000);
        Patient p2 = new Patient("Reza","Abbasi","5426849", Patient.Illness.eye,400000);
        Patient p3 = new Patient("Elham","Zarghami","63169695", Patient.Illness.beauty,500000);
        Patient p4 = new Patient("Ahmad","Sarabi","020333659", Patient.Illness.heart,200000);
        Patient p5 = new Patient("Soraya","rahaniam","65266266", Patient.Illness.beauty,6900000);

        p1.gotoReceptionist();
        p2.gotoReceptionist();
        p3.gotoReceptionist();
        p4.gotoReceptionist();
        p5.gotoReceptionist();









    }
}
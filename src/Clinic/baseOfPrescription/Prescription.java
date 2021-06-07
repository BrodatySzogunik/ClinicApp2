package Clinic.baseOfPrescription;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prescription {

    public int a;//widocznosc recepty, jesli 0=brak recepty przypisanej do wizyty jesli 1=jest recepta
    public ArrayList <Medicine> medicines;
    public Payment payment;
    public Date date;
    public int patientId;

    public Prescription(ArrayList<Medicine> medicines, Payment payment, Date date, int patientId,int visibility) {
        this.a=visibility;
        this.medicines = medicines;
        this.payment = payment;
        this.date = date;
        this.patientId = patientId;
    }

}

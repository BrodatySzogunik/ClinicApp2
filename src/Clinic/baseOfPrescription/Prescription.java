package Clinic.baseOfPrescription;

import java.util.Date;
import java.util.List;

public class Prescription {
    List <Medicine> medicines;
    Payment payment;
    Date date;
    int patientId;

    public Prescription(List<Medicine> medicines, Payment payment, Date date, int patientId) {
        this.medicines = medicines;
        this.payment = payment;
        this.date = date;
        this.patientId = patientId;
    }
}

package Clinic.prescription;

import java.util.ArrayList;
import java.util.List;

public class prescription {
    List <Medicine> medicines;
    Payment payment;
    int date;
    int patientId;

    public prescription(List<Medicine> medicines, Payment payment, int date, int patientId) {
        this.medicines = medicines;
        this.payment = payment;
        this.date = date;
        this.patientId = patientId;
    }
}

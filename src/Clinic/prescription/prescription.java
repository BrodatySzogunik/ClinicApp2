package Clinic.prescription;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class prescription {
    List <Medicine> medicines;
    Payment payment;
    Date date;
    int patientId;

    public prescription(List<Medicine> medicines, Payment payment, Date date, int patientId) {
        this.medicines = medicines;
        this.payment = payment;
        this.date = date;
        this.patientId = patientId;
    }
}

package Clinic.prescription;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseOfPrescriptions {

    static List <prescription> prescriptions = new ArrayList();

    public static void removePrescription(int prescription){
        prescriptions.remove(prescription);
    }

    public static void newPrescription(List<Medicine> medicines, Payment payment,Date date, int patientId, String recommendation){
        prescriptions.add(new prescription(medicines,payment,date,patientId));
    }

}

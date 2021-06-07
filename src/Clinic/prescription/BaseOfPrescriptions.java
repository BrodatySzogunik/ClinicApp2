package Clinic.prescription;

import java.util.ArrayList;
import java.util.List;

public class BaseOfPrescriptions {

    static List <Prescription> prescriptions = new ArrayList();

    public static void removePrescription(int prescription){
        prescriptions.remove(prescription);
    }

    public static void newPrescription(List<Medicine> medicines, int date, int patientId,String recommendation){
        prescriptions.add(new Prescription(medicines,date,patientId,recommendation));
    }

}

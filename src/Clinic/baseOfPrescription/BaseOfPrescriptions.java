package Clinic.baseOfPrescription;

import java.util.*;

public class BaseOfPrescriptions {

    static Map<Integer,Prescription> prescriptions = new HashMap<>();

    public static void removePrescription(int key){
        prescriptions.remove(key);
    }

    public static void newPrescription(int key,List<Medicine> medicines, Payment payment,Date date, int patientId, String recommendation){
        prescriptions.put(key,new Prescription(medicines,payment,date,patientId));
    }

}

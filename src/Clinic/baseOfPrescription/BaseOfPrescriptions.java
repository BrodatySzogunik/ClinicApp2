package Clinic.baseOfPrescription;

import java.util.*;

public class BaseOfPrescriptions {

    static Map<Integer,Prescription> prescriptions = new HashMap<>();

    public static void removePrescription(int key){
        prescriptions.remove(key);
    }

    public static void newPrescription(int key,ArrayList<Medicine> medicines, Payment payment,Date date, int patientId, int visibility,String recommendation){
        prescriptions.put(key,new Prescription(medicines,payment,date,patientId,visibility));
    }

    public static Prescription returnPrescription(int key)
    {
        return prescriptions.get(key);
    }

    public static void putPrescritpion(int key,Prescription prescription)
    {
        prescriptions.put(key,prescription);
    }
}

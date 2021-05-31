package Clinic.prescription;

import java.util.LinkedList;
import java.util.List;

public class BaseOfMedicines  {
    static List <Medicine> medicines = new LinkedList();





    public static void deleteMedicine(int Medicine){
        //medicines.remove();
    }
    public static void addMedicine(String medicineName, double price){
        medicines.add(new Medicine(medicineName,price));
    }

}

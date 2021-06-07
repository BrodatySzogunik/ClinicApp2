package Clinic.baseOfPrescription;

import java.util.ArrayList;
import java.util.List;

public class Medicines {

    private List<Medicine> medicines;


    public Medicines(){
        medicines = new ArrayList<>();
    }

    public boolean addMedicine(Medicine medicine){
        if(!medicines.contains(medicine)) {
            medicines.add(medicine);
            return true;
        }else{
            return false;
        }
    }

    public boolean removeMedicine(Medicine medicine){
        if(medicines.contains(medicine)) {
            medicines.remove(medicine);
            return true;
        }
        else{
            return false;
        }
    }
}
